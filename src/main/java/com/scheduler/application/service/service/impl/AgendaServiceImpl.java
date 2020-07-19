package com.scheduler.application.service.service.impl;

import com.scheduler.application.service.service.AgendaService;
import org.springframework.stereotype.Service;

@Service
public class AgendaServiceImpl implements AgendaService {

    public void scheduleSomething(){
        System.out.println("scheduling something");
    }

}
