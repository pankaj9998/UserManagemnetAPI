package com.example.user.controller;



import com.example.user.service.StringUtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/string")
public class StringUtilController {
    @Autowired
    private StringUtilService stringUtilService;

    @GetMapping("/permutations")
    public Set<String> getPermutations(@RequestParam String input) {
        return stringUtilService.uniquePermutations(input);
    }
}