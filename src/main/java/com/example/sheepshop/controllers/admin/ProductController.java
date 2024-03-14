package com.example.sheepshop.controllers.admin;

import com.example.sheepshop.entitys.Brand;
import com.example.sheepshop.entitys.Category;
import com.example.sheepshop.entitys.Product;
import com.example.sheepshop.services.impl.CategoryService;
import com.example.sheepshop.services.impl.ProductService;
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
@RequestMapping("/admin/product/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "1") int page) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Product> products = productService.getAllPage(pageable);
        model.addAttribute("products", products);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", products.getTotalPages());
        return "admin/product/product";
    }

    @GetMapping("view-add")
    public String viewadd(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "admin/product/add-product";
    }

    @GetMapping("view-update/{id}")
    public String viewupdate(@PathVariable("id") UUID id, Model model) {
        Product product = productService.detail(id);
        model.addAttribute("product", product);
        List<Category> categories = categoryService.getAll();
        model.addAttribute("categories", categories);
        return "admin/product/update-product";
    }

}
