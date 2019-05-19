package com.pulsar.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.pulsar.cursomc.domain.Cliente;
import com.pulsar.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
	void sendNewPasswordEmail(Cliente cliente, String newPass);
	
}
