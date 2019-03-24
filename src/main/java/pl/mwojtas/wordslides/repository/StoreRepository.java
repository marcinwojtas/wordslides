package pl.mwojtas.wordslides.repository;

public interface StoreRepository {
    Boolean keyExists(String key);
    Integer getValue(String key);
}
