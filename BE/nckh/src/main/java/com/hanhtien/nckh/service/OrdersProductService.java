package com.hanhtien.nckh.service;

import com.hanhtien.nckh.service.dto.OrdersProductDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing OrdersProduct.
 */
public interface OrdersProductService {

    /**
     * Save a ordersProduct.
     *
     * @param ordersProductDTO the entity to save
     * @return the persisted entity
     */
    OrdersProductDTO save(OrdersProductDTO ordersProductDTO);

    /**
     * Get all the ordersProducts.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<OrdersProductDTO> findAll(Pageable pageable);


    /**
     * Get the "id" ordersProduct.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<OrdersProductDTO> findOne(Long id);

    /**
     * Delete the "id" ordersProduct.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
