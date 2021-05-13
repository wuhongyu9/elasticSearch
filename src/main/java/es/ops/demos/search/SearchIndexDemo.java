// Copyright (C) 2021 Meituan
// All rights reserved
package es.ops.demos.search;

import es.ops.ClientUtil;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
 * @author wuhongyu03
 * @version 1.0
 * @created 2021/5/13 1:58 下午
 **/
public class SearchIndexDemo {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = ClientUtil.getClient();
        GetIndexResponse response = client.indices().get(new GetIndexRequest("user"),RequestOptions.DEFAULT);
        System.out.println(response.getAliases());
        System.out.println(response.getMappings());
        System.out.println(response.getSettings());
    }
}