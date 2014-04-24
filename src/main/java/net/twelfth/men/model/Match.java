package net.twelfth.men.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "matches")
public class Match {

    @Id
    private String id;
    Date matchDate;
    String opposingTeam;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    public String getOpposingTeam() {
        return opposingTeam;
    }

    public void setOpposingTeam(String opposingTeam) {
        this.opposingTeam = opposingTeam;
    }
}
