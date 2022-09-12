package com.betapi.bet.model.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class FinishEventIn {

    @NotNull
    private Long idEvent;

    @NotNull
    private Long idWinner;
}
