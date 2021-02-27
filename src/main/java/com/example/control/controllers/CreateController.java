package com.example.control.controllers;

import com.example.control.models.*;
import com.example.control.services.StateService;
import com.example.control.services.ThingService;
import com.example.control.services.TypeService;
import com.example.control.services.UnitService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@AllArgsConstructor
public class CreateController {

    private final StateService stateService;
    private final TypeService typeService;
    private final ThingService thingService;



    //Test
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("thing", thingService.createThing());
        model.addAttribute("states", stateService.findAll());
        model.addAttribute("types", typeService.findAll());
        return "create";
    }

    @RequestMapping(value="/create", params={"addThing"})
    public String addThing(final Thing thing, final BindingResult bindingResult) {
        thingService.addThing(thing);
        return "create";
    }

    @RequestMapping(value="/create", params={"removeThing"})
    public String removeRow(final Thing thing, final BindingResult bindingResult, final HttpServletRequest req) {
        thingService.removeThing(thing, Long.valueOf(req.getParameter("removeThing")));
        return "create";
    }

    @RequestMapping(value="/create", params={"save"})
    public String saveThing(final Thing thing, final BindingResult bindingResult,
                            @AuthenticationPrincipal User user) {
        if (bindingResult.hasErrors()) {
            return "index";
        }

        thing.setUnit(user.getUnit());
        thing.getThings().stream().forEach(x -> {
            x.setUnit(user.getUnit());
            x.setParentThing(thing);
            thingService.save(x);
        });
        thing.getThings().stream().forEach(System.out::println);
        thingService.save(thing);
        return "redirect:/";
    }


    @ModelAttribute("allStates")
    public List<State> populateStates() {
        return this.stateService.findAll();
    }

    @ModelAttribute("allTypes")
    public List<Type> populateTypes() {
        return this.typeService.findAll();
    }

}
