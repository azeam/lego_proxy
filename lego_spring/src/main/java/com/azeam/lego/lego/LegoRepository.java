package com.azeam.lego.lego;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LegoRepository extends MongoRepository<Lego, String> {
    public List<Lego> findAll();

    public List<Lego> findByNameLikeIgnoreCase(String searchString);

    public Lego findByName(String name);
}
