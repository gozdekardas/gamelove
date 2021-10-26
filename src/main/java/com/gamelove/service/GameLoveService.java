package com.gamelove.service;


import com.gamelove.model.GameLove;
import com.gamelove.repository.GameLoveRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
@Transactional
public class GameLoveService {

    @Autowired
    private GameLoveRepo repo;

    public List<GameLove> findByUserId (int userId) {
        return repo.findByUserId(userId);
    }

    public int saveLovedGame(GameLove gameLove) {
        repo.save(gameLove);
        return gameLove.getLoveId();
    }

    public int checkIfExists(int userId, int gameId) {

        return repo.chechExist(userId,gameId);
    }


    public void deleteFromLoved(Integer loveId) {
        repo.deleteFromLoved(loveId);
    }

    public List<Object[]>  getTopGames(int topLoved) {
        List<Object[]> topGames= repo.getTopGames(topLoved);

        return topGames;
    }


}
