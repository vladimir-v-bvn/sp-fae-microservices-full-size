package com.vber.spfaeeventservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vber.spfaeeventservice.service.EventService;


@RestController
@RequestMapping("/api/v1/event")
public class EventController {

  @Autowired
  EventService eventService;

//LOG.info("EventsController");

  @GetMapping
  public ResponseEntity<String> vEvents() {
    return ResponseEntity.status(HttpStatus.OK).header("Custom-Header", "").body(eventService.vEvent());
  }

}
