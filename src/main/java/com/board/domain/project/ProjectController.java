package com.board.domain.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectController {
    @GetMapping("/project/work")
    public String openProjectWork() {
        return "project/work";
    }
    @GetMapping("/project/capstone")
    public String openProjectCapstone() {
        return "project/capstone";
    }
    @GetMapping("/project/smart")
    public String openProjectSmart() {
        return "project/smart";
    }
    @GetMapping("/project/solar")
    public String openProjectSolar() {
        return "project/solar";
    }


}
