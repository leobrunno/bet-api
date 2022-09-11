package com.betapi.bet.controller;

import com.betapi.bet.model.dto.EventPlayerIn;
import com.betapi.bet.service.EventPlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class EventPlayerController {

    private final EventPlayerService eventPlayerService;

    @PostMapping("/eventPlayer")
    public ResponseEntity saveEventPlayer(@Valid @RequestBody EventPlayerIn eventPlayerIn) {
        eventPlayerService.saveEventPlayer(eventPlayerIn);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
