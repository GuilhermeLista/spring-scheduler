package com.scheduler.application;

import com.scheduler.application.service.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerAgenda {

    private final long SECOND = 1000;
    private final long MINUTE = SECOND * 60;

    @Autowired
    AgendaService service;

    @Scheduled(fixedRate = SECOND * 5)
    public void schedulingAgenda(){
        service.scheduleSomething();
    }
}
