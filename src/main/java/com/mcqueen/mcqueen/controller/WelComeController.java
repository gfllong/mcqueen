package com.mcqueen.mcqueen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * Created by gfl on 2018/4/4 14:54
 * Email:gfl@cheok.com.
 */
@Controller
public class WelComeController  {

    @GetMapping("/index")
    public ModelAndView welcome(Map<String, Object> model) {
        model.put("welcome", "welcome");
        return new ModelAndView("welcome");
    }

}
