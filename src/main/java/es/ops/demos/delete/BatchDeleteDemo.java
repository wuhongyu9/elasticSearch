// Copyright (C) 2021 Meituan
// All rights reserved
package es.ops.demos.delete;

import com.fasterxml.jackson.databind.ObjectMapper;
import es.ops.ClientUtil;
import es.ops.domain.User;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author wuhongyu03
 * @version 1.0
 * @created 2021/5/13 2:42 下午
 **/
public class BatchDeleteDemo {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = ClientUtil.getClient();
        BulkRequest bulkRequest = new BulkRequest();
        for(int i = 0;i<10;i++){
            String id = String.valueOf(1002 + i);
            DeleteRequest indexRequest = new DeleteRequest("user").id(id);
            bulkRequest.add(indexRequest);
        }
        BulkResponse bulkResponse = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulkResponse);
    }
}