package edu.miu.cs.cs425.fairfieldlibraryapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"", "/", "fairfieldLibrary"})
public class HomePageController {
    @GetMapping(value = {"", "/", "/fairfieldLibrary"})
    public String displayHomepage() {
        return "index";
    }
    @GetMapping(value = {"/about"})
    public String displayAboutUsPage() {
        return "about";
    }
}
