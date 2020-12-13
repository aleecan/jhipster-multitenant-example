package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.WorkContractPeriodService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.WorkContractPeriodDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.WorkContractPeriod}.
 */
@RestController
@RequestMapping("/api")
public class WorkContractPeriodResource {

    private final Logger log = LoggerFactory.getLogger(WorkContractPeriodResource.class);

    private static final String ENTITY_NAME = "workContractPeriod";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final WorkContractPeriodService workContractPeriodService;

    public WorkContractPeriodResource(WorkContractPeriodService workContractPeriodService) {
        this.workContractPeriodService = workContractPeriodService;
    }

    /**
     * {@code POST  /work-contract-periods} : Create a new workContractPeriod.
     *
     * @param workContractPeriodDTO the workContractPeriodDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new workContractPeriodDTO, or with status {@code 400 (Bad Request)} if the workContractPeriod has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/work-contract-periods")
    public ResponseEntity<WorkContractPeriodDTO> createWorkContractPeriod(@Valid @RequestBody WorkContractPeriodDTO workContractPeriodDTO) throws URISyntaxException {
        log.debug("REST request to save WorkContractPeriod : {}", workContractPeriodDTO);
        if (workContractPeriodDTO.getId() != null) {
            throw new BadRequestAlertException("A new workContractPeriod cannot already have an ID", ENTITY_NAME, "idexists");
        }
        WorkContractPeriodDTO result = workContractPeriodService.save(workContractPeriodDTO);
        return ResponseEntity.created(new URI("/api/work-contract-periods/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /work-contract-periods} : Updates an existing workContractPeriod.
     *
     * @param workContractPeriodDTO the workContractPeriodDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated workContractPeriodDTO,
     * or with status {@code 400 (Bad Request)} if the workContractPeriodDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the workContractPeriodDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/work-contract-periods")
    public ResponseEntity<WorkContractPeriodDTO> updateWorkContractPeriod(@Valid @RequestBody WorkContractPeriodDTO workContractPeriodDTO) throws URISyntaxException {
        log.debug("REST request to update WorkContractPeriod : {}", workContractPeriodDTO);
        if (workContractPeriodDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        WorkContractPeriodDTO result = workContractPeriodService.save(workContractPeriodDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, workContractPeriodDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /work-contract-periods} : get all the workContractPeriods.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of workContractPeriods in body.
     */
    @GetMapping("/work-contract-periods")
    public ResponseEntity<List<WorkContractPeriodDTO>> getAllWorkContractPeriods(Pageable pageable) {
        log.debug("REST request to get a page of WorkContractPeriods");
        Page<WorkContractPeriodDTO> page = workContractPeriodService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /work-contract-periods/:id} : get the "id" workContractPeriod.
     *
     * @param id the id of the workContractPeriodDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the workContractPeriodDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/work-contract-periods/{id}")
    public ResponseEntity<WorkContractPeriodDTO> getWorkContractPeriod(@PathVariable Long id) {
        log.debug("REST request to get WorkContractPeriod : {}", id);
        Optional<WorkContractPeriodDTO> workContractPeriodDTO = workContractPeriodService.findOne(id);
        return ResponseUtil.wrapOrNotFound(workContractPeriodDTO);
    }

    /**
     * {@code DELETE  /work-contract-periods/:id} : delete the "id" workContractPeriod.
     *
     * @param id the id of the workContractPeriodDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/work-contract-periods/{id}")
    public ResponseEntity<Void> deleteWorkContractPeriod(@PathVariable Long id) {
        log.debug("REST request to delete WorkContractPeriod : {}", id);
        workContractPeriodService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
