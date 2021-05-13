// Copyright (C) 2021 Meituan
// All rights reserved
package es.ops.demos;

import es.ops.ClientUtil;
import org.elasticsearch.client.RestHighLevelClient;

import java.io.IOException;

/**
 * @author wuhongyu03
 * @version 1.0
 * @created 2021/5/13 1:24 下午
 **/
public class ConnTest {
    public static void main(String[] args) throws IOException {
        RestHighLevelClient client = ClientUtil.getClient();
        System.out.println(client);
        try{
            ClientUtil.closeClient();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}