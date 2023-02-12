package com.sevenbee.dao;

public interface SESSIONDAO {
	public Object get(String key); // Get theo key trả về type

	public void set(String key, Object value); // set key là string, type tùy ý

	public void clear(); // clear session
}
