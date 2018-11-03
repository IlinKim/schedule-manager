package com.ilsee.schedulemanager.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimeTableController {

    @GetMapping("/timetable")
    public String timeTable() {
        return "timeTable";
    }

}
