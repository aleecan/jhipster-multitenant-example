package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.TerminalSlaveService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.TerminalSlaveDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.TerminalSlave}.
 */
@RestController
@RequestMapping("/api")
public class TerminalSlaveResource {

    private final Logger log = LoggerFactory.getLogger(TerminalSlaveResource.class);

    private static final String ENTITY_NAME = "terminalSlave";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TerminalSlaveService terminalSlaveService;

    public TerminalSlaveResource(TerminalSlaveService terminalSlaveService) {
        this.terminalSlaveService = terminalSlaveService;
    }

    /**
     * {@code POST  /terminal-slaves} : Create a new terminalSlave.
     *
     * @param terminalSlaveDTO the terminalSlaveDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new terminalSlaveDTO, or with status {@code 400 (Bad Request)} if the terminalSlave has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/terminal-slaves")
    public ResponseEntity<TerminalSlaveDTO> createTerminalSlave(@Valid @RequestBody TerminalSlaveDTO terminalSlaveDTO) throws URISyntaxException {
        log.debug("REST request to save TerminalSlave : {}", terminalSlaveDTO);
        if (terminalSlaveDTO.getId() != null) {
            throw new BadRequestAlertException("A new terminalSlave cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TerminalSlaveDTO result = terminalSlaveService.save(terminalSlaveDTO);
        return ResponseEntity.created(new URI("/api/terminal-slaves/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /terminal-slaves} : Updates an existing terminalSlave.
     *
     * @param terminalSlaveDTO the terminalSlaveDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated terminalSlaveDTO,
     * or with status {@code 400 (Bad Request)} if the terminalSlaveDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the terminalSlaveDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/terminal-slaves")
    public ResponseEntity<TerminalSlaveDTO> updateTerminalSlave(@Valid @RequestBody TerminalSlaveDTO terminalSlaveDTO) throws URISyntaxException {
        log.debug("REST request to update TerminalSlave : {}", terminalSlaveDTO);
        if (terminalSlaveDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TerminalSlaveDTO result = terminalSlaveService.save(terminalSlaveDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, terminalSlaveDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /terminal-slaves} : get all the terminalSlaves.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of terminalSlaves in body.
     */
    @GetMapping("/terminal-slaves")
    public ResponseEntity<List<TerminalSlaveDTO>> getAllTerminalSlaves(Pageable pageable) {
        log.debug("REST request to get a page of TerminalSlaves");
        Page<TerminalSlaveDTO> page = terminalSlaveService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /terminal-slaves/:id} : get the "id" terminalSlave.
     *
     * @param id the id of the terminalSlaveDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the terminalSlaveDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/terminal-slaves/{id}")
    public ResponseEntity<TerminalSlaveDTO> getTerminalSlave(@PathVariable Long id) {
        log.debug("REST request to get TerminalSlave : {}", id);
        Optional<TerminalSlaveDTO> terminalSlaveDTO = terminalSlaveService.findOne(id);
        return ResponseUtil.wrapOrNotFound(terminalSlaveDTO);
    }

    /**
     * {@code DELETE  /terminal-slaves/:id} : delete the "id" terminalSlave.
     *
     * @param id the id of the terminalSlaveDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/terminal-slaves/{id}")
    public ResponseEntity<Void> deleteTerminalSlave(@PathVariable Long id) {
        log.debug("REST request to delete TerminalSlave : {}", id);
        terminalSlaveService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
