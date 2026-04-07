package com.edudrolhe.desafio_uber.service;

import org.springframework.stereotype.Service;

@Service
public class SmsMockService {

    public String sendSms(String phoneNumber, String message) {
        String messageId = "MOCK-" + System.currentTimeMillis();
        System.out.println("[MOCK SMS] Enviado para: " + phoneNumber);
        System.out.println("[MOCK SMS] Mensagem: " + message);
        System.out.println("[MOCK SMS] MessageId: " + messageId);
        return messageId;
    }
}
