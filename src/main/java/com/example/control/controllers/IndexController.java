package com.example.control.controllers;

import com.example.control.models.Properties;
import com.example.control.models.State;
import com.example.control.models.Thing;
import com.example.control.models.Type;
import com.example.control.services.PropertiesService;
import com.example.control.services.StateService;
import com.example.control.services.ThingService;
import com.example.control.services.TypeService;
import lombok.AllArgsConstructor;
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
    private final StateService stateService;
    private final PropertiesService propertiesService;
    private final TypeService typeService;


    @GetMapping("/")
    public String getIndex(Model model) {
        model.addAttribute("things", thingService.findAll());
        return "index";
    }



//    @PostMapping("/save")
//    public String saveThings(@ModelAttribute("thing") Thing thing,
//                             @ModelAttribute("properties") Properties properties, Model model) {
//
//        model.addAttribute("thing", thing);
//        model.addAttribute("properties", properties);
//
//        properties.setThing(thing);
//        thing.setProperties(properties);
//        propertiesService.save(properties);
//        thingService.save(thing);
//        return "index";
//    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Long id) {
        thingService.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/save")
    public String createSave(@ModelAttribute("thing") Thing thing) {

        thingService.save(thing);

        return "redirect:/";
    }




}
