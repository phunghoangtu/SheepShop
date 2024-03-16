package com.example.sheepshop.controllers.admin;

import com.example.sheepshop.entitys.Brand;
import com.example.sheepshop.services.impl.BrandService;
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

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/admin/brand/")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "1") int page) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Brand> brands = brandService.getAllPage(pageable);
        model.addAttribute("brands", brands);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", brands.getTotalPages());
        return "admin/brand/brand";
    }

    @GetMapping("view-add")
    public String viewadd(Model model) {
        Brand brand = new Brand();
        model.addAttribute("brand", brand);
        return "admin/brand/add-brand";
    }

    @GetMapping("view-update/{id}")
    public String viewupdate(@PathVariable("id") UUID id, Model model) {
        Brand brand  = brandService.detail(id);
        model.addAttribute("brand", brand);
        return "admin/brand/update-brand";
    }

}
