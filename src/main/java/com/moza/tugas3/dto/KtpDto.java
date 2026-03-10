package com.moza.tugas3.dto;

import lombok.Data;
import java.util.Date;

@Data
public class KtpDto {

    private String nomorKtp;
    private String namaLengkap;
    private String alamat;
    private Date tanggalLahir;
    private String jenisKelamin;
}
