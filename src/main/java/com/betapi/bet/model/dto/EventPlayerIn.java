package com.betapi.bet.model.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class EventPlayerIn {

    @NotBlank
    private String nameEventPlayer;
}
