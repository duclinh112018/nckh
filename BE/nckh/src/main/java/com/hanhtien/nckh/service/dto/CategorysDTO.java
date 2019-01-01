package com.hanhtien.nckh.service.dto;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Categorys entity.
 */
public class CategorysDTO implements Serializable {

    private Long id;

    private String name;

    private Long parentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long categorysId) {
        this.parentId = categorysId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CategorysDTO categorysDTO = (CategorysDTO) o;
        if (categorysDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), categorysDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "CategorysDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", parent=" + getParentId() +
            "}";
    }
}
