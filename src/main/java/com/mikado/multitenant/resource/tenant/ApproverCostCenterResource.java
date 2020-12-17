package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.ApproverCostCenterService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.ApproverCostCenterDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.ApproverCostCenter}.
 */
@RestController
@RequestMapping("/api")
public class ApproverCostCenterResource {

    private final Logger log = LoggerFactory.getLogger(ApproverCostCenterResource.class);

    private static final String ENTITY_NAME = "approverCostCenter";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ApproverCostCenterService approverCostCenterService;

    public ApproverCostCenterResource(ApproverCostCenterService approverCostCenterService) {
        this.approverCostCenterService = approverCostCenterService;
    }

    /**
     * {@code POST  /approver-cost-centers} : Create a new approverCostCenter.
     *
     * @param approverCostCenterDTO the approverCostCenterDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new approverCostCenterDTO, or with status {@code 400 (Bad Request)} if the approverCostCenter has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/approver-cost-centers")
    public ResponseEntity<ApproverCostCenterDTO> createApproverCostCenter(@Valid @RequestBody ApproverCostCenterDTO approverCostCenterDTO) throws URISyntaxException {
        log.debug("REST request to save ApproverCostCenter : {}", approverCostCenterDTO);
        if (approverCostCenterDTO.getId() != null) {
            throw new BadRequestAlertException("A new approverCostCenter cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ApproverCostCenterDTO result = approverCostCenterService.save(approverCostCenterDTO);
        return ResponseEntity.created(new URI("/api/approver-cost-centers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /approver-cost-centers} : Updates an existing approverCostCenter.
     *
     * @param approverCostCenterDTO the approverCostCenterDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated approverCostCenterDTO,
     * or with status {@code 400 (Bad Request)} if the approverCostCenterDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the approverCostCenterDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/approver-cost-centers")
    public ResponseEntity<ApproverCostCenterDTO> updateApproverCostCenter(@Valid @RequestBody ApproverCostCenterDTO approverCostCenterDTO) throws URISyntaxException {
        log.debug("REST request to update ApproverCostCenter : {}", approverCostCenterDTO);
        if (approverCostCenterDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ApproverCostCenterDTO result = approverCostCenterService.save(approverCostCenterDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, approverCostCenterDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /approver-cost-centers} : get all the approverCostCenters.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of approverCostCenters in body.
     */
    @GetMapping("/approver-cost-centers")
    public ResponseEntity<List<ApproverCostCenterDTO>> getAllApproverCostCenters(Pageable pageable) {
        log.debug("REST request to get a page of ApproverCostCenters");
        Page<ApproverCostCenterDTO> page = approverCostCenterService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /approver-cost-centers/:id} : get the "id" approverCostCenter.
     *
     * @param id the id of the approverCostCenterDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the approverCostCenterDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/approver-cost-centers/{id}")
    public ResponseEntity<ApproverCostCenterDTO> getApproverCostCenter(@PathVariable Long id) {
        log.debug("REST request to get ApproverCostCenter : {}", id);
        Optional<ApproverCostCenterDTO> approverCostCenterDTO = approverCostCenterService.findOne(id);
        return ResponseUtil.wrapOrNotFound(approverCostCenterDTO);
    }

    /**
     * {@code DELETE  /approver-cost-centers/:id} : delete the "id" approverCostCenter.
     *
     * @param id the id of the approverCostCenterDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/approver-cost-centers/{id}")
    public ResponseEntity<Void> deleteApproverCostCenter(@PathVariable Long id) {
        log.debug("REST request to delete ApproverCostCenter : {}", id);
        approverCostCenterService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
