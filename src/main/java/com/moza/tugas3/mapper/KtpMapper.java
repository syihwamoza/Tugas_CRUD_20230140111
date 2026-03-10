package com.moza.tugas3.mapper;

import com.moza.tugas3.dto.KtpDto;
import com.moza.tugas3.entity.Ktp;

public class KtpMapper {

    public static Ktp toEntity(KtpDto dto){
        Ktp ktp = new Ktp();

        ktp.setNomorKtp(dto.getNomorKtp());
        ktp.setNamaLengkap(dto.getNamaLengkap());
        ktp.setAlamat(dto.getAlamat());
        ktp.setTanggalLahir(dto.getTanggalLahir());
        ktp.setJenisKelamin(dto.getJenisKelamin());

        return ktp;
    }
}