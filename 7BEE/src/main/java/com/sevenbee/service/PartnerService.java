package com.sevenbee.service;

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

import com.sevenbee.dao.PARTNERDAO;
import com.sevenbee.entity.PARTNER;

public interface PartnerService {

	void deleteAll();

	<S extends PARTNER> List<S> findAll(Example<S> example, Sort sort);

	<S extends PARTNER> List<S> findAll(Example<S> example);

	void deleteAll(Iterable<? extends PARTNER> entities);

	void deleteAllById(Iterable<? extends String> ids);

	PARTNER getReferenceById(String id);

	void delete(PARTNER entity);

	PARTNER getById(String id);

	void deleteById(String id);

	long count();

	<S extends PARTNER, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	PARTNER getOne(String id);

	void deleteAllInBatch();

	<S extends PARTNER> boolean exists(Example<S> example);

	<S extends PARTNER> long count(Example<S> example);

	void deleteAllByIdInBatch(Iterable<String> ids);

	boolean existsById(String id);

	void deleteAllInBatch(Iterable<PARTNER> entities);

	Optional<PARTNER> findById(String id);

	<S extends PARTNER> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<PARTNER> entities);

	List<PARTNER> findAllById(Iterable<String> ids);

	List<PARTNER> findAll();

	<S extends PARTNER> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends PARTNER> S saveAndFlush(S entity);

	Page<PARTNER> findAll(Pageable pageable);

	void flush();

	List<PARTNER> findAll(Sort sort);

	<S extends PARTNER> Optional<S> findOne(Example<S> example);

	<S extends PARTNER> List<S> saveAll(Iterable<S> entities);

	List<PARTNER> findProductsByShopRandom(int limit);

	<S extends PARTNER> S save(S entity);

	PARTNER login(String username, String password);

}
