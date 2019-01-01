package com.hanhtien.nckh.service;

import com.hanhtien.nckh.service.dto.OrdersDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Orders.
 */
public interface OrdersService {

    /**
     * Save a orders.
     *
     * @param ordersDTO the entity to save
     * @return the persisted entity
     */
    OrdersDTO save(OrdersDTO ordersDTO);

    /**
     * Get all the orders.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<OrdersDTO> findAll(Pageable pageable);


    /**
     * Get the "id" orders.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<OrdersDTO> findOne(Long id);

    /**
     * Delete the "id" orders.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
