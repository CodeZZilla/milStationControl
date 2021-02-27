package com.example.control.controllers;

import com.example.control.models.Thing;
import com.example.control.models.User;
import com.example.control.services.StateService;
import com.example.control.services.ThingService;
import com.example.control.services.TypeService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@AllArgsConstructor
public class EditController {

    private final ThingService thingService;
    private final TypeService typeService;
    private final StateService stateService;

    @GetMapping("/edit/{id}")
    public ModelAndView editPage(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("editForm");
        Thing thing = thingService.findById(id);
        mav.addObject("thing", thing);
        mav.addObject("states", stateService.findAll());
        mav.addObject("types", typeService.findAll());
        return mav;
    }

    @PostMapping("/save")
    public String editSave(@ModelAttribute("thing") Thing thing,
                           @AuthenticationPrincipal User user) {

        thing.setUnit(user.getUnit());
        thingService.save(thing);

        return "redirect:/";
    }
}
