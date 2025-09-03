package org.example.haoaiagent.controller;


import jakarta.annotation.Resource;
import org.example.haoaiagent.agent.model.HaoManus;
import org.example.haoaiagent.app.LoveApp;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@RestController
@RequestMapping("/ai")
public class AiController {

    @Resource
    private LoveApp loveApp;

    @Resource
    private ChatModel dashscopeChatModel;

    @Resource
    private ToolCallback[] allTools;

    /**
     * 同步调用 ai
     * @param message
     * @param chatId
     * @return
     */
    @GetMapping("/love_app/chat/sync")
    public String doChatWithLoveAppSync(String message, String chatId){

        return loveApp.dochat(message, chatId);
    }

    /**
     * SSE 流式调用
     * @param message
     * @param chatId
     * @return
     */
    @GetMapping("/love_app/chat/sse")
    public SseEmitter doChatWithLoveAppSSeEmitter(String message, String chatId){
        SseEmitter sseEmitter = new SseEmitter();

        loveApp.dochatByStream(message, chatId)
                .subscribe(chunk -> {
                    try {
                        sseEmitter.send(chunk);
                    } catch (IOException e) {
                        sseEmitter.completeWithError(e);
                    }
                }, sseEmitter::completeWithError, sseEmitter::complete);

        return sseEmitter;
    }

    /**
     * 流式调用 Manus 超级智能体
     *
     * @param message
     * @return
     */
    @GetMapping("/manus/chat")
    public SseEmitter doChatWithManus(String message) {
        HaoManus yuManus = new HaoManus(allTools, dashscopeChatModel);
        return yuManus.runStream(message);
    }



}
