package com.betapi.bet.controller;

import com.betapi.bet.model.dto.PlayerIn;
import com.betapi.bet.service.PlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PlayerController {

    private final PlayerService playerService;

    @PostMapping("/player")
    public ResponseEntity savePlayer(@RequestBody PlayerIn playerIn) {
        playerService.savePlayer(playerIn);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
