package com.betapi.bet.model.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class EventIn {

    @NotNull
    private Long idChallenger;

    @NotNull
    private Long idChallenged;
}
