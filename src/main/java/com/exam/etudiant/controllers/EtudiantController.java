package com.exam.etudiant.controllers;


import com.exam.etudiant.entities.Etudiant;
import com.exam.etudiant.services.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Etudiant controller.
 */
@Controller
public class EtudiantController {

    private EtudiantService etudiantService;

    @Autowired
    public void setEtudiantService(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    /**
     * List all etudiants.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/etudiants", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("etudiants", etudiantService.listAllEtudiants());
        return "etudiants_liste";
    }

    /**
     * View a specific etudiant by its id.
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("etudiant/{id}")
    public String showEtudiant(@PathVariable Integer id, Model model) {
        model.addAttribute("etudiant", etudiantService.getEtudiantById(id));
        return "etudiant_detail";
    }

    // Afficher le formulaire de modification du Etudiant
    // @RequestMapping("etudiant/edit/{id}")
    // public String edit(@PathVariable Integer id, Model model) {
    // model.addAttribute("etudiant", etudiantService.getEtudiantById(id));
    // return "etudiantform";
    // }


    /**
     * View a specific etudiant by its id.
     *
     * @param id
     * @param model
     * @return
     */

    @RequestMapping("etudiant/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        
        Etudiant etudiant =  etudiantService.getEtudiantById(id);
        model.addAttribute(etudiant);
        
        return "etudiant_form";
    }



    /**
     * New etudiant.
     *
     * @param model
     * @return
     */
    @RequestMapping("etudiant/new")
    public String newEtudiant(Model model) {
        model.addAttribute("etudiant", new Etudiant());
        return "etudiant_form";
    }

    /**
     * Enregistrer dans la base de donnée.
     *
     * @param etudiant
     * @return
     */
    @RequestMapping(value = "etudiant", method = RequestMethod.POST)
    public String saveEtudiant(Etudiant etudiant) {
        etudiantService.saveEtudiant(etudiant);
        return "redirect:/etudiant/" + etudiant.getId();
    }

    /**
     *Supprimer l'étudiant ayant un id.
     *
     * @param id
     * @return
     */
    @RequestMapping("etudiant/delete/{id}")
    public String delete(@PathVariable Integer id) {
        etudiantService.deleteEtudiant(id);
        return "redirect:/etudiants";
    }

}
