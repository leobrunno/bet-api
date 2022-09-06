package com.betapi.bet.controller;

import com.betapi.bet.model.Player;
import com.betapi.bet.model.dto.PlayerIn;
import com.betapi.bet.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PlayerController {

    private final PlayerRepository playerRepository;

    @PostMapping("/player")
    public ResponseEntity savePlayer(@RequestBody PlayerIn playerIn) {
        Player player = playerIn.toConvert();
        playerRepository.save(player);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
