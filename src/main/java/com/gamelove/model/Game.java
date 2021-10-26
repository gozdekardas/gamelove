package com.gamelove.model;
import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game {

    @Id
    private int gameId;
    private String gameName;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

}
