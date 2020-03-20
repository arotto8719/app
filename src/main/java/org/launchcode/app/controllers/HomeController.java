package org.launchcode.app.controllers;

import org.launchcode.app.data.Artifact;
import org.launchcode.app.data.ArtifactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;


@Controller
public class HomeController {

//    @GetMapping
//    public String index() {
//        return "index";
//    }
//
//    @GetMapping
//    public String add() {
//        return "add";
//    }
    @Autowired
    private ArtifactRepository artifactRepository;

    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("search", "Search");
        model.addAttribute("add", "Add");
        model.addAttribute("artifacts", artifactRepository.findAll());
//        HashMap<String, String> actionChoices = new HashMap<>();
//        actionChoices.put("search", "Search");
//        actionChoices.put("add", "Add");
        return "index";
    }

    @GetMapping("add")
    public String displayAddArtifactForm(Model model) {
        model.addAttribute("artifact", new Artifact());
        return "add";
    }

    @PostMapping("add")
    @ResponseBody
    public String processAddArtifactForm(@ModelAttribute @Valid Artifact newArtifact,
                                         Errors errors) {
        if (errors.hasErrors()) {
            return "add";
        } else {
            artifactRepository.save(newArtifact);
            return "redirect:";
        }
    }
}

