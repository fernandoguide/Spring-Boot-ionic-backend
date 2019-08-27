package com.fernando.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.fernando.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);
}
