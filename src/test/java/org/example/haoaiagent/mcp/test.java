package org.example.haoaiagent.mcp;

import jakarta.annotation.Resource;
import org.example.haoaiagent.app.LoveApp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;
@SpringBootTest
public class test {

    @Resource
    private LoveApp loveApp;

    @Test
    void doChatWithMcp() {
        String chatId = UUID.randomUUID().toString();
        // 测试图片搜索
        String message1 = "帮我下载一张美女图片";
        String answer1 = loveApp.doChatWithMcp(message1, chatId);
        Assertions.assertNotNull(answer1);
    }
}
