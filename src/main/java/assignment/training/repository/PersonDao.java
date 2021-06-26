package assignment.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import assignment.training.model.Person;

@Repository
// person is class , Integer Type of ID
public interface PersonDao extends JpaRepository<Person, Integer> {

}
