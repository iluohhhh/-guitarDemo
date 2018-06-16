package com.github.cumtfc.guitar.service;

import com.github.cumtfc.guitar.dao.WoodRepository;
import com.github.cumtfc.guitar.po.wood.Wood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WoodService {

    @Autowired
    WoodRepository woodRepository;

    public List<Wood> getAll() {
        return woodRepository.findAll();
    }
}
