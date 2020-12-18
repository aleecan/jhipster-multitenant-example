package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.EntryExitChangeService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.EntryExitChangeDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.EntryExitChange}.
 */
@RestController
@RequestMapping("/api")
public class EntryExitChangeResource {

    private final Logger log = LoggerFactory.getLogger(EntryExitChangeResource.class);

    private static final String ENTITY_NAME = "entryExitChange";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EntryExitChangeService entryExitChangeService;

    public EntryExitChangeResource(EntryExitChangeService entryExitChangeService) {
        this.entryExitChangeService = entryExitChangeService;
    }

    /**
     * {@code POST  /entry-exit-changes} : Create a new entryExitChange.
     *
     * @param entryExitChangeDTO the entryExitChangeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new entryExitChangeDTO, or with status {@code 400 (Bad Request)} if the entryExitChange has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/entry-exit-changes")
    public ResponseEntity<EntryExitChangeDTO> createEntryExitChange(@Valid @RequestBody EntryExitChangeDTO entryExitChangeDTO) throws URISyntaxException {
        log.debug("REST request to save EntryExitChange : {}", entryExitChangeDTO);
        if (entryExitChangeDTO.getId() != null) {
            throw new BadRequestAlertException("A new entryExitChange cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EntryExitChangeDTO result = entryExitChangeService.save(entryExitChangeDTO);
        return ResponseEntity.created(new URI("/api/entry-exit-changes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /entry-exit-changes} : Updates an existing entryExitChange.
     *
     * @param entryExitChangeDTO the entryExitChangeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated entryExitChangeDTO,
     * or with status {@code 400 (Bad Request)} if the entryExitChangeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the entryExitChangeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/entry-exit-changes")
    public ResponseEntity<EntryExitChangeDTO> updateEntryExitChange(@Valid @RequestBody EntryExitChangeDTO entryExitChangeDTO) throws URISyntaxException {
        log.debug("REST request to update EntryExitChange : {}", entryExitChangeDTO);
        if (entryExitChangeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        EntryExitChangeDTO result = entryExitChangeService.save(entryExitChangeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, entryExitChangeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /entry-exit-changes} : get all the entryExitChanges.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of entryExitChanges in body.
     */
    @GetMapping("/entry-exit-changes")
    public ResponseEntity<List<EntryExitChangeDTO>> getAllEntryExitChanges(Pageable pageable) {
        log.debug("REST request to get a page of EntryExitChanges");
        Page<EntryExitChangeDTO> page = entryExitChangeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /entry-exit-changes/:id} : get the "id" entryExitChange.
     *
     * @param id the id of the entryExitChangeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the entryExitChangeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/entry-exit-changes/{id}")
    public ResponseEntity<EntryExitChangeDTO> getEntryExitChange(@PathVariable Long id) {
        log.debug("REST request to get EntryExitChange : {}", id);
        Optional<EntryExitChangeDTO> entryExitChangeDTO = entryExitChangeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(entryExitChangeDTO);
    }

    /**
     * {@code DELETE  /entry-exit-changes/:id} : delete the "id" entryExitChange.
     *
     * @param id the id of the entryExitChangeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/entry-exit-changes/{id}")
    public ResponseEntity<Void> deleteEntryExitChange(@PathVariable Long id) {
        log.debug("REST request to delete EntryExitChange : {}", id);
        entryExitChangeService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
