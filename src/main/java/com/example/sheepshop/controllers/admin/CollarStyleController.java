package com.example.sheepshop.controllers.admin;

import com.example.sheepshop.entitys.Brand;
import com.example.sheepshop.entitys.CollarStyle;
import com.example.sheepshop.services.impl.CollarStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/admin/collar-style/")
public class CollarStyleController {

    @Autowired
    private CollarStyleService collarStyleService;

    @GetMapping("hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "1") int page) {

        CollarStyle collarStyle = new CollarStyle();
        model.addAttribute("collarStyle", collarStyle);

        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<CollarStyle> collarStyles = collarStyleService.getAllPage(pageable);
        model.addAttribute("collarStyles", collarStyles);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", collarStyles.getTotalPages());
        return "admin/collarstyle/collarstyle";
    }

    @GetMapping("detail/{id}")
    public String detail(
            Model model,
            @RequestParam(defaultValue = "1") int page,
            @PathVariable("id") UUID id
    ) {
        CollarStyle collarStyleDetail = collarStyleService.detail(id);
        model.addAttribute("collarStyle", collarStyleDetail);

        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<CollarStyle> collarStyles = collarStyleService.getAllPage(pageable);
        model.addAttribute("collarStyles", collarStyles);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", collarStyles.getTotalPages());
        return "admin/collarstyle/collarstyle";
    }


    @PostMapping("add")
    public String add(@ModelAttribute("collarStyle") CollarStyle collarStyle) {
        this.collarStyleService.add(collarStyle);
        return "redirect:/admin/collar-style/hien-thi";
    }
}
