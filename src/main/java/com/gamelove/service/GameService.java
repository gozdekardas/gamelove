package com.gamelove.service;


import com.gamelove.model.Game;
import com.gamelove.repository.GameRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@Service
@Transactional
public class GameService {

    @Autowired
    private GameRepo repo;

    public List<Game> listAllGames() {
        System.out.println(repo.findAll());
        return repo.findAll();
    }

}
