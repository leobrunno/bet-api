package com.betapi.bet.repository;

import com.betapi.bet.model.EventPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventPlayerRepository extends JpaRepository<EventPlayer, String> {
}
