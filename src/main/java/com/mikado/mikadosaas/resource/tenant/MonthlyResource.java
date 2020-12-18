package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.MonthlyService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.MonthlyDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.Monthly}.
 */
@RestController
@RequestMapping("/api")
public class MonthlyResource {

    private final Logger log = LoggerFactory.getLogger(MonthlyResource.class);

    private static final String ENTITY_NAME = "monthly";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MonthlyService monthlyService;

    public MonthlyResource(MonthlyService monthlyService) {
        this.monthlyService = monthlyService;
    }

    /**
     * {@code POST  /monthlies} : Create a new monthly.
     *
     * @param monthlyDTO the monthlyDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new monthlyDTO, or with status {@code 400 (Bad Request)} if the monthly has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/monthlies")
    public ResponseEntity<MonthlyDTO> createMonthly(@Valid @RequestBody MonthlyDTO monthlyDTO) throws URISyntaxException {
        log.debug("REST request to save Monthly : {}", monthlyDTO);
        if (monthlyDTO.getId() != null) {
            throw new BadRequestAlertException("A new monthly cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MonthlyDTO result = monthlyService.save(monthlyDTO);
        return ResponseEntity.created(new URI("/api/monthlies/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /monthlies} : Updates an existing monthly.
     *
     * @param monthlyDTO the monthlyDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated monthlyDTO,
     * or with status {@code 400 (Bad Request)} if the monthlyDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the monthlyDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/monthlies")
    public ResponseEntity<MonthlyDTO> updateMonthly(@Valid @RequestBody MonthlyDTO monthlyDTO) throws URISyntaxException {
        log.debug("REST request to update Monthly : {}", monthlyDTO);
        if (monthlyDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MonthlyDTO result = monthlyService.save(monthlyDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, monthlyDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /monthlies} : get all the monthlies.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of monthlies in body.
     */
    @GetMapping("/monthlies")
    public ResponseEntity<List<MonthlyDTO>> getAllMonthlies(Pageable pageable) {
        log.debug("REST request to get a page of Monthlies");
        Page<MonthlyDTO> page = monthlyService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /monthlies/:id} : get the "id" monthly.
     *
     * @param id the id of the monthlyDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the monthlyDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/monthlies/{id}")
    public ResponseEntity<MonthlyDTO> getMonthly(@PathVariable Long id) {
        log.debug("REST request to get Monthly : {}", id);
        Optional<MonthlyDTO> monthlyDTO = monthlyService.findOne(id);
        return ResponseUtil.wrapOrNotFound(monthlyDTO);
    }

    /**
     * {@code DELETE  /monthlies/:id} : delete the "id" monthly.
     *
     * @param id the id of the monthlyDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/monthlies/{id}")
    public ResponseEntity<Void> deleteMonthly(@PathVariable Long id) {
        log.debug("REST request to delete Monthly : {}", id);
        monthlyService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
