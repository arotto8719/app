package org.launchcode.app.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SearchController {

@RequestMapping("/search")
@ResponseBody
    public String search() {
        return "search/index";
    }
}
