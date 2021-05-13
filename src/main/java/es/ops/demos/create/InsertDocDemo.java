// Copyright (C) 2021 Meituan
// All rights reserved
package es.ops.demos.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.ops.ClientUtil;
import es.ops.domain.User;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author wuhongyu03
 * @version 1.0
 * @created 2021/5/13 2:10 下午
 **/
public class InsertDocDemo {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = ClientUtil.getClient();
        IndexRequest request = new IndexRequest("user").id("1001");
        User user = new User("wuhongyu",23,"man");
        request.source(new ObjectMapper().writeValueAsString(user), XContentType.JSON);
        IndexResponse index = client.index(request, RequestOptions.DEFAULT);
        DocWriteResponse.Result result = index.getResult();
        System.out.println(result);
    }
}