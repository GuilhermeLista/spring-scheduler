package com.scheduler.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class Agenda implements Serializable {

    private String name;
    public static Integer cron;
}
