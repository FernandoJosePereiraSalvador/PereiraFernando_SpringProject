package com.irojas.demojwt.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WelcomeController {

    @GetMapping({"/"})
    public String welcome(Model model) {
        String message = "CRUD de la NASA";
        String aboutMessage = "Welcome to the NASA CRUD application!<br><br>"
                + "To modify entities, use the following format:<br>"
                + "/api/entity-name/action<br><br>"
                + "Replace 'entity-name' with the name of the entity you want to modify, and 'action' with the desired action (e.g., create, read, update, delete).<br><br>"
                + "For example, to create a new Astronauta, use: /api/astronauta/create";

        model.addAttribute("message", message);
        model.addAttribute("aboutMessage", aboutMessage);

        return "welcome";
    }
}
