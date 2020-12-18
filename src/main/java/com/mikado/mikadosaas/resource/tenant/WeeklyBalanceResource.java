package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.WeeklyBalanceService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.WeeklyBalanceDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.WeeklyBalance}.
 */
@RestController
@RequestMapping("/api")
public class WeeklyBalanceResource {

    private final Logger log = LoggerFactory.getLogger(WeeklyBalanceResource.class);

    private static final String ENTITY_NAME = "weeklyBalance";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final WeeklyBalanceService weeklyBalanceService;

    public WeeklyBalanceResource(WeeklyBalanceService weeklyBalanceService) {
        this.weeklyBalanceService = weeklyBalanceService;
    }

    /**
     * {@code POST  /weekly-balances} : Create a new weeklyBalance.
     *
     * @param weeklyBalanceDTO the weeklyBalanceDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new weeklyBalanceDTO, or with status {@code 400 (Bad Request)} if the weeklyBalance has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/weekly-balances")
    public ResponseEntity<WeeklyBalanceDTO> createWeeklyBalance(@Valid @RequestBody WeeklyBalanceDTO weeklyBalanceDTO) throws URISyntaxException {
        log.debug("REST request to save WeeklyBalance : {}", weeklyBalanceDTO);
        if (weeklyBalanceDTO.getId() != null) {
            throw new BadRequestAlertException("A new weeklyBalance cannot already have an ID", ENTITY_NAME, "idexists");
        }
        WeeklyBalanceDTO result = weeklyBalanceService.save(weeklyBalanceDTO);
        return ResponseEntity.created(new URI("/api/weekly-balances/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /weekly-balances} : Updates an existing weeklyBalance.
     *
     * @param weeklyBalanceDTO the weeklyBalanceDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated weeklyBalanceDTO,
     * or with status {@code 400 (Bad Request)} if the weeklyBalanceDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the weeklyBalanceDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/weekly-balances")
    public ResponseEntity<WeeklyBalanceDTO> updateWeeklyBalance(@Valid @RequestBody WeeklyBalanceDTO weeklyBalanceDTO) throws URISyntaxException {
        log.debug("REST request to update WeeklyBalance : {}", weeklyBalanceDTO);
        if (weeklyBalanceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        WeeklyBalanceDTO result = weeklyBalanceService.save(weeklyBalanceDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, weeklyBalanceDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /weekly-balances} : get all the weeklyBalances.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of weeklyBalances in body.
     */
    @GetMapping("/weekly-balances")
    public ResponseEntity<List<WeeklyBalanceDTO>> getAllWeeklyBalances(Pageable pageable) {
        log.debug("REST request to get a page of WeeklyBalances");
        Page<WeeklyBalanceDTO> page = weeklyBalanceService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /weekly-balances/:id} : get the "id" weeklyBalance.
     *
     * @param id the id of the weeklyBalanceDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the weeklyBalanceDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/weekly-balances/{id}")
    public ResponseEntity<WeeklyBalanceDTO> getWeeklyBalance(@PathVariable Long id) {
        log.debug("REST request to get WeeklyBalance : {}", id);
        Optional<WeeklyBalanceDTO> weeklyBalanceDTO = weeklyBalanceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(weeklyBalanceDTO);
    }

    /**
     * {@code DELETE  /weekly-balances/:id} : delete the "id" weeklyBalance.
     *
     * @param id the id of the weeklyBalanceDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/weekly-balances/{id}")
    public ResponseEntity<Void> deleteWeeklyBalance(@PathVariable Long id) {
        log.debug("REST request to delete WeeklyBalance : {}", id);
        weeklyBalanceService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
