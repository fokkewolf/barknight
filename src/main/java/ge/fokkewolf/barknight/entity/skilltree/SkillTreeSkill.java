/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.fokkewolf.barknight.entity.skilltree;

import java.io.Serializable;
import java.util.List;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author adjaginov
 */
@Entity(name = "SkillTreeSkill")
@Table(
        name = "skill_tree_skills",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"skill_tree_id", "skill_name"})
        }
)
public class SkillTreeSkill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "skill_tree_skills")
    private Long id;

    @Column(name = "skill_name", nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @JsonbTransient
    @ManyToOne
    @JoinColumn(name = "skill_tree_id", nullable = false)
    private SkillTree skillTree;

    @OneToMany
    @JoinTable(joinColumns = @JoinColumn(name = "skill_id"), inverseJoinColumns = @JoinColumn(name = "required_skill_id"))
    private List<SkillTreeSkill> requiredSkills;

    @OneToMany(mappedBy = "skill", fetch = FetchType.LAZY)
    private List<SkillTreeSkillLevel> levels;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkillTreeSkill)) {
            return false;
        }
        SkillTreeSkill other = (SkillTreeSkill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ge.fokkewolf.barknight.entity.characterClass.SkillTreeSkill[ id=" + id + " ]";
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
     * @return the branch
     */
    public SkillTree getBranch() {
        return skillTree;
    }

    /**
     * @param branch the branch to set
     */
    public void setBranch(SkillTree branch) {
        this.skillTree = branch;
    }

    /**
     * @return the requiredSkills
     */
    public List<SkillTreeSkill> getRequiredSkills() {
        return requiredSkills;
    }

    /**
     * @param requiredSkills the requiredSkills to set
     */
    public void setRequiredSkills(List<SkillTreeSkill> requiredSkills) {
        this.requiredSkills = requiredSkills;
    }

    /**
     * @return the levels
     */
    public List<SkillTreeSkillLevel> getLevels() {
        return levels;
    }

    /**
     * @param levels the levels to set
     */
    public void setLevels(List<SkillTreeSkillLevel> levels) {
        this.levels = levels;
    }

}
