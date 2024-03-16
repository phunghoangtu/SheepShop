package com.example.sheepshop.controllers.admin;

import com.example.sheepshop.entitys.CollarStyle;
import com.example.sheepshop.services.impl.CollarStyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
@RequestMapping("/admin/collar-style/")
public class CollarStyleController {

    @Autowired
    private CollarStyleService collarStyleService;

    @GetMapping("hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "1") int page) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<CollarStyle> collarStyles = collarStyleService.getAllPage(pageable);
        model.addAttribute("collarStyles", collarStyles);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", collarStyles.getTotalPages());
        return "admin/collarstyle/collarstyle";
    }

    @GetMapping("view-add")
    public String viewadd(Model model) {
        CollarStyle collarStyle = new CollarStyle();
        model.addAttribute("collarStyle", collarStyle);
        return "admin/collarstyle/add-collarstyle";
    }

    @GetMapping("view-update/{id}")
    public String viewupdate(@PathVariable("id") UUID id, Model model) {
        CollarStyle collarStyle  = collarStyleService.detail(id);
        model.addAttribute("collarStyle", collarStyle);
        return "admin/collarstyle/update-collarstyle";
    }
}
