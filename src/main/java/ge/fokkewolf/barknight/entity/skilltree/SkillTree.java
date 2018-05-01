/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.fokkewolf.barknight.entity.skilltree;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author adjaginov
 */
@Entity(name = "SkillTree")
@Table(name = "skill_trees")
public class SkillTree implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "skill_trees")
    private Long id;
    
    @Column(name = "skill_tree_name", unique = true, nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "SkillTree", fetch = FetchType.LAZY)
    private List<SkillTreeSkill> skills;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkillTree)) {
            return false;
        }
        SkillTree other = (SkillTree) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ge.fokkewolf.barknight.entity.characterClass.SkillTreeBranch[ id=" + id + " ]";
    }
    
}
