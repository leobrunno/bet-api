package com.betapi.bet.model.dto;

import lombok.Getter;

import javax.validation.constraints.NotBlank;

@Getter
public class PlayerIn {

    @NotBlank
    private String name;

    @NotBlank
    private String email;
}
