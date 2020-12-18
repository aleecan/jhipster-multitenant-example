package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.QuotaBalanceDetailsService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.QuotaBalanceDetailsDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.QuotaBalanceDetails}.
 */
@RestController
@RequestMapping("/api")
public class QuotaBalanceDetailsResource {

    private final Logger log = LoggerFactory.getLogger(QuotaBalanceDetailsResource.class);

    private static final String ENTITY_NAME = "quotaBalanceDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final QuotaBalanceDetailsService quotaBalanceDetailsService;

    public QuotaBalanceDetailsResource(QuotaBalanceDetailsService quotaBalanceDetailsService) {
        this.quotaBalanceDetailsService = quotaBalanceDetailsService;
    }

    /**
     * {@code POST  /quota-balance-details} : Create a new quotaBalanceDetails.
     *
     * @param quotaBalanceDetailsDTO the quotaBalanceDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new quotaBalanceDetailsDTO, or with status {@code 400 (Bad Request)} if the quotaBalanceDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/quota-balance-details")
    public ResponseEntity<QuotaBalanceDetailsDTO> createQuotaBalanceDetails(@Valid @RequestBody QuotaBalanceDetailsDTO quotaBalanceDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save QuotaBalanceDetails : {}", quotaBalanceDetailsDTO);
        if (quotaBalanceDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new quotaBalanceDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        QuotaBalanceDetailsDTO result = quotaBalanceDetailsService.save(quotaBalanceDetailsDTO);
        return ResponseEntity.created(new URI("/api/quota-balance-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /quota-balance-details} : Updates an existing quotaBalanceDetails.
     *
     * @param quotaBalanceDetailsDTO the quotaBalanceDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated quotaBalanceDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the quotaBalanceDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the quotaBalanceDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/quota-balance-details")
    public ResponseEntity<QuotaBalanceDetailsDTO> updateQuotaBalanceDetails(@Valid @RequestBody QuotaBalanceDetailsDTO quotaBalanceDetailsDTO) throws URISyntaxException {
        log.debug("REST request to update QuotaBalanceDetails : {}", quotaBalanceDetailsDTO);
        if (quotaBalanceDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        QuotaBalanceDetailsDTO result = quotaBalanceDetailsService.save(quotaBalanceDetailsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, quotaBalanceDetailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /quota-balance-details} : get all the quotaBalanceDetails.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of quotaBalanceDetails in body.
     */
    @GetMapping("/quota-balance-details")
    public ResponseEntity<List<QuotaBalanceDetailsDTO>> getAllQuotaBalanceDetails(Pageable pageable) {
        log.debug("REST request to get a page of QuotaBalanceDetails");
        Page<QuotaBalanceDetailsDTO> page = quotaBalanceDetailsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /quota-balance-details/:id} : get the "id" quotaBalanceDetails.
     *
     * @param id the id of the quotaBalanceDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the quotaBalanceDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/quota-balance-details/{id}")
    public ResponseEntity<QuotaBalanceDetailsDTO> getQuotaBalanceDetails(@PathVariable Long id) {
        log.debug("REST request to get QuotaBalanceDetails : {}", id);
        Optional<QuotaBalanceDetailsDTO> quotaBalanceDetailsDTO = quotaBalanceDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(quotaBalanceDetailsDTO);
    }

    /**
     * {@code DELETE  /quota-balance-details/:id} : delete the "id" quotaBalanceDetails.
     *
     * @param id the id of the quotaBalanceDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/quota-balance-details/{id}")
    public ResponseEntity<Void> deleteQuotaBalanceDetails(@PathVariable Long id) {
        log.debug("REST request to delete QuotaBalanceDetails : {}", id);
        quotaBalanceDetailsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
