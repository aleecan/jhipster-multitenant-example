package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.WeeklyDetailsService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.WeeklyDetailsDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.WeeklyDetails}.
 */
@RestController
@RequestMapping("/api")
public class WeeklyDetailsResource {

    private final Logger log = LoggerFactory.getLogger(WeeklyDetailsResource.class);

    private static final String ENTITY_NAME = "weeklyDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final WeeklyDetailsService weeklyDetailsService;

    public WeeklyDetailsResource(WeeklyDetailsService weeklyDetailsService) {
        this.weeklyDetailsService = weeklyDetailsService;
    }

    /**
     * {@code POST  /weekly-details} : Create a new weeklyDetails.
     *
     * @param weeklyDetailsDTO the weeklyDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new weeklyDetailsDTO, or with status {@code 400 (Bad Request)} if the weeklyDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/weekly-details")
    public ResponseEntity<WeeklyDetailsDTO> createWeeklyDetails(@Valid @RequestBody WeeklyDetailsDTO weeklyDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save WeeklyDetails : {}", weeklyDetailsDTO);
        if (weeklyDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new weeklyDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        WeeklyDetailsDTO result = weeklyDetailsService.save(weeklyDetailsDTO);
        return ResponseEntity.created(new URI("/api/weekly-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /weekly-details} : Updates an existing weeklyDetails.
     *
     * @param weeklyDetailsDTO the weeklyDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated weeklyDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the weeklyDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the weeklyDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/weekly-details")
    public ResponseEntity<WeeklyDetailsDTO> updateWeeklyDetails(@Valid @RequestBody WeeklyDetailsDTO weeklyDetailsDTO) throws URISyntaxException {
        log.debug("REST request to update WeeklyDetails : {}", weeklyDetailsDTO);
        if (weeklyDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        WeeklyDetailsDTO result = weeklyDetailsService.save(weeklyDetailsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, weeklyDetailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /weekly-details} : get all the weeklyDetails.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of weeklyDetails in body.
     */
    @GetMapping("/weekly-details")
    public ResponseEntity<List<WeeklyDetailsDTO>> getAllWeeklyDetails(Pageable pageable) {
        log.debug("REST request to get a page of WeeklyDetails");
        Page<WeeklyDetailsDTO> page = weeklyDetailsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /weekly-details/:id} : get the "id" weeklyDetails.
     *
     * @param id the id of the weeklyDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the weeklyDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/weekly-details/{id}")
    public ResponseEntity<WeeklyDetailsDTO> getWeeklyDetails(@PathVariable Long id) {
        log.debug("REST request to get WeeklyDetails : {}", id);
        Optional<WeeklyDetailsDTO> weeklyDetailsDTO = weeklyDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(weeklyDetailsDTO);
    }

    /**
     * {@code DELETE  /weekly-details/:id} : delete the "id" weeklyDetails.
     *
     * @param id the id of the weeklyDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/weekly-details/{id}")
    public ResponseEntity<Void> deleteWeeklyDetails(@PathVariable Long id) {
        log.debug("REST request to delete WeeklyDetails : {}", id);
        weeklyDetailsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
