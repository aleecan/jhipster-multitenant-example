package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.TerminalActivityScheduleService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.TerminalActivityScheduleDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.TerminalActivitySchedule}.
 */
@RestController
@RequestMapping("/api")
public class TerminalActivityScheduleResource {

    private final Logger log = LoggerFactory.getLogger(TerminalActivityScheduleResource.class);

    private static final String ENTITY_NAME = "terminalActivitySchedule";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TerminalActivityScheduleService terminalActivityScheduleService;

    public TerminalActivityScheduleResource(TerminalActivityScheduleService terminalActivityScheduleService) {
        this.terminalActivityScheduleService = terminalActivityScheduleService;
    }

    /**
     * {@code POST  /terminal-activity-schedules} : Create a new terminalActivitySchedule.
     *
     * @param terminalActivityScheduleDTO the terminalActivityScheduleDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new terminalActivityScheduleDTO, or with status {@code 400 (Bad Request)} if the terminalActivitySchedule has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/terminal-activity-schedules")
    public ResponseEntity<TerminalActivityScheduleDTO> createTerminalActivitySchedule(@Valid @RequestBody TerminalActivityScheduleDTO terminalActivityScheduleDTO) throws URISyntaxException {
        log.debug("REST request to save TerminalActivitySchedule : {}", terminalActivityScheduleDTO);
        if (terminalActivityScheduleDTO.getId() != null) {
            throw new BadRequestAlertException("A new terminalActivitySchedule cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TerminalActivityScheduleDTO result = terminalActivityScheduleService.save(terminalActivityScheduleDTO);
        return ResponseEntity.created(new URI("/api/terminal-activity-schedules/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /terminal-activity-schedules} : Updates an existing terminalActivitySchedule.
     *
     * @param terminalActivityScheduleDTO the terminalActivityScheduleDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated terminalActivityScheduleDTO,
     * or with status {@code 400 (Bad Request)} if the terminalActivityScheduleDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the terminalActivityScheduleDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/terminal-activity-schedules")
    public ResponseEntity<TerminalActivityScheduleDTO> updateTerminalActivitySchedule(@Valid @RequestBody TerminalActivityScheduleDTO terminalActivityScheduleDTO) throws URISyntaxException {
        log.debug("REST request to update TerminalActivitySchedule : {}", terminalActivityScheduleDTO);
        if (terminalActivityScheduleDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TerminalActivityScheduleDTO result = terminalActivityScheduleService.save(terminalActivityScheduleDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, terminalActivityScheduleDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /terminal-activity-schedules} : get all the terminalActivitySchedules.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of terminalActivitySchedules in body.
     */
    @GetMapping("/terminal-activity-schedules")
    public ResponseEntity<List<TerminalActivityScheduleDTO>> getAllTerminalActivitySchedules(Pageable pageable) {
        log.debug("REST request to get a page of TerminalActivitySchedules");
        Page<TerminalActivityScheduleDTO> page = terminalActivityScheduleService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /terminal-activity-schedules/:id} : get the "id" terminalActivitySchedule.
     *
     * @param id the id of the terminalActivityScheduleDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the terminalActivityScheduleDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/terminal-activity-schedules/{id}")
    public ResponseEntity<TerminalActivityScheduleDTO> getTerminalActivitySchedule(@PathVariable Long id) {
        log.debug("REST request to get TerminalActivitySchedule : {}", id);
        Optional<TerminalActivityScheduleDTO> terminalActivityScheduleDTO = terminalActivityScheduleService.findOne(id);
        return ResponseUtil.wrapOrNotFound(terminalActivityScheduleDTO);
    }

    /**
     * {@code DELETE  /terminal-activity-schedules/:id} : delete the "id" terminalActivitySchedule.
     *
     * @param id the id of the terminalActivityScheduleDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/terminal-activity-schedules/{id}")
    public ResponseEntity<Void> deleteTerminalActivitySchedule(@PathVariable Long id) {
        log.debug("REST request to delete TerminalActivitySchedule : {}", id);
        terminalActivityScheduleService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
