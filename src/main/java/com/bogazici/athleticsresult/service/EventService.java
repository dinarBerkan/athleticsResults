package com.bogazici.athleticsresult.service;


import com.bogazici.athleticsresult.entity.Event;
import com.bogazici.athleticsresult.entity.IndoorEvent;
import com.bogazici.athleticsresult.entity.OutdoorEvent;
import com.bogazici.athleticsresult.enumeration.EventType;
import com.bogazici.athleticsresult.repository.EventRepository;
import com.bogazici.athleticsresult.request.CreateEventRequest;
import com.bogazici.athleticsresult.response.CreateEventResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public CreateEventResponse createEvent(CreateEventRequest createEventRequest) {
        Event eventToSave;
        if(EventType.INDOOR.equals(createEventRequest.getEventType())) {
            IndoorEvent indoorEvent = new IndoorEvent();
            indoorEvent.setEventName(createEventRequest.getEventName());
            indoorEvent.setGender(createEventRequest.getGender());
            eventToSave = indoorEvent;
        } else {
            OutdoorEvent outdoorEvent = new OutdoorEvent();
            outdoorEvent.setEventName(createEventRequest.getEventName());
            outdoorEvent.setGender(createEventRequest.getGender());
            eventToSave = outdoorEvent;
        }
        eventRepository.save(eventToSave);
        return CreateEventResponse.builder().eventId(eventToSave.getId()).message("Event created successfully").success(Boolean.TRUE).build();
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