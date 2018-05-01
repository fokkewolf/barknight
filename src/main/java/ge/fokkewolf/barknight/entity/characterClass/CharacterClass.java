/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.fokkewolf.barknight.entity.characterClass;

import ge.fokkewolf.barknight.entity.skilltree.SkillTreeSkill;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author adjaginov
 */
@Entity(name = "CharacterClass")
@Table(name = "charater_classes")
public class CharacterClass implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "charater_classes")
    private Long id;

    @Column(name = "class_name", unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(name = "base_max_hp", unique = true, nullable = false)
    private Integer BaseMaxHP;

    @OneToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_tree_id"),
            uniqueConstraints = @UniqueConstraint(columnNames = {"class_id", "skill_tree_id"})
    )
    private List<SkillTreeSkill> classSkillTrees;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CharacterClass)) {
            return false;
        }
        CharacterClass other = (CharacterClass) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ge.fokkewolf.barknight.entity.characterClass.CharacterClass[ id=" + id + " ]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the BaseMaxHP
     */
    public Integer getBaseMaxHP() {
        return BaseMaxHP;
    }

    /**
     * @param BaseMaxHP the BaseMaxHP to set
     */
    public void setBaseMaxHP(Integer BaseMaxHP) {
        this.BaseMaxHP = BaseMaxHP;
    }

    /**
     * @return the classSkillTrees
     */
    public List<SkillTreeSkill> getClassSkillTrees() {
        return classSkillTrees;
    }

    /**
     * @param classSkillTrees the classSkillTrees to set
     */
    public void setClassSkillTrees(List<SkillTreeSkill> classSkillTrees) {
        this.classSkillTrees = classSkillTrees;
    }

}
