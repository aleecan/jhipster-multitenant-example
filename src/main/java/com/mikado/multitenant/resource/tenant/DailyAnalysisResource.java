package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.DailyAnalysisService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.DailyAnalysisDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.DailyAnalysis}.
 */
@RestController
@RequestMapping("/api")
public class DailyAnalysisResource {

    private final Logger log = LoggerFactory.getLogger(DailyAnalysisResource.class);

    private static final String ENTITY_NAME = "dailyAnalysis";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DailyAnalysisService dailyAnalysisService;

    public DailyAnalysisResource(DailyAnalysisService dailyAnalysisService) {
        this.dailyAnalysisService = dailyAnalysisService;
    }

    /**
     * {@code POST  /daily-analyses} : Create a new dailyAnalysis.
     *
     * @param dailyAnalysisDTO the dailyAnalysisDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dailyAnalysisDTO, or with status {@code 400 (Bad Request)} if the dailyAnalysis has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/daily-analyses")
    public ResponseEntity<DailyAnalysisDTO> createDailyAnalysis(@Valid @RequestBody DailyAnalysisDTO dailyAnalysisDTO) throws URISyntaxException {
        log.debug("REST request to save DailyAnalysis : {}", dailyAnalysisDTO);
        if (dailyAnalysisDTO.getId() != null) {
            throw new BadRequestAlertException("A new dailyAnalysis cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DailyAnalysisDTO result = dailyAnalysisService.save(dailyAnalysisDTO);
        return ResponseEntity.created(new URI("/api/daily-analyses/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /daily-analyses} : Updates an existing dailyAnalysis.
     *
     * @param dailyAnalysisDTO the dailyAnalysisDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dailyAnalysisDTO,
     * or with status {@code 400 (Bad Request)} if the dailyAnalysisDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dailyAnalysisDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/daily-analyses")
    public ResponseEntity<DailyAnalysisDTO> updateDailyAnalysis(@Valid @RequestBody DailyAnalysisDTO dailyAnalysisDTO) throws URISyntaxException {
        log.debug("REST request to update DailyAnalysis : {}", dailyAnalysisDTO);
        if (dailyAnalysisDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DailyAnalysisDTO result = dailyAnalysisService.save(dailyAnalysisDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, dailyAnalysisDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /daily-analyses} : get all the dailyAnalyses.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dailyAnalyses in body.
     */
    @GetMapping("/daily-analyses")
    public ResponseEntity<List<DailyAnalysisDTO>> getAllDailyAnalyses(Pageable pageable) {
        log.debug("REST request to get a page of DailyAnalyses");
        Page<DailyAnalysisDTO> page = dailyAnalysisService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /daily-analyses/:id} : get the "id" dailyAnalysis.
     *
     * @param id the id of the dailyAnalysisDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dailyAnalysisDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/daily-analyses/{id}")
    public ResponseEntity<DailyAnalysisDTO> getDailyAnalysis(@PathVariable Long id) {
        log.debug("REST request to get DailyAnalysis : {}", id);
        Optional<DailyAnalysisDTO> dailyAnalysisDTO = dailyAnalysisService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dailyAnalysisDTO);
    }

    /**
     * {@code DELETE  /daily-analyses/:id} : delete the "id" dailyAnalysis.
     *
     * @param id the id of the dailyAnalysisDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/daily-analyses/{id}")
    public ResponseEntity<Void> deleteDailyAnalysis(@PathVariable Long id) {
        log.debug("REST request to delete DailyAnalysis : {}", id);
        dailyAnalysisService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
