package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.DailyTaskService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.DailyTaskDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.DailyTask}.
 */
@RestController
@RequestMapping("/api")
public class DailyTaskResource {

    private final Logger log = LoggerFactory.getLogger(DailyTaskResource.class);

    private static final String ENTITY_NAME = "dailyTask";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DailyTaskService dailyTaskService;

    public DailyTaskResource(DailyTaskService dailyTaskService) {
        this.dailyTaskService = dailyTaskService;
    }

    /**
     * {@code POST  /daily-tasks} : Create a new dailyTask.
     *
     * @param dailyTaskDTO the dailyTaskDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dailyTaskDTO, or with status {@code 400 (Bad Request)} if the dailyTask has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/daily-tasks")
    public ResponseEntity<DailyTaskDTO> createDailyTask(@Valid @RequestBody DailyTaskDTO dailyTaskDTO) throws URISyntaxException {
        log.debug("REST request to save DailyTask : {}", dailyTaskDTO);
        if (dailyTaskDTO.getId() != null) {
            throw new BadRequestAlertException("A new dailyTask cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DailyTaskDTO result = dailyTaskService.save(dailyTaskDTO);
        return ResponseEntity.created(new URI("/api/daily-tasks/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /daily-tasks} : Updates an existing dailyTask.
     *
     * @param dailyTaskDTO the dailyTaskDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dailyTaskDTO,
     * or with status {@code 400 (Bad Request)} if the dailyTaskDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dailyTaskDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/daily-tasks")
    public ResponseEntity<DailyTaskDTO> updateDailyTask(@Valid @RequestBody DailyTaskDTO dailyTaskDTO) throws URISyntaxException {
        log.debug("REST request to update DailyTask : {}", dailyTaskDTO);
        if (dailyTaskDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DailyTaskDTO result = dailyTaskService.save(dailyTaskDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, dailyTaskDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /daily-tasks} : get all the dailyTasks.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dailyTasks in body.
     */
    @GetMapping("/daily-tasks")
    public ResponseEntity<List<DailyTaskDTO>> getAllDailyTasks(Pageable pageable) {
        log.debug("REST request to get a page of DailyTasks");
        Page<DailyTaskDTO> page = dailyTaskService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /daily-tasks/:id} : get the "id" dailyTask.
     *
     * @param id the id of the dailyTaskDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dailyTaskDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/daily-tasks/{id}")
    public ResponseEntity<DailyTaskDTO> getDailyTask(@PathVariable Long id) {
        log.debug("REST request to get DailyTask : {}", id);
        Optional<DailyTaskDTO> dailyTaskDTO = dailyTaskService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dailyTaskDTO);
    }

    /**
     * {@code DELETE  /daily-tasks/:id} : delete the "id" dailyTask.
     *
     * @param id the id of the dailyTaskDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/daily-tasks/{id}")
    public ResponseEntity<Void> deleteDailyTask(@PathVariable Long id) {
        log.debug("REST request to delete DailyTask : {}", id);
        dailyTaskService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
