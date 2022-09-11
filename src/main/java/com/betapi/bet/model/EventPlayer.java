package com.betapi.bet.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class EventPlayer {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEventPlayer;

    @NotBlank
    private String nameEventPlayer;
}
