package com.gb.contactmanagement.config;

import com.mongodb.*;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class DbConfig {
    @Value("${spring.data.mongodb.host}")
    private String hostName;
    @Value("${spring.data.mongodb.database}")
    private String database;

    //public @Bean
    MongoTemplate mongoTemplate() {
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(hostName))
                .writeConcern(WriteConcern.JOURNALED)
                .retryWrites(true)
                .readConcern(ReadConcern.AVAILABLE)
                .readPreference(ReadPreference.secondaryPreferred())
                .build();

        MongoTemplate mongoTemplate = new MongoTemplate(MongoClients.create(), database);
        return mongoTemplate;
    }
}
