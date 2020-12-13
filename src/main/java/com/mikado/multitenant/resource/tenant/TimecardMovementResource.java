package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.TimecardMovementService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.TimecardMovementDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.TimecardMovement}.
 */
@RestController
@RequestMapping("/api")
public class TimecardMovementResource {

    private final Logger log = LoggerFactory.getLogger(TimecardMovementResource.class);

    private static final String ENTITY_NAME = "timecardMovement";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TimecardMovementService timecardMovementService;

    public TimecardMovementResource(TimecardMovementService timecardMovementService) {
        this.timecardMovementService = timecardMovementService;
    }

    /**
     * {@code POST  /timecard-movements} : Create a new timecardMovement.
     *
     * @param timecardMovementDTO the timecardMovementDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new timecardMovementDTO, or with status {@code 400 (Bad Request)} if the timecardMovement has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/timecard-movements")
    public ResponseEntity<TimecardMovementDTO> createTimecardMovement(@Valid @RequestBody TimecardMovementDTO timecardMovementDTO) throws URISyntaxException {
        log.debug("REST request to save TimecardMovement : {}", timecardMovementDTO);
        if (timecardMovementDTO.getId() != null) {
            throw new BadRequestAlertException("A new timecardMovement cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TimecardMovementDTO result = timecardMovementService.save(timecardMovementDTO);
        return ResponseEntity.created(new URI("/api/timecard-movements/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /timecard-movements} : Updates an existing timecardMovement.
     *
     * @param timecardMovementDTO the timecardMovementDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated timecardMovementDTO,
     * or with status {@code 400 (Bad Request)} if the timecardMovementDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the timecardMovementDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/timecard-movements")
    public ResponseEntity<TimecardMovementDTO> updateTimecardMovement(@Valid @RequestBody TimecardMovementDTO timecardMovementDTO) throws URISyntaxException {
        log.debug("REST request to update TimecardMovement : {}", timecardMovementDTO);
        if (timecardMovementDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TimecardMovementDTO result = timecardMovementService.save(timecardMovementDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, timecardMovementDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /timecard-movements} : get all the timecardMovements.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of timecardMovements in body.
     */
    @GetMapping("/timecard-movements")
    public ResponseEntity<List<TimecardMovementDTO>> getAllTimecardMovements(Pageable pageable) {
        log.debug("REST request to get a page of TimecardMovements");
        Page<TimecardMovementDTO> page = timecardMovementService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /timecard-movements/:id} : get the "id" timecardMovement.
     *
     * @param id the id of the timecardMovementDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the timecardMovementDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/timecard-movements/{id}")
    public ResponseEntity<TimecardMovementDTO> getTimecardMovement(@PathVariable Long id) {
        log.debug("REST request to get TimecardMovement : {}", id);
        Optional<TimecardMovementDTO> timecardMovementDTO = timecardMovementService.findOne(id);
        return ResponseUtil.wrapOrNotFound(timecardMovementDTO);
    }

    /**
     * {@code DELETE  /timecard-movements/:id} : delete the "id" timecardMovement.
     *
     * @param id the id of the timecardMovementDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/timecard-movements/{id}")
    public ResponseEntity<Void> deleteTimecardMovement(@PathVariable Long id) {
        log.debug("REST request to delete TimecardMovement : {}", id);
        timecardMovementService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
