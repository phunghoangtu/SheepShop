package com.example.sheepshop.controllers.admin;

import com.example.sheepshop.entitys.Material;
import com.example.sheepshop.services.impl.MaterialSerivce;
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
@RequestMapping("/admin/material/")
public class MaterialController {

    @Autowired
    private MaterialSerivce materialSerivce;

    @GetMapping("hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "1") int page) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Material> materials = materialSerivce.getAllPage(pageable);
        model.addAttribute("materials", materials);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", materials.getTotalPages());
        return "admin/material/material";
    }

    @GetMapping("view-add")
    public String viewadd(Model model) {
        Material material = new Material();
        model.addAttribute("material", material);
        return "admin/material/add-material";
    }

    @GetMapping("view-update/{id}")
    public String viewupdate(@PathVariable("id") UUID id, Model model) {
        Material material  = materialSerivce.detail(id);
        model.addAttribute("material", material);
        return "admin/material/update-material";
    }

}
