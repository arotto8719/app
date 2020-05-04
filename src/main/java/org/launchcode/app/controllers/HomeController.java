package org.launchcode.app.controllers;

import org.launchcode.app.data.Artifact;
import org.launchcode.app.data.ArtifactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Id;
import javax.validation.Valid;
import java.util.HashMap;


@Controller
public class HomeController {

    @Autowired
    private ArtifactRepository artifactRepository;

    @RequestMapping(value = "/")
    public String index(Model model) {
//        model.addAttribute("database", "Database");
//        model.addAttribute("images", "Images");
        model.addAttribute("add", "Add");
        model.addAttribute("search", "Search");
        model.addAttribute("edit", "Edit");
        model.addAttribute("delete", "Delete");
//        model.addAttribute("thePost", thePost);
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
//    @RequestMapping(value="edit/{postId}", method = RequestMethod.GET)
//    public String displayEditForm(Model model, @PathVariable int postId){
//        Post thePost = PostData.findById(postId).get();
//        model.addAttribute("thePost", thePost);
//        return "pages/edit";
//    }
//
//    @RequestMapping(value="edit", method=RequestMethod.POST)
//    public String processEditForm(@RequestParam(value="post_id") int post_id, @RequestParam(value="title") String title, @RequestParam(value="description") String description, Model model) {
//        Post thePost = PostData.findById(post_id).get();
//        thePost.setTitle(title);
//        thePost.setDescription(description);
//        PostData.save(thePost);
//        return "redirect:";
//    }
    @RequestMapping(value="edit/{postId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int postId, Error error){
        Artifact thePost = artifactRepository.findById(postId).get();
//        artifactRepository.save(thePost);
        model.addAttribute("thePost", thePost);
        return "index";
    }

    @RequestMapping(value="edit", method=RequestMethod.POST)
    public String processEditForm(@RequestParam(value="post_id") int post_id, @RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="description") String description, Model model) {
        Artifact thePost = artifactRepository.findById(post_id).get();
        thePost.setName(name);
        thePost.setLocation(location);
        thePost.setDescription(description);
        artifactRepository.save(thePost);
        return "index";
    }
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id) {
            artifactRepository.deleteById(id);
        return "index";
    }

    @GetMapping("view/{artifactId}")
    public String displayViewArtifactId(Model model, @PathVariable int Id) {
        return "index";
    }

//    @GetMapping("view/{Images}")
//    public String displayViewImagesId(Model model, @PathVariable int Id) {
//        return "images";
//    }
}
