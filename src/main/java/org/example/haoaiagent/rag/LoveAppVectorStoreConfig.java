package org.example.haoaiagent.rag;


import jakarta.annotation.Resource;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SimpleVectorStore;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 向量数据库配置(初始化基于内存的向量数据库 Bean)
 */
@Configuration
public class LoveAppVectorStoreConfig {

    @Resource
    private LoveAppDocumentLoader loveAppDocumentLoader;


    @Bean
    VectorStore loveAppVectorStore(@Qualifier("dashscopeEmbeddingModel")EmbeddingModel dashScopeembeddingModel){
        // 创建一个向量库
        SimpleVectorStore simpleVectorStore = SimpleVectorStore.builder(dashScopeembeddingModel).build();
        // 向数据库中加入数据
        List<Document> documents = loveAppDocumentLoader.loadMarkdowns();
        simpleVectorStore.add(documents);
        return simpleVectorStore;

    }
}
