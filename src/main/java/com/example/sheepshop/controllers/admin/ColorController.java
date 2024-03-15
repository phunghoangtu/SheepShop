package com.example.sheepshop.controllers.admin;

import com.example.sheepshop.entitys.Color;
import com.example.sheepshop.services.impl.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/admin/color/")
public class ColorController {

    @Autowired
    private ColorService colorService;

    @GetMapping("hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "1") int page) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Color> colors = colorService.getAllPage(pageable);
        model.addAttribute("colors", colors);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", colors.getTotalPages());
        return "admin/color/color";
    }

}
