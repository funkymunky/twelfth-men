package net.twelfth.men.service;

import net.twelfth.men.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class PlayerService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public static final String COLLECTION_NAME = "players";

    public void addPlayer(Player player) {
        if (!mongoTemplate.collectionExists(Player.class)) {
            mongoTemplate.createCollection(Player.class);
        }

        player.setId(UUID.randomUUID().toString());
        mongoTemplate.insert(player, COLLECTION_NAME);
    }

    public List<Player> listPlayers() {
        return mongoTemplate.findAll(Player.class, COLLECTION_NAME);
    }

    public void deletePlayer(Player player) {
        mongoTemplate.remove(player, COLLECTION_NAME);
    }

    public void updatePlayer(Player player) {
        mongoTemplate.insert(player, COLLECTION_NAME);
    }
}
