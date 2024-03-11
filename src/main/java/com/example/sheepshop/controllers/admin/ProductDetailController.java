package com.example.sheepshop.controllers.admin;

import com.example.sheepshop.entitys.ProductDetail;
import com.example.sheepshop.services.impl.ProductDetailService;
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
@RequestMapping("/admin/product-details/")
public class ProductDetailController {

    @Autowired
    private ProductDetailService productDetailService;

    @GetMapping("hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "1") int page) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<ProductDetail> productDetails = productDetailService.getAll(pageable);

        model.addAttribute("productDetails", productDetails);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productDetails.getTotalPages());
        return "admin/index";
    }
}
