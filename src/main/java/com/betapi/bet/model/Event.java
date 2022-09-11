package com.betapi.bet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Event {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEvent;

    @ManyToOne
    @JoinColumn(name = "idEventPlayerChallenger", nullable = false)
    private EventPlayer challenger;

    @ManyToOne
    @JoinColumn(name = "idEventPlayerChallenged", nullable = false)
    private EventPlayer challenged;

    private boolean finished;

    private Long idWinner;
}
