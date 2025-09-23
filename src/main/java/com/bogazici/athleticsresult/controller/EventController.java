package com.bogazici.athleticsresult.controller;

import com.bogazici.athleticsresult.request.CreateEventRequest;
import com.bogazici.athleticsresult.response.CreateEventResponse;
import com.bogazici.athleticsresult.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("event")
public class EventController {
    private final EventService eventService;

    @Autowired
    EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @PostMapping("/create-event")
    public CreateEventResponse createAthlete(@RequestBody CreateEventRequest request) {
        return eventService.createEvent(request);
    }
}