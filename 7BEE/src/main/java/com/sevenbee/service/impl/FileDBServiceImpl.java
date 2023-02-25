package com.sevenbee.service.impl;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.sevenbee.entity.NGUOIDUNG;
import com.sevenbee.repository.FileDBRepository;
import com.sevenbee.service.FileDBService;

@Service
public class FileDBServiceImpl implements FileDBService {

    @Autowired
    private FileDBRepository fileDBRepository;

    @Override
    public NGUOIDUNG store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        NGUOIDUNG image = new NGUOIDUNG();

        return fileDBRepository.save(image);
    }

    @Override
    public Stream<NGUOIDUNG> getAllFiles() {
        return fileDBRepository.findAll().stream();
    }
}
