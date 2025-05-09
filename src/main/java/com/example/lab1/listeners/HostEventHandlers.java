package com.example.lab1.listeners;

import com.example.lab1.events.HostChangedEvent;
import com.example.lab1.events.HostCreatedEvent;
import com.example.lab1.events.HostDeletedEvent;
import com.example.lab1.services.application.CountryApplicationService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class HostEventHandlers {
    private final CountryApplicationService countryApplicationService;

    public HostEventHandlers(CountryApplicationService countryApplicationService) {
        this.countryApplicationService = countryApplicationService;
    }

    @EventListener
    public void onHostCreated(HostCreatedEvent event) {
        this.countryApplicationService.refreshMaterializedView();
    }
    @EventListener
    public void onHostDeleted(HostDeletedEvent event) {
        this.countryApplicationService.refreshMaterializedView();
    }
    @EventListener
    public void onHostChanged(HostChangedEvent event) {
        this.countryApplicationService.refreshMaterializedView();
    }
}