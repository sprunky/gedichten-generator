package com.jcore.gedichtengenerator.controller;

import com.jcore.gedichtengenerator.service.RhymeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileNotFoundException;

@Controller
public class SinterklaasController {
    private final RhymeService rhymeService;

    public SinterklaasController(RhymeService rhymeService) {
        this.rhymeService = rhymeService;
    }
    @GetMapping("")
    public String getGedicht(Model model) throws FileNotFoundException {
        model.addAttribute("gedicht", rhymeService.getRhymes());
        return "index";
    }

}
