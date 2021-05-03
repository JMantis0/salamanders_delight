package base.services;

public interface MongoService<E> {
    E findOne(String id);
}
