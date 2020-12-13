package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.EntryExitAdditionalService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.EntryExitAdditionalDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.EntryExitAdditional}.
 */
@RestController
@RequestMapping("/api")
public class EntryExitAdditionalResource {

    private final Logger log = LoggerFactory.getLogger(EntryExitAdditionalResource.class);

    private static final String ENTITY_NAME = "entryExitAdditional";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EntryExitAdditionalService entryExitAdditionalService;

    public EntryExitAdditionalResource(EntryExitAdditionalService entryExitAdditionalService) {
        this.entryExitAdditionalService = entryExitAdditionalService;
    }

    /**
     * {@code POST  /entry-exit-additionals} : Create a new entryExitAdditional.
     *
     * @param entryExitAdditionalDTO the entryExitAdditionalDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new entryExitAdditionalDTO, or with status {@code 400 (Bad Request)} if the entryExitAdditional has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/entry-exit-additionals")
    public ResponseEntity<EntryExitAdditionalDTO> createEntryExitAdditional(@Valid @RequestBody EntryExitAdditionalDTO entryExitAdditionalDTO) throws URISyntaxException {
        log.debug("REST request to save EntryExitAdditional : {}", entryExitAdditionalDTO);
        if (entryExitAdditionalDTO.getId() != null) {
            throw new BadRequestAlertException("A new entryExitAdditional cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EntryExitAdditionalDTO result = entryExitAdditionalService.save(entryExitAdditionalDTO);
        return ResponseEntity.created(new URI("/api/entry-exit-additionals/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /entry-exit-additionals} : Updates an existing entryExitAdditional.
     *
     * @param entryExitAdditionalDTO the entryExitAdditionalDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated entryExitAdditionalDTO,
     * or with status {@code 400 (Bad Request)} if the entryExitAdditionalDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the entryExitAdditionalDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/entry-exit-additionals")
    public ResponseEntity<EntryExitAdditionalDTO> updateEntryExitAdditional(@Valid @RequestBody EntryExitAdditionalDTO entryExitAdditionalDTO) throws URISyntaxException {
        log.debug("REST request to update EntryExitAdditional : {}", entryExitAdditionalDTO);
        if (entryExitAdditionalDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        EntryExitAdditionalDTO result = entryExitAdditionalService.save(entryExitAdditionalDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, entryExitAdditionalDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /entry-exit-additionals} : get all the entryExitAdditionals.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of entryExitAdditionals in body.
     */
    @GetMapping("/entry-exit-additionals")
    public ResponseEntity<List<EntryExitAdditionalDTO>> getAllEntryExitAdditionals(Pageable pageable) {
        log.debug("REST request to get a page of EntryExitAdditionals");
        Page<EntryExitAdditionalDTO> page = entryExitAdditionalService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /entry-exit-additionals/:id} : get the "id" entryExitAdditional.
     *
     * @param id the id of the entryExitAdditionalDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the entryExitAdditionalDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/entry-exit-additionals/{id}")
    public ResponseEntity<EntryExitAdditionalDTO> getEntryExitAdditional(@PathVariable Long id) {
        log.debug("REST request to get EntryExitAdditional : {}", id);
        Optional<EntryExitAdditionalDTO> entryExitAdditionalDTO = entryExitAdditionalService.findOne(id);
        return ResponseUtil.wrapOrNotFound(entryExitAdditionalDTO);
    }

    /**
     * {@code DELETE  /entry-exit-additionals/:id} : delete the "id" entryExitAdditional.
     *
     * @param id the id of the entryExitAdditionalDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/entry-exit-additionals/{id}")
    public ResponseEntity<Void> deleteEntryExitAdditional(@PathVariable Long id) {
        log.debug("REST request to delete EntryExitAdditional : {}", id);
        entryExitAdditionalService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
