package com.example.sheepshop.controllers.admin;

import com.example.sheepshop.entitys.Size;
import com.example.sheepshop.services.impl.SizeService;
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
@RequestMapping("/admin/size/")
public class SizeController {

    @Autowired
    private SizeService sizeService;

    @GetMapping("hien-thi")
    public String hienthi(Model model, @RequestParam(defaultValue = "1") int page) {
        int pageSize = 5;
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        Page<Size> sizes = sizeService.getAllPage(pageable);
        model.addAttribute("sizes", sizes);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", sizes.getTotalPages());
        return "admin/size/size";
    }

    @GetMapping("view-add")
    public String viewadd(Model model) {
        Size size = new Size();
        model.addAttribute("size", size);
        return "admin/size/add-size";
    }

    @GetMapping("view-update/{id}")
    public String viewupdate(@PathVariable("id") UUID id, Model model) {
        Size size  = sizeService.detail(id);
        model.addAttribute("size", size);
        return "admin/size/update-size";
    }

}
