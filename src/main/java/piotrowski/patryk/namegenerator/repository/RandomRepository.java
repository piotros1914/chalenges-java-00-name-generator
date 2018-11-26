package piotrowski.patryk.namegenerator.repository;

import org.springframework.data.repository.Repository;

import javax.persistence.Query;
import java.math.BigInteger;
import java.util.Random;

public abstract class RandomRepository<T> implements Repository {

    public T getRandomData(Query countQuery, Query selectQuery) {
        BigInteger count = (BigInteger) countQuery.getSingleResult();

        Random random = new Random();
        int number = random.nextInt(count.intValue());
        selectQuery.setFirstResult(number);
        selectQuery.setMaxResults(1);
        return (T) selectQuery.getSingleResult();
    }
}
