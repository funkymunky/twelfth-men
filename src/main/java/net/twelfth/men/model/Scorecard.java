package net.twelfth.men.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "scorecards")
public class Scorecard {

    @Id
    private String id;
    String matchId;

}
