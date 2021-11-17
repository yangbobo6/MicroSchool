package com.school.schoolelastic;

import com.school.schoolelastic.model.User;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class SchoolElasticApplicationTests {

    @Autowired  //按类型匹配  默认按类型赋值，写了qualifier按名称赋值
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

    @Test
    void testCreateIndex() throws IOException{
        //1.创建索引的请求
        CreateIndexRequest request = new CreateIndexRequest("twitter");
        //2客户端执行请求，请求后获得响应
        CreateIndexResponse response = client.indices().create(request,RequestOptions.DEFAULT);
        System.out.println(response);
    }
    @Test
    void testExistIndex() throws IOException {
        //创建索引的请求
        GetIndexRequest request = new GetIndexRequest("twitter");
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println("测试索引是否存在"+exists);
    }

    @Test
    void testAddDocument() throws IOException{
        User user = new User("yangbo",10);
        IndexRequest request = new IndexRequest("twitter");
        request.id("1");
        //设置超时时间
        request.timeout("1s");
        //将数据放到json字符串
//        request.source(JSON.toJSON(user),XContentType.JSON);
//        //发送请求
//        IndexResponse response = client.index(request,RequestOptions.DEFAULT);
//        System.out.println("添加文档"+response.toString());
//        System.out.println("添加文档"+response.status());

    }
    @Test
    void println(){
        System.out.println("yangbo");
    }







}
