package com.test.es;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

public class ESClient {
     RestHighLevelClient client;
    //准备一个highlevel client
    @Before
    public void init() {
        final RestHighLevelClient highLevelClient = new RestHighLevelClient(RestClient.builder(
                new HttpHost("linux121", 9200, "http")
                ,
                new HttpHost("linux122", 9200, "http"),
                new HttpHost("linux123", 9200, "http")
        ));

// System.out.println(highLevelClient.cluster().toString());
        client = highLevelClient;
    }
    @After
    public void destory() {
        if (client != null) {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //创建索引
    @Test
    public void createIndex() {
        final CreateIndexRequest indexRequest = new CreateIndexRequest("es_test");
//准备mapping映射信息
        String str = "{\n" +
                " \"settings\": {},\n" +
                " \"mappings\": {\n" +
                " \"properties\": {\n" +
                " \"description\": {\n" +
                " \"type\": \"text\",\n" +
                " \"analyzer\": \"ik_max_word\"\n" +
                " },\n" +
                " \"name\": {\n" +
                " \"type\": \"text\"\n" +
                " },\n" +
                " \"pic\": {\n" +
                " \"type\": \"text\",\n" +
                " \"index\": false\n" +
                " },\n" +
                " \"studymodel\": {\n" +
                " \"type\": \"text\"\n" +
                " }\n" +
                " }\n" +
                " }\n" +
                " }";
//把映射信息添加到request对象中
        indexRequest.source(str, XContentType.JSON);
//创建索引
        try {
            //high
            final CreateIndexResponse createIndexResponse =
                    client.indices().create(indexRequest, RequestOptions.DEFAULT);
            final boolean acknowledged = createIndexResponse.isAcknowledged();
            System.out.println("创建结果：" + acknowledged);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //删除索引
    @Test
    public void deleteIndex() throws IOException {
//创建一个删除索引的请求
        final DeleteIndexRequest indexRequest = new DeleteIndexRequest("index_scale");
        final AcknowledgedResponse delete = client.indices().delete(indexRequest,
                RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());
    }

    //添加doc
    @Test
    public void addDoc() throws IOException {
//准备一个添加文档的对象
        final IndexRequest indexRequest = new IndexRequest("es_test").id("1");
/*
{
"name": "spark添加文档",
"description": "spark技术栈",
"studymodel":"online",
"pic": "http://www.baidu.com"
}
*/
//准备文档内容
        String str = " {\n" +
                " \"name\": \"es添加文档\",\n" +
                " \"description\": \"esssssss\",\n" +
                " \"studymodel\":\"online\",\n" +
                " \"pic\": \"http://www.baidu.com\"\n" +
                " }";
        indexRequest.source(str, XContentType.JSON);
//执行添加动作
        final IndexResponse index = client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(index.status());
    }

    //查询文档
    @Test
    public void getDoc() throws IOException {
//准备一个查询的reqeust请求
        final GetRequest getRequest = new GetRequest("es_test");
//设定id he
        getRequest.id("1");
//执行查询
        final GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        final Map<String, Object> sourceAsMap = getResponse.getSourceAsMap();
        System.out.println(sourceAsMap);
    }
}
