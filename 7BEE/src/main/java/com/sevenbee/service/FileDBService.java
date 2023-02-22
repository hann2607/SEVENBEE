package com.sevenbee.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import com.sevenbee.entity.NGUOIDUNG;

public interface FileDBService {
	NGUOIDUNG store(MultipartFile file) throws IOException;

    Stream<NGUOIDUNG> getAllFiles();

}
