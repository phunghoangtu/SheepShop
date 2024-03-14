package com.example.sheepshop.services;


import com.example.sheepshop.entitys.Size;
import com.example.sheepshop.repositorys.SizeRepository;
import com.example.sheepshop.services.impl.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SizeServiceImpl implements SizeService {

    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public List<Size> getAll() {
        return sizeRepository.findAll();
    }

    @Override
    public void add(Size size) {
        sizeRepository.save(size);
    }

    @Override
    public void update(Size size) {
        sizeRepository.save(size);
    }

    @Override
    public Size detail(UUID id) {
        return sizeRepository.getById(id);
    }

    @Override
    public Page<Size> getAllPage(Pageable pageable) {
        return sizeRepository.findAll(pageable);
    }
}
