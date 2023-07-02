package com.exam.etudiant.services;
import com.exam.etudiant.entities.Etudiant;
import com.exam.etudiant.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Etudiant service implement.
 */
@Service
public class EtudiantServiceImpl implements EtudiantService {

    private EtudiantRepository etudiantRepository;

    @Autowired
    public void setEtudiantRepository(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public Iterable<Etudiant> listAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(Integer id) {
        return etudiantRepository.findById(id).orElse(null);
    }

    @Override
    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void deleteEtudiant(Integer id) {
        etudiantRepository.deleteById(id);
    }

}
