package com.moza.tugas3.service;

import com.moza.tugas3.dto.KtpDto;
import com.moza.tugas3.entity.Ktp;

import java.util.List;

public interface KtpService {

    Ktp create(KtpDto dto);

    List<Ktp> findAll();

    Ktp findById(Integer id);

    Ktp update(Integer id, KtpDto dto);

    void delete(Integer id);
}