package com.repositories;

import com.pojos.Manager;
import org.bson.types.ObjectId;

import java.util.Collection;

public class ManagerRepository implements Repository<Manager, ObjectId> {

    public Manager findById(ObjectId objectId) {
        return null;
    }

    @Override
    public Collection findAll() {
        return null;
    }
}
