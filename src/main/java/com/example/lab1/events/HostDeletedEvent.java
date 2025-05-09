package com.example.lab1.events;

import com.example.lab1.model.domain.Host;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

public class HostDeletedEvent extends ApplicationEvent {

    private final LocalDateTime when;

    public HostDeletedEvent(Host source) {
        super(source);
        this.when = LocalDateTime.now();
    }
}