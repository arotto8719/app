package org.launchcode.app.controllers;

import org.launchcode.app.data.Artifact;
import org.launchcode.app.data.ArtifactRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;


@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index(Model model) {

        HashMap<String, String> actionChoices = new HashMap<>();
        actionChoices.put("search", "Search");
        actionChoices.put("add", "Add");
        return "index";
    }

    @GetMapping("add")
    @ResponseBody
    public String displayAddArtifactForm(Model model) {
        model.addAttribute("artifact", new Artifact());
        return "add";
    }
 }

