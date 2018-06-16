package com.github.cumtfc.guitar.service;

import com.github.cumtfc.guitar.dao.TypeRepository;
import com.github.cumtfc.guitar.po.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    @Autowired
    TypeRepository typeRepository;

    public List<Type> getAll() {
        return typeRepository.findAll();
    }
}
