package com.example.sheepshop.controllers.admin;

import com.example.sheepshop.entitys.Brand;
import com.example.sheepshop.entitys.Size;
import com.example.sheepshop.services.impl.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/admin/size/")
public class SizeController {

    @Autowired
    private SizeService sizeService;

    @GetMapping("hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "1") int page) {

        Size size = new Size();
        model.addAttribute("size", size);

        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Size> sizes = sizeService.getAllPage(pageable);
        model.addAttribute("sizes", sizes);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", sizes.getTotalPages());
        return "admin/size/size";
    }

    @GetMapping("detail/{id}")
    public String detail(
            Model model,
            @RequestParam(defaultValue = "1") int page,
            @PathVariable("id") UUID id
    ) {
        Size sizeDetail = sizeService.detail(id);
        model.addAttribute("size", sizeDetail);

        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Size> sizes = sizeService.getAllPage(pageable);
        model.addAttribute("sizes", sizes);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", sizes.getTotalPages());
        return "admin/size/size";
    }


    @PostMapping("add")
    public String add(@ModelAttribute("size") Size size) {
        this.sizeService.add(size);
        return "redirect:/admin/size/hien-thi";
    }

}
