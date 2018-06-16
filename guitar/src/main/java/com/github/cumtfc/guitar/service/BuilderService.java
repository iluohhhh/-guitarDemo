package com.github.cumtfc.guitar.service;

import com.github.cumtfc.guitar.dao.BuilderRepository;
import com.github.cumtfc.guitar.po.builder.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuilderService {

    @Autowired
    BuilderRepository builderRepository;

    public List<Builder> getAll() {
        return builderRepository.findAll();
    }
}
