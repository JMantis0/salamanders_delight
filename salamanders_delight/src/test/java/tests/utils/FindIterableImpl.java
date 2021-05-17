package tests.utils;

import com.mongodb.CursorType;
import com.mongodb.Function;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Collation;
import org.bson.conversions.Bson;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

public class FindIterableImpl implements FindIterable {
    @Override
    public FindIterable filter(Bson filter) {
        return null;
    }

    @Override
    public FindIterable limit(int limit) {
        return null;
    }

    @Override
    public FindIterable skip(int skip) {
        return null;
    }

    @Override
    public FindIterable maxTime(long maxTime, TimeUnit timeUnit) {
        return null;
    }

    @Override
    public FindIterable maxAwaitTime(long maxAwaitTime, TimeUnit timeUnit) {
        return null;
    }

    @Override
    public FindIterable projection(Bson projection) {
        return null;
    }

    @Override
    public FindIterable sort(Bson sort) {
        return null;
    }

    @Override
    public FindIterable noCursorTimeout(boolean noCursorTimeout) {
        return null;
    }

    @Override
    public FindIterable oplogReplay(boolean oplogReplay) {
        return null;
    }

    @Override
    public FindIterable partial(boolean partial) {
        return null;
    }

    @Override
    public FindIterable cursorType(CursorType cursorType) {
        return null;
    }

    @Override
    public MongoCursor iterator() {
        return null;
    }

    @Override
    public MongoCursor cursor() {
        return null;
    }

    @Override
    public Object first() {
        return null;
    }

    @Override
    public Collection into(Collection target) {
        return null;
    }

    @Override
    public MongoIterable map(Function mapper) {
        return null;
    }

    @Override
    public FindIterable batchSize(int batchSize) {
        return null;
    }

    @Override
    public FindIterable collation(Collation collation) {
        return null;
    }

    @Override
    public FindIterable comment(String comment) {
        return null;
    }

    @Override
    public FindIterable hint(Bson hint) {
        return null;
    }

    @Override
    public FindIterable hintString(String hint) {
        return null;
    }

    @Override
    public FindIterable max(Bson max) {
        return null;
    }

    @Override
    public FindIterable min(Bson min) {
        return null;
    }

    @Override
    public FindIterable returnKey(boolean returnKey) {
        return null;
    }

    @Override
    public FindIterable showRecordId(boolean showRecordId) {
        return null;
    }
}
