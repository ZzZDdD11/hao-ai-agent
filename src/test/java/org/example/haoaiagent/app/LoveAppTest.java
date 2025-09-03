package org.example.haoaiagent.app;

import jakarta.annotation.Resource;
import org.example.haoaiagent.HaoAiAgentApplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

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
        // 第二轮
        message = "我想让一个人喜欢上我";
        response = loveApp.dochat(message, chatId);

        assertNotNull(response);
        assertFalse(response.isEmpty());
        System.out.println("Response: " + response);
    }

    @Test
    void testDochat() {
    }

    @Test
    void dochatWithReport() {
        String chatId = "test-chat-id-1";
        String message = "你好我是昊哥， 我想让另一半更爱我但我不知道怎么做";
        LoveApp.LoveReport report = loveApp.dochatWithReport(message, chatId);
        Assertions.assertNotNull(report);
    }

    @Test
    void doChatWithRag() {
        String chatId = "test-chat-id-1";
        String message = "我已经结婚了，但婚后关系不太亲密，怎么办？";
        String report = loveApp.doChatWithRag(message, chatId);
        Assertions.assertNotNull(report);
    }

    @Test
    void doChatWithTools() {
        // 测试联网搜索问题的答案
        testMessage("周末想带女朋友去上海约会，推荐几个适合情侣的小众打卡地？");

        // 测试网页抓取：恋爱案例分析
        testMessage("最近和对象吵架了，看看编程导航网站（codefather.cn）的其他情侣是怎么解决矛盾的？");

        // 测试资源下载：图片下载
        testMessage("直接下载一张适合做手机壁纸的星空情侣图片为文件");

        // 测试终端操作：执行代码
        testMessage("执行 Python3 脚本来生成数据分析报告");

        // 测试文件操作：保存用户档案
        testMessage("保存我的恋爱档案为文件");

        // 测试 PDF 生成
        testMessage("生成一份‘七夕约会计划’PDF，包含餐厅预订、活动流程和礼物清单");
    }

    private void testMessage(String message) {
        String chatId = UUID.randomUUID().toString();
        String answer = loveApp.doChatWithTools(message, chatId);
        Assertions.assertNotNull(answer);
    }

    @Test
    void doChatWithMcp() {
        String chatId = UUID.randomUUID().toString();
        // 测试地图
//        String message = "我的另一半居住在静安区，请帮我在高德地图中找到5公里内合适的约会地点";
//        String answer = loveApp.doChatWithTools(message, chatId);
//        Assertions.assertNotNull(answer);

        // 测试图片搜索
        String message1 = "帮我下载一张美女图片";
        String answer1 = loveApp.doChatWithMcp(message1, chatId);
        Assertions.assertNotNull(answer1);

    }
}