package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.JobSchedulerDayService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.JobSchedulerDayDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.JobSchedulerDay}.
 */
@RestController
@RequestMapping("/api")
public class JobSchedulerDayResource {

    private final Logger log = LoggerFactory.getLogger(JobSchedulerDayResource.class);

    private static final String ENTITY_NAME = "jobSchedulerDay";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final JobSchedulerDayService jobSchedulerDayService;

    public JobSchedulerDayResource(JobSchedulerDayService jobSchedulerDayService) {
        this.jobSchedulerDayService = jobSchedulerDayService;
    }

    /**
     * {@code POST  /job-scheduler-days} : Create a new jobSchedulerDay.
     *
     * @param jobSchedulerDayDTO the jobSchedulerDayDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new jobSchedulerDayDTO, or with status {@code 400 (Bad Request)} if the jobSchedulerDay has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/job-scheduler-days")
    public ResponseEntity<JobSchedulerDayDTO> createJobSchedulerDay(@Valid @RequestBody JobSchedulerDayDTO jobSchedulerDayDTO) throws URISyntaxException {
        log.debug("REST request to save JobSchedulerDay : {}", jobSchedulerDayDTO);
        if (jobSchedulerDayDTO.getId() != null) {
            throw new BadRequestAlertException("A new jobSchedulerDay cannot already have an ID", ENTITY_NAME, "idexists");
        }
        JobSchedulerDayDTO result = jobSchedulerDayService.save(jobSchedulerDayDTO);
        return ResponseEntity.created(new URI("/api/job-scheduler-days/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /job-scheduler-days} : Updates an existing jobSchedulerDay.
     *
     * @param jobSchedulerDayDTO the jobSchedulerDayDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated jobSchedulerDayDTO,
     * or with status {@code 400 (Bad Request)} if the jobSchedulerDayDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the jobSchedulerDayDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/job-scheduler-days")
    public ResponseEntity<JobSchedulerDayDTO> updateJobSchedulerDay(@Valid @RequestBody JobSchedulerDayDTO jobSchedulerDayDTO) throws URISyntaxException {
        log.debug("REST request to update JobSchedulerDay : {}", jobSchedulerDayDTO);
        if (jobSchedulerDayDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        JobSchedulerDayDTO result = jobSchedulerDayService.save(jobSchedulerDayDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, jobSchedulerDayDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /job-scheduler-days} : get all the jobSchedulerDays.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of jobSchedulerDays in body.
     */
    @GetMapping("/job-scheduler-days")
    public ResponseEntity<List<JobSchedulerDayDTO>> getAllJobSchedulerDays(Pageable pageable) {
        log.debug("REST request to get a page of JobSchedulerDays");
        Page<JobSchedulerDayDTO> page = jobSchedulerDayService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /job-scheduler-days/:id} : get the "id" jobSchedulerDay.
     *
     * @param id the id of the jobSchedulerDayDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the jobSchedulerDayDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/job-scheduler-days/{id}")
    public ResponseEntity<JobSchedulerDayDTO> getJobSchedulerDay(@PathVariable Long id) {
        log.debug("REST request to get JobSchedulerDay : {}", id);
        Optional<JobSchedulerDayDTO> jobSchedulerDayDTO = jobSchedulerDayService.findOne(id);
        return ResponseUtil.wrapOrNotFound(jobSchedulerDayDTO);
    }

    /**
     * {@code DELETE  /job-scheduler-days/:id} : delete the "id" jobSchedulerDay.
     *
     * @param id the id of the jobSchedulerDayDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/job-scheduler-days/{id}")
    public ResponseEntity<Void> deleteJobSchedulerDay(@PathVariable Long id) {
        log.debug("REST request to delete JobSchedulerDay : {}", id);
        jobSchedulerDayService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
