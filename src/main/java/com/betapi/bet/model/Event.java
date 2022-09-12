package com.betapi.bet.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
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
