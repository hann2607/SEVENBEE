package com.sevenbee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sevenbee.entity.NGUOIDUNG;
@Repository
public interface FileDBRepository extends JpaRepository<NGUOIDUNG, String> {
} 
