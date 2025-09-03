package org.example.haoaiagent.tools;

import cn.hutool.core.io.FileUtil;
import org.example.haoaiagent.Consetent.FileConstant;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;

import java.io.File;

/**
 * 文件操作工具类
 */
public class FileOperationTool {

    private final String FILE_DIR = FileConstant.FILE_SAVE_DIR + "/file";

    @Tool(description = "Read content form a file")
    public String readFile(@ToolParam(description = "Name content from a file") String filename) {

        String filePath = FILE_DIR + "/" + filename;
        try {
            return FileUtil.readUtf8String(filePath);
        } catch (Exception e) {
            return "Error reading file: " + e.getMessage();
        }
    }

    @Tool(description = "Write content to a file")
    public String writeFile(@ToolParam(description = "Name of the file to write" ) String filename,
                             @ToolParam(description = "Content to write the file") String content){

        String filePath = FILE_DIR + "/" + filename;

        try {
            // 创建目录
            FileUtil.mkdir(FILE_DIR);
            FileUtil.writeUtf8String(content, filePath);
            return "File write successfully to: " + filePath;
        }catch (Exception e){
            System.err.println("文件写入时捕获到异常！详细信息如下：");
            e.printStackTrace();

            return "Error write file :" + e.getMessage();
        }

    }

}
