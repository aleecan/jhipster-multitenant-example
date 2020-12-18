package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.MonthlyLineService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.MonthlyLineDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.MonthlyLine}.
 */
@RestController
@RequestMapping("/api")
public class MonthlyLineResource {

    private final Logger log = LoggerFactory.getLogger(MonthlyLineResource.class);

    private static final String ENTITY_NAME = "monthlyLine";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MonthlyLineService monthlyLineService;

    public MonthlyLineResource(MonthlyLineService monthlyLineService) {
        this.monthlyLineService = monthlyLineService;
    }

    /**
     * {@code POST  /monthly-lines} : Create a new monthlyLine.
     *
     * @param monthlyLineDTO the monthlyLineDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new monthlyLineDTO, or with status {@code 400 (Bad Request)} if the monthlyLine has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/monthly-lines")
    public ResponseEntity<MonthlyLineDTO> createMonthlyLine(@Valid @RequestBody MonthlyLineDTO monthlyLineDTO) throws URISyntaxException {
        log.debug("REST request to save MonthlyLine : {}", monthlyLineDTO);
        if (monthlyLineDTO.getId() != null) {
            throw new BadRequestAlertException("A new monthlyLine cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MonthlyLineDTO result = monthlyLineService.save(monthlyLineDTO);
        return ResponseEntity.created(new URI("/api/monthly-lines/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /monthly-lines} : Updates an existing monthlyLine.
     *
     * @param monthlyLineDTO the monthlyLineDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated monthlyLineDTO,
     * or with status {@code 400 (Bad Request)} if the monthlyLineDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the monthlyLineDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/monthly-lines")
    public ResponseEntity<MonthlyLineDTO> updateMonthlyLine(@Valid @RequestBody MonthlyLineDTO monthlyLineDTO) throws URISyntaxException {
        log.debug("REST request to update MonthlyLine : {}", monthlyLineDTO);
        if (monthlyLineDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MonthlyLineDTO result = monthlyLineService.save(monthlyLineDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, monthlyLineDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /monthly-lines} : get all the monthlyLines.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of monthlyLines in body.
     */
    @GetMapping("/monthly-lines")
    public ResponseEntity<List<MonthlyLineDTO>> getAllMonthlyLines(Pageable pageable) {
        log.debug("REST request to get a page of MonthlyLines");
        Page<MonthlyLineDTO> page = monthlyLineService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /monthly-lines/:id} : get the "id" monthlyLine.
     *
     * @param id the id of the monthlyLineDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the monthlyLineDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/monthly-lines/{id}")
    public ResponseEntity<MonthlyLineDTO> getMonthlyLine(@PathVariable Long id) {
        log.debug("REST request to get MonthlyLine : {}", id);
        Optional<MonthlyLineDTO> monthlyLineDTO = monthlyLineService.findOne(id);
        return ResponseUtil.wrapOrNotFound(monthlyLineDTO);
    }

    /**
     * {@code DELETE  /monthly-lines/:id} : delete the "id" monthlyLine.
     *
     * @param id the id of the monthlyLineDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/monthly-lines/{id}")
    public ResponseEntity<Void> deleteMonthlyLine(@PathVariable Long id) {
        log.debug("REST request to delete MonthlyLine : {}", id);
        monthlyLineService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
