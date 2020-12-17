package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.ProcessMonthlyService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.ProcessMonthlyDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.ProcessMonthly}.
 */
@RestController
@RequestMapping("/api")
public class ProcessMonthlyResource {

    private final Logger log = LoggerFactory.getLogger(ProcessMonthlyResource.class);

    private static final String ENTITY_NAME = "processMonthly";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ProcessMonthlyService processMonthlyService;

    public ProcessMonthlyResource(ProcessMonthlyService processMonthlyService) {
        this.processMonthlyService = processMonthlyService;
    }

    /**
     * {@code POST  /process-monthlies} : Create a new processMonthly.
     *
     * @param processMonthlyDTO the processMonthlyDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new processMonthlyDTO, or with status {@code 400 (Bad Request)} if the processMonthly has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/process-monthlies")
    public ResponseEntity<ProcessMonthlyDTO> createProcessMonthly(@Valid @RequestBody ProcessMonthlyDTO processMonthlyDTO) throws URISyntaxException {
        log.debug("REST request to save ProcessMonthly : {}", processMonthlyDTO);
        if (processMonthlyDTO.getId() != null) {
            throw new BadRequestAlertException("A new processMonthly cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ProcessMonthlyDTO result = processMonthlyService.save(processMonthlyDTO);
        return ResponseEntity.created(new URI("/api/process-monthlies/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /process-monthlies} : Updates an existing processMonthly.
     *
     * @param processMonthlyDTO the processMonthlyDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated processMonthlyDTO,
     * or with status {@code 400 (Bad Request)} if the processMonthlyDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the processMonthlyDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/process-monthlies")
    public ResponseEntity<ProcessMonthlyDTO> updateProcessMonthly(@Valid @RequestBody ProcessMonthlyDTO processMonthlyDTO) throws URISyntaxException {
        log.debug("REST request to update ProcessMonthly : {}", processMonthlyDTO);
        if (processMonthlyDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ProcessMonthlyDTO result = processMonthlyService.save(processMonthlyDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, processMonthlyDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /process-monthlies} : get all the processMonthlies.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of processMonthlies in body.
     */
    @GetMapping("/process-monthlies")
    public ResponseEntity<List<ProcessMonthlyDTO>> getAllProcessMonthlies(Pageable pageable) {
        log.debug("REST request to get a page of ProcessMonthlies");
        Page<ProcessMonthlyDTO> page = processMonthlyService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /process-monthlies/:id} : get the "id" processMonthly.
     *
     * @param id the id of the processMonthlyDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the processMonthlyDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/process-monthlies/{id}")
    public ResponseEntity<ProcessMonthlyDTO> getProcessMonthly(@PathVariable Long id) {
        log.debug("REST request to get ProcessMonthly : {}", id);
        Optional<ProcessMonthlyDTO> processMonthlyDTO = processMonthlyService.findOne(id);
        return ResponseUtil.wrapOrNotFound(processMonthlyDTO);
    }

    /**
     * {@code DELETE  /process-monthlies/:id} : delete the "id" processMonthly.
     *
     * @param id the id of the processMonthlyDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/process-monthlies/{id}")
    public ResponseEntity<Void> deleteProcessMonthly(@PathVariable Long id) {
        log.debug("REST request to delete ProcessMonthly : {}", id);
        processMonthlyService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
