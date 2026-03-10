package com.moza.tugas3.controller;

import com.moza.tugas3.dto.KtpDto;
import com.moza.tugas3.entity.Ktp;
import com.moza.tugas3.service.KtpService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ktp")
public class KtpController {

    private final KtpService service;

    public KtpController(KtpService service){
        this.service = service;
    }

    @PostMapping
    public Ktp create(@RequestBody KtpDto dto){
        return service.create(dto);
    }

    @GetMapping
    public List<Ktp> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Ktp findById(@PathVariable Integer id){
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public Ktp update(@PathVariable Integer id, @RequestBody KtpDto dto){
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }
}
