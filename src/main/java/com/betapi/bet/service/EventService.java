package com.betapi.bet.service;

import com.betapi.bet.model.Event;
import com.betapi.bet.model.EventPlayer;
import com.betapi.bet.model.dto.EventIn;
import com.betapi.bet.model.dto.EventOut;
import com.betapi.bet.repository.EventPlayerRepository;
import com.betapi.bet.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EventService {

    private final EventPlayerRepository eventPlayerRepository;
    private final EventRepository eventRepository;

    public EventOut saveEvent(EventIn eventIn) {
        EventOut eventOut = null;
        try {
            Optional<EventPlayer> challenger = eventPlayerRepository.findById(eventIn.getIdChallenger());
            Optional<EventPlayer> challenged = eventPlayerRepository.findById(eventIn.getIdChallenged());

            Event event = new Event(null, challenger.get(), challenged.get(), false, null);
            eventRepository.save(event);

            eventOut = new EventOut(event.getIdEvent(), challenged.get().getNameEventPlayer(), challenger.get().getNameEventPlayer());
        } catch (NoSuchElementException e) {

            System.out.println("An error occurred, event challenger/challenged not found");
        }

        return eventOut;
    }
}
