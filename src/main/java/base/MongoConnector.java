package base;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

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

    public ConnectionString newConnectionString(String url) {
        return new ConnectionString(url);
    }

    public MongoClient getClient() {
        return this.client;
    }
}
