// Copyright (C) 2021 Meituan
// All rights reserved
package es.ops.demos.search;

import com.fasterxml.jackson.core.JsonParser;
import es.ops.ClientUtil;
import es.ops.domain.User;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;
import java.util.Map;

/**
 * @author wuhongyu03
 * @version 1.0
 * @created 2021/5/13 2:22 下午
 **/
public class SearchDocDemo {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = ClientUtil.getClient();
        GetRequest request = new GetRequest("user").id("1001");
        GetResponse documentFields = client.get(request, RequestOptions.DEFAULT);
        Map<String, Object> sourceAsMap = documentFields.getSourceAsMap();
        for(Map.Entry<String,Object> entry : sourceAsMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}