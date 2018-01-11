package com.flower.common.mongodb;

import com.flower.common.config.ConfigBean;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by geyu on 18-1-10.
 */
public class MongoDB {
    @Autowired
    private ConfigBean configBean;
    MongoDatabase getMongoDataBase(String url,int port,String dataBase){
        MongoClient mongoClient=new MongoClient(url, port);
        return  mongoClient.getDatabase(dataBase);

    }

}
