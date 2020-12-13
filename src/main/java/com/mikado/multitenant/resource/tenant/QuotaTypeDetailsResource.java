package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.QuotaTypeDetailsService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.QuotaTypeDetailsDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.QuotaTypeDetails}.
 */
@RestController
@RequestMapping("/api")
public class QuotaTypeDetailsResource {

    private final Logger log = LoggerFactory.getLogger(QuotaTypeDetailsResource.class);

    private static final String ENTITY_NAME = "quotaTypeDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final QuotaTypeDetailsService quotaTypeDetailsService;

    public QuotaTypeDetailsResource(QuotaTypeDetailsService quotaTypeDetailsService) {
        this.quotaTypeDetailsService = quotaTypeDetailsService;
    }

    /**
     * {@code POST  /quota-type-details} : Create a new quotaTypeDetails.
     *
     * @param quotaTypeDetailsDTO the quotaTypeDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new quotaTypeDetailsDTO, or with status {@code 400 (Bad Request)} if the quotaTypeDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/quota-type-details")
    public ResponseEntity<QuotaTypeDetailsDTO> createQuotaTypeDetails(@Valid @RequestBody QuotaTypeDetailsDTO quotaTypeDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save QuotaTypeDetails : {}", quotaTypeDetailsDTO);
        if (quotaTypeDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new quotaTypeDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        QuotaTypeDetailsDTO result = quotaTypeDetailsService.save(quotaTypeDetailsDTO);
        return ResponseEntity.created(new URI("/api/quota-type-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /quota-type-details} : Updates an existing quotaTypeDetails.
     *
     * @param quotaTypeDetailsDTO the quotaTypeDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated quotaTypeDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the quotaTypeDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the quotaTypeDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/quota-type-details")
    public ResponseEntity<QuotaTypeDetailsDTO> updateQuotaTypeDetails(@Valid @RequestBody QuotaTypeDetailsDTO quotaTypeDetailsDTO) throws URISyntaxException {
        log.debug("REST request to update QuotaTypeDetails : {}", quotaTypeDetailsDTO);
        if (quotaTypeDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        QuotaTypeDetailsDTO result = quotaTypeDetailsService.save(quotaTypeDetailsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, quotaTypeDetailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /quota-type-details} : get all the quotaTypeDetails.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of quotaTypeDetails in body.
     */
    @GetMapping("/quota-type-details")
    public ResponseEntity<List<QuotaTypeDetailsDTO>> getAllQuotaTypeDetails(Pageable pageable) {
        log.debug("REST request to get a page of QuotaTypeDetails");
        Page<QuotaTypeDetailsDTO> page = quotaTypeDetailsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /quota-type-details/:id} : get the "id" quotaTypeDetails.
     *
     * @param id the id of the quotaTypeDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the quotaTypeDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/quota-type-details/{id}")
    public ResponseEntity<QuotaTypeDetailsDTO> getQuotaTypeDetails(@PathVariable Long id) {
        log.debug("REST request to get QuotaTypeDetails : {}", id);
        Optional<QuotaTypeDetailsDTO> quotaTypeDetailsDTO = quotaTypeDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(quotaTypeDetailsDTO);
    }

    /**
     * {@code DELETE  /quota-type-details/:id} : delete the "id" quotaTypeDetails.
     *
     * @param id the id of the quotaTypeDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/quota-type-details/{id}")
    public ResponseEntity<Void> deleteQuotaTypeDetails(@PathVariable Long id) {
        log.debug("REST request to delete QuotaTypeDetails : {}", id);
        quotaTypeDetailsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
