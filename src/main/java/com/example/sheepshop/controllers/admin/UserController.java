package com.example.sheepshop.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @RequestMapping("/logon")
    public String index() {
        return "admin/logon";
    }

}
