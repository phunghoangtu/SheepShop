package com.example.sheepshop.controllers.admin;


import com.example.sheepshop.entitys.*;
import com.example.sheepshop.repositorys.*;
import com.example.sheepshop.services.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/product-details/")
public class ProductDetailController {

    @Autowired
    private ProductDetailService productDetailService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private CollarStyleService collarStyleService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private HandStyleService handStyleService;
    @Autowired
    private MaterialSerivce materialSerivce;
    @Autowired
    private ProductService productService;
    @Autowired
    private SizeService sizeService;

    @GetMapping("hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "1") int page) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<ProductDetail> productDetails = productDetailService.getAllPage(pageable);

        model.addAttribute("productDetails", productDetails);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productDetails.getTotalPages());
        return "admin/product_detail/product_detail";
    }

    @GetMapping("view-add")
    public String viewadd(Model model) {
        ProductDetail productDetail = new ProductDetail();
        model.addAttribute("productDetail",productDetail);

        List<Brand> brands = brandService.getAll();
        model.addAttribute("brands", brands);
        List<CollarStyle> collarStyles = collarStyleService.getAll();
        model.addAttribute("collarTypes", collarStyles);
        List<Color> colors = colorService.getAll();
        model.addAttribute("colors", colors);
        List<HandStyle> handStyles = handStyleService.getAll();
        model.addAttribute("handStyles", handStyles);
        List<Material> materials = materialSerivce.getAll();
        model.addAttribute("materials", materials);
        List<Product> products = productService.getAll();
        model.addAttribute("products", products);
        List<Size> sizes = sizeService.getAll();
        model.addAttribute("sizes", sizes);

        return "admin/product_detail/add-product";
    }

    @PostMapping("add")
    public String add(
            Model model ,
            @ModelAttribute("productDetail") ProductDetail productDetail
    ) {
        this.productDetailService.add(productDetail);
        return "redirect:/admin/product-details/add";
    }

}
