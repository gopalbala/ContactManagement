package com.gb.contactmanagement.config;

import com.gb.contactmanagement.model.Contact;
import com.gb.contactmanagement.service.ContactChangeStreams;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDbFactory;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.messaging.ChangeStreamRequest;
import org.springframework.data.mongodb.core.messaging.DefaultMessageListenerContainer;
import org.springframework.data.mongodb.core.messaging.MessageListenerContainer;

@Slf4j
@Configuration
public class DbConfig {
    @Value("${spring.data.mongodb.host}")
    private String hostName;
    @Value("${spring.data.mongodb.database}")
    private String database;
    @Autowired
    ContactChangeStreams contactChangeStreams;

    //public @Bean
//    MongoTemplate mongoTemplate() {
//        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
//                .applyConnectionString(new ConnectionString(hostName))
//                .writeConcern(WriteConcern.JOURNALED)
//                .retryWrites(true)
//                .readConcern(ReadConcern.AVAILABLE)
//                .readPreference(ReadPreference.secondaryPreferred())
//                .build();
//
//        MongoTemplate mongoTemplate = new MongoTemplate(MongoClients.create(), database);
//        return mongoTemplate;
//    }
    @Value("${spring.data.mongodb.uri}")
    private String uri;
    @Autowired
    private MongoConverter mongoConverter;

    @Bean
    public MongoDbFactory mongoDbFactory() {
        return new SimpleMongoClientDbFactory(uri);
    }

    public @Bean
    MongoTemplate mongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory(), mongoConverter);

        return mongoTemplate;
    }

    @Bean
    MessageListenerContainer messageListenerContainer(MongoTemplate template) {

        DefaultMessageListenerContainer messageListenerContainer =
                new DefaultMessageListenerContainer(template);

        ChangeStreamRequest<Contact> request = ChangeStreamRequest.builder()
                .collection("contacts")
//                .filter(newAggregation(match(where("operationType").is("insert"))))
//                .filter()
                .publishTo(contactChangeStreams)
                .build();

        messageListenerContainer.register(request, Contact.class);

        messageListenerContainer.start();

        return messageListenerContainer;
    }
}
