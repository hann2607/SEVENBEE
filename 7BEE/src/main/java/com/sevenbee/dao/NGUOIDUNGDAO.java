package com.sevenbee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sevenbee.entities.NGUOIDUNG;

@Repository
public interface NGUOIDUNGDAO extends JpaRepository<NGUOIDUNG, String>{

}
