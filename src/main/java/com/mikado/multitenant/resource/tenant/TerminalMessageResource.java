package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.TerminalMessageService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.TerminalMessageDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.TerminalMessage}.
 */
@RestController
@RequestMapping("/api")
public class TerminalMessageResource {

    private final Logger log = LoggerFactory.getLogger(TerminalMessageResource.class);

    private static final String ENTITY_NAME = "terminalMessage";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TerminalMessageService terminalMessageService;

    public TerminalMessageResource(TerminalMessageService terminalMessageService) {
        this.terminalMessageService = terminalMessageService;
    }

    /**
     * {@code POST  /terminal-messages} : Create a new terminalMessage.
     *
     * @param terminalMessageDTO the terminalMessageDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new terminalMessageDTO, or with status {@code 400 (Bad Request)} if the terminalMessage has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/terminal-messages")
    public ResponseEntity<TerminalMessageDTO> createTerminalMessage(@Valid @RequestBody TerminalMessageDTO terminalMessageDTO) throws URISyntaxException {
        log.debug("REST request to save TerminalMessage : {}", terminalMessageDTO);
        if (terminalMessageDTO.getId() != null) {
            throw new BadRequestAlertException("A new terminalMessage cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TerminalMessageDTO result = terminalMessageService.save(terminalMessageDTO);
        return ResponseEntity.created(new URI("/api/terminal-messages/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /terminal-messages} : Updates an existing terminalMessage.
     *
     * @param terminalMessageDTO the terminalMessageDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated terminalMessageDTO,
     * or with status {@code 400 (Bad Request)} if the terminalMessageDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the terminalMessageDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/terminal-messages")
    public ResponseEntity<TerminalMessageDTO> updateTerminalMessage(@Valid @RequestBody TerminalMessageDTO terminalMessageDTO) throws URISyntaxException {
        log.debug("REST request to update TerminalMessage : {}", terminalMessageDTO);
        if (terminalMessageDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TerminalMessageDTO result = terminalMessageService.save(terminalMessageDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, terminalMessageDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /terminal-messages} : get all the terminalMessages.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of terminalMessages in body.
     */
    @GetMapping("/terminal-messages")
    public ResponseEntity<List<TerminalMessageDTO>> getAllTerminalMessages(Pageable pageable) {
        log.debug("REST request to get a page of TerminalMessages");
        Page<TerminalMessageDTO> page = terminalMessageService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /terminal-messages/:id} : get the "id" terminalMessage.
     *
     * @param id the id of the terminalMessageDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the terminalMessageDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/terminal-messages/{id}")
    public ResponseEntity<TerminalMessageDTO> getTerminalMessage(@PathVariable Long id) {
        log.debug("REST request to get TerminalMessage : {}", id);
        Optional<TerminalMessageDTO> terminalMessageDTO = terminalMessageService.findOne(id);
        return ResponseUtil.wrapOrNotFound(terminalMessageDTO);
    }

    /**
     * {@code DELETE  /terminal-messages/:id} : delete the "id" terminalMessage.
     *
     * @param id the id of the terminalMessageDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/terminal-messages/{id}")
    public ResponseEntity<Void> deleteTerminalMessage(@PathVariable Long id) {
        log.debug("REST request to delete TerminalMessage : {}", id);
        terminalMessageService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
