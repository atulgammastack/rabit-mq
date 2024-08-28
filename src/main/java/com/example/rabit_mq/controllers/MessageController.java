package com.example.rabit_mq.controllers;

import com.example.rabit_mq.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/send-message")
    public String sendMessage(@RequestParam("message") String message, Model model) {
        messageService.processAndSendMessage(message);
        model.addAttribute("message", "Message sent: " + message);
        return "messageView"; // This is the name of the view to be rendered
    }
}