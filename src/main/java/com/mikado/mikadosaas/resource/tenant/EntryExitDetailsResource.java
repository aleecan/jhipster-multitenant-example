package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.EntryExitDetailsService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.EntryExitDetailsDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.EntryExitDetails}.
 */
@RestController
@RequestMapping("/api")
public class EntryExitDetailsResource {

    private final Logger log = LoggerFactory.getLogger(EntryExitDetailsResource.class);

    private static final String ENTITY_NAME = "entryExitDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EntryExitDetailsService entryExitDetailsService;

    public EntryExitDetailsResource(EntryExitDetailsService entryExitDetailsService) {
        this.entryExitDetailsService = entryExitDetailsService;
    }

    /**
     * {@code POST  /entry-exit-details} : Create a new entryExitDetails.
     *
     * @param entryExitDetailsDTO the entryExitDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new entryExitDetailsDTO, or with status {@code 400 (Bad Request)} if the entryExitDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/entry-exit-details")
    public ResponseEntity<EntryExitDetailsDTO> createEntryExitDetails(@Valid @RequestBody EntryExitDetailsDTO entryExitDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save EntryExitDetails : {}", entryExitDetailsDTO);
        if (entryExitDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new entryExitDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EntryExitDetailsDTO result = entryExitDetailsService.save(entryExitDetailsDTO);
        return ResponseEntity.created(new URI("/api/entry-exit-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /entry-exit-details} : Updates an existing entryExitDetails.
     *
     * @param entryExitDetailsDTO the entryExitDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated entryExitDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the entryExitDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the entryExitDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/entry-exit-details")
    public ResponseEntity<EntryExitDetailsDTO> updateEntryExitDetails(@Valid @RequestBody EntryExitDetailsDTO entryExitDetailsDTO) throws URISyntaxException {
        log.debug("REST request to update EntryExitDetails : {}", entryExitDetailsDTO);
        if (entryExitDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        EntryExitDetailsDTO result = entryExitDetailsService.save(entryExitDetailsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, entryExitDetailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /entry-exit-details} : get all the entryExitDetails.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of entryExitDetails in body.
     */
    @GetMapping("/entry-exit-details")
    public ResponseEntity<List<EntryExitDetailsDTO>> getAllEntryExitDetails(Pageable pageable) {
        log.debug("REST request to get a page of EntryExitDetails");
        Page<EntryExitDetailsDTO> page = entryExitDetailsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /entry-exit-details/:id} : get the "id" entryExitDetails.
     *
     * @param id the id of the entryExitDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the entryExitDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/entry-exit-details/{id}")
    public ResponseEntity<EntryExitDetailsDTO> getEntryExitDetails(@PathVariable Long id) {
        log.debug("REST request to get EntryExitDetails : {}", id);
        Optional<EntryExitDetailsDTO> entryExitDetailsDTO = entryExitDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(entryExitDetailsDTO);
    }

    /**
     * {@code DELETE  /entry-exit-details/:id} : delete the "id" entryExitDetails.
     *
     * @param id the id of the entryExitDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/entry-exit-details/{id}")
    public ResponseEntity<Void> deleteEntryExitDetails(@PathVariable Long id) {
        log.debug("REST request to delete EntryExitDetails : {}", id);
        entryExitDetailsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
