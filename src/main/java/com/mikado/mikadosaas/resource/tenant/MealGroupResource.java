package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.MealGroupService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.MealGroupDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.MealGroup}.
 */
@RestController
@RequestMapping("/api")
public class MealGroupResource {

    private final Logger log = LoggerFactory.getLogger(MealGroupResource.class);

    private static final String ENTITY_NAME = "mealGroup";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MealGroupService mealGroupService;

    public MealGroupResource(MealGroupService mealGroupService) {
        this.mealGroupService = mealGroupService;
    }

    /**
     * {@code POST  /meal-groups} : Create a new mealGroup.
     *
     * @param mealGroupDTO the mealGroupDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new mealGroupDTO, or with status {@code 400 (Bad Request)} if the mealGroup has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/meal-groups")
    public ResponseEntity<MealGroupDTO> createMealGroup(@Valid @RequestBody MealGroupDTO mealGroupDTO) throws URISyntaxException {
        log.debug("REST request to save MealGroup : {}", mealGroupDTO);
        if (mealGroupDTO.getId() != null) {
            throw new BadRequestAlertException("A new mealGroup cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MealGroupDTO result = mealGroupService.save(mealGroupDTO);
        return ResponseEntity.created(new URI("/api/meal-groups/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /meal-groups} : Updates an existing mealGroup.
     *
     * @param mealGroupDTO the mealGroupDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mealGroupDTO,
     * or with status {@code 400 (Bad Request)} if the mealGroupDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the mealGroupDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/meal-groups")
    public ResponseEntity<MealGroupDTO> updateMealGroup(@Valid @RequestBody MealGroupDTO mealGroupDTO) throws URISyntaxException {
        log.debug("REST request to update MealGroup : {}", mealGroupDTO);
        if (mealGroupDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MealGroupDTO result = mealGroupService.save(mealGroupDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, mealGroupDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /meal-groups} : get all the mealGroups.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of mealGroups in body.
     */
    @GetMapping("/meal-groups")
    public ResponseEntity<List<MealGroupDTO>> getAllMealGroups(Pageable pageable) {
        log.debug("REST request to get a page of MealGroups");
        Page<MealGroupDTO> page = mealGroupService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /meal-groups/:id} : get the "id" mealGroup.
     *
     * @param id the id of the mealGroupDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the mealGroupDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/meal-groups/{id}")
    public ResponseEntity<MealGroupDTO> getMealGroup(@PathVariable Long id) {
        log.debug("REST request to get MealGroup : {}", id);
        Optional<MealGroupDTO> mealGroupDTO = mealGroupService.findOne(id);
        return ResponseUtil.wrapOrNotFound(mealGroupDTO);
    }

    /**
     * {@code DELETE  /meal-groups/:id} : delete the "id" mealGroup.
     *
     * @param id the id of the mealGroupDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/meal-groups/{id}")
    public ResponseEntity<Void> deleteMealGroup(@PathVariable Long id) {
        log.debug("REST request to delete MealGroup : {}", id);
        mealGroupService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
