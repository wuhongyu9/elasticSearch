// Copyright (C) 2021 Meituan
// All rights reserved
package es.ops.demos.search.highlevel;

import es.ops.ClientUtil;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.io.IOException;

/**
 * @author wuhongyu03
 * @version 1.0
 * @created 2021/5/13 2:49 下午
 **/
public class HighLevelSearchDemo {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = ClientUtil.getClient();
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder query = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        searchRequest.source(query);
        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getHits();
        SearchHit[] hits1 = hits.getHits();
        for(SearchHit h : hits1){
            System.out.println(h.getSourceAsMap().get("name"));
        }
    }
}