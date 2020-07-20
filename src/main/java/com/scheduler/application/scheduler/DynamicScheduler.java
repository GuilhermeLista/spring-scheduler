package com.scheduler.application.scheduler;

import com.scheduler.domain.Agenda;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Configuration
public class DynamicScheduler implements SchedulingConfigurer {


    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running Schedular..." + Calendar.getInstance().getTime());
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                Calendar nextExecutionTime = new GregorianCalendar();
                Date lastActualExecutionTime = triggerContext.lastActualExecutionTime();
                nextExecutionTime.setTime(lastActualExecutionTime != null ? lastActualExecutionTime : new Date());
                nextExecutionTime.add(Calendar.MILLISECOND, getNewExecutionTime());
                return nextExecutionTime.getTime();
            }
        });
    }

    private Integer getNewExecutionTime() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SchedulerConfiguration.class);
        Agenda agenda = context.getBean("Agenda", Agenda.class);
        System.out.println("Agenda cron is: "+agenda.cron);
        context.close();

        return agenda.cron == null ? 10000 : agenda.cron;
    }
}
