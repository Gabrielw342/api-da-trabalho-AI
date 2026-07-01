package com.saborrei.saborrei.api.controller;

import com.saborrei.saborrei.api.dto.ChatRequest;
import com.saborrei.saborrei.api.dto.ChatResponse;
import com.saborrei.saborrei.api.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @PostMapping
    public ChatResponse conversar(@RequestBody ChatRequest request) {
        return chatService.processarPergunta(request);
    }
}