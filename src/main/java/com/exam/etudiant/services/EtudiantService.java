package com.exam.etudiant.services;

import com.exam.etudiant.entities.Etudiant;

public interface EtudiantService {

    Iterable<Etudiant> listAllEtudiants();

    Etudiant getEtudiantById(Integer id);

    Etudiant saveEtudiant(Etudiant product);

    void deleteEtudiant(Integer id);

}
