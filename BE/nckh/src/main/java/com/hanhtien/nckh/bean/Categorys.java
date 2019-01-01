package com.hanhtien.nckh.bean;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Categorys.
 */
@Entity
@Table(name = "categorys")
public class Categorys implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private Categorys parent;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Categorys name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Categorys getParent() {
        return parent;
    }

    public Categorys parent(Categorys categorys) {
        this.parent = categorys;
        return this;
    }

    public void setParent(Categorys categorys) {
        this.parent = categorys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Categorys categorys = (Categorys) o;
        if (categorys.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), categorys.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Categorys{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            "}";
    }
}
