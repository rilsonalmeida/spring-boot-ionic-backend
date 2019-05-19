package com.pulsar.cursomc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pulsar.cursomc.domain.Cliente;
import com.pulsar.cursomc.repositories.ClienteRepository;
import com.pulsar.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {

	private Random rand = new Random();
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService emailService;
	
	public void sendNewPassword(String email) {
	
		Cliente cliente = clienteRepository.findByEmail(email);
		if (cliente == null) {
			throw new ObjectNotFoundException("Email não cadastrado");
		}
		
		String newPass = newPassword();
		cliente.setSenha(pe.encode(newPass));
		emailService.sendNewPasswordEmail(cliente, newPass);
		
	}

	private String newPassword() {

		char[] vet = new char[10];
		for (int i=0; i < 10; i++) {
			vet[i] = randonChar();
		}
		return new String(vet);
	}

	private char randonChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) { // gera um dígito
			return (char) (rand.nextInt(10) + 48);
		}
		else if (opt == 1)  { // gera letra maiuscula
			return (char) (rand.nextInt(26) + 65);		
		}
		else  {  // gera letra minuscula
			return (char) (rand.nextInt(26) + 97);		
		}	
		}
	
}