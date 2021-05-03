package base;
import com.mongodb.MongoClientSettings;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
public class Main {
    public static void main(String[] args) {
        //  Logger initialized here
        Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
        mongoLogger.setLevel(Level.FATAL);
        BasicConfigurator.configure();
        //  Create an instance of MongoConnector to connect to the db.
        MongoConnector connector = new MongoConnector();
        //  Connector is configured here
        connector.configure(() -> {
            CodecProvider codecProvider = PojoCodecProvider.builder().register("base.pojos").build();
            CodecRegistry registry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), CodecRegistries.fromProviders(codecProvider));
            return MongoClientSettings.builder()
                    .applyConnectionString(connector.newConnectionString("mongodb://localhost:27017/salamander"))
                    .retryWrites(true)
                    .codecRegistry(registry)
                    .build();
        }).createClient();
        SalamanderApp app = new SalamanderApp("Salamander Reimbursements", connector);
        app.run(app.context);
    }
}
