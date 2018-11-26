package piotrowski.patryk.namegenerator.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import piotrowski.patryk.namegenerator.entity.Name;

import java.util.List;

@Repository
public interface NameRepository extends CrudRepository<Name, Long> {

    List<Name> findByName(String name);

}