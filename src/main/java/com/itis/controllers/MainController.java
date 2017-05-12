package com.itis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by maratgatin on 12/05/2017.
 */
@Controller
public class MainController {

    @GetMapping(value = "/")
    public String index(){
        return "index";
  
    @GetMapping(value = "/news")
    public String news(){
        return "news";
      
    }
}
