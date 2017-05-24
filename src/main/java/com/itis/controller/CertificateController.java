package com.itis.controller;

import com.itis.utils.ApplicationUrls;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by maratgatin on 24/05/2017.
 */
@Controller
@RequestMapping(ApplicationUrls.WebAppUrls.BASE_CERTIFICATE_URL)
public class CertificateController {

    @GetMapping
    public String getCertificatePage(){
        return "certificate/certificate";//надо сделать разделение по ролям, деканат получает certificate/certificate_dean
    }

}
