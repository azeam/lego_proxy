package com.azeam.lego.lego;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class LegoController {

    @Autowired
    LegoService legoService;

    @GetMapping("/legos")
    public List<Lego> findLegosByName(HttpServletResponse response, @RequestParam Optional<String> name) {
        return name
                .map(searchString -> legoService.findByNameLikeIgnoreCase(searchString))
                .orElse(legoService.getAll());
    }
}
