package com.example.sheepshop.controllers.admin;


import com.example.sheepshop.entitys.*;
import com.example.sheepshop.repositorys.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin/product-details/")
public class ProductDetailController {

    @Autowired
    private ProductDetailRepository productDetailRepository;
    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private CollarStyleRepository collarStyleRepository;
    @Autowired
    private ColorRepository colorRepository;
    @Autowired
    private HandStyleRepository handStyleRepository;
    @Autowired
    private MaterialRepository materialRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private SizeRepository sizeRepository;

    @ModelAttribute("brands")
    public List<Brand> brandList() {
        return brandRepository.findAll();
    }

    @ModelAttribute("products")
    public List<Product> productList() {
        return productRepository.findAll();
    }

    @ModelAttribute("collarTypes")
    public List<CollarStyle> collarTypeList() {
        return collarStyleRepository.findAll();
    }

    @ModelAttribute("handStyles")
    public List<HandStyle> handStyleList() {
        return handStyleRepository.findAll();
    }

    @ModelAttribute("colors")
    public List<Color> colorList() {
        return colorRepository.findAll();
    }

    @ModelAttribute("sizes")
    public List<Size> sizeList() {
        return sizeRepository.findAll();
    }

    @ModelAttribute("materials")
    public List<Material> materialList() {
        return materialRepository.findAll();
    }

    @GetMapping("hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "1") int page) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<ProductDetail> productDetails = productDetailRepository.findAll(pageable);

        model.addAttribute("productDetails", productDetails);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productDetails.getTotalPages());
        return "admin/product/index";
    }

    @GetMapping("view-add")
    public String viewadd(Model model) {

        return "admin/product/add-product";
    }

}
