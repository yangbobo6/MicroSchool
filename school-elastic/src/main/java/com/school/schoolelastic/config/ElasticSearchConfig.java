package com.school.schoolelastic.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//两个步骤
//1.找对象
//2.放到spring中待用
//3.分析源码
// spring源码中，所有的自动配置  xxxAutoConfigeration  配置类 xxx properities

@Configuration //相当于原来的xml文件   -配置bean
public class ElasticSearchConfig {

    //Spring  里面有beans文件  <id = "restHighLevelClient 方法名"   class= "返回值"  >
    @Bean
    public RestHighLevelClient restHighLevelClient(){
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1",9200,"http")));
        return client;
    }

}
