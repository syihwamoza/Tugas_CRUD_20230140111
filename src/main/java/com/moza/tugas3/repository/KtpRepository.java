package com.moza.tugas3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.moza.tugas3.entity.Ktp;

import java.util.Optional;

public interface KtpRepository extends JpaRepository<Ktp, Integer> {

    Optional<Ktp> findByNomorKtp(String nomorKtp);
}
