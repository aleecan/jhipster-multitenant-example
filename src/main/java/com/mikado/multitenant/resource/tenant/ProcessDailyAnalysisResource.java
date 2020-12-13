package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.ProcessDailyAnalysisService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.ProcessDailyAnalysisDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.ProcessDailyAnalysis}.
 */
@RestController
@RequestMapping("/api")
public class ProcessDailyAnalysisResource {

    private final Logger log = LoggerFactory.getLogger(ProcessDailyAnalysisResource.class);

    private static final String ENTITY_NAME = "processDailyAnalysis";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ProcessDailyAnalysisService processDailyAnalysisService;

    public ProcessDailyAnalysisResource(ProcessDailyAnalysisService processDailyAnalysisService) {
        this.processDailyAnalysisService = processDailyAnalysisService;
    }

    /**
     * {@code POST  /process-daily-analyses} : Create a new processDailyAnalysis.
     *
     * @param processDailyAnalysisDTO the processDailyAnalysisDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new processDailyAnalysisDTO, or with status {@code 400 (Bad Request)} if the processDailyAnalysis has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/process-daily-analyses")
    public ResponseEntity<ProcessDailyAnalysisDTO> createProcessDailyAnalysis(@Valid @RequestBody ProcessDailyAnalysisDTO processDailyAnalysisDTO) throws URISyntaxException {
        log.debug("REST request to save ProcessDailyAnalysis : {}", processDailyAnalysisDTO);
        if (processDailyAnalysisDTO.getId() != null) {
            throw new BadRequestAlertException("A new processDailyAnalysis cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ProcessDailyAnalysisDTO result = processDailyAnalysisService.save(processDailyAnalysisDTO);
        return ResponseEntity.created(new URI("/api/process-daily-analyses/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /process-daily-analyses} : Updates an existing processDailyAnalysis.
     *
     * @param processDailyAnalysisDTO the processDailyAnalysisDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated processDailyAnalysisDTO,
     * or with status {@code 400 (Bad Request)} if the processDailyAnalysisDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the processDailyAnalysisDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/process-daily-analyses")
    public ResponseEntity<ProcessDailyAnalysisDTO> updateProcessDailyAnalysis(@Valid @RequestBody ProcessDailyAnalysisDTO processDailyAnalysisDTO) throws URISyntaxException {
        log.debug("REST request to update ProcessDailyAnalysis : {}", processDailyAnalysisDTO);
        if (processDailyAnalysisDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ProcessDailyAnalysisDTO result = processDailyAnalysisService.save(processDailyAnalysisDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, processDailyAnalysisDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /process-daily-analyses} : get all the processDailyAnalyses.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of processDailyAnalyses in body.
     */
    @GetMapping("/process-daily-analyses")
    public ResponseEntity<List<ProcessDailyAnalysisDTO>> getAllProcessDailyAnalyses(Pageable pageable) {
        log.debug("REST request to get a page of ProcessDailyAnalyses");
        Page<ProcessDailyAnalysisDTO> page = processDailyAnalysisService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /process-daily-analyses/:id} : get the "id" processDailyAnalysis.
     *
     * @param id the id of the processDailyAnalysisDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the processDailyAnalysisDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/process-daily-analyses/{id}")
    public ResponseEntity<ProcessDailyAnalysisDTO> getProcessDailyAnalysis(@PathVariable Long id) {
        log.debug("REST request to get ProcessDailyAnalysis : {}", id);
        Optional<ProcessDailyAnalysisDTO> processDailyAnalysisDTO = processDailyAnalysisService.findOne(id);
        return ResponseUtil.wrapOrNotFound(processDailyAnalysisDTO);
    }

    /**
     * {@code DELETE  /process-daily-analyses/:id} : delete the "id" processDailyAnalysis.
     *
     * @param id the id of the processDailyAnalysisDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/process-daily-analyses/{id}")
    public ResponseEntity<Void> deleteProcessDailyAnalysis(@PathVariable Long id) {
        log.debug("REST request to delete ProcessDailyAnalysis : {}", id);
        processDailyAnalysisService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
