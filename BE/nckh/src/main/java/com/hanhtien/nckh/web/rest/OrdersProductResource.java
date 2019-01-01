package com.hanhtien.nckh.web.rest;

import com.hanhtien.nckh.service.OrdersProductService;
import com.hanhtien.nckh.web.rest.errors.BadRequestAlertException;
import com.hanhtien.nckh.web.rest.util.HeaderUtil;
import com.hanhtien.nckh.web.rest.util.PaginationUtil;
import com.hanhtien.nckh.service.dto.OrdersProductDTO;
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
 * REST controller for managing OrdersProduct.
 */
@RestController
@RequestMapping("/api")
public class OrdersProductResource {


    private static final String ENTITY_NAME = "ordersProduct";

    private final OrdersProductService ordersProductService;

    public OrdersProductResource(OrdersProductService ordersProductService) {
        this.ordersProductService = ordersProductService;
    }

    /**
     * POST  /orders-products : Create a new ordersProduct.
     *
     * @param ordersProductDTO the ordersProductDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new ordersProductDTO, or with status 400 (Bad Request) if the ordersProduct has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/orders-products")
    
    public ResponseEntity<OrdersProductDTO> createOrdersProduct(@RequestBody OrdersProductDTO ordersProductDTO) throws URISyntaxException {
        if (ordersProductDTO.getId() != null) {
            throw new BadRequestAlertException("A new ordersProduct cannot already have an ID", ENTITY_NAME, "idexists");
        }
        OrdersProductDTO result = ordersProductService.save(ordersProductDTO);
        return ResponseEntity.created(new URI("/api/orders-products/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /orders-products : Updates an existing ordersProduct.
     *
     * @param ordersProductDTO the ordersProductDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated ordersProductDTO,
     * or with status 400 (Bad Request) if the ordersProductDTO is not valid,
     * or with status 500 (Internal Server Error) if the ordersProductDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/orders-products")
    
    public ResponseEntity<OrdersProductDTO> updateOrdersProduct(@RequestBody OrdersProductDTO ordersProductDTO) throws URISyntaxException {
        if (ordersProductDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        OrdersProductDTO result = ordersProductService.save(ordersProductDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, ordersProductDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /orders-products : get all the ordersProducts.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of ordersProducts in body
     */
    @GetMapping("/orders-products")
    
    public ResponseEntity<List<OrdersProductDTO>> getAllOrdersProducts(Pageable pageable) {
        Page<OrdersProductDTO> page = ordersProductService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/orders-products");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /orders-products/:id : get the "id" ordersProduct.
     *
     * @param id the id of the ordersProductDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the ordersProductDTO, or with status 404 (Not Found)
     */
    @GetMapping("/orders-products/{id}")
    
    public ResponseEntity<OrdersProductDTO> getOrdersProduct(@PathVariable Long id) {
        Optional<OrdersProductDTO> ordersProductDTO = ordersProductService.findOne(id);
        return ResponseEntity.ok().body(ordersProductDTO.get());
    }

    /**
     * DELETE  /orders-products/:id : delete the "id" ordersProduct.
     *
     * @param id the id of the ordersProductDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/orders-products/{id}")
    
    public ResponseEntity<Void> deleteOrdersProduct(@PathVariable Long id) {
        ordersProductService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
