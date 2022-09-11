package com.betapi.bet.repository;

import com.betapi.bet.model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BetRepository extends JpaRepository<Bet, String> {

    @Query(value = "SELECT * FROM bet WHERE id_player = ?", nativeQuery = true)
    List<Bet> findByIdPlayer(@Param("idPlayer") Long idPlayer);
}
