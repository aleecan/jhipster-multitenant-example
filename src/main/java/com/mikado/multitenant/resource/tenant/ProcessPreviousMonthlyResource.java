package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.ProcessPreviousMonthlyService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.ProcessPreviousMonthlyDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.ProcessPreviousMonthly}.
 */
@RestController
@RequestMapping("/api")
public class ProcessPreviousMonthlyResource {

    private final Logger log = LoggerFactory.getLogger(ProcessPreviousMonthlyResource.class);

    private static final String ENTITY_NAME = "processPreviousMonthly";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ProcessPreviousMonthlyService processPreviousMonthlyService;

    public ProcessPreviousMonthlyResource(ProcessPreviousMonthlyService processPreviousMonthlyService) {
        this.processPreviousMonthlyService = processPreviousMonthlyService;
    }

    /**
     * {@code POST  /process-previous-monthlies} : Create a new processPreviousMonthly.
     *
     * @param processPreviousMonthlyDTO the processPreviousMonthlyDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new processPreviousMonthlyDTO, or with status {@code 400 (Bad Request)} if the processPreviousMonthly has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/process-previous-monthlies")
    public ResponseEntity<ProcessPreviousMonthlyDTO> createProcessPreviousMonthly(@Valid @RequestBody ProcessPreviousMonthlyDTO processPreviousMonthlyDTO) throws URISyntaxException {
        log.debug("REST request to save ProcessPreviousMonthly : {}", processPreviousMonthlyDTO);
        if (processPreviousMonthlyDTO.getId() != null) {
            throw new BadRequestAlertException("A new processPreviousMonthly cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ProcessPreviousMonthlyDTO result = processPreviousMonthlyService.save(processPreviousMonthlyDTO);
        return ResponseEntity.created(new URI("/api/process-previous-monthlies/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /process-previous-monthlies} : Updates an existing processPreviousMonthly.
     *
     * @param processPreviousMonthlyDTO the processPreviousMonthlyDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated processPreviousMonthlyDTO,
     * or with status {@code 400 (Bad Request)} if the processPreviousMonthlyDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the processPreviousMonthlyDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/process-previous-monthlies")
    public ResponseEntity<ProcessPreviousMonthlyDTO> updateProcessPreviousMonthly(@Valid @RequestBody ProcessPreviousMonthlyDTO processPreviousMonthlyDTO) throws URISyntaxException {
        log.debug("REST request to update ProcessPreviousMonthly : {}", processPreviousMonthlyDTO);
        if (processPreviousMonthlyDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ProcessPreviousMonthlyDTO result = processPreviousMonthlyService.save(processPreviousMonthlyDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, processPreviousMonthlyDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /process-previous-monthlies} : get all the processPreviousMonthlies.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of processPreviousMonthlies in body.
     */
    @GetMapping("/process-previous-monthlies")
    public ResponseEntity<List<ProcessPreviousMonthlyDTO>> getAllProcessPreviousMonthlies(Pageable pageable) {
        log.debug("REST request to get a page of ProcessPreviousMonthlies");
        Page<ProcessPreviousMonthlyDTO> page = processPreviousMonthlyService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /process-previous-monthlies/:id} : get the "id" processPreviousMonthly.
     *
     * @param id the id of the processPreviousMonthlyDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the processPreviousMonthlyDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/process-previous-monthlies/{id}")
    public ResponseEntity<ProcessPreviousMonthlyDTO> getProcessPreviousMonthly(@PathVariable Long id) {
        log.debug("REST request to get ProcessPreviousMonthly : {}", id);
        Optional<ProcessPreviousMonthlyDTO> processPreviousMonthlyDTO = processPreviousMonthlyService.findOne(id);
        return ResponseUtil.wrapOrNotFound(processPreviousMonthlyDTO);
    }

    /**
     * {@code DELETE  /process-previous-monthlies/:id} : delete the "id" processPreviousMonthly.
     *
     * @param id the id of the processPreviousMonthlyDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/process-previous-monthlies/{id}")
    public ResponseEntity<Void> deleteProcessPreviousMonthly(@PathVariable Long id) {
        log.debug("REST request to delete ProcessPreviousMonthly : {}", id);
        processPreviousMonthlyService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
