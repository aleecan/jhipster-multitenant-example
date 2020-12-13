package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.WeeklyWorkService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.WeeklyWorkDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.WeeklyWork}.
 */
@RestController
@RequestMapping("/api")
public class WeeklyWorkResource {

    private final Logger log = LoggerFactory.getLogger(WeeklyWorkResource.class);

    private static final String ENTITY_NAME = "weeklyWork";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final WeeklyWorkService weeklyWorkService;

    public WeeklyWorkResource(WeeklyWorkService weeklyWorkService) {
        this.weeklyWorkService = weeklyWorkService;
    }

    /**
     * {@code POST  /weekly-works} : Create a new weeklyWork.
     *
     * @param weeklyWorkDTO the weeklyWorkDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new weeklyWorkDTO, or with status {@code 400 (Bad Request)} if the weeklyWork has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/weekly-works")
    public ResponseEntity<WeeklyWorkDTO> createWeeklyWork(@Valid @RequestBody WeeklyWorkDTO weeklyWorkDTO) throws URISyntaxException {
        log.debug("REST request to save WeeklyWork : {}", weeklyWorkDTO);
        if (weeklyWorkDTO.getId() != null) {
            throw new BadRequestAlertException("A new weeklyWork cannot already have an ID", ENTITY_NAME, "idexists");
        }
        WeeklyWorkDTO result = weeklyWorkService.save(weeklyWorkDTO);
        return ResponseEntity.created(new URI("/api/weekly-works/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /weekly-works} : Updates an existing weeklyWork.
     *
     * @param weeklyWorkDTO the weeklyWorkDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated weeklyWorkDTO,
     * or with status {@code 400 (Bad Request)} if the weeklyWorkDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the weeklyWorkDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/weekly-works")
    public ResponseEntity<WeeklyWorkDTO> updateWeeklyWork(@Valid @RequestBody WeeklyWorkDTO weeklyWorkDTO) throws URISyntaxException {
        log.debug("REST request to update WeeklyWork : {}", weeklyWorkDTO);
        if (weeklyWorkDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        WeeklyWorkDTO result = weeklyWorkService.save(weeklyWorkDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, weeklyWorkDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /weekly-works} : get all the weeklyWorks.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of weeklyWorks in body.
     */
    @GetMapping("/weekly-works")
    public ResponseEntity<List<WeeklyWorkDTO>> getAllWeeklyWorks(Pageable pageable) {
        log.debug("REST request to get a page of WeeklyWorks");
        Page<WeeklyWorkDTO> page = weeklyWorkService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /weekly-works/:id} : get the "id" weeklyWork.
     *
     * @param id the id of the weeklyWorkDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the weeklyWorkDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/weekly-works/{id}")
    public ResponseEntity<WeeklyWorkDTO> getWeeklyWork(@PathVariable Long id) {
        log.debug("REST request to get WeeklyWork : {}", id);
        Optional<WeeklyWorkDTO> weeklyWorkDTO = weeklyWorkService.findOne(id);
        return ResponseUtil.wrapOrNotFound(weeklyWorkDTO);
    }

    /**
     * {@code DELETE  /weekly-works/:id} : delete the "id" weeklyWork.
     *
     * @param id the id of the weeklyWorkDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/weekly-works/{id}")
    public ResponseEntity<Void> deleteWeeklyWork(@PathVariable Long id) {
        log.debug("REST request to delete WeeklyWork : {}", id);
        weeklyWorkService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
