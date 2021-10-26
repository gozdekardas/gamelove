package com.gamelove.repository;

import com.gamelove.model.GameLove;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameLoveRepo extends JpaRepository<GameLove, Integer> {
    List<GameLove> findByUserId(int userId);

    @Override
    void deleteById(Integer integer);

    @Query(value="select g.game_name, gl.loves_count from games g,\n" +
            "(select game_id ,loves_count from (\n" +
            "                  select game_id, count(game_id) loves_count\n" +
            "                  from game_love\n" +
            "                  group by game_id\n" +
            "                  order by count(game_id) desc\n" +
            "              ) LIMIT :topCount) gl\n" +
            "where g.game_id = gl.game_id", nativeQuery=true)
    List<Object[]> getTopGames(int topCount);

    @Modifying
    @Query(value = "DELETE FROM game_love WHERE love_id = :loveid",nativeQuery = true) // if want to write nativequery then mask nativeQuery  as true
    int deleteFromLoved(@Param("loveid") int loveid);

    @Query(value="select count(*) from game_love where user_id = :userId and " +
            "game_id = :gameId", nativeQuery=true)
    int chechExist(int userId, int gameId);

}