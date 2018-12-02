package piotrowski.patryk.namegenerator.repository;

import org.springframework.data.repository.Repository;
import piotrowski.patryk.namegenerator.exception.DataNotFound;

import javax.persistence.Query;
import java.math.BigInteger;
import java.util.Random;

public abstract class RandomRepository<T> implements Repository {

    public T getRandomData(Query countQuery, Query selectQuery) throws DataNotFound {
        BigInteger count = (BigInteger) countQuery.getSingleResult();
        if(count.intValue() == 0){
            throw new DataNotFound("Data not founded");
        }
        Random random = new Random();
        int number = random.nextInt(count.intValue());
        selectQuery.setFirstResult(number);
        selectQuery.setMaxResults(1);
        return (T) selectQuery.getSingleResult();
    }
}
