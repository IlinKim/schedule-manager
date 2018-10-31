package com.ilsee.schedulemanager.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/reservation")
@Controller
public class ReservationController {

    @RequestMapping("/dashboard")
    public String test() {
        return "dashboard";
    }
}
