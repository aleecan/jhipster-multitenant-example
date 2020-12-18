package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.MonthlyPreviousService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.MonthlyPreviousDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.MonthlyPrevious}.
 */
@RestController
@RequestMapping("/api")
public class MonthlyPreviousResource {

    private final Logger log = LoggerFactory.getLogger(MonthlyPreviousResource.class);

    private static final String ENTITY_NAME = "monthlyPrevious";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MonthlyPreviousService monthlyPreviousService;

    public MonthlyPreviousResource(MonthlyPreviousService monthlyPreviousService) {
        this.monthlyPreviousService = monthlyPreviousService;
    }

    /**
     * {@code POST  /monthly-previous} : Create a new monthlyPrevious.
     *
     * @param monthlyPreviousDTO the monthlyPreviousDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new monthlyPreviousDTO, or with status {@code 400 (Bad Request)} if the monthlyPrevious has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/monthly-previous")
    public ResponseEntity<MonthlyPreviousDTO> createMonthlyPrevious(@Valid @RequestBody MonthlyPreviousDTO monthlyPreviousDTO) throws URISyntaxException {
        log.debug("REST request to save MonthlyPrevious : {}", monthlyPreviousDTO);
        if (monthlyPreviousDTO.getId() != null) {
            throw new BadRequestAlertException("A new monthlyPrevious cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MonthlyPreviousDTO result = monthlyPreviousService.save(monthlyPreviousDTO);
        return ResponseEntity.created(new URI("/api/monthly-previous/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /monthly-previous} : Updates an existing monthlyPrevious.
     *
     * @param monthlyPreviousDTO the monthlyPreviousDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated monthlyPreviousDTO,
     * or with status {@code 400 (Bad Request)} if the monthlyPreviousDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the monthlyPreviousDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/monthly-previous")
    public ResponseEntity<MonthlyPreviousDTO> updateMonthlyPrevious(@Valid @RequestBody MonthlyPreviousDTO monthlyPreviousDTO) throws URISyntaxException {
        log.debug("REST request to update MonthlyPrevious : {}", monthlyPreviousDTO);
        if (monthlyPreviousDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MonthlyPreviousDTO result = monthlyPreviousService.save(monthlyPreviousDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, monthlyPreviousDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /monthly-previous} : get all the monthlyPrevious.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of monthlyPrevious in body.
     */
    @GetMapping("/monthly-previous")
    public ResponseEntity<List<MonthlyPreviousDTO>> getAllMonthlyPrevious(Pageable pageable) {
        log.debug("REST request to get a page of MonthlyPrevious");
        Page<MonthlyPreviousDTO> page = monthlyPreviousService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /monthly-previous/:id} : get the "id" monthlyPrevious.
     *
     * @param id the id of the monthlyPreviousDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the monthlyPreviousDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/monthly-previous/{id}")
    public ResponseEntity<MonthlyPreviousDTO> getMonthlyPrevious(@PathVariable Long id) {
        log.debug("REST request to get MonthlyPrevious : {}", id);
        Optional<MonthlyPreviousDTO> monthlyPreviousDTO = monthlyPreviousService.findOne(id);
        return ResponseUtil.wrapOrNotFound(monthlyPreviousDTO);
    }

    /**
     * {@code DELETE  /monthly-previous/:id} : delete the "id" monthlyPrevious.
     *
     * @param id the id of the monthlyPreviousDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/monthly-previous/{id}")
    public ResponseEntity<Void> deleteMonthlyPrevious(@PathVariable Long id) {
        log.debug("REST request to delete MonthlyPrevious : {}", id);
        monthlyPreviousService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
