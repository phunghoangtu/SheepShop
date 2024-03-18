package com.example.sheepshop.controllers.admin;

import com.example.sheepshop.entitys.CollarStyle;
import com.example.sheepshop.entitys.HandStyle;
import com.example.sheepshop.services.impl.HandStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/admin/hand-style/")
public class HandStyleController {

    @Autowired
    private HandStyleService handStyleService;

    @GetMapping("hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "1") int page) {

        HandStyle handStyle = new HandStyle();
        model.addAttribute("handStyle", handStyle);

        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<HandStyle> handStyles = handStyleService.getAllPage(pageable);
        model.addAttribute("handStyles", handStyles);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", handStyles.getTotalPages());
        return "admin/handstyle/handstyle";
    }

    @GetMapping("detail/{id}")
    public String detail(
            Model model,
            @RequestParam(defaultValue = "1") int page,
            @PathVariable("id") UUID id
    ) {
        HandStyle handStyleDetail = handStyleService.detail(id);
        model.addAttribute("handStyle", handStyleDetail);

        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<HandStyle> handStyles = handStyleService.getAllPage(pageable);
        model.addAttribute("handStyles", handStyles);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", handStyles.getTotalPages());
        return "admin/handstyle/handstyle";
    }


    @PostMapping("add")
    public String add(@ModelAttribute("handStyle") HandStyle handStyle) {
        this.handStyleService.add(handStyle);
        return "redirect:/admin/hand-style/hien-thi";
    }

}
