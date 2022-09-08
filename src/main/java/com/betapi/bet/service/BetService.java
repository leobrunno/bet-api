package com.betapi.bet.service;

import com.betapi.bet.model.Bet;
import com.betapi.bet.model.Player;
import com.betapi.bet.model.dto.BetIn;
import com.betapi.bet.model.dto.BetOut;
import com.betapi.bet.repository.BetRepository;
import com.betapi.bet.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class BetService {

    private final PlayerRepository playerRepository;
    private final BetRepository betRepository;

    public BetOut saveBet(BetIn betIn) {
        BetOut betOut = null;
        try {

            Optional<Player> player = playerRepository.findById(betIn.getIdPlayer());
            String betNum = UUID.randomUUID().toString();
            Bet bet = new Bet(betNum, player.get());

            betRepository.save(bet);
            betOut = new BetOut(betNum, player.get().getName(), player.get().getEmail());
        } catch (NoSuchElementException e) {

            System.out.println("An error occurred, user not found");
        }

        return betOut;
    }
}
