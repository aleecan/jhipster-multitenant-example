package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.CategoryRelationService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.CategoryRelationDTO;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.CategoryRelation}.
 */
@RestController
@RequestMapping("/api")
public class CategoryRelationResource {

    private final Logger log = LoggerFactory.getLogger(CategoryRelationResource.class);

    private static final String ENTITY_NAME = "categoryRelation";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CategoryRelationService categoryRelationService;

    public CategoryRelationResource(CategoryRelationService categoryRelationService) {
        this.categoryRelationService = categoryRelationService;
    }

    /**
     * {@code POST  /category-relations} : Create a new categoryRelation.
     *
     * @param categoryRelationDTO the categoryRelationDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new categoryRelationDTO, or with status {@code 400 (Bad Request)} if the categoryRelation has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/category-relations")
    public ResponseEntity<CategoryRelationDTO> createCategoryRelation(@Valid @RequestBody CategoryRelationDTO categoryRelationDTO) throws URISyntaxException {
        log.debug("REST request to save CategoryRelation : {}", categoryRelationDTO);
        if (categoryRelationDTO.getId() != null) {
            throw new BadRequestAlertException("A new categoryRelation cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CategoryRelationDTO result = categoryRelationService.save(categoryRelationDTO);
        return ResponseEntity.created(new URI("/api/category-relations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /category-relations} : Updates an existing categoryRelation.
     *
     * @param categoryRelationDTO the categoryRelationDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated categoryRelationDTO,
     * or with status {@code 400 (Bad Request)} if the categoryRelationDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the categoryRelationDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/category-relations")
    public ResponseEntity<CategoryRelationDTO> updateCategoryRelation(@Valid @RequestBody CategoryRelationDTO categoryRelationDTO) throws URISyntaxException {
        log.debug("REST request to update CategoryRelation : {}", categoryRelationDTO);
        if (categoryRelationDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CategoryRelationDTO result = categoryRelationService.save(categoryRelationDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, categoryRelationDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /category-relations} : get all the categoryRelations.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of categoryRelations in body.
     */
    @GetMapping("/category-relations")
    public ResponseEntity<List<CategoryRelationDTO>> getAllCategoryRelations(Pageable pageable) {
        log.debug("REST request to get a page of CategoryRelations");
        Page<CategoryRelationDTO> page = categoryRelationService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /category-relations/:id} : get the "id" categoryRelation.
     *
     * @param id the id of the categoryRelationDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the categoryRelationDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/category-relations/{id}")
    public ResponseEntity<CategoryRelationDTO> getCategoryRelation(@PathVariable Long id) {
        log.debug("REST request to get CategoryRelation : {}", id);
        Optional<CategoryRelationDTO> categoryRelationDTO = categoryRelationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(categoryRelationDTO);
    }

    /**
     * {@code DELETE  /category-relations/:id} : delete the "id" categoryRelation.
     *
     * @param id the id of the categoryRelationDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/category-relations/{id}")
    public ResponseEntity<Void> deleteCategoryRelation(@PathVariable Long id) {
        log.debug("REST request to delete CategoryRelation : {}", id);
        categoryRelationService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
