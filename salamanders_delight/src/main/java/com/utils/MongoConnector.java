package com.utils;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.function.Supplier;
/**
 * <h1>MongoConnector Class</h1>
 * <h2>Connects to MongoDB</h2>
 */
public class MongoConnector {
    private MongoClient client;
    private MongoClientSettings settings;

    public MongoConnector configure(Supplier<MongoClientSettings> configure) {
        this.settings = configure.get();
        return this;
    }

    public MongoClient createClient() {
        client = MongoClients.create(this.settings);
        return client;
    }

    /**
     * Configures the connector.  The string in .register() should path to pojos package.
     * the String in newConnectionString() is the mongoDB url that points to your db.
     */
    public void configureCodecAndRegistryAndCreateClient() {
        this.configure( () -> {
            CodecProvider codecProvider = PojoCodecProvider.builder().register("com.pojos").build();
            CodecRegistry registry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), CodecRegistries.fromProviders(codecProvider));
            return MongoClientSettings.builder()
                    .applyConnectionString(this.newConnectionString("mongodb://localhost:27017/salamander"))
                    .retryWrites(true)
                    .codecRegistry(registry)
                    .build();
        }).createClient();
    }

    public ConnectionString newConnectionString(String url) {
        return new ConnectionString(url);
    }

    public MongoClient getClient() {
        return this.client;
    }
}
