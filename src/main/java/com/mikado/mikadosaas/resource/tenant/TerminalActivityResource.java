package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.TerminalActivityService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.TerminalActivityDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.TerminalActivity}.
 */
@RestController
@RequestMapping("/api")
public class TerminalActivityResource {

    private final Logger log = LoggerFactory.getLogger(TerminalActivityResource.class);

    private static final String ENTITY_NAME = "terminalActivity";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TerminalActivityService terminalActivityService;

    public TerminalActivityResource(TerminalActivityService terminalActivityService) {
        this.terminalActivityService = terminalActivityService;
    }

    /**
     * {@code POST  /terminal-activities} : Create a new terminalActivity.
     *
     * @param terminalActivityDTO the terminalActivityDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new terminalActivityDTO, or with status {@code 400 (Bad Request)} if the terminalActivity has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/terminal-activities")
    public ResponseEntity<TerminalActivityDTO> createTerminalActivity(@Valid @RequestBody TerminalActivityDTO terminalActivityDTO) throws URISyntaxException {
        log.debug("REST request to save TerminalActivity : {}", terminalActivityDTO);
        if (terminalActivityDTO.getId() != null) {
            throw new BadRequestAlertException("A new terminalActivity cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TerminalActivityDTO result = terminalActivityService.save(terminalActivityDTO);
        return ResponseEntity.created(new URI("/api/terminal-activities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /terminal-activities} : Updates an existing terminalActivity.
     *
     * @param terminalActivityDTO the terminalActivityDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated terminalActivityDTO,
     * or with status {@code 400 (Bad Request)} if the terminalActivityDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the terminalActivityDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/terminal-activities")
    public ResponseEntity<TerminalActivityDTO> updateTerminalActivity(@Valid @RequestBody TerminalActivityDTO terminalActivityDTO) throws URISyntaxException {
        log.debug("REST request to update TerminalActivity : {}", terminalActivityDTO);
        if (terminalActivityDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TerminalActivityDTO result = terminalActivityService.save(terminalActivityDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, terminalActivityDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /terminal-activities} : get all the terminalActivities.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of terminalActivities in body.
     */
    @GetMapping("/terminal-activities")
    public ResponseEntity<List<TerminalActivityDTO>> getAllTerminalActivities(Pageable pageable) {
        log.debug("REST request to get a page of TerminalActivities");
        Page<TerminalActivityDTO> page = terminalActivityService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /terminal-activities/:id} : get the "id" terminalActivity.
     *
     * @param id the id of the terminalActivityDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the terminalActivityDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/terminal-activities/{id}")
    public ResponseEntity<TerminalActivityDTO> getTerminalActivity(@PathVariable Long id) {
        log.debug("REST request to get TerminalActivity : {}", id);
        Optional<TerminalActivityDTO> terminalActivityDTO = terminalActivityService.findOne(id);
        return ResponseUtil.wrapOrNotFound(terminalActivityDTO);
    }

    /**
     * {@code DELETE  /terminal-activities/:id} : delete the "id" terminalActivity.
     *
     * @param id the id of the terminalActivityDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/terminal-activities/{id}")
    public ResponseEntity<Void> deleteTerminalActivity(@PathVariable Long id) {
        log.debug("REST request to delete TerminalActivity : {}", id);
        terminalActivityService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
