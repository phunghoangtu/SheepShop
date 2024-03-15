package com.example.sheepshop.controllers.admin;

import com.example.sheepshop.entitys.HandStyle;
import com.example.sheepshop.services.impl.HandStyleService;
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
@RequestMapping("/admin/hand-style/")
public class HandStyleController {

    @Autowired
    private HandStyleService handStyleService;

    @GetMapping("hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "1") int page) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<HandStyle> handStyles = handStyleService.getAllPage(pageable);
        model.addAttribute("handStyles", handStyles);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", handStyles.getTotalPages());
        return "admin/handstyle/handstyle";
    }

}
