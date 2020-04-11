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

    @Autowired
    private ArtifactRepository artifactRepository;

    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("add", "Add");
        model.addAttribute("search", "Search");
        model.addAttribute("edit", "Edit");
        model.addAttribute("delete", "Delete");
        model.addAttribute("artifacts", artifactRepository.findAll());
        HashMap<String, String> actionChoices = new HashMap<>();
        return "index";
    }

    @GetMapping("add")
    public String displayAddArtifactForm(Model model) {
        model.addAttribute(new Artifact());
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
            return "index";
        }
    }
    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") int id) {
        artifactRepository.editById(id);
        return "edit";
    }
    @GetMapping("edit/{Id}")
    public String displayEditForm(Model model, @PathVariable int Id) {
        model.addAttribute(new Artifact());
//        model.addAttribute("artifact", edit Artifact());
        return "index";
    }
    @PostMapping("edit/{Id}")
    public String processEditForm(@RequestParam String artifactId) {
        artifact.edit(new Artifact(artifactId));
        return "redirect:";
    }
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {
            artifactRepository.deleteById(id);
        return "index";
    }
    @GetMapping("view/{Id}")
    public String displayViewArtifact(Model model, @PathVariable int Id) {
        return "index";
    }
}

