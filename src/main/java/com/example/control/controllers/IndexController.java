package com.example.control.controllers;

import com.example.control.models.*;
import com.example.control.services.PropertiesService;
import com.example.control.services.StateService;
import com.example.control.services.ThingService;
import com.example.control.services.TypeService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class IndexController {

    private final ThingService thingService;


    @GetMapping("/")
    public String getIndex(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("userPrincipal", user);
        model.addAttribute("things", thingService.findAllByIdUnit(user.getUnit().getId()));
        return "index";
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        thingService.deleteById(id);
        return "redirect:/";
    }
}
