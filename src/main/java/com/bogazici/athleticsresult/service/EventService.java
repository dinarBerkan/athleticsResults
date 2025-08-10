package com.bogazici.athleticsresult.service;

import com.bogazici.athleticsresult.dto.AthleteDto;
import com.bogazici.athleticsresult.dto.EventDto;
import com.bogazici.athleticsresult.entity.Athlete;
import com.bogazici.athleticsresult.entity.Event;
import com.bogazici.athleticsresult.enumeration.EventType;
import com.bogazici.athleticsresult.enumeration.Gender;
import com.bogazici.athleticsresult.repository.AthleteRepository;
import com.bogazici.athleticsresult.repository.EventRepository;
import com.bogazici.athleticsresult.request.CreateAthleteRequest;
import com.bogazici.athleticsresult.response.CreateAthleteResponse;
import com.bogazici.athleticsresult.response.GetAthleteInformationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event getEventByNameAndType(String eventName, EventType eventType) {
        Event event = eventRepository.findByEventNameAndEventType(eventName, eventType);
        if(event == null) {
            throw new RuntimeException("Event with name " + eventName + " and type " + eventType + " not found");
        }
        return event;
    }

    public Event getEventForResult(Long eventId) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);
        if(eventOptional.isPresent()) {
            return eventOptional.get();
        } else {
            throw new RuntimeException("Event with id " + eventId + " not found");
        }
    }
}