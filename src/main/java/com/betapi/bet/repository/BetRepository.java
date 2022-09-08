package com.betapi.bet.repository;

import com.betapi.bet.model.Bet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetRepository extends JpaRepository<Bet, String> {
}
