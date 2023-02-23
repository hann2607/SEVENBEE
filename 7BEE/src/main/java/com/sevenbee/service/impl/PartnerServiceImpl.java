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

import com.sevenbee.dao.PARTNERDAO;
import com.sevenbee.entity.PARTNER;
import com.sevenbee.service.PartnerService;

import io.micrometer.common.util.StringUtils;

@Service
public class PartnerServiceImpl  implements PartnerService{
	
	@Autowired
	PARTNERDAO partnerDAO;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public PARTNER login(String username, String password) {
		Optional<PARTNER> optExist = findById(username);
		if (optExist.isPresent() && bCryptPasswordEncoder.matches(password, optExist.get().getMatkhau())) {
			optExist.get().setMatkhau("");
			return optExist.get();
		}
		
		return null;
	}
	
	@Override
	public <S extends PARTNER> S save(S entity) {
		Optional<PARTNER> optExist = findById(entity.getSDT());
		if (optExist.isPresent()) {
			if (StringUtils.isEmpty(entity.getMatkhau())) {
				entity.setMatkhau(optExist.get().getMatkhau());
			} else {
				entity.setMatkhau(bCryptPasswordEncoder.encode(entity.getMatkhau()));
			}
		} else {
			entity.setMatkhau(bCryptPasswordEncoder.encode(entity.getMatkhau()));
		}

		return partnerDAO.save(entity);
	}
	
	@Override
	public List<PARTNER> findProductsByShopRandom(int limit) {
		return partnerDAO.findProductsByShopRandom(limit);
	}


	@Override
	public <S extends PARTNER> List<S> saveAll(Iterable<S> entities) {
		return partnerDAO.saveAll(entities);
	}

	@Override
	public <S extends PARTNER> Optional<S> findOne(Example<S> example) {
		return partnerDAO.findOne(example);
	}

	@Override
	public List<PARTNER> findAll(Sort sort) {
		return partnerDAO.findAll(sort);
	}

	@Override
	public void flush() {
		partnerDAO.flush();
	}

	@Override
	public Page<PARTNER> findAll(Pageable pageable) {
		return partnerDAO.findAll(pageable);
	}

	@Override
	public <S extends PARTNER> S saveAndFlush(S entity) {
		return partnerDAO.saveAndFlush(entity);
	}

	@Override
	public <S extends PARTNER> List<S> saveAllAndFlush(Iterable<S> entities) {
		return partnerDAO.saveAllAndFlush(entities);
	}

	@Override
	public List<PARTNER> findAll() {
		return partnerDAO.findAll();
	}

	@Override
	public List<PARTNER> findAllById(Iterable<String> ids) {
		return partnerDAO.findAllById(ids);
	}

	@Override
	public void deleteInBatch(Iterable<PARTNER> entities) {
		partnerDAO.deleteInBatch(entities);
	}

	@Override
	public <S extends PARTNER> Page<S> findAll(Example<S> example, Pageable pageable) {
		return partnerDAO.findAll(example, pageable);
	}

	@Override
	public Optional<PARTNER> findById(String id) {
		return partnerDAO.findById(id);
	}

	@Override
	public void deleteAllInBatch(Iterable<PARTNER> entities) {
		partnerDAO.deleteAllInBatch(entities);
	}

	@Override
	public boolean existsById(String id) {
		return partnerDAO.existsById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<String> ids) {
		partnerDAO.deleteAllByIdInBatch(ids);
	}

	@Override
	public <S extends PARTNER> long count(Example<S> example) {
		return partnerDAO.count(example);
	}

	@Override
	public <S extends PARTNER> boolean exists(Example<S> example) {
		return partnerDAO.exists(example);
	}

	@Override
	public void deleteAllInBatch() {
		partnerDAO.deleteAllInBatch();
	}

	@Override
	public PARTNER getOne(String id) {
		return partnerDAO.getOne(id);
	}

	@Override
	public <S extends PARTNER, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return partnerDAO.findBy(example, queryFunction);
	}

	@Override
	public long count() {
		return partnerDAO.count();
	}

	@Override
	public void deleteById(String id) {
		partnerDAO.deleteById(id);
	}

	@Override
	public PARTNER getById(String id) {
		return partnerDAO.getById(id);
	}

	@Override
	public void delete(PARTNER entity) {
		partnerDAO.delete(entity);
	}

	@Override
	public PARTNER getReferenceById(String id) {
		return partnerDAO.getReferenceById(id);
	}

	@Override
	public void deleteAllById(Iterable<? extends String> ids) {
		partnerDAO.deleteAllById(ids);
	}

	@Override
	public void deleteAll(Iterable<? extends PARTNER> entities) {
		partnerDAO.deleteAll(entities);
	}

	@Override
	public <S extends PARTNER> List<S> findAll(Example<S> example) {
		return partnerDAO.findAll(example);
	}

	@Override
	public <S extends PARTNER> List<S> findAll(Example<S> example, Sort sort) {
		return partnerDAO.findAll(example, sort);
	}

	@Override
	public void deleteAll() {
		partnerDAO.deleteAll();
	}
	
	
}
