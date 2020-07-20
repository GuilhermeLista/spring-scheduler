package com.scheduler.application.service.service.impl;

import com.scheduler.application.scheduler.SchedulerConfiguration;
import com.scheduler.application.service.service.AgendaService;
import com.scheduler.domain.Agenda;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class AgendaServiceImpl implements AgendaService {

    public void scheduleSomething(){
        System.out.println("scheduling something");
    }

    public void scheduleSomethingDinamically(Integer cron){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SchedulerConfiguration.class);

        Agenda agenda = context.getBean("Agenda",Agenda.class);
        agenda.cron = cron;
        context.close();
    }

}
