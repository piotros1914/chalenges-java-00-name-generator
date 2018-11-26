package piotrowski.patryk.namegenerator.repository;

import org.springframework.beans.factory.annotation.Autowired;
import piotrowski.patryk.namegenerator.entity.Name;
import piotrowski.patryk.namegenerator.entity.enums.Country;
import piotrowski.patryk.namegenerator.entity.enums.Gender;
import javax.persistence.EntityManager;
import javax.persistence.Query;


@org.springframework.stereotype.Repository
public class RandomNameRepository extends RandomRepository<Name> {

    @Autowired
    EntityManager em;

    public Name getRandomNameByCountryAndGender(Gender gender, Country country) {
        Query countQuery = em.createNativeQuery("select count(*) from Name where country = :country and gender = :gender");
        countQuery.setParameter("country", country.name());
        countQuery.setParameter("gender", gender.name());

        Query selectQuery = em.createQuery("select q from Name q  where country = :country and gender = :gender");
        selectQuery.setParameter("country", country);
        selectQuery.setParameter("gender", gender);

        return this.getRandomData(countQuery, selectQuery);
    }
}
