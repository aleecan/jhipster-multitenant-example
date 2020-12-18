package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.ToleranceService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.ToleranceDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.Tolerance}.
 */
@RestController
@RequestMapping("/api")
public class ToleranceResource {

    private final Logger log = LoggerFactory.getLogger(ToleranceResource.class);

    private static final String ENTITY_NAME = "tolerance";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ToleranceService toleranceService;

    public ToleranceResource(ToleranceService toleranceService) {
        this.toleranceService = toleranceService;
    }

    /**
     * {@code POST  /tolerances} : Create a new tolerance.
     *
     * @param toleranceDTO the toleranceDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new toleranceDTO, or with status {@code 400 (Bad Request)} if the tolerance has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/tolerances")
    public ResponseEntity<ToleranceDTO> createTolerance(@Valid @RequestBody ToleranceDTO toleranceDTO) throws URISyntaxException {
        log.debug("REST request to save Tolerance : {}", toleranceDTO);
        if (toleranceDTO.getId() != null) {
            throw new BadRequestAlertException("A new tolerance cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ToleranceDTO result = toleranceService.save(toleranceDTO);
        return ResponseEntity.created(new URI("/api/tolerances/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /tolerances} : Updates an existing tolerance.
     *
     * @param toleranceDTO the toleranceDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated toleranceDTO,
     * or with status {@code 400 (Bad Request)} if the toleranceDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the toleranceDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/tolerances")
    public ResponseEntity<ToleranceDTO> updateTolerance(@Valid @RequestBody ToleranceDTO toleranceDTO) throws URISyntaxException {
        log.debug("REST request to update Tolerance : {}", toleranceDTO);
        if (toleranceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ToleranceDTO result = toleranceService.save(toleranceDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, toleranceDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /tolerances} : get all the tolerances.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of tolerances in body.
     */
    @GetMapping("/tolerances")
    public ResponseEntity<List<ToleranceDTO>> getAllTolerances(Pageable pageable) {
        log.debug("REST request to get a page of Tolerances");
        Page<ToleranceDTO> page = toleranceService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /tolerances/:id} : get the "id" tolerance.
     *
     * @param id the id of the toleranceDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the toleranceDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/tolerances/{id}")
    public ResponseEntity<ToleranceDTO> getTolerance(@PathVariable Long id) {
        log.debug("REST request to get Tolerance : {}", id);
        Optional<ToleranceDTO> toleranceDTO = toleranceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(toleranceDTO);
    }

    /**
     * {@code DELETE  /tolerances/:id} : delete the "id" tolerance.
     *
     * @param id the id of the toleranceDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/tolerances/{id}")
    public ResponseEntity<Void> deleteTolerance(@PathVariable Long id) {
        log.debug("REST request to delete Tolerance : {}", id);
        toleranceService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
