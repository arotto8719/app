package org.launchcode.app.controllers;
import org.launchcode.app.data.Artifact;
import org.launchcode.app.data.ArtifactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SearchController {

    @Autowired
    private ArtifactRepository artifactRepository;

    @RequestMapping("/search")
    @ResponseBody
    public String search() {
        return "search";
    }

//    @PostMapping("results")
//    public String displaySearchResults(Model model, @RequestParam String searchType, @RequestParam String searchTerm) {
//        Iterable<Artifact> artifacts;
//        if (searchTerm.toLowerCase().equals("all") || searchTerm.equals("")) {
//            artifacts = artifactRepository.findAll();
//            return "search";
//        }
//    }
}
