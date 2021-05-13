// Copyright (C) 2021 Meituan
// All rights reserved
package es.ops.demos.create;

import es.ops.ClientUtil;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;

import java.io.IOException;

/**
 * @author wuhongyu03
 * @version 1.0
 * @created 2021/5/13 1:36 下午
 **/

/**
 * 创建一个user索引
 */
public class CreateIndicesDemo {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = ClientUtil.getClient();
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("user");
        CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse.isAcknowledged());
    }
}