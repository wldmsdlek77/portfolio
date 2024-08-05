package com.board.domain.profile;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {
    @GetMapping("/profile/about")
    public String openProfileAbout() {
        return "profile/about";
    }

    @GetMapping("/profile/expr")
    public String openProfileExpr() {
        return "profile/expr";
    }

    @GetMapping("/profile/skills")
    public String openProfileSkills() {
        return "profile/skills";
    }

    @GetMapping("/profile/awards")
    public String openProfileAwards() {
        return "profile/awards";
    }
}
