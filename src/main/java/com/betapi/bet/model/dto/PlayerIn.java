package com.betapi.bet.model.dto;

import com.betapi.bet.model.Player;
import lombok.Getter;

@Getter
public class PlayerIn {
    private String name;
    private String email;

    public Player toConvert() {

        return new Player(null, name, email);
    }
}
