package com.school.schoolsearch;

import com.alibaba.fastjson.JSON;
import com.school.schoolsearch.model.User;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.naming.directory.SearchResult;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class SchoolSearchApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("yangbo");
    }
    @Autowired  //按类型匹配  默认按类型赋值，写了qualifier按名称赋值
    @Qualifier("restHighLevelClient")
    private RestHighLevelClient client;

    @Test
    void testCreateIndex() throws IOException {
        //1.创建索引的请求
        CreateIndexRequest request = new CreateIndexRequest("twitter");
        //2客户端执行请求，请求后获得响应
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
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
        request.source(JSON.toJSON(user), XContentType.JSON);
        //发送请求
        IndexResponse response = client.index(request,RequestOptions.DEFAULT);

        System.out.println("添加文档"+response.toString());
        System.out.println("添加文档"+response.status());

    }

    @Test
    void testExistDocument() throws IOException{
        //获取请求
        GetRequest request = new GetRequest("twitter","1");
        //注意没有indices  是否存在
        boolean exists = client.exists(request, RequestOptions.DEFAULT);
        //获取文档
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        System.out.println("文档是否存在"+exists);
        System.out.println("获取文档"+  response);

        //修改文档
        UpdateRequest request1 = new UpdateRequest("twitter","1");
        User user = new User("tanjing",20);
        request1.timeout("1s");
        //将数据放到json字符串
        request1.doc(JSON.toJSONString(user),XContentType.JSON);
        UpdateResponse response1 = client.update(request1,RequestOptions.DEFAULT);
        System.out.println("测试修改文档-----"+response1);
        System.out.println("测试修改文档-----"+response1.status());

    }

    //测试删除文档
    @Test
    void testDeleteDocument() throws IOException {
        DeleteRequest request= new DeleteRequest("twitter","1");
        request.timeout("1s");
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        System.out.println("测试删除文档------"+response.status());
    }

    //批量添加文档
    @Test
    void testBulkAddDocument() throws IOException{
        ArrayList<User> list = new ArrayList<User>();
        list.add(new User("tanzhuzhu",14));
        list.add(new User("tanxiaojing",15));
        list.add(new User("xiaozhu",16));
        list.add(new User("xiaotutu",11));
        list.add(new User("xiaogou",10));
        list.add(new User("xiaozhu",8));
        list.add(new User("zhuzhutu",3));
        //批量操作request
        BulkRequest request = new BulkRequest();
        request.timeout("1s");

        //批量处理请求
        for (int i = 0; i <list.size() ; i++) {
            request.add(
                    new IndexRequest("twitter")
                    .id(""+(i+1))
                    .source(JSON.toJSONString(list.get(i)),XContentType.JSON)
            );
        }
        BulkResponse response = client.bulk(request,RequestOptions.DEFAULT);
        //hasFailures
        System.out.println("测试批量添加文档"+response.hasFailures());

    }

    @Test
    void testSearchDocument() throws IOException{
        SearchRequest request = new SearchRequest("twitter");
        //构造搜索条件
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //设置高亮
        sourceBuilder.highlighter();
        //term name为xiaozhu  精确查询
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name","xiaozhu");
        sourceBuilder.query(termQueryBuilder);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        request.source(sourceBuilder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        //测试查询文档
        System.out.println("测试查询文档"+JSON.toJSONString(response.getHits()));
        System.out.println("==============");
        for (SearchHit documentField:response.getHits().getHits()
             ) {
            System.out.println("测试查询文档--遍历参数--"+documentField.getSourceAsMap());
            
        }


    }







}
