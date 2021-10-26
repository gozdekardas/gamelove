package com.gamelove.repository;

import com.gamelove.model.GameLove;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameLoveRepo extends JpaRepository<GameLove, Integer> {
    List<GameLove> findByUserId(int userId);

    @Query(value="select g.game_name, gl.loves_count from games g,\n" +
            "(select game_id, count(game_id) loves_count\n" +
            "from game_love group by game_id having count(game_id)>= :topCount) gl\n" +
            "where g.game_id = gl.game_id", nativeQuery=true)
    List<Object[]> getTopGames(int topCount);

}