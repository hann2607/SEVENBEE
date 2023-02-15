package com.sevenbee.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sevenbee.dao.NGUOIDUNGDAO;
import com.sevenbee.entity.NGUOIDUNG;
import com.sevenbee.service.AccountService;

import io.micrometer.common.util.StringUtils;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private NGUOIDUNGDAO nguoidungDAO;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public NGUOIDUNG login(String username, String password) {
		Optional<NGUOIDUNG> optExist = findById(username);
		if (optExist.isPresent() && bCryptPasswordEncoder.matches(password, optExist.get().getMatkhau())) {
			optExist.get().setMatkhau("");
			return optExist.get();
		}
		
		return null;
	}
	
	@Override
	public <S extends NGUOIDUNG> S save(S entity) {
		Optional<NGUOIDUNG> optExist = findById(entity.getSDT());
		if (optExist.isPresent()) {
			if (StringUtils.isEmpty(entity.getMatkhau())) {
				entity.setMatkhau(optExist.get().getMatkhau());
			} else {
				entity.setMatkhau(bCryptPasswordEncoder.encode(entity.getMatkhau()));
			}
		} else {
			entity.setMatkhau(bCryptPasswordEncoder.encode(entity.getMatkhau()));
		}

		return nguoidungDAO.save(entity);
	}

	@Override
	public <S extends NGUOIDUNG> List<S> saveAll(Iterable<S> entities) {
		return nguoidungDAO.saveAll(entities);
	}

	@Override
	public <S extends NGUOIDUNG> Optional<S> findOne(Example<S> example) {
		return nguoidungDAO.findOne(example);
	}

	@Override
	public List<NGUOIDUNG> findAll(Sort sort) {
		return nguoidungDAO.findAll(sort);
	}

	@Override
	public void flush() {
		nguoidungDAO.flush();
	}

	@Override
	public Page<NGUOIDUNG> findAll(Pageable pageable) {
		return nguoidungDAO.findAll(pageable);
	}

	@Override
	public <S extends NGUOIDUNG> S saveAndFlush(S entity) {
		return nguoidungDAO.saveAndFlush(entity);
	}

	@Override
	public <S extends NGUOIDUNG> List<S> saveAllAndFlush(Iterable<S> entities) {
		return nguoidungDAO.saveAllAndFlush(entities);
	}

	@Override
	public List<NGUOIDUNG> findAll() {
		return nguoidungDAO.findAll();
	}

	@Override
	public List<NGUOIDUNG> findAllById(Iterable<String> ids) {
		return nguoidungDAO.findAllById(ids);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteInBatch(Iterable<NGUOIDUNG> entities) {
		nguoidungDAO.deleteInBatch(entities);
	}

	@Override
	public <S extends NGUOIDUNG> Page<S> findAll(Example<S> example, Pageable pageable) {
		return nguoidungDAO.findAll(example, pageable);
	}

	@Override
	public Optional<NGUOIDUNG> findById(String id) {
		return nguoidungDAO.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<NGUOIDUNG> entities) {
		nguoidungDAO.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(String id) {
		return nguoidungDAO.existsById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		nguoidungDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends NGUOIDUNG> long count(Example<S> example) {
		return nguoidungDAO.count(example);
	}

	@Override
	public <S extends NGUOIDUNG> boolean exists(Example<S> example) {
		return nguoidungDAO.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		nguoidungDAO.deleteAllInBatch();
	}

	@SuppressWarnings("deprecation")
	@Override
	public NGUOIDUNG getOne(String id) {
		return nguoidungDAO.getOne(id);
	}

	@Override
	public <S extends NGUOIDUNG, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return nguoidungDAO.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return nguoidungDAO.count();
	}

	@Override
	public void deleteById(String id) {
		nguoidungDAO.deleteById(id);
	}

	@SuppressWarnings("deprecation")
	@Override
	public NGUOIDUNG getById(String id) {
		return nguoidungDAO.getById(id);
	}

	@Override
	public void delete(NGUOIDUNG entity) {
		nguoidungDAO.delete(entity);
	}

	@Override
	public NGUOIDUNG getReferenceById(String id) {
		return nguoidungDAO.getReferenceById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		nguoidungDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends NGUOIDUNG> entities) {
		nguoidungDAO.deleteAll(entities);
	}

	@Override
	public <S extends NGUOIDUNG> List<S> findAll(Example<S> example) {
		return nguoidungDAO.findAll(example);
	}

	@Override
	public <S extends NGUOIDUNG> List<S> findAll(Example<S> example, Sort sort) {
		return nguoidungDAO.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		nguoidungDAO.deleteAll();
	}

}
