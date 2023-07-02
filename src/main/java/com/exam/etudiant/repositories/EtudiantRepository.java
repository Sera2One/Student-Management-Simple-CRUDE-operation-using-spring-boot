package com.exam.etudiant.repositories;

import com.exam.etudiant.entities.Etudiant;
import org.springframework.data.repository.CrudRepository;

public interface EtudiantRepository extends CrudRepository<Etudiant, Integer> {

}
