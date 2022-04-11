package com.vber.spfaeeventservice.service;

import org.springframework.stereotype.Service;

import com.vber.spfaeeventservice.repository.EventRepositoryJdbc;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventService {

  private final EventRepositoryJdbc eventRepositoryJdbc;

  public String vEvent() {
    return eventRepositoryJdbc.vEvent();
  }
  
  public int eventCount() {
    return eventRepositoryJdbc.eventCount();
  }
  
// this method is just for testing
  public int eventCountStub() {
    return 6;
  }
}
