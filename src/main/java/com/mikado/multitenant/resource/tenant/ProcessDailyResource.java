package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.ProcessDailyService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.ProcessDailyDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.ProcessDaily}.
 */
@RestController
@RequestMapping("/api")
public class ProcessDailyResource {

    private final Logger log = LoggerFactory.getLogger(ProcessDailyResource.class);

    private static final String ENTITY_NAME = "processDaily";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ProcessDailyService processDailyService;

    public ProcessDailyResource(ProcessDailyService processDailyService) {
        this.processDailyService = processDailyService;
    }

    /**
     * {@code POST  /process-dailies} : Create a new processDaily.
     *
     * @param processDailyDTO the processDailyDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new processDailyDTO, or with status {@code 400 (Bad Request)} if the processDaily has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/process-dailies")
    public ResponseEntity<ProcessDailyDTO> createProcessDaily(@Valid @RequestBody ProcessDailyDTO processDailyDTO) throws URISyntaxException {
        log.debug("REST request to save ProcessDaily : {}", processDailyDTO);
        if (processDailyDTO.getId() != null) {
            throw new BadRequestAlertException("A new processDaily cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ProcessDailyDTO result = processDailyService.save(processDailyDTO);
        return ResponseEntity.created(new URI("/api/process-dailies/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /process-dailies} : Updates an existing processDaily.
     *
     * @param processDailyDTO the processDailyDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated processDailyDTO,
     * or with status {@code 400 (Bad Request)} if the processDailyDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the processDailyDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/process-dailies")
    public ResponseEntity<ProcessDailyDTO> updateProcessDaily(@Valid @RequestBody ProcessDailyDTO processDailyDTO) throws URISyntaxException {
        log.debug("REST request to update ProcessDaily : {}", processDailyDTO);
        if (processDailyDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ProcessDailyDTO result = processDailyService.save(processDailyDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, processDailyDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /process-dailies} : get all the processDailies.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of processDailies in body.
     */
    @GetMapping("/process-dailies")
    public ResponseEntity<List<ProcessDailyDTO>> getAllProcessDailies(Pageable pageable) {
        log.debug("REST request to get a page of ProcessDailies");
        Page<ProcessDailyDTO> page = processDailyService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /process-dailies/:id} : get the "id" processDaily.
     *
     * @param id the id of the processDailyDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the processDailyDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/process-dailies/{id}")
    public ResponseEntity<ProcessDailyDTO> getProcessDaily(@PathVariable Long id) {
        log.debug("REST request to get ProcessDaily : {}", id);
        Optional<ProcessDailyDTO> processDailyDTO = processDailyService.findOne(id);
        return ResponseUtil.wrapOrNotFound(processDailyDTO);
    }

    /**
     * {@code DELETE  /process-dailies/:id} : delete the "id" processDaily.
     *
     * @param id the id of the processDailyDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/process-dailies/{id}")
    public ResponseEntity<Void> deleteProcessDaily(@PathVariable Long id) {
        log.debug("REST request to delete ProcessDaily : {}", id);
        processDailyService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
