package pl.mwojtas.wordslides.repository;

import java.util.Random;

import org.springframework.stereotype.Repository;

@Repository
public final class RandomStoreRepository implements StoreRepository {
    public Boolean keyExists(String key) {
        return Math.random() < 0.5;
    }

    public Integer getValue(String key) {
        return new Random().nextInt(10) + 1;
    }
}
