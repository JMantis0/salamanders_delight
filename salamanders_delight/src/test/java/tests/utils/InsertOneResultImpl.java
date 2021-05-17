package tests.utils;

import com.mongodb.client.result.InsertOneResult;
import org.bson.BsonValue;

public class InsertOneResultImpl extends InsertOneResult {
    @Override
    public boolean wasAcknowledged() {
        return false;
    }

    @Override
    public BsonValue getInsertedId() {
        return null;
    }
}
