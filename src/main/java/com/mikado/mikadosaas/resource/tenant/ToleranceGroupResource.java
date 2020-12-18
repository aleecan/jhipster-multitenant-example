package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.ToleranceGroupService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.ToleranceGroupDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.ToleranceGroup}.
 */
@RestController
@RequestMapping("/api")
public class ToleranceGroupResource {

    private final Logger log = LoggerFactory.getLogger(ToleranceGroupResource.class);

    private static final String ENTITY_NAME = "toleranceGroup";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ToleranceGroupService toleranceGroupService;

    public ToleranceGroupResource(ToleranceGroupService toleranceGroupService) {
        this.toleranceGroupService = toleranceGroupService;
    }

    /**
     * {@code POST  /tolerance-groups} : Create a new toleranceGroup.
     *
     * @param toleranceGroupDTO the toleranceGroupDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new toleranceGroupDTO, or with status {@code 400 (Bad Request)} if the toleranceGroup has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/tolerance-groups")
    public ResponseEntity<ToleranceGroupDTO> createToleranceGroup(@Valid @RequestBody ToleranceGroupDTO toleranceGroupDTO) throws URISyntaxException {
        log.debug("REST request to save ToleranceGroup : {}", toleranceGroupDTO);
        if (toleranceGroupDTO.getId() != null) {
            throw new BadRequestAlertException("A new toleranceGroup cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ToleranceGroupDTO result = toleranceGroupService.save(toleranceGroupDTO);
        return ResponseEntity.created(new URI("/api/tolerance-groups/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /tolerance-groups} : Updates an existing toleranceGroup.
     *
     * @param toleranceGroupDTO the toleranceGroupDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated toleranceGroupDTO,
     * or with status {@code 400 (Bad Request)} if the toleranceGroupDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the toleranceGroupDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/tolerance-groups")
    public ResponseEntity<ToleranceGroupDTO> updateToleranceGroup(@Valid @RequestBody ToleranceGroupDTO toleranceGroupDTO) throws URISyntaxException {
        log.debug("REST request to update ToleranceGroup : {}", toleranceGroupDTO);
        if (toleranceGroupDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ToleranceGroupDTO result = toleranceGroupService.save(toleranceGroupDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, toleranceGroupDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /tolerance-groups} : get all the toleranceGroups.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of toleranceGroups in body.
     */
    @GetMapping("/tolerance-groups")
    public ResponseEntity<List<ToleranceGroupDTO>> getAllToleranceGroups(Pageable pageable) {
        log.debug("REST request to get a page of ToleranceGroups");
        Page<ToleranceGroupDTO> page = toleranceGroupService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /tolerance-groups/:id} : get the "id" toleranceGroup.
     *
     * @param id the id of the toleranceGroupDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the toleranceGroupDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/tolerance-groups/{id}")
    public ResponseEntity<ToleranceGroupDTO> getToleranceGroup(@PathVariable Long id) {
        log.debug("REST request to get ToleranceGroup : {}", id);
        Optional<ToleranceGroupDTO> toleranceGroupDTO = toleranceGroupService.findOne(id);
        return ResponseUtil.wrapOrNotFound(toleranceGroupDTO);
    }

    /**
     * {@code DELETE  /tolerance-groups/:id} : delete the "id" toleranceGroup.
     *
     * @param id the id of the toleranceGroupDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/tolerance-groups/{id}")
    public ResponseEntity<Void> deleteToleranceGroup(@PathVariable Long id) {
        log.debug("REST request to delete ToleranceGroup : {}", id);
        toleranceGroupService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
