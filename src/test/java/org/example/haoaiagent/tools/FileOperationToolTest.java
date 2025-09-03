package org.example.haoaiagent.tools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FileOperationToolTest {

    @Test
    void readFile() {
        FileOperationTool fileOperationTool = new FileOperationTool();
        String filename = "编程导航.txt";
        String string = fileOperationTool.readFile(filename);
        Assertions.assertNotNull(string);
    }

    @Test
    void writeFile() {

            FileOperationTool fileOperationTool = new FileOperationTool();
            String filename = "编程导航.txt";
            String content = "学习是 study good";
            String string = fileOperationTool.writeFile(filename, content);
            Assertions.assertNotNull(string);


    }
}