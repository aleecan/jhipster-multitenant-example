package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.ScheduleChangeService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.ScheduleChangeDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.ScheduleChange}.
 */
@RestController
@RequestMapping("/api")
public class ScheduleChangeResource {

    private final Logger log = LoggerFactory.getLogger(ScheduleChangeResource.class);

    private static final String ENTITY_NAME = "scheduleChange";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ScheduleChangeService scheduleChangeService;

    public ScheduleChangeResource(ScheduleChangeService scheduleChangeService) {
        this.scheduleChangeService = scheduleChangeService;
    }

    /**
     * {@code POST  /schedule-changes} : Create a new scheduleChange.
     *
     * @param scheduleChangeDTO the scheduleChangeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new scheduleChangeDTO, or with status {@code 400 (Bad Request)} if the scheduleChange has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/schedule-changes")
    public ResponseEntity<ScheduleChangeDTO> createScheduleChange(@Valid @RequestBody ScheduleChangeDTO scheduleChangeDTO) throws URISyntaxException {
        log.debug("REST request to save ScheduleChange : {}", scheduleChangeDTO);
        if (scheduleChangeDTO.getId() != null) {
            throw new BadRequestAlertException("A new scheduleChange cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ScheduleChangeDTO result = scheduleChangeService.save(scheduleChangeDTO);
        return ResponseEntity.created(new URI("/api/schedule-changes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /schedule-changes} : Updates an existing scheduleChange.
     *
     * @param scheduleChangeDTO the scheduleChangeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated scheduleChangeDTO,
     * or with status {@code 400 (Bad Request)} if the scheduleChangeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the scheduleChangeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/schedule-changes")
    public ResponseEntity<ScheduleChangeDTO> updateScheduleChange(@Valid @RequestBody ScheduleChangeDTO scheduleChangeDTO) throws URISyntaxException {
        log.debug("REST request to update ScheduleChange : {}", scheduleChangeDTO);
        if (scheduleChangeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ScheduleChangeDTO result = scheduleChangeService.save(scheduleChangeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, scheduleChangeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /schedule-changes} : get all the scheduleChanges.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of scheduleChanges in body.
     */
    @GetMapping("/schedule-changes")
    public ResponseEntity<List<ScheduleChangeDTO>> getAllScheduleChanges(Pageable pageable) {
        log.debug("REST request to get a page of ScheduleChanges");
        Page<ScheduleChangeDTO> page = scheduleChangeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /schedule-changes/:id} : get the "id" scheduleChange.
     *
     * @param id the id of the scheduleChangeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the scheduleChangeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/schedule-changes/{id}")
    public ResponseEntity<ScheduleChangeDTO> getScheduleChange(@PathVariable Long id) {
        log.debug("REST request to get ScheduleChange : {}", id);
        Optional<ScheduleChangeDTO> scheduleChangeDTO = scheduleChangeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(scheduleChangeDTO);
    }

    /**
     * {@code DELETE  /schedule-changes/:id} : delete the "id" scheduleChange.
     *
     * @param id the id of the scheduleChangeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/schedule-changes/{id}")
    public ResponseEntity<Void> deleteScheduleChange(@PathVariable Long id) {
        log.debug("REST request to delete ScheduleChange : {}", id);
        scheduleChangeService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
