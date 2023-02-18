package com.sevenbee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sevenbee.entity.NGUOIDUNG;

public interface UserRepository extends JpaRepository<NGUOIDUNG, String> {

}
