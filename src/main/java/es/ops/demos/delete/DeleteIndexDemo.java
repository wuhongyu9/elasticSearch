// Copyright (C) 2021 Meituan
// All rights reserved
package es.ops.demos.delete;

import es.ops.ClientUtil;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author wuhongyu03
 * @version 1.0
 * @created 2021/5/13 1:53 下午
 **/
public class DeleteIndexDemo {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = ClientUtil.getClient();
        AcknowledgedResponse response = client.indices().delete(new DeleteIndexRequest("user"), RequestOptions.DEFAULT);
        boolean acknowledged = response.isAcknowledged();
        System.out.println(acknowledged);
        client.close();
    }
}