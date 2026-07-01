package com.saborrei.saborrei.api.service;

import com.saborrei.saborrei.api.dto.ChatRequest;
import com.saborrei.saborrei.api.dto.ChatResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;

import java.util.Map;

@Service


public class ChatService {

    @Value("${n8n.webhook.url}")
    private String n8nWebhookUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public ChatResponse processarPergunta(ChatRequest request) {
        String pergunta = request.getPergunta();

        // Monta o corpo que será enviado ao n8n
        Map<String, String> body = Map.of("pergunta", pergunta);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, String>> entity = new HttpEntity<>(body, headers);

        // Chama o n8n e espera a resposta
        ResponseEntity<Map> response = restTemplate.postForEntity(
            n8nWebhookUrl, entity, Map.class
        );

        // O n8n deve retornar um JSON com o campo "resposta"
        String resposta = (String) response.getBody().get("resposta");

        return new ChatResponse(resposta);
    }
}