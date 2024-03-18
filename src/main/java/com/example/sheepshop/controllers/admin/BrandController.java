package com.example.sheepshop.controllers.admin;

import com.example.sheepshop.entitys.Brand;
import com.example.sheepshop.entitys.Category;
import com.example.sheepshop.entitys.Material;
import com.example.sheepshop.services.impl.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/admin/brand/")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("hien-thi")
    public String hienthi(
            Model model,
            @RequestParam(defaultValue = "1") int page
    ) {

        Brand brand = new Brand();
        model.addAttribute("brand", brand);

        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Brand> brands = brandService.getAllPage(pageable);
        model.addAttribute("brands", brands);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", brands.getTotalPages());
        return "admin/brand/brand";
    }

    @GetMapping("detail/{id}")
    public String detail(
            Model model,
            @RequestParam(defaultValue = "1") int page,
            @PathVariable("id") UUID id
    ) {
        Brand brandDetail = brandService.detail(id);
        model.addAttribute("brand",brandDetail);

        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Brand> brands = brandService.getAllPage(pageable);
        model.addAttribute("brands", brands);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", brands.getTotalPages());
        return "admin/brand/brand";
    }


    @PostMapping("add")
    public String add(@ModelAttribute("brand") Brand brand) {
        this.brandService.add(brand);
        return "redirect:/admin/brand/hien-thi";
    }

}
