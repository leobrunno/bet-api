package com.betapi.bet.service;

import com.betapi.bet.model.EventPlayer;
import com.betapi.bet.model.dto.EventPlayerIn;
import com.betapi.bet.repository.EventPlayerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EventPlayerService {

    private final EventPlayerRepository eventPlayerRepository;
    private final ModelMapper modelMapper;

    public void saveEventPlayer(EventPlayerIn eventPlayerIn) {
        EventPlayer eventPlayer = modelMapper.map(eventPlayerIn, EventPlayer.class);
        eventPlayerRepository.save(eventPlayer);
    }
}
