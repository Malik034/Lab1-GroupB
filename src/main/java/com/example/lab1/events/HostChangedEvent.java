package com.example.lab1.events;

import com.example.lab1.model.domain.Host;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.time.LocalDateTime;

@Getter
public class HostChangedEvent extends ApplicationEvent {

    private final LocalDateTime when;

    public HostChangedEvent(Host source) {
        super(source);
        this.when = LocalDateTime.now();
    }
}