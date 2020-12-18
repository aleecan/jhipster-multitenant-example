package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.ProcessHolidayLeaveService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.ProcessHolidayLeaveDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.ProcessHolidayLeave}.
 */
@RestController
@RequestMapping("/api")
public class ProcessHolidayLeaveResource {

    private final Logger log = LoggerFactory.getLogger(ProcessHolidayLeaveResource.class);

    private static final String ENTITY_NAME = "processHolidayLeave";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ProcessHolidayLeaveService processHolidayLeaveService;

    public ProcessHolidayLeaveResource(ProcessHolidayLeaveService processHolidayLeaveService) {
        this.processHolidayLeaveService = processHolidayLeaveService;
    }

    /**
     * {@code POST  /process-holiday-leaves} : Create a new processHolidayLeave.
     *
     * @param processHolidayLeaveDTO the processHolidayLeaveDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new processHolidayLeaveDTO, or with status {@code 400 (Bad Request)} if the processHolidayLeave has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/process-holiday-leaves")
    public ResponseEntity<ProcessHolidayLeaveDTO> createProcessHolidayLeave(@Valid @RequestBody ProcessHolidayLeaveDTO processHolidayLeaveDTO) throws URISyntaxException {
        log.debug("REST request to save ProcessHolidayLeave : {}", processHolidayLeaveDTO);
        if (processHolidayLeaveDTO.getId() != null) {
            throw new BadRequestAlertException("A new processHolidayLeave cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ProcessHolidayLeaveDTO result = processHolidayLeaveService.save(processHolidayLeaveDTO);
        return ResponseEntity.created(new URI("/api/process-holiday-leaves/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /process-holiday-leaves} : Updates an existing processHolidayLeave.
     *
     * @param processHolidayLeaveDTO the processHolidayLeaveDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated processHolidayLeaveDTO,
     * or with status {@code 400 (Bad Request)} if the processHolidayLeaveDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the processHolidayLeaveDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/process-holiday-leaves")
    public ResponseEntity<ProcessHolidayLeaveDTO> updateProcessHolidayLeave(@Valid @RequestBody ProcessHolidayLeaveDTO processHolidayLeaveDTO) throws URISyntaxException {
        log.debug("REST request to update ProcessHolidayLeave : {}", processHolidayLeaveDTO);
        if (processHolidayLeaveDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ProcessHolidayLeaveDTO result = processHolidayLeaveService.save(processHolidayLeaveDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, processHolidayLeaveDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /process-holiday-leaves} : get all the processHolidayLeaves.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of processHolidayLeaves in body.
     */
    @GetMapping("/process-holiday-leaves")
    public ResponseEntity<List<ProcessHolidayLeaveDTO>> getAllProcessHolidayLeaves(Pageable pageable) {
        log.debug("REST request to get a page of ProcessHolidayLeaves");
        Page<ProcessHolidayLeaveDTO> page = processHolidayLeaveService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /process-holiday-leaves/:id} : get the "id" processHolidayLeave.
     *
     * @param id the id of the processHolidayLeaveDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the processHolidayLeaveDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/process-holiday-leaves/{id}")
    public ResponseEntity<ProcessHolidayLeaveDTO> getProcessHolidayLeave(@PathVariable Long id) {
        log.debug("REST request to get ProcessHolidayLeave : {}", id);
        Optional<ProcessHolidayLeaveDTO> processHolidayLeaveDTO = processHolidayLeaveService.findOne(id);
        return ResponseUtil.wrapOrNotFound(processHolidayLeaveDTO);
    }

    /**
     * {@code DELETE  /process-holiday-leaves/:id} : delete the "id" processHolidayLeave.
     *
     * @param id the id of the processHolidayLeaveDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/process-holiday-leaves/{id}")
    public ResponseEntity<Void> deleteProcessHolidayLeave(@PathVariable Long id) {
        log.debug("REST request to delete ProcessHolidayLeave : {}", id);
        processHolidayLeaveService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
