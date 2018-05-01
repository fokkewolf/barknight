/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.fokkewolf.barknight.entity.skilltree;

import java.io.Serializable;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author adjaginov
 */
@Entity(name = "SkillTreeSkillLevel")
@Table(
        name = "skll_tree_skill_levels",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"skill_tree_skill_id", "level_name"})
            ,@UniqueConstraint(columnNames = {"skill_tree_skill_id", "levelIndex"})
        }
)
public class SkillTreeSkillLevel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "level_index", nullable = false)
    private Integer levelIndex;

    @Column(name = "level_name", nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(name = "required_skill_tree_points")
    private Integer requiredSkillTreePoints;

    @ManyToOne
    @JoinColumn(name = "skill_tree_skill_id", nullable = false)
    @JsonbTransient
    private SkillTreeSkill skill;

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkillTreeSkillLevel)) {
            return false;
        }
        SkillTreeSkillLevel other = (SkillTreeSkillLevel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ge.fokkewolf.barknight.entity.characterClass.SkillTreeLevel[ id=" + id + " ]";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the levelIndex
     */
    public Integer getLevelIndex() {
        return levelIndex;
    }

    /**
     * @param levelIndex the levelIndex to set
     */
    public void setLevelIndex(Integer levelIndex) {
        this.levelIndex = levelIndex;
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
     * @return the requiredSkillTreePoints
     */
    public Integer getRequiredSkillTreePoints() {
        return requiredSkillTreePoints;
    }

    /**
     * @param requiredSkillTreePoints the requiredSkillTreePoints to set
     */
    public void setRequiredSkillTreePoints(Integer requiredSkillTreePoints) {
        this.requiredSkillTreePoints = requiredSkillTreePoints;
    }

    /**
     * @return the skill
     */
    public SkillTreeSkill getSkill() {
        return skill;
    }

    /**
     * @param skill the skill to set
     */
    public void setSkill(SkillTreeSkill skill) {
        this.skill = skill;
    }

}
