package com.edudrolhe.desafio_anota_ai.controllers;

import org.springframework.web.bind.annotation.*;
import com.edudrolhe.desafio_anota_ai.service.SmsMockService;

@RestController
@RequestMapping("/api/sms")
public class SmsTestController {

    private final SmsMockService smsService;

    public SmsTestController(SmsMockService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/send")
    public String sendTestSms(@RequestParam String phoneNumber, 
                               @RequestParam String message) {
        String messageId = smsService.sendSms(phoneNumber, message);
        return "SMS enviado para " + phoneNumber + " | MessageId: " + messageId;
    }
}
