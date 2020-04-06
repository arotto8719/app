package org.launchcode.app.controllers;
import org.launchcode.app.data.Artifact;
import org.launchcode.app.data.ArtifactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import static org.launchcode.app.controllers.SearchController.columnChoices;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private ArtifactRepository artifactRepository;

    static HashMap<String, String> columnChoices = new HashMap<>();

    @RequestMapping("")
    public String search(Model model) {
        model.addAttribute("columns", columnChoices);
        return "search";
    }

    @PostMapping("results")
    public String displaySearchResults(Model model) {
        Iterable<Artifact> artifacts;
        artifacts = artifactRepository.findAll();
        model.addAttribute("columns", columnChoices);
        model.addAttribute("artifacts",artifacts);
        return"search";
    }
//        } else {
//            artifacts = artifactRepository.findAll(searchType, searchTerm, jobRepository.findAll());
//            artifacts = JobData.findByColumnAndValue(searchType, searchTerm, jobRepository.findAll());
//        }
//
//        model.addAttribute("title", "Jobs with " + columnChoices.get(searchType) + ": " + searchTerm);
//
//
//        return "search";
    }


