package com.hanhtien.nckh.web.rest;

import com.hanhtien.nckh.web.rest.errors.BadRequestAlertException;
import com.hanhtien.nckh.web.rest.util.HeaderUtil;
import com.hanhtien.nckh.service.CategorysService;
import com.hanhtien.nckh.web.rest.util.PaginationUtil;
import com.hanhtien.nckh.service.dto.CategorysDTO;
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
 * REST controller for managing Categorys.
 */
@RestController
@RequestMapping("/api")
public class CategorysResource {


    private static final String ENTITY_NAME = "categorys";

    private final CategorysService categorysService;

    public CategorysResource(CategorysService categorysService) {
        this.categorysService = categorysService;
    }

    /**
     * POST  /categorys : Create a new categorys.
     *
     * @param categorysDTO the categorysDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new categorysDTO, or with status 400 (Bad Request) if the categorys has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/categorys")
    public ResponseEntity<CategorysDTO> createCategorys(@RequestBody CategorysDTO categorysDTO) throws URISyntaxException {
        if (categorysDTO.getId() != null) {
            throw new BadRequestAlertException("A new categorys cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CategorysDTO result = categorysService.save(categorysDTO);
        return ResponseEntity.created(new URI("/api/categorys/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /categorys : Updates an existing categorys.
     *
     * @param categorysDTO the categorysDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated categorysDTO,
     * or with status 400 (Bad Request) if the categorysDTO is not valid,
     * or with status 500 (Internal Server Error) if the categorysDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/categorys")
    public ResponseEntity<CategorysDTO> updateCategorys(@RequestBody CategorysDTO categorysDTO) throws URISyntaxException {
        if (categorysDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CategorysDTO result = categorysService.save(categorysDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, categorysDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /categorys : get all the categorys.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of categorys in body
     */
    @GetMapping("/categorys")
    public ResponseEntity<List<CategorysDTO>> getAllCategorys(Pageable pageable) {
        Page<CategorysDTO> page = categorysService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/categorys");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /categorys/:id : get the "id" categorys.
     *
     * @param id the id of the categorysDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the categorysDTO, or with status 404 (Not Found)
     */
    @GetMapping("/categorys/{id}")
    public ResponseEntity<CategorysDTO> getCategorys(@PathVariable Long id) {        
        Optional<CategorysDTO> categorysDTO = categorysService.findOne(id);
        return ResponseEntity.ok().body(categorysDTO.get());
    }

    /**
     * DELETE  /categorys/:id : delete the "id" categorys.
     *
     * @param id the id of the categorysDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/categorys/{id}")
    public ResponseEntity<Void> deleteCategorys(@PathVariable Long id) {
        categorysService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
