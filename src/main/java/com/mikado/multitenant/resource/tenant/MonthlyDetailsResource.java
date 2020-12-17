package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.MonthlyDetailsService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.MonthlyDetailsDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.MonthlyDetails}.
 */
@RestController
@RequestMapping("/api")
public class MonthlyDetailsResource {

    private final Logger log = LoggerFactory.getLogger(MonthlyDetailsResource.class);

    private static final String ENTITY_NAME = "monthlyDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MonthlyDetailsService monthlyDetailsService;

    public MonthlyDetailsResource(MonthlyDetailsService monthlyDetailsService) {
        this.monthlyDetailsService = monthlyDetailsService;
    }

    /**
     * {@code POST  /monthly-details} : Create a new monthlyDetails.
     *
     * @param monthlyDetailsDTO the monthlyDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new monthlyDetailsDTO, or with status {@code 400 (Bad Request)} if the monthlyDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/monthly-details")
    public ResponseEntity<MonthlyDetailsDTO> createMonthlyDetails(@Valid @RequestBody MonthlyDetailsDTO monthlyDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save MonthlyDetails : {}", monthlyDetailsDTO);
        if (monthlyDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new monthlyDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MonthlyDetailsDTO result = monthlyDetailsService.save(monthlyDetailsDTO);
        return ResponseEntity.created(new URI("/api/monthly-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /monthly-details} : Updates an existing monthlyDetails.
     *
     * @param monthlyDetailsDTO the monthlyDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated monthlyDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the monthlyDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the monthlyDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/monthly-details")
    public ResponseEntity<MonthlyDetailsDTO> updateMonthlyDetails(@Valid @RequestBody MonthlyDetailsDTO monthlyDetailsDTO) throws URISyntaxException {
        log.debug("REST request to update MonthlyDetails : {}", monthlyDetailsDTO);
        if (monthlyDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MonthlyDetailsDTO result = monthlyDetailsService.save(monthlyDetailsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, monthlyDetailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /monthly-details} : get all the monthlyDetails.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of monthlyDetails in body.
     */
    @GetMapping("/monthly-details")
    public ResponseEntity<List<MonthlyDetailsDTO>> getAllMonthlyDetails(Pageable pageable) {
        log.debug("REST request to get a page of MonthlyDetails");
        Page<MonthlyDetailsDTO> page = monthlyDetailsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /monthly-details/:id} : get the "id" monthlyDetails.
     *
     * @param id the id of the monthlyDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the monthlyDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/monthly-details/{id}")
    public ResponseEntity<MonthlyDetailsDTO> getMonthlyDetails(@PathVariable Long id) {
        log.debug("REST request to get MonthlyDetails : {}", id);
        Optional<MonthlyDetailsDTO> monthlyDetailsDTO = monthlyDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(monthlyDetailsDTO);
    }

    /**
     * {@code DELETE  /monthly-details/:id} : delete the "id" monthlyDetails.
     *
     * @param id the id of the monthlyDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/monthly-details/{id}")
    public ResponseEntity<Void> deleteMonthlyDetails(@PathVariable Long id) {
        log.debug("REST request to delete MonthlyDetails : {}", id);
        monthlyDetailsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
