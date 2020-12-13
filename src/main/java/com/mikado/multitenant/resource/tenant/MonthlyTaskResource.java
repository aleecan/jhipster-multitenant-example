package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.MonthlyTaskService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.MonthlyTaskDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.MonthlyTask}.
 */
@RestController
@RequestMapping("/api")
public class MonthlyTaskResource {

    private final Logger log = LoggerFactory.getLogger(MonthlyTaskResource.class);

    private static final String ENTITY_NAME = "monthlyTask";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MonthlyTaskService monthlyTaskService;

    public MonthlyTaskResource(MonthlyTaskService monthlyTaskService) {
        this.monthlyTaskService = monthlyTaskService;
    }

    /**
     * {@code POST  /monthly-tasks} : Create a new monthlyTask.
     *
     * @param monthlyTaskDTO the monthlyTaskDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new monthlyTaskDTO, or with status {@code 400 (Bad Request)} if the monthlyTask has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/monthly-tasks")
    public ResponseEntity<MonthlyTaskDTO> createMonthlyTask(@Valid @RequestBody MonthlyTaskDTO monthlyTaskDTO) throws URISyntaxException {
        log.debug("REST request to save MonthlyTask : {}", monthlyTaskDTO);
        if (monthlyTaskDTO.getId() != null) {
            throw new BadRequestAlertException("A new monthlyTask cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MonthlyTaskDTO result = monthlyTaskService.save(monthlyTaskDTO);
        return ResponseEntity.created(new URI("/api/monthly-tasks/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /monthly-tasks} : Updates an existing monthlyTask.
     *
     * @param monthlyTaskDTO the monthlyTaskDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated monthlyTaskDTO,
     * or with status {@code 400 (Bad Request)} if the monthlyTaskDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the monthlyTaskDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/monthly-tasks")
    public ResponseEntity<MonthlyTaskDTO> updateMonthlyTask(@Valid @RequestBody MonthlyTaskDTO monthlyTaskDTO) throws URISyntaxException {
        log.debug("REST request to update MonthlyTask : {}", monthlyTaskDTO);
        if (monthlyTaskDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MonthlyTaskDTO result = monthlyTaskService.save(monthlyTaskDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, monthlyTaskDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /monthly-tasks} : get all the monthlyTasks.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of monthlyTasks in body.
     */
    @GetMapping("/monthly-tasks")
    public ResponseEntity<List<MonthlyTaskDTO>> getAllMonthlyTasks(Pageable pageable) {
        log.debug("REST request to get a page of MonthlyTasks");
        Page<MonthlyTaskDTO> page = monthlyTaskService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /monthly-tasks/:id} : get the "id" monthlyTask.
     *
     * @param id the id of the monthlyTaskDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the monthlyTaskDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/monthly-tasks/{id}")
    public ResponseEntity<MonthlyTaskDTO> getMonthlyTask(@PathVariable Long id) {
        log.debug("REST request to get MonthlyTask : {}", id);
        Optional<MonthlyTaskDTO> monthlyTaskDTO = monthlyTaskService.findOne(id);
        return ResponseUtil.wrapOrNotFound(monthlyTaskDTO);
    }

    /**
     * {@code DELETE  /monthly-tasks/:id} : delete the "id" monthlyTask.
     *
     * @param id the id of the monthlyTaskDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/monthly-tasks/{id}")
    public ResponseEntity<Void> deleteMonthlyTask(@PathVariable Long id) {
        log.debug("REST request to delete MonthlyTask : {}", id);
        monthlyTaskService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
