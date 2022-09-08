package com.betapi.bet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BetOut {

    private String betNum;
    private String playerName;
    private String playerEmail;
}
