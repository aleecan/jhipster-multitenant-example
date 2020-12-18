package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.MonthlyPreviousDetailsService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.MonthlyPreviousDetailsDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.MonthlyPreviousDetails}.
 */
@RestController
@RequestMapping("/api")
public class MonthlyPreviousDetailsResource {

    private final Logger log = LoggerFactory.getLogger(MonthlyPreviousDetailsResource.class);

    private static final String ENTITY_NAME = "monthlyPreviousDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MonthlyPreviousDetailsService monthlyPreviousDetailsService;

    public MonthlyPreviousDetailsResource(MonthlyPreviousDetailsService monthlyPreviousDetailsService) {
        this.monthlyPreviousDetailsService = monthlyPreviousDetailsService;
    }

    /**
     * {@code POST  /monthly-previous-details} : Create a new monthlyPreviousDetails.
     *
     * @param monthlyPreviousDetailsDTO the monthlyPreviousDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new monthlyPreviousDetailsDTO, or with status {@code 400 (Bad Request)} if the monthlyPreviousDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/monthly-previous-details")
    public ResponseEntity<MonthlyPreviousDetailsDTO> createMonthlyPreviousDetails(@Valid @RequestBody MonthlyPreviousDetailsDTO monthlyPreviousDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save MonthlyPreviousDetails : {}", monthlyPreviousDetailsDTO);
        if (monthlyPreviousDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new monthlyPreviousDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MonthlyPreviousDetailsDTO result = monthlyPreviousDetailsService.save(monthlyPreviousDetailsDTO);
        return ResponseEntity.created(new URI("/api/monthly-previous-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /monthly-previous-details} : Updates an existing monthlyPreviousDetails.
     *
     * @param monthlyPreviousDetailsDTO the monthlyPreviousDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated monthlyPreviousDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the monthlyPreviousDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the monthlyPreviousDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/monthly-previous-details")
    public ResponseEntity<MonthlyPreviousDetailsDTO> updateMonthlyPreviousDetails(@Valid @RequestBody MonthlyPreviousDetailsDTO monthlyPreviousDetailsDTO) throws URISyntaxException {
        log.debug("REST request to update MonthlyPreviousDetails : {}", monthlyPreviousDetailsDTO);
        if (monthlyPreviousDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MonthlyPreviousDetailsDTO result = monthlyPreviousDetailsService.save(monthlyPreviousDetailsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, monthlyPreviousDetailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /monthly-previous-details} : get all the monthlyPreviousDetails.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of monthlyPreviousDetails in body.
     */
    @GetMapping("/monthly-previous-details")
    public ResponseEntity<List<MonthlyPreviousDetailsDTO>> getAllMonthlyPreviousDetails(Pageable pageable) {
        log.debug("REST request to get a page of MonthlyPreviousDetails");
        Page<MonthlyPreviousDetailsDTO> page = monthlyPreviousDetailsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /monthly-previous-details/:id} : get the "id" monthlyPreviousDetails.
     *
     * @param id the id of the monthlyPreviousDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the monthlyPreviousDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/monthly-previous-details/{id}")
    public ResponseEntity<MonthlyPreviousDetailsDTO> getMonthlyPreviousDetails(@PathVariable Long id) {
        log.debug("REST request to get MonthlyPreviousDetails : {}", id);
        Optional<MonthlyPreviousDetailsDTO> monthlyPreviousDetailsDTO = monthlyPreviousDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(monthlyPreviousDetailsDTO);
    }

    /**
     * {@code DELETE  /monthly-previous-details/:id} : delete the "id" monthlyPreviousDetails.
     *
     * @param id the id of the monthlyPreviousDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/monthly-previous-details/{id}")
    public ResponseEntity<Void> deleteMonthlyPreviousDetails(@PathVariable Long id) {
        log.debug("REST request to delete MonthlyPreviousDetails : {}", id);
        monthlyPreviousDetailsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
