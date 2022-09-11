package com.betapi.bet.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EventOut {

    private Long idEvent;
    private String challengedName;
    private String challengerName;
}
