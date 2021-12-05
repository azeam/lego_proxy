package com.azeam.lego.lego;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LegoService {

    @Autowired
    LegoRepository legoRepository;

    public List<Lego> getAll() {
        return legoRepository.findAll();
    }

    public List<Lego> findByNameLikeIgnoreCase(String searchString) {
        return legoRepository.findByNameLikeIgnoreCase(searchString);
    }
}
