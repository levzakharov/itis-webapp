package com.itis.controller;

import com.itis.utils.ApplicationUrls;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by maratgatin on 27/05/2017.
 */
@Controller
@RequestMapping(ApplicationUrls.WebAppUrls.BASE_RAITING_URL)
public class RaitingController {

    @GetMapping
    public String getRaitingPage(){
        return "raiting/raiting";
    }
}
