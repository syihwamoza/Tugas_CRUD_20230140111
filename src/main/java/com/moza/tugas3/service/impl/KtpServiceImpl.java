package com.moza.tugas3.service.impl;

import com.moza.tugas3.dto.KtpDto;
import com.moza.tugas3.entity.Ktp;
import com.moza.tugas3.mapper.KtpMapper;
import com.moza.tugas3.repository.KtpRepository;
import com.moza.tugas3.service.KtpService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KtpServiceImpl implements KtpService {

    private final KtpRepository repository;

    public KtpServiceImpl(KtpRepository repository){
        this.repository = repository;
    }

    @Override
    public Ktp create(KtpDto dto) {

        if(repository.findByNomorKtp(dto.getNomorKtp()).isPresent()){
            throw new RuntimeException("Nomor KTP sudah ada");
        }

        Ktp ktp = KtpMapper.toEntity(dto);
        return repository.save(ktp);
    }

    @Override
    public List<Ktp> findAll() {
        return repository.findAll();
    }

    @Override
    public Ktp findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data tidak ditemukan"));
    }

    @Override
    public Ktp update(Integer id, KtpDto dto) {

        Ktp ktp = findById(id);

        ktp.setNomorKtp(dto.getNomorKtp());
        ktp.setNamaLengkap(dto.getNamaLengkap());
        ktp.setAlamat(dto.getAlamat());
        ktp.setTanggalLahir(dto.getTanggalLahir());
        ktp.setJenisKelamin(dto.getJenisKelamin());

        return repository.save(ktp);
    }

    @Override
    public void delete(Integer id) {

        Ktp ktp = findById(id);
        repository.delete(ktp);
    }
}
