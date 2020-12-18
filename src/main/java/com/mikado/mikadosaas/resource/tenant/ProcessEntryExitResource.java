package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.ProcessEntryExitService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.ProcessEntryExitDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.ProcessEntryExit}.
 */
@RestController
@RequestMapping("/api")
public class ProcessEntryExitResource {

    private final Logger log = LoggerFactory.getLogger(ProcessEntryExitResource.class);

    private static final String ENTITY_NAME = "processEntryExit";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ProcessEntryExitService processEntryExitService;

    public ProcessEntryExitResource(ProcessEntryExitService processEntryExitService) {
        this.processEntryExitService = processEntryExitService;
    }

    /**
     * {@code POST  /process-entry-exits} : Create a new processEntryExit.
     *
     * @param processEntryExitDTO the processEntryExitDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new processEntryExitDTO, or with status {@code 400 (Bad Request)} if the processEntryExit has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/process-entry-exits")
    public ResponseEntity<ProcessEntryExitDTO> createProcessEntryExit(@Valid @RequestBody ProcessEntryExitDTO processEntryExitDTO) throws URISyntaxException {
        log.debug("REST request to save ProcessEntryExit : {}", processEntryExitDTO);
        if (processEntryExitDTO.getId() != null) {
            throw new BadRequestAlertException("A new processEntryExit cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ProcessEntryExitDTO result = processEntryExitService.save(processEntryExitDTO);
        return ResponseEntity.created(new URI("/api/process-entry-exits/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /process-entry-exits} : Updates an existing processEntryExit.
     *
     * @param processEntryExitDTO the processEntryExitDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated processEntryExitDTO,
     * or with status {@code 400 (Bad Request)} if the processEntryExitDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the processEntryExitDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/process-entry-exits")
    public ResponseEntity<ProcessEntryExitDTO> updateProcessEntryExit(@Valid @RequestBody ProcessEntryExitDTO processEntryExitDTO) throws URISyntaxException {
        log.debug("REST request to update ProcessEntryExit : {}", processEntryExitDTO);
        if (processEntryExitDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ProcessEntryExitDTO result = processEntryExitService.save(processEntryExitDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, processEntryExitDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /process-entry-exits} : get all the processEntryExits.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of processEntryExits in body.
     */
    @GetMapping("/process-entry-exits")
    public ResponseEntity<List<ProcessEntryExitDTO>> getAllProcessEntryExits(Pageable pageable) {
        log.debug("REST request to get a page of ProcessEntryExits");
        Page<ProcessEntryExitDTO> page = processEntryExitService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /process-entry-exits/:id} : get the "id" processEntryExit.
     *
     * @param id the id of the processEntryExitDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the processEntryExitDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/process-entry-exits/{id}")
    public ResponseEntity<ProcessEntryExitDTO> getProcessEntryExit(@PathVariable Long id) {
        log.debug("REST request to get ProcessEntryExit : {}", id);
        Optional<ProcessEntryExitDTO> processEntryExitDTO = processEntryExitService.findOne(id);
        return ResponseUtil.wrapOrNotFound(processEntryExitDTO);
    }

    /**
     * {@code DELETE  /process-entry-exits/:id} : delete the "id" processEntryExit.
     *
     * @param id the id of the processEntryExitDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/process-entry-exits/{id}")
    public ResponseEntity<Void> deleteProcessEntryExit(@PathVariable Long id) {
        log.debug("REST request to delete ProcessEntryExit : {}", id);
        processEntryExitService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
