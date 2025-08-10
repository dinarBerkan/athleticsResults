package com.bogazici.athleticsresult.repository;

import com.bogazici.athleticsresult.entity.Event;
import com.bogazici.athleticsresult.enumeration.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
    Event findByEventNameAndEventType(String eventName, EventType eventType);
}