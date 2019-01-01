package com.hanhtien.nckh.service;

import com.hanhtien.nckh.service.dto.CategorysDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Categorys.
 */
public interface CategorysService {

    /**
     * Save a categorys.
     *
     * @param categorysDTO the entity to save
     * @return the persisted entity
     */
    CategorysDTO save(CategorysDTO categorysDTO);

    /**
     * Get all the categorys.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<CategorysDTO> findAll(Pageable pageable);


    /**
     * Get the "id" categorys.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<CategorysDTO> findOne(Long id);

    /**
     * Delete the "id" categorys.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
