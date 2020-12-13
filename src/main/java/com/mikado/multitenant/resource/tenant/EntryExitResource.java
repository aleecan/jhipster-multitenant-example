package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.EntryExitService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.EntryExitDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.EntryExit}.
 */
@RestController
@RequestMapping("/api")
public class EntryExitResource {

    private final Logger log = LoggerFactory.getLogger(EntryExitResource.class);

    private static final String ENTITY_NAME = "entryExit";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EntryExitService entryExitService;

    public EntryExitResource(EntryExitService entryExitService) {
        this.entryExitService = entryExitService;
    }

    /**
     * {@code POST  /entry-exits} : Create a new entryExit.
     *
     * @param entryExitDTO the entryExitDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new entryExitDTO, or with status {@code 400 (Bad Request)} if the entryExit has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/entry-exits")
    public ResponseEntity<EntryExitDTO> createEntryExit(@Valid @RequestBody EntryExitDTO entryExitDTO) throws URISyntaxException {
        log.debug("REST request to save EntryExit : {}", entryExitDTO);
        if (entryExitDTO.getId() != null) {
            throw new BadRequestAlertException("A new entryExit cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EntryExitDTO result = entryExitService.save(entryExitDTO);
        return ResponseEntity.created(new URI("/api/entry-exits/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /entry-exits} : Updates an existing entryExit.
     *
     * @param entryExitDTO the entryExitDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated entryExitDTO,
     * or with status {@code 400 (Bad Request)} if the entryExitDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the entryExitDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/entry-exits")
    public ResponseEntity<EntryExitDTO> updateEntryExit(@Valid @RequestBody EntryExitDTO entryExitDTO) throws URISyntaxException {
        log.debug("REST request to update EntryExit : {}", entryExitDTO);
        if (entryExitDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        EntryExitDTO result = entryExitService.save(entryExitDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, entryExitDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /entry-exits} : get all the entryExits.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of entryExits in body.
     */
    @GetMapping("/entry-exits")
    public ResponseEntity<List<EntryExitDTO>> getAllEntryExits(Pageable pageable) {
        log.debug("REST request to get a page of EntryExits");
        Page<EntryExitDTO> page = entryExitService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /entry-exits/:id} : get the "id" entryExit.
     *
     * @param id the id of the entryExitDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the entryExitDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/entry-exits/{id}")
    public ResponseEntity<EntryExitDTO> getEntryExit(@PathVariable Long id) {
        log.debug("REST request to get EntryExit : {}", id);
        Optional<EntryExitDTO> entryExitDTO = entryExitService.findOne(id);
        return ResponseUtil.wrapOrNotFound(entryExitDTO);
    }

    /**
     * {@code DELETE  /entry-exits/:id} : delete the "id" entryExit.
     *
     * @param id the id of the entryExitDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/entry-exits/{id}")
    public ResponseEntity<Void> deleteEntryExit(@PathVariable Long id) {
        log.debug("REST request to delete EntryExit : {}", id);
        entryExitService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
