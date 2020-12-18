package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.WeeklyBalanceDetailsService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.WeeklyBalanceDetailsDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.WeeklyBalanceDetails}.
 */
@RestController
@RequestMapping("/api")
public class WeeklyBalanceDetailsResource {

    private final Logger log = LoggerFactory.getLogger(WeeklyBalanceDetailsResource.class);

    private static final String ENTITY_NAME = "weeklyBalanceDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final WeeklyBalanceDetailsService weeklyBalanceDetailsService;

    public WeeklyBalanceDetailsResource(WeeklyBalanceDetailsService weeklyBalanceDetailsService) {
        this.weeklyBalanceDetailsService = weeklyBalanceDetailsService;
    }

    /**
     * {@code POST  /weekly-balance-details} : Create a new weeklyBalanceDetails.
     *
     * @param weeklyBalanceDetailsDTO the weeklyBalanceDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new weeklyBalanceDetailsDTO, or with status {@code 400 (Bad Request)} if the weeklyBalanceDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/weekly-balance-details")
    public ResponseEntity<WeeklyBalanceDetailsDTO> createWeeklyBalanceDetails(@Valid @RequestBody WeeklyBalanceDetailsDTO weeklyBalanceDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save WeeklyBalanceDetails : {}", weeklyBalanceDetailsDTO);
        if (weeklyBalanceDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new weeklyBalanceDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        WeeklyBalanceDetailsDTO result = weeklyBalanceDetailsService.save(weeklyBalanceDetailsDTO);
        return ResponseEntity.created(new URI("/api/weekly-balance-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /weekly-balance-details} : Updates an existing weeklyBalanceDetails.
     *
     * @param weeklyBalanceDetailsDTO the weeklyBalanceDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated weeklyBalanceDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the weeklyBalanceDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the weeklyBalanceDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/weekly-balance-details")
    public ResponseEntity<WeeklyBalanceDetailsDTO> updateWeeklyBalanceDetails(@Valid @RequestBody WeeklyBalanceDetailsDTO weeklyBalanceDetailsDTO) throws URISyntaxException {
        log.debug("REST request to update WeeklyBalanceDetails : {}", weeklyBalanceDetailsDTO);
        if (weeklyBalanceDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        WeeklyBalanceDetailsDTO result = weeklyBalanceDetailsService.save(weeklyBalanceDetailsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, weeklyBalanceDetailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /weekly-balance-details} : get all the weeklyBalanceDetails.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of weeklyBalanceDetails in body.
     */
    @GetMapping("/weekly-balance-details")
    public ResponseEntity<List<WeeklyBalanceDetailsDTO>> getAllWeeklyBalanceDetails(Pageable pageable) {
        log.debug("REST request to get a page of WeeklyBalanceDetails");
        Page<WeeklyBalanceDetailsDTO> page = weeklyBalanceDetailsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /weekly-balance-details/:id} : get the "id" weeklyBalanceDetails.
     *
     * @param id the id of the weeklyBalanceDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the weeklyBalanceDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/weekly-balance-details/{id}")
    public ResponseEntity<WeeklyBalanceDetailsDTO> getWeeklyBalanceDetails(@PathVariable Long id) {
        log.debug("REST request to get WeeklyBalanceDetails : {}", id);
        Optional<WeeklyBalanceDetailsDTO> weeklyBalanceDetailsDTO = weeklyBalanceDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(weeklyBalanceDetailsDTO);
    }

    /**
     * {@code DELETE  /weekly-balance-details/:id} : delete the "id" weeklyBalanceDetails.
     *
     * @param id the id of the weeklyBalanceDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/weekly-balance-details/{id}")
    public ResponseEntity<Void> deleteWeeklyBalanceDetails(@PathVariable Long id) {
        log.debug("REST request to delete WeeklyBalanceDetails : {}", id);
        weeklyBalanceDetailsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
