// Copyright (C) 2021 Meituan
// All rights reserved
package es.ops.demos.delete;

import es.ops.ClientUtil;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author wuhongyu03
 * @version 1.0
 * @created 2021/5/13 2:18 下午
 **/
public class DeleteDocDemo {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = ClientUtil.getClient();
        DeleteRequest deleteRequest = new DeleteRequest("user").id("1001");
        DeleteResponse response = client.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(response.getResult());
    }
}