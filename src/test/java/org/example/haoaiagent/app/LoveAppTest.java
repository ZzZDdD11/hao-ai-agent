package org.example.haoaiagent.app;

import jakarta.annotation.Resource;
import org.example.haoaiagent.HaoAiAgentApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = HaoAiAgentApplication.class)
class LoveAppTest {

    @Resource
    private LoveApp loveApp;

    @Test
    void dochat() {
        String chatId = "test-chat-id";
        String message = "你好，我是昊哥";
        String response = loveApp.dochat(message, chatId);
        assertNotNull(response);
        assertFalse(response.isEmpty());
        System.out.println("Response: " + response);
    }
}