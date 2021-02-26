package com.example.control.controllers;

import com.example.control.models.State;
import com.example.control.models.Type;
import com.example.control.services.StateService;
import com.example.control.services.TypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Collection;
import java.util.List;

@Controller
@AllArgsConstructor
public class ViewListController {

    private final StateService stateService;
    private final TypeService typeService;

    @ModelAttribute("states")
    public Collection<State> populateStates() {
        return stateService.findAll();
    }

    @ModelAttribute("types")
    public Collection<Type> populateTypes() {
        return typeService.findAll();
    }
}
