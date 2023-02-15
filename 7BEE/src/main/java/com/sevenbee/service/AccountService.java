package com.sevenbee.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import com.sevenbee.entity.NGUOIDUNG;

public interface AccountService {

	void deleteAll();

	<S extends NGUOIDUNG> List<S> findAll(Example<S> example, Sort sort);

	<S extends NGUOIDUNG> List<S> findAll(Example<S> example);

	void deleteAll(Iterable<? extends NGUOIDUNG> entities);

	void deleteAllById(Iterable<? extends String> ids);

	NGUOIDUNG getReferenceById(String id);

	void delete(NGUOIDUNG entity);

	NGUOIDUNG getById(String id);

	void deleteById(String id);

	long count();

	<S extends NGUOIDUNG, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	NGUOIDUNG getOne(String id);

	void deleteAllInBatch();

	<S extends NGUOIDUNG> boolean exists(Example<S> example);

	<S extends NGUOIDUNG> long count(Example<S> example);

	void deleteAllByIdInBatch(Iterable<String> ids);

	boolean existsById(String id);

	void deleteAllInBatch(Iterable<NGUOIDUNG> entities);

	Optional<NGUOIDUNG> findById(String id);

	<S extends NGUOIDUNG> Page<S> findAll(Example<S> example, Pageable pageable);

	void deleteInBatch(Iterable<NGUOIDUNG> entities);

	List<NGUOIDUNG> findAllById(Iterable<String> ids);

	List<NGUOIDUNG> findAll();

	<S extends NGUOIDUNG> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends NGUOIDUNG> S saveAndFlush(S entity);

	Page<NGUOIDUNG> findAll(Pageable pageable);

	void flush();

	List<NGUOIDUNG> findAll(Sort sort);

	<S extends NGUOIDUNG> Optional<S> findOne(Example<S> example);

	<S extends NGUOIDUNG> List<S> saveAll(Iterable<S> entities);

	<S extends NGUOIDUNG> S save(S entity);

	NGUOIDUNG login(String username, String password);

}
