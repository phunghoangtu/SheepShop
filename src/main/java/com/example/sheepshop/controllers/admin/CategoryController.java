package com.example.sheepshop.controllers.admin;


import com.example.sheepshop.entitys.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

//@Controller
//@RequestMapping("/admin/category/")
public class CategoryController {

//    @Autowired
//    private CategoryService categoryService;
//
//    @GetMapping("hien-thi")
//    public String hienthi(
//            Model model,
//            @RequestParam(defaultValue = "1") int page
//    ) {
//        Category category = new Category();
//        model.addAttribute("category", category);
//        int pageSize = 5;
//        Pageable pageable = PageRequest.of(page - 1, pageSize);
//        Page<Category> categories = categoryService.getAllPage(pageable);
//        model.addAttribute("categories", categories);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", categories.getTotalPages());
//        return "admin/category/category";
//    }
//
//    @GetMapping("detail/{id}")
//    public String detail(
//            Model model,
//            @RequestParam(defaultValue = "1") int page,
//            @PathVariable("id") UUID id
//    ) {
//        Category categoryDetail = categoryService.detail(id);
//        model.addAttribute("category", categoryDetail);
//
//        int pageSize = 5;
//        Pageable pageable = PageRequest.of(page - 1, pageSize);
//        Page<Category> categories = categoryService.getAllPage(pageable);
//        model.addAttribute("categories", categories);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", categories.getTotalPages());
//        return "admin/category/category";
//    }
//
//
//    @PostMapping("add")
//    public String add(@ModelAttribute("category") Category category) {
//        this.categoryService.add(category);
//        return "redirect:/admin/category/hien-thi";
//    }

}
