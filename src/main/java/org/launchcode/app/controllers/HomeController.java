package org.launchcode.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;


@Controller
public class HomeController {

    @RequestMapping(value = "")
    public String index(Model model) {

        HashMap<String, String> actionChoices = new HashMap<>();
        actionChoices.put("search", "Search");
        actionChoices.put("add", "Add");

        return "index";
    }
    @GetMapping("/add")
    @ResponseBody
    public String add() {
        return "add objects";
    }

}
