package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.JobSchedulerService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.JobSchedulerDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.JobScheduler}.
 */
@RestController
@RequestMapping("/api")
public class JobSchedulerResource {

    private final Logger log = LoggerFactory.getLogger(JobSchedulerResource.class);

    private static final String ENTITY_NAME = "jobScheduler";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final JobSchedulerService jobSchedulerService;

    public JobSchedulerResource(JobSchedulerService jobSchedulerService) {
        this.jobSchedulerService = jobSchedulerService;
    }

    /**
     * {@code POST  /job-schedulers} : Create a new jobScheduler.
     *
     * @param jobSchedulerDTO the jobSchedulerDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new jobSchedulerDTO, or with status {@code 400 (Bad Request)} if the jobScheduler has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/job-schedulers")
    public ResponseEntity<JobSchedulerDTO> createJobScheduler(@Valid @RequestBody JobSchedulerDTO jobSchedulerDTO) throws URISyntaxException {
        log.debug("REST request to save JobScheduler : {}", jobSchedulerDTO);
        if (jobSchedulerDTO.getId() != null) {
            throw new BadRequestAlertException("A new jobScheduler cannot already have an ID", ENTITY_NAME, "idexists");
        }
        JobSchedulerDTO result = jobSchedulerService.save(jobSchedulerDTO);
        return ResponseEntity.created(new URI("/api/job-schedulers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /job-schedulers} : Updates an existing jobScheduler.
     *
     * @param jobSchedulerDTO the jobSchedulerDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated jobSchedulerDTO,
     * or with status {@code 400 (Bad Request)} if the jobSchedulerDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the jobSchedulerDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/job-schedulers")
    public ResponseEntity<JobSchedulerDTO> updateJobScheduler(@Valid @RequestBody JobSchedulerDTO jobSchedulerDTO) throws URISyntaxException {
        log.debug("REST request to update JobScheduler : {}", jobSchedulerDTO);
        if (jobSchedulerDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        JobSchedulerDTO result = jobSchedulerService.save(jobSchedulerDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, jobSchedulerDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /job-schedulers} : get all the jobSchedulers.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of jobSchedulers in body.
     */
    @GetMapping("/job-schedulers")
    public ResponseEntity<List<JobSchedulerDTO>> getAllJobSchedulers(Pageable pageable) {
        log.debug("REST request to get a page of JobSchedulers");
        Page<JobSchedulerDTO> page = jobSchedulerService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /job-schedulers/:id} : get the "id" jobScheduler.
     *
     * @param id the id of the jobSchedulerDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the jobSchedulerDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/job-schedulers/{id}")
    public ResponseEntity<JobSchedulerDTO> getJobScheduler(@PathVariable Long id) {
        log.debug("REST request to get JobScheduler : {}", id);
        Optional<JobSchedulerDTO> jobSchedulerDTO = jobSchedulerService.findOne(id);
        return ResponseUtil.wrapOrNotFound(jobSchedulerDTO);
    }

    /**
     * {@code DELETE  /job-schedulers/:id} : delete the "id" jobScheduler.
     *
     * @param id the id of the jobSchedulerDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/job-schedulers/{id}")
    public ResponseEntity<Void> deleteJobScheduler(@PathVariable Long id) {
        log.debug("REST request to delete JobScheduler : {}", id);
        jobSchedulerService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
