/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.fokkewolf.barknight.control;

import ge.fokkewolf.barknight.entity.characterClass.CharacterClass;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author adjaginov
 */
@Stateless
@RolesAllowed({"member", "admin"})
public class CharacterClassControl {

    @PersistenceContext(unitName = "barkNightPU")
    private EntityManager em;
    
    
    public List<CharacterClass> fuck(){
        return em.createQuery("SELECT c FROM CharacterClass c\n"
                + "JOIN FETCH c.classSkillTrees\n"
                + "JOIN FETCH c.classSkillTrees.levels\n"
                + "JOIN FETCH c.classSkillTrees.requiredSkills", CharacterClass.class)
                .getResultList();
        
    }

}