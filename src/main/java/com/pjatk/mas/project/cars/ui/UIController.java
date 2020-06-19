package com.pjatk.mas.project.cars.ui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UIController {
    @RequestMapping(value = {"/", "/carInfo"})
    public String index() {
        return "index";
    }
}
