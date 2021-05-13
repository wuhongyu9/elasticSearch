// Copyright (C) 2021 Meituan
// All rights reserved
package es.ops;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author wuhongyu03
 * @version 1.0
 * @created 2021/5/13 1:21 下午
 **/
public class ClientUtil {
    static RestHighLevelClient client;
    public static RestHighLevelClient getClient() throws IOException {
        if(client == null){
            client = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost",9200,"http")));
        }
        return client;
    }

    public static void closeClient() throws IOException {
        System.out.println("try to close client!");
        if(client != null){
            client.close();
            System.out.println("closed");
        }else{
            System.out.println("client already closed");
        }
        return;
    }
}