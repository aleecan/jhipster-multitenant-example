package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.WeeklyTaskService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.WeeklyTaskDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.WeeklyTask}.
 */
@RestController
@RequestMapping("/api")
public class WeeklyTaskResource {

    private final Logger log = LoggerFactory.getLogger(WeeklyTaskResource.class);

    private static final String ENTITY_NAME = "weeklyTask";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final WeeklyTaskService weeklyTaskService;

    public WeeklyTaskResource(WeeklyTaskService weeklyTaskService) {
        this.weeklyTaskService = weeklyTaskService;
    }

    /**
     * {@code POST  /weekly-tasks} : Create a new weeklyTask.
     *
     * @param weeklyTaskDTO the weeklyTaskDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new weeklyTaskDTO, or with status {@code 400 (Bad Request)} if the weeklyTask has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/weekly-tasks")
    public ResponseEntity<WeeklyTaskDTO> createWeeklyTask(@Valid @RequestBody WeeklyTaskDTO weeklyTaskDTO) throws URISyntaxException {
        log.debug("REST request to save WeeklyTask : {}", weeklyTaskDTO);
        if (weeklyTaskDTO.getId() != null) {
            throw new BadRequestAlertException("A new weeklyTask cannot already have an ID", ENTITY_NAME, "idexists");
        }
        WeeklyTaskDTO result = weeklyTaskService.save(weeklyTaskDTO);
        return ResponseEntity.created(new URI("/api/weekly-tasks/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /weekly-tasks} : Updates an existing weeklyTask.
     *
     * @param weeklyTaskDTO the weeklyTaskDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated weeklyTaskDTO,
     * or with status {@code 400 (Bad Request)} if the weeklyTaskDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the weeklyTaskDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/weekly-tasks")
    public ResponseEntity<WeeklyTaskDTO> updateWeeklyTask(@Valid @RequestBody WeeklyTaskDTO weeklyTaskDTO) throws URISyntaxException {
        log.debug("REST request to update WeeklyTask : {}", weeklyTaskDTO);
        if (weeklyTaskDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        WeeklyTaskDTO result = weeklyTaskService.save(weeklyTaskDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, weeklyTaskDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /weekly-tasks} : get all the weeklyTasks.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of weeklyTasks in body.
     */
    @GetMapping("/weekly-tasks")
    public ResponseEntity<List<WeeklyTaskDTO>> getAllWeeklyTasks(Pageable pageable) {
        log.debug("REST request to get a page of WeeklyTasks");
        Page<WeeklyTaskDTO> page = weeklyTaskService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /weekly-tasks/:id} : get the "id" weeklyTask.
     *
     * @param id the id of the weeklyTaskDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the weeklyTaskDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/weekly-tasks/{id}")
    public ResponseEntity<WeeklyTaskDTO> getWeeklyTask(@PathVariable Long id) {
        log.debug("REST request to get WeeklyTask : {}", id);
        Optional<WeeklyTaskDTO> weeklyTaskDTO = weeklyTaskService.findOne(id);
        return ResponseUtil.wrapOrNotFound(weeklyTaskDTO);
    }

    /**
     * {@code DELETE  /weekly-tasks/:id} : delete the "id" weeklyTask.
     *
     * @param id the id of the weeklyTaskDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/weekly-tasks/{id}")
    public ResponseEntity<Void> deleteWeeklyTask(@PathVariable Long id) {
        log.debug("REST request to delete WeeklyTask : {}", id);
        weeklyTaskService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
