package com.hanhtien.nckh.service.mapper;

import com.hanhtien.nckh.bean.*;
import com.hanhtien.nckh.service.dto.CategorysDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Categorys and its DTO CategorysDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CategorysMapper extends EntityMapper<CategorysDTO, Categorys> {

    @Mapping(source = "parent.id", target = "parentId")
    CategorysDTO toDto(Categorys categorys);

    @Mapping(source = "parentId", target = "parent")
    Categorys toEntity(CategorysDTO categorysDTO);

    default Categorys fromId(Long id) {
        if (id == null) {
            return null;
        }
        Categorys categorys = new Categorys();
        categorys.setId(id);
        return categorys;
    }
}
