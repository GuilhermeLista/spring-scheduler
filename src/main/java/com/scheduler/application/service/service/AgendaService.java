package com.scheduler.application.service.service;

import org.springframework.stereotype.Service;

public interface AgendaService {

    public void scheduleSomething();

    public void scheduleSomethingDinamically(Integer cron);
}
