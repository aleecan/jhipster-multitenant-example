package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.SchedulerHistoryService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.SchedulerHistoryDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.SchedulerHistory}.
 */
@RestController
@RequestMapping("/api")
public class SchedulerHistoryResource {

    private final Logger log = LoggerFactory.getLogger(SchedulerHistoryResource.class);

    private static final String ENTITY_NAME = "schedulerHistory";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SchedulerHistoryService schedulerHistoryService;

    public SchedulerHistoryResource(SchedulerHistoryService schedulerHistoryService) {
        this.schedulerHistoryService = schedulerHistoryService;
    }

    /**
     * {@code POST  /scheduler-histories} : Create a new schedulerHistory.
     *
     * @param schedulerHistoryDTO the schedulerHistoryDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new schedulerHistoryDTO, or with status {@code 400 (Bad Request)} if the schedulerHistory has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/scheduler-histories")
    public ResponseEntity<SchedulerHistoryDTO> createSchedulerHistory(@Valid @RequestBody SchedulerHistoryDTO schedulerHistoryDTO) throws URISyntaxException {
        log.debug("REST request to save SchedulerHistory : {}", schedulerHistoryDTO);
        if (schedulerHistoryDTO.getId() != null) {
            throw new BadRequestAlertException("A new schedulerHistory cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SchedulerHistoryDTO result = schedulerHistoryService.save(schedulerHistoryDTO);
        return ResponseEntity.created(new URI("/api/scheduler-histories/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /scheduler-histories} : Updates an existing schedulerHistory.
     *
     * @param schedulerHistoryDTO the schedulerHistoryDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated schedulerHistoryDTO,
     * or with status {@code 400 (Bad Request)} if the schedulerHistoryDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the schedulerHistoryDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/scheduler-histories")
    public ResponseEntity<SchedulerHistoryDTO> updateSchedulerHistory(@Valid @RequestBody SchedulerHistoryDTO schedulerHistoryDTO) throws URISyntaxException {
        log.debug("REST request to update SchedulerHistory : {}", schedulerHistoryDTO);
        if (schedulerHistoryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SchedulerHistoryDTO result = schedulerHistoryService.save(schedulerHistoryDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, schedulerHistoryDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /scheduler-histories} : get all the schedulerHistories.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of schedulerHistories in body.
     */
    @GetMapping("/scheduler-histories")
    public ResponseEntity<List<SchedulerHistoryDTO>> getAllSchedulerHistories(Pageable pageable) {
        log.debug("REST request to get a page of SchedulerHistories");
        Page<SchedulerHistoryDTO> page = schedulerHistoryService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /scheduler-histories/:id} : get the "id" schedulerHistory.
     *
     * @param id the id of the schedulerHistoryDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the schedulerHistoryDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/scheduler-histories/{id}")
    public ResponseEntity<SchedulerHistoryDTO> getSchedulerHistory(@PathVariable Long id) {
        log.debug("REST request to get SchedulerHistory : {}", id);
        Optional<SchedulerHistoryDTO> schedulerHistoryDTO = schedulerHistoryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(schedulerHistoryDTO);
    }

    /**
     * {@code DELETE  /scheduler-histories/:id} : delete the "id" schedulerHistory.
     *
     * @param id the id of the schedulerHistoryDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/scheduler-histories/{id}")
    public ResponseEntity<Void> deleteSchedulerHistory(@PathVariable Long id) {
        log.debug("REST request to delete SchedulerHistory : {}", id);
        schedulerHistoryService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
