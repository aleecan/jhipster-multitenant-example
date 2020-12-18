package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.ApproverDepartmentService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.ApproverDepartmentDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.ApproverDepartment}.
 */
@RestController
@RequestMapping("/api")
public class ApproverDepartmentResource {

    private final Logger log = LoggerFactory.getLogger(ApproverDepartmentResource.class);

    private static final String ENTITY_NAME = "approverDepartment";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ApproverDepartmentService approverDepartmentService;

    public ApproverDepartmentResource(ApproverDepartmentService approverDepartmentService) {
        this.approverDepartmentService = approverDepartmentService;
    }

    /**
     * {@code POST  /approver-departments} : Create a new approverDepartment.
     *
     * @param approverDepartmentDTO the approverDepartmentDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new approverDepartmentDTO, or with status {@code 400 (Bad Request)} if the approverDepartment has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/approver-departments")
    public ResponseEntity<ApproverDepartmentDTO> createApproverDepartment(@Valid @RequestBody ApproverDepartmentDTO approverDepartmentDTO) throws URISyntaxException {
        log.debug("REST request to save ApproverDepartment : {}", approverDepartmentDTO);
        if (approverDepartmentDTO.getId() != null) {
            throw new BadRequestAlertException("A new approverDepartment cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ApproverDepartmentDTO result = approverDepartmentService.save(approverDepartmentDTO);
        return ResponseEntity.created(new URI("/api/approver-departments/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /approver-departments} : Updates an existing approverDepartment.
     *
     * @param approverDepartmentDTO the approverDepartmentDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated approverDepartmentDTO,
     * or with status {@code 400 (Bad Request)} if the approverDepartmentDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the approverDepartmentDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/approver-departments")
    public ResponseEntity<ApproverDepartmentDTO> updateApproverDepartment(@Valid @RequestBody ApproverDepartmentDTO approverDepartmentDTO) throws URISyntaxException {
        log.debug("REST request to update ApproverDepartment : {}", approverDepartmentDTO);
        if (approverDepartmentDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ApproverDepartmentDTO result = approverDepartmentService.save(approverDepartmentDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, approverDepartmentDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /approver-departments} : get all the approverDepartments.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of approverDepartments in body.
     */
    @GetMapping("/approver-departments")
    public ResponseEntity<List<ApproverDepartmentDTO>> getAllApproverDepartments(Pageable pageable) {
        log.debug("REST request to get a page of ApproverDepartments");
        Page<ApproverDepartmentDTO> page = approverDepartmentService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /approver-departments/:id} : get the "id" approverDepartment.
     *
     * @param id the id of the approverDepartmentDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the approverDepartmentDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/approver-departments/{id}")
    public ResponseEntity<ApproverDepartmentDTO> getApproverDepartment(@PathVariable Long id) {
        log.debug("REST request to get ApproverDepartment : {}", id);
        Optional<ApproverDepartmentDTO> approverDepartmentDTO = approverDepartmentService.findOne(id);
        return ResponseUtil.wrapOrNotFound(approverDepartmentDTO);
    }

    /**
     * {@code DELETE  /approver-departments/:id} : delete the "id" approverDepartment.
     *
     * @param id the id of the approverDepartmentDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/approver-departments/{id}")
    public ResponseEntity<Void> deleteApproverDepartment(@PathVariable Long id) {
        log.debug("REST request to delete ApproverDepartment : {}", id);
        approverDepartmentService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
