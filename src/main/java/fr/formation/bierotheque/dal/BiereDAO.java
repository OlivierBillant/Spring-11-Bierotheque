package fr.formation.bierotheque.dal;

import org.springframework.data.repository.CrudRepository;

import fr.formation.bierotheque.bo.Biere;

public interface BiereDAO extends CrudRepository<Biere, Integer>{

}
