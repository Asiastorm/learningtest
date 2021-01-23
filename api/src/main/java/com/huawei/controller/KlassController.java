package com.huawei.controller;

import com.huawei.service.KlassService;
import com.huawei.Dao.model.Klass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Klass")
public class KlassController {
    private final static Logger logger = LoggerFactory.getLogger(KlassController.class.getName());

    @Autowired
    KlassService klassService;

    @GetMapping
    public List<Klass> getAll(@RequestParam String name) {
        return klassService.getKlassByName(name);
    }

    @GetMapping("{id}")
    public Klass getAll(@PathVariable Long id) {
        return klassService.getKlassById(id).get(0);
    }

    @PostMapping
    public void save(@RequestBody Klass klass) {
        klassService.save(klass);
    }

    @PutMapping("{id}")
    public void updateKlass(@PathVariable Long id, @RequestBody Klass klass) {
        klassService.update(id, klass);
    }

    @DeleteMapping("{id}")
    public void deleteKlass(@PathVariable Long id) {
        klassService.delete(id);
    }




}