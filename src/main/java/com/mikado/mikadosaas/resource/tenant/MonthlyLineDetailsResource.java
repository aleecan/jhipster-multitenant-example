package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.MonthlyLineDetailsService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.MonthlyLineDetailsDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.MonthlyLineDetails}.
 */
@RestController
@RequestMapping("/api")
public class MonthlyLineDetailsResource {

    private final Logger log = LoggerFactory.getLogger(MonthlyLineDetailsResource.class);

    private static final String ENTITY_NAME = "monthlyLineDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MonthlyLineDetailsService monthlyLineDetailsService;

    public MonthlyLineDetailsResource(MonthlyLineDetailsService monthlyLineDetailsService) {
        this.monthlyLineDetailsService = monthlyLineDetailsService;
    }

    /**
     * {@code POST  /monthly-line-details} : Create a new monthlyLineDetails.
     *
     * @param monthlyLineDetailsDTO the monthlyLineDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new monthlyLineDetailsDTO, or with status {@code 400 (Bad Request)} if the monthlyLineDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/monthly-line-details")
    public ResponseEntity<MonthlyLineDetailsDTO> createMonthlyLineDetails(@Valid @RequestBody MonthlyLineDetailsDTO monthlyLineDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save MonthlyLineDetails : {}", monthlyLineDetailsDTO);
        if (monthlyLineDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new monthlyLineDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MonthlyLineDetailsDTO result = monthlyLineDetailsService.save(monthlyLineDetailsDTO);
        return ResponseEntity.created(new URI("/api/monthly-line-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /monthly-line-details} : Updates an existing monthlyLineDetails.
     *
     * @param monthlyLineDetailsDTO the monthlyLineDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated monthlyLineDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the monthlyLineDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the monthlyLineDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/monthly-line-details")
    public ResponseEntity<MonthlyLineDetailsDTO> updateMonthlyLineDetails(@Valid @RequestBody MonthlyLineDetailsDTO monthlyLineDetailsDTO) throws URISyntaxException {
        log.debug("REST request to update MonthlyLineDetails : {}", monthlyLineDetailsDTO);
        if (monthlyLineDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MonthlyLineDetailsDTO result = monthlyLineDetailsService.save(monthlyLineDetailsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, monthlyLineDetailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /monthly-line-details} : get all the monthlyLineDetails.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of monthlyLineDetails in body.
     */
    @GetMapping("/monthly-line-details")
    public ResponseEntity<List<MonthlyLineDetailsDTO>> getAllMonthlyLineDetails(Pageable pageable) {
        log.debug("REST request to get a page of MonthlyLineDetails");
        Page<MonthlyLineDetailsDTO> page = monthlyLineDetailsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /monthly-line-details/:id} : get the "id" monthlyLineDetails.
     *
     * @param id the id of the monthlyLineDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the monthlyLineDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/monthly-line-details/{id}")
    public ResponseEntity<MonthlyLineDetailsDTO> getMonthlyLineDetails(@PathVariable Long id) {
        log.debug("REST request to get MonthlyLineDetails : {}", id);
        Optional<MonthlyLineDetailsDTO> monthlyLineDetailsDTO = monthlyLineDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(monthlyLineDetailsDTO);
    }

    /**
     * {@code DELETE  /monthly-line-details/:id} : delete the "id" monthlyLineDetails.
     *
     * @param id the id of the monthlyLineDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/monthly-line-details/{id}")
    public ResponseEntity<Void> deleteMonthlyLineDetails(@PathVariable Long id) {
        log.debug("REST request to delete MonthlyLineDetails : {}", id);
        monthlyLineDetailsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
