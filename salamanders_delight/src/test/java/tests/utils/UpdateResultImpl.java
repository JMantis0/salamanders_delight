package tests.utils;

import com.mongodb.client.result.UpdateResult;
import org.bson.BsonValue;

public class UpdateResultImpl extends UpdateResult {
    @Override
    public boolean wasAcknowledged() {
        return false;
    }

    @Override
    public long getMatchedCount() {
        return 0;
    }

    @Override
    public long getModifiedCount() {
        return 0;
    }

    @Override
    public BsonValue getUpsertedId() {
        return null;
    }
}
