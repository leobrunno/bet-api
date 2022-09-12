package com.betapi.bet.service;

import com.betapi.bet.model.Event;
import com.betapi.bet.model.EventPlayer;
import com.betapi.bet.model.dto.EventIn;
import com.betapi.bet.model.dto.EventOut;
import com.betapi.bet.model.dto.FinishEventIn;
import com.betapi.bet.repository.EventPlayerRepository;
import com.betapi.bet.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EventService {

    private final EventPlayerRepository eventPlayerRepository;
    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;

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

    public void finishEvent(FinishEventIn finishEventIn) {
        try {
            Optional<Event> event = eventRepository.findById(finishEventIn.getIdEvent());

            if(((event.get().getChallenged().getIdEventPlayer() == finishEventIn.getIdWinner())
                    || (event.get().getChallenger().getIdEventPlayer() == finishEventIn.getIdWinner()))
                    && (!event.get().isFinished())) {

                event.get().setFinished(true);
                event.get().setIdWinner(finishEventIn.getIdWinner());

                Event eventEntity = modelMapper.map(event, Event.class);
                eventRepository.save(eventEntity);
            } else {

                throw new Exception("An error occurred");
            }
        } catch (NoSuchElementException e) {

            System.out.println("An error occurred, event not found");
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
}
