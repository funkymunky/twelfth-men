package net.twelfth.men.service;

import net.twelfth.men.model.Match;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class MatchService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public static final String COLLECTION_NAME = "matches";

    public void addMatch(Match match) {
        if (!mongoTemplate.collectionExists(Match.class)) {
            mongoTemplate.createCollection(Match.class);
        }

        match.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(match, COLLECTION_NAME);
    }

    public List<Match> listMatches() {
        return mongoTemplate.findAll(Match.class, COLLECTION_NAME);
    }

    public void deleteMatch(Match match) {
        mongoTemplate.remove(match, COLLECTION_NAME);
    }

    public void updateMatch(Match match) {
        mongoTemplate.insert(match, COLLECTION_NAME);
    }
}
