package com.hanhtien.nckh.service.impl;
import com.hanhtien.nckh.service.CategorysService;
import com.hanhtien.nckh.bean.Categorys;
import com.hanhtien.nckh.repository.CategorysRepository;
import com.hanhtien.nckh.service.dto.CategorysDTO;
import com.hanhtien.nckh.service.mapper.CategorysMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing Categorys.
 */
@Service
@Transactional
public class CategorysServiceImpl implements CategorysService {


    private final CategorysRepository categorysRepository;

    private final CategorysMapper categorysMapper;

    public CategorysServiceImpl(CategorysRepository categorysRepository, CategorysMapper categorysMapper) {
        this.categorysRepository = categorysRepository;
        this.categorysMapper = categorysMapper;
    }

    /**
     * Save a categorys.
     *
     * @param categorysDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public CategorysDTO save(CategorysDTO categorysDTO) {

        Categorys categorys = categorysMapper.toEntity(categorysDTO);
        categorys = categorysRepository.save(categorys);
        return categorysMapper.toDto(categorys);
    }

    /**
     * Get all the categorys.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<CategorysDTO> findAll(Pageable pageable) {
        return categorysRepository.findAll(pageable)
            .map(categorysMapper::toDto);
    }


    /**
     * Get one categorys by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<CategorysDTO> findOne(Long id) {
        return categorysRepository.findById(id)
            .map(categorysMapper::toDto);
    }

    /**
     * Delete the categorys by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        categorysRepository.deleteById(id);
    }
}
