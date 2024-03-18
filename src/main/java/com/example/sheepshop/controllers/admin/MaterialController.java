package com.example.sheepshop.controllers.admin;

import com.example.sheepshop.entitys.Category;
import com.example.sheepshop.entitys.Material;
import com.example.sheepshop.services.impl.MaterialSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/admin/material/")
public class MaterialController {

    @Autowired
    private MaterialSerivce materialSerivce;

    @GetMapping("hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "1") int page) {

        Material material = new Material();
        model.addAttribute("material", material);

        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Material> materials = materialSerivce.getAllPage(pageable);
        model.addAttribute("materials", materials);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", materials.getTotalPages());
        return "admin/material/material";
    }

    @GetMapping("detail/{id}")
    public String detail(
            Model model,
            @RequestParam(defaultValue = "1") int page,
            @PathVariable("id") UUID id
    ) {
        Material materialDetail = materialSerivce.detail(id);
        model.addAttribute("material", materialDetail);

        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Material> materials = materialSerivce.getAllPage(pageable);
        model.addAttribute("materials", materials);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", materials.getTotalPages());
        return "admin/material/material";
    }


    @PostMapping("add")
    public String add(@ModelAttribute("material") Material material) {
        this.materialSerivce.add(material);
        return "redirect:/admin/material/hien-thi";
    }



}
