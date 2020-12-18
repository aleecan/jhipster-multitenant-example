package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.QuotaBalanceService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.QuotaBalanceDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.QuotaBalance}.
 */
@RestController
@RequestMapping("/api")
public class QuotaBalanceResource {

    private final Logger log = LoggerFactory.getLogger(QuotaBalanceResource.class);

    private static final String ENTITY_NAME = "quotaBalance";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final QuotaBalanceService quotaBalanceService;

    public QuotaBalanceResource(QuotaBalanceService quotaBalanceService) {
        this.quotaBalanceService = quotaBalanceService;
    }

    /**
     * {@code POST  /quota-balances} : Create a new quotaBalance.
     *
     * @param quotaBalanceDTO the quotaBalanceDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new quotaBalanceDTO, or with status {@code 400 (Bad Request)} if the quotaBalance has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/quota-balances")
    public ResponseEntity<QuotaBalanceDTO> createQuotaBalance(@Valid @RequestBody QuotaBalanceDTO quotaBalanceDTO) throws URISyntaxException {
        log.debug("REST request to save QuotaBalance : {}", quotaBalanceDTO);
        if (quotaBalanceDTO.getId() != null) {
            throw new BadRequestAlertException("A new quotaBalance cannot already have an ID", ENTITY_NAME, "idexists");
        }
        QuotaBalanceDTO result = quotaBalanceService.save(quotaBalanceDTO);
        return ResponseEntity.created(new URI("/api/quota-balances/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /quota-balances} : Updates an existing quotaBalance.
     *
     * @param quotaBalanceDTO the quotaBalanceDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated quotaBalanceDTO,
     * or with status {@code 400 (Bad Request)} if the quotaBalanceDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the quotaBalanceDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/quota-balances")
    public ResponseEntity<QuotaBalanceDTO> updateQuotaBalance(@Valid @RequestBody QuotaBalanceDTO quotaBalanceDTO) throws URISyntaxException {
        log.debug("REST request to update QuotaBalance : {}", quotaBalanceDTO);
        if (quotaBalanceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        QuotaBalanceDTO result = quotaBalanceService.save(quotaBalanceDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, quotaBalanceDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /quota-balances} : get all the quotaBalances.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of quotaBalances in body.
     */
    @GetMapping("/quota-balances")
    public ResponseEntity<List<QuotaBalanceDTO>> getAllQuotaBalances(Pageable pageable) {
        log.debug("REST request to get a page of QuotaBalances");
        Page<QuotaBalanceDTO> page = quotaBalanceService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /quota-balances/:id} : get the "id" quotaBalance.
     *
     * @param id the id of the quotaBalanceDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the quotaBalanceDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/quota-balances/{id}")
    public ResponseEntity<QuotaBalanceDTO> getQuotaBalance(@PathVariable Long id) {
        log.debug("REST request to get QuotaBalance : {}", id);
        Optional<QuotaBalanceDTO> quotaBalanceDTO = quotaBalanceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(quotaBalanceDTO);
    }

    /**
     * {@code DELETE  /quota-balances/:id} : delete the "id" quotaBalance.
     *
     * @param id the id of the quotaBalanceDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/quota-balances/{id}")
    public ResponseEntity<Void> deleteQuotaBalance(@PathVariable Long id) {
        log.debug("REST request to delete QuotaBalance : {}", id);
        quotaBalanceService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
