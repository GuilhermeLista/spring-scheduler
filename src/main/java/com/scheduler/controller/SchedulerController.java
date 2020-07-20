package com.scheduler.controller;

import com.scheduler.application.service.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/com/scheduler")
public class SchedulerController {

    @Autowired
    private AgendaService service;

    @PostMapping(path = "/post/agenda")
    public ResponseEntity<Object> postAgenda(
            @RequestParam(value = "cron",required = true) Integer cron,
            @RequestBody(required = false) String body,
            Errors errors
    ){
        ResponseEntity<Object> response = null;
            if(cron > 0) {
                service.scheduleSomethingDinamically(cron);
                response = new ResponseEntity<>(HttpStatus.OK);
            }else {
                response = new ResponseEntity<Object>(errors.getAllErrors(),HttpStatus.BAD_REQUEST);
            }

        return response;
    }

}
