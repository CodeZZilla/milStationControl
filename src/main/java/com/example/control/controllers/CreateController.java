package com.example.control.controllers;

import com.example.control.models.Properties;
import com.example.control.models.Thing;
import com.example.control.models.User;
import com.example.control.services.StateService;
import com.example.control.services.ThingService;
import com.example.control.services.TypeService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class CreateController {

    private final StateService stateService;
    private final TypeService typeService;
    private final ThingService thingService;

    @GetMapping("/create")
    public String createPage(@AuthenticationPrincipal User user, Model model) {
        Thing thing = new Thing();
        model.addAttribute("thing", thing);
//        model.addAttribute("properties", new Properties());
        model.addAttribute("states", stateService.findAll());
        model.addAttribute("types", typeService.findAll());



        return "createForm";
    }


}
