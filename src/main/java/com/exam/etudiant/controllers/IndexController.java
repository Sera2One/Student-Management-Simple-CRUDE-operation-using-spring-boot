package com.exam.etudiant.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Homepage controller.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    String index() {
        return "index"; 
    }
    @RequestMapping("informations_sur_les_developpers")
    String info() {
        return "developper_info"; 
    }

}
