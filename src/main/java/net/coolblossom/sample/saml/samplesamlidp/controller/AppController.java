package net.coolblossom.sample.saml.samplesamlidp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    @RequestMapping("/")
    public String selectProvider() {
        return "redirect:/saml/idp/select";
    }

}
