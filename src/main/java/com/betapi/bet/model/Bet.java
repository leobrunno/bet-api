package com.betapi.bet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bet {

    @Id
    @NotBlank
    private String betNum;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private Player player;
}
