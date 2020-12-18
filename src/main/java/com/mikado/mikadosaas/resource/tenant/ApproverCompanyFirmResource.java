package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.ApproverCompanyFirmService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.ApproverCompanyFirmDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.ApproverCompanyFirm}.
 */
@RestController
@RequestMapping("/api")
public class ApproverCompanyFirmResource {

    private final Logger log = LoggerFactory.getLogger(ApproverCompanyFirmResource.class);

    private static final String ENTITY_NAME = "approverCompanyFirm";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ApproverCompanyFirmService approverCompanyFirmService;

    public ApproverCompanyFirmResource(ApproverCompanyFirmService approverCompanyFirmService) {
        this.approverCompanyFirmService = approverCompanyFirmService;
    }

    /**
     * {@code POST  /approver-company-firms} : Create a new approverCompanyFirm.
     *
     * @param approverCompanyFirmDTO the approverCompanyFirmDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new approverCompanyFirmDTO, or with status {@code 400 (Bad Request)} if the approverCompanyFirm has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/approver-company-firms")
    public ResponseEntity<ApproverCompanyFirmDTO> createApproverCompanyFirm(@Valid @RequestBody ApproverCompanyFirmDTO approverCompanyFirmDTO) throws URISyntaxException {
        log.debug("REST request to save ApproverCompanyFirm : {}", approverCompanyFirmDTO);
        if (approverCompanyFirmDTO.getId() != null) {
            throw new BadRequestAlertException("A new approverCompanyFirm cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ApproverCompanyFirmDTO result = approverCompanyFirmService.save(approverCompanyFirmDTO);
        return ResponseEntity.created(new URI("/api/approver-company-firms/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /approver-company-firms} : Updates an existing approverCompanyFirm.
     *
     * @param approverCompanyFirmDTO the approverCompanyFirmDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated approverCompanyFirmDTO,
     * or with status {@code 400 (Bad Request)} if the approverCompanyFirmDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the approverCompanyFirmDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/approver-company-firms")
    public ResponseEntity<ApproverCompanyFirmDTO> updateApproverCompanyFirm(@Valid @RequestBody ApproverCompanyFirmDTO approverCompanyFirmDTO) throws URISyntaxException {
        log.debug("REST request to update ApproverCompanyFirm : {}", approverCompanyFirmDTO);
        if (approverCompanyFirmDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ApproverCompanyFirmDTO result = approverCompanyFirmService.save(approverCompanyFirmDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, approverCompanyFirmDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /approver-company-firms} : get all the approverCompanyFirms.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of approverCompanyFirms in body.
     */
    @GetMapping("/approver-company-firms")
    public ResponseEntity<List<ApproverCompanyFirmDTO>> getAllApproverCompanyFirms(Pageable pageable) {
        log.debug("REST request to get a page of ApproverCompanyFirms");
        Page<ApproverCompanyFirmDTO> page = approverCompanyFirmService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /approver-company-firms/:id} : get the "id" approverCompanyFirm.
     *
     * @param id the id of the approverCompanyFirmDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the approverCompanyFirmDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/approver-company-firms/{id}")
    public ResponseEntity<ApproverCompanyFirmDTO> getApproverCompanyFirm(@PathVariable Long id) {
        log.debug("REST request to get ApproverCompanyFirm : {}", id);
        Optional<ApproverCompanyFirmDTO> approverCompanyFirmDTO = approverCompanyFirmService.findOne(id);
        return ResponseUtil.wrapOrNotFound(approverCompanyFirmDTO);
    }

    /**
     * {@code DELETE  /approver-company-firms/:id} : delete the "id" approverCompanyFirm.
     *
     * @param id the id of the approverCompanyFirmDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/approver-company-firms/{id}")
    public ResponseEntity<Void> deleteApproverCompanyFirm(@PathVariable Long id) {
        log.debug("REST request to delete ApproverCompanyFirm : {}", id);
        approverCompanyFirmService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
