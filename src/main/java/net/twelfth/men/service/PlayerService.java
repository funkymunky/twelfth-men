package net.twelfth.men.service;

import net.twelfth.men.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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

    public void updatePlayerDetails(Player player) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(player.getId()));
        Player playerToUpdate = mongoTemplate.findOne(query, Player.class);

        //modify and update with save()
        playerToUpdate.setNickName(player.getNickName());
        playerToUpdate.setFirstName(player.getFirstName());
        playerToUpdate.setLastName(player.getLastName());
        playerToUpdate.setPhone(player.getPhone());
        playerToUpdate.setEmail(player.getEmail());

        mongoTemplate.save(playerToUpdate);
    }

    public Player getPlayer(String id) {
        Query playerQuery = new Query();
        playerQuery.addCriteria(Criteria.where("id").is(id));

        return mongoTemplate.findOne(playerQuery, Player.class);
    }
}
