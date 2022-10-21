package edu.miu.cs.cs425.fairfieldlibraryapp.controller;

import edu.miu.cs.cs425.fairfieldlibraryapp.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/fairfieldLibrary/sysadmin/publisher")
public class PublisherController {
    private PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping("/list") // /fairfieldLibrary/sysadmin/list
    public ModelAndView listPublishers() {
        var modelAndView = new ModelAndView();
        var publishers = publisherService.getPublishers();
        modelAndView.addObject("publishers", publishers);
        modelAndView.setViewName("secured/syssadmin/publisher/list");
        //TODO
        return modelAndView;
    }

    // old way of doing this
    /*public String listPublishers2(Model model) {
        model.addAttribute("publishers", "publishers");
        return "secured/syssadmin/publisher/list";
    }*/
}
