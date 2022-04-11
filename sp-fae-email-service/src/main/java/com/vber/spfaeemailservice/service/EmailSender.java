package com.vber.spfaeemailservice.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmailSender {

  public void sendEmail(String eventId) {
    log.info("An email is sent for eventId {}", eventId);
}

}
