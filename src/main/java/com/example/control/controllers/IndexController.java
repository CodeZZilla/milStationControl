package com.example.control.controllers;

import com.example.control.models.User;
import com.example.control.services.ThingService;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.File;

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

    @GetMapping("/generate")
    public ResponseEntity getPDF(@AuthenticationPrincipal User user) throws Exception {
        byte[] contents;
        try {

            contents = FileUtils.readFileToByteArray(new File("document.xlsx"));
            HttpHeaders headers = new HttpHeaders();

            // Here you have to set the actual filename of your pdf
            String filename = "dodatok.xlsx";
            headers.setContentDispositionFormData(filename, filename);
            headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
            ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
            return response;
        } catch (Exception e) {
            return new ResponseEntity("Err", HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
