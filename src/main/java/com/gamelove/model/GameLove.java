package com.gamelove.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "game_love")
public class GameLove {

    @Id
    @Column(name = "love_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic
    private int loveId;
    private int userId;
    private int gameId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gameId" , insertable = false, updatable = false)
    private Game gamesLoved;

    public Game getGamesLoved() {
        return gamesLoved;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getLoveId() {
        return loveId;
    }

    public void setLoveId(int loveId) {
        this.loveId = loveId;
    }



}
