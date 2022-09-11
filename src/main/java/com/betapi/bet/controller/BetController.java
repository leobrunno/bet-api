package com.betapi.bet.controller;

import com.betapi.bet.model.dto.BetIn;
import com.betapi.bet.model.dto.BetOut;
import com.betapi.bet.model.dto.BetsOut;
import com.betapi.bet.service.BetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class BetController {

    private final BetService betService;

    @PostMapping("/bet")
    public ResponseEntity<BetOut> saveBet(@Valid @RequestBody BetIn betIn) {
        BetOut betOut = betService.saveBet(betIn);
        return ResponseEntity.status(HttpStatus.CREATED).body(betOut);
    }

    @GetMapping("/listBetsIdPlayer/{idPlayer}")
    public List<BetsOut> listBetsIdPlayer(@PathVariable Long idPlayer) {
        return betService.listBetsIdPlayer(idPlayer);
    }
}
