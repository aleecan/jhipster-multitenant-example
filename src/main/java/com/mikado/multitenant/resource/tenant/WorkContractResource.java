package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.WorkContractService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.WorkContractDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.WorkContract}.
 */
@RestController
@RequestMapping("/api")
public class WorkContractResource {

    private final Logger log = LoggerFactory.getLogger(WorkContractResource.class);

    private static final String ENTITY_NAME = "workContract";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final WorkContractService workContractService;

    public WorkContractResource(WorkContractService workContractService) {
        this.workContractService = workContractService;
    }

    /**
     * {@code POST  /work-contracts} : Create a new workContract.
     *
     * @param workContractDTO the workContractDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new workContractDTO, or with status {@code 400 (Bad Request)} if the workContract has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/work-contracts")
    public ResponseEntity<WorkContractDTO> createWorkContract(@Valid @RequestBody WorkContractDTO workContractDTO) throws URISyntaxException {
        log.debug("REST request to save WorkContract : {}", workContractDTO);
        if (workContractDTO.getId() != null) {
            throw new BadRequestAlertException("A new workContract cannot already have an ID", ENTITY_NAME, "idexists");
        }
        WorkContractDTO result = workContractService.save(workContractDTO);
        return ResponseEntity.created(new URI("/api/work-contracts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /work-contracts} : Updates an existing workContract.
     *
     * @param workContractDTO the workContractDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated workContractDTO,
     * or with status {@code 400 (Bad Request)} if the workContractDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the workContractDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/work-contracts")
    public ResponseEntity<WorkContractDTO> updateWorkContract(@Valid @RequestBody WorkContractDTO workContractDTO) throws URISyntaxException {
        log.debug("REST request to update WorkContract : {}", workContractDTO);
        if (workContractDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        WorkContractDTO result = workContractService.save(workContractDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, workContractDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /work-contracts} : get all the workContracts.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of workContracts in body.
     */
    @GetMapping("/work-contracts")
    public ResponseEntity<List<WorkContractDTO>> getAllWorkContracts(Pageable pageable) {
        log.debug("REST request to get a page of WorkContracts");
        Page<WorkContractDTO> page = workContractService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /work-contracts/:id} : get the "id" workContract.
     *
     * @param id the id of the workContractDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the workContractDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/work-contracts/{id}")
    public ResponseEntity<WorkContractDTO> getWorkContract(@PathVariable Long id) {
        log.debug("REST request to get WorkContract : {}", id);
        Optional<WorkContractDTO> workContractDTO = workContractService.findOne(id);
        return ResponseUtil.wrapOrNotFound(workContractDTO);
    }

    /**
     * {@code DELETE  /work-contracts/:id} : delete the "id" workContract.
     *
     * @param id the id of the workContractDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/work-contracts/{id}")
    public ResponseEntity<Void> deleteWorkContract(@PathVariable Long id) {
        log.debug("REST request to delete WorkContract : {}", id);
        workContractService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
