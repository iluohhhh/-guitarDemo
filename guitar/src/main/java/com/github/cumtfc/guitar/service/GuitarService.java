package com.github.cumtfc.guitar.service;

import com.github.cumtfc.guitar.dao.GuitarRepository;
import com.github.cumtfc.guitar.domain.Inventory;
import com.github.cumtfc.guitar.po.guitar.Guitar;
import com.github.cumtfc.guitar.po.guitar.GuitarSpec;
import com.github.cumtfc.guitar.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
public class GuitarService {

    @Autowired
    GuitarRepository guitarRepository;

    public List<Guitar> searchGuitar(GuitarSpec guitarSpec) {
        Inventory inventory = new Inventory();
        return inventory.search(guitarSpec, guitarRepository.findAll());
    }

    public List<Guitar> getAll() {
        return guitarRepository.findAll();
    }

    public Guitar save(Guitar guitar) {
        if(StringUtils.isEmpty(guitar.getSerialNumber())){
            guitar.setSerialNumber(Integer.valueOf((int) Math.random()));
        }
        return guitarRepository.save(guitar);
    }

    public boolean deleteById(Integer id) {
        guitarRepository.deleteById(id);
        return true;
    }
}
