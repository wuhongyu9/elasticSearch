// Copyright (C) 2021 Meituan
// All rights reserved
package es.ops.demos.create;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.ops.ClientUtil;
import es.ops.domain.User;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author wuhongyu03
 * @version 1.0
 * @created 2021/5/13 2:36 下午
 **/
public class BatchInserDocDemo {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = ClientUtil.getClient();
        BulkRequest bulkRequest = new BulkRequest();
        for(int i = 0;i<10;i++){
            String id = String.valueOf(1002 + i);
            User user = new User("emp"+id,18 + i,i % 2 == 0 ? "man" : "woman");
            IndexRequest indexRequest = new IndexRequest("user").id(id);
            indexRequest.source(new ObjectMapper().writeValueAsString(user), XContentType.JSON);
            bulkRequest.add(indexRequest);
        }
        BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulkResponse);

    }
}