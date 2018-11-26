package piotrowski.patryk.namegenerator.repository;

import org.springframework.beans.factory.annotation.Autowired;
import piotrowski.patryk.namegenerator.entity.Lastname;
import piotrowski.patryk.namegenerator.entity.enums.Country;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@org.springframework.stereotype.Repository
public class RandomLastnameRepository extends RandomRepository<Lastname> {

    @Autowired
    EntityManager em;

    public Lastname getRandomLastnameByCountry(Country country) {
        Query countQuery = em.createNativeQuery("select count(*) from Lastname where country = :country");
        countQuery.setParameter("country", country.name());

        Query selectQuery = em.createQuery("select q from Lastname q  where country = :country");
        selectQuery.setParameter("country", country);

        return this.getRandomData(countQuery, selectQuery);
    }
}
