package com.example.sheepshop.services.impl;

import com.example.sheepshop.entitys.CollarStyle;

import java.util.List;

public interface CollarStyleService {

    List<CollarStyle> getCollarStyleList();

    CollarStyle findById(Integer id);

    void save(CollarStyle collarStyle);

}