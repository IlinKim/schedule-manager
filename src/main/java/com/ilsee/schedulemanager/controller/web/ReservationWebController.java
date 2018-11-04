package com.ilsee.schedulemanager.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationWebController {
    @GetMapping("/")
    public String home() {
      return "redirect:/timeTable";
    };

    @GetMapping("/timeTable")
    public String timeTable() {
        return "timeTable";
    }

    @GetMapping("/manageRoom")
    public String manageRoom() {
        return "manageRoom";
    }
}
