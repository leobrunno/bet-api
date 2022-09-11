package com.betapi.bet.model.dto;

import com.betapi.bet.model.Player;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BetsOut {

    private String betNum;
    private Player player;
}
