package com.betapi.bet.controller;

import com.betapi.bet.model.dto.EventIn;
import com.betapi.bet.model.dto.EventOut;
import com.betapi.bet.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class EventController {

    private final EventService eventService;

    @PostMapping("/createEvent")
    public ResponseEntity<EventOut> saveEvent(@Valid @RequestBody EventIn eventIn) {
        EventOut eventOut = eventService.saveEvent(eventIn);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventOut);
    }
}
