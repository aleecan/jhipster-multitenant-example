package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.EntryExitTaskService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.EntryExitTaskDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.EntryExitTask}.
 */
@RestController
@RequestMapping("/api")
public class EntryExitTaskResource {

    private final Logger log = LoggerFactory.getLogger(EntryExitTaskResource.class);

    private static final String ENTITY_NAME = "entryExitTask";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EntryExitTaskService entryExitTaskService;

    public EntryExitTaskResource(EntryExitTaskService entryExitTaskService) {
        this.entryExitTaskService = entryExitTaskService;
    }

    /**
     * {@code POST  /entry-exit-tasks} : Create a new entryExitTask.
     *
     * @param entryExitTaskDTO the entryExitTaskDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new entryExitTaskDTO, or with status {@code 400 (Bad Request)} if the entryExitTask has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/entry-exit-tasks")
    public ResponseEntity<EntryExitTaskDTO> createEntryExitTask(@Valid @RequestBody EntryExitTaskDTO entryExitTaskDTO) throws URISyntaxException {
        log.debug("REST request to save EntryExitTask : {}", entryExitTaskDTO);
        if (entryExitTaskDTO.getId() != null) {
            throw new BadRequestAlertException("A new entryExitTask cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EntryExitTaskDTO result = entryExitTaskService.save(entryExitTaskDTO);
        return ResponseEntity.created(new URI("/api/entry-exit-tasks/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /entry-exit-tasks} : Updates an existing entryExitTask.
     *
     * @param entryExitTaskDTO the entryExitTaskDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated entryExitTaskDTO,
     * or with status {@code 400 (Bad Request)} if the entryExitTaskDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the entryExitTaskDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/entry-exit-tasks")
    public ResponseEntity<EntryExitTaskDTO> updateEntryExitTask(@Valid @RequestBody EntryExitTaskDTO entryExitTaskDTO) throws URISyntaxException {
        log.debug("REST request to update EntryExitTask : {}", entryExitTaskDTO);
        if (entryExitTaskDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        EntryExitTaskDTO result = entryExitTaskService.save(entryExitTaskDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, entryExitTaskDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /entry-exit-tasks} : get all the entryExitTasks.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of entryExitTasks in body.
     */
    @GetMapping("/entry-exit-tasks")
    public ResponseEntity<List<EntryExitTaskDTO>> getAllEntryExitTasks(Pageable pageable) {
        log.debug("REST request to get a page of EntryExitTasks");
        Page<EntryExitTaskDTO> page = entryExitTaskService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /entry-exit-tasks/:id} : get the "id" entryExitTask.
     *
     * @param id the id of the entryExitTaskDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the entryExitTaskDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/entry-exit-tasks/{id}")
    public ResponseEntity<EntryExitTaskDTO> getEntryExitTask(@PathVariable Long id) {
        log.debug("REST request to get EntryExitTask : {}", id);
        Optional<EntryExitTaskDTO> entryExitTaskDTO = entryExitTaskService.findOne(id);
        return ResponseUtil.wrapOrNotFound(entryExitTaskDTO);
    }

    /**
     * {@code DELETE  /entry-exit-tasks/:id} : delete the "id" entryExitTask.
     *
     * @param id the id of the entryExitTaskDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/entry-exit-tasks/{id}")
    public ResponseEntity<Void> deleteEntryExitTask(@PathVariable Long id) {
        log.debug("REST request to delete EntryExitTask : {}", id);
        entryExitTaskService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
