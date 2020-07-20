package com.scheduler.application.scheduler;

import com.scheduler.domain.Agenda;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
@ComponentScan(basePackages = {"com.scheduler.application.*"})
public class SchedulerConfiguration {


    @Bean("Agenda")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Agenda getAgenda(){
        return new Agenda();
    }
}
