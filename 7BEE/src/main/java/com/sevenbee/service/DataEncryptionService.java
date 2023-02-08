package com.sevenbee.service;

import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.stereotype.Service;

@Service
public class DataEncryptionService {
	private static final String ENCRYPTION_PASSWORD = "7bee";
	private static final String SALT = "salt-for-encryption";

	//Mã hóa
	public String encryptData(String data) {
		return Encryptors.text(ENCRYPTION_PASSWORD, SALT).encrypt(data);
	}
	
	//Giải mã
	public String decryptData(String data) {
		return Encryptors.text(ENCRYPTION_PASSWORD, SALT).decrypt(data);
	}
}
