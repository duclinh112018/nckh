package com.hanhtien.nckh.web.rest;

import com.hanhtien.nckh.web.rest.errors.BadRequestAlertException;
import com.hanhtien.nckh.web.rest.util.HeaderUtil;
import com.hanhtien.nckh.service.OrdersService;
import com.hanhtien.nckh.web.rest.util.PaginationUtil;
import com.hanhtien.nckh.service.dto.OrdersDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Orders.
 */
@RestController
@RequestMapping("/api")
public class OrdersResource {


    private static final String ENTITY_NAME = "orders";

    private final OrdersService ordersService;

    public OrdersResource(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    /**
     * POST  /orders : Create a new orders.
     *
     * @param ordersDTO the ordersDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new ordersDTO, or with status 400 (Bad Request) if the orders has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/orders")
    
    public ResponseEntity<OrdersDTO> createOrders(@RequestBody OrdersDTO ordersDTO) throws URISyntaxException {
        if (ordersDTO.getId() != null) {
            throw new BadRequestAlertException("A new orders cannot already have an ID", ENTITY_NAME, "idexists");
        }
        OrdersDTO result = ordersService.save(ordersDTO);
        return ResponseEntity.created(new URI("/api/orders/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /orders : Updates an existing orders.
     *
     * @param ordersDTO the ordersDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated ordersDTO,
     * or with status 400 (Bad Request) if the ordersDTO is not valid,
     * or with status 500 (Internal Server Error) if the ordersDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/orders")
    
    public ResponseEntity<OrdersDTO> updateOrders(@RequestBody OrdersDTO ordersDTO) throws URISyntaxException {
        if (ordersDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        OrdersDTO result = ordersService.save(ordersDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, ordersDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /orders : get all the orders.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of orders in body
     */
    @GetMapping("/orders")
    
    public ResponseEntity<List<OrdersDTO>> getAllOrders(Pageable pageable) {
        Page<OrdersDTO> page = ordersService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/orders");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /orders/:id : get the "id" orders.
     *
     * @param id the id of the ordersDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the ordersDTO, or with status 404 (Not Found)
     */
    @GetMapping("/orders/{id}")
    
    public ResponseEntity<OrdersDTO> getOrders(@PathVariable Long id) {
        Optional<OrdersDTO> ordersDTO = ordersService.findOne(id);
        return ResponseEntity.ok().body(ordersDTO.get());
    }

    /**
     * DELETE  /orders/:id : delete the "id" orders.
     *
     * @param id the id of the ordersDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/orders/{id}")
    
    public ResponseEntity<Void> deleteOrders(@PathVariable Long id) {
        ordersService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
