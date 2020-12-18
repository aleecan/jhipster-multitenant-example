package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.TimezoneDayService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.TimezoneDayDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.TimezoneDay}.
 */
@RestController
@RequestMapping("/api")
public class TimezoneDayResource {

    private final Logger log = LoggerFactory.getLogger(TimezoneDayResource.class);

    private static final String ENTITY_NAME = "timezoneDay";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TimezoneDayService timezoneDayService;

    public TimezoneDayResource(TimezoneDayService timezoneDayService) {
        this.timezoneDayService = timezoneDayService;
    }

    /**
     * {@code POST  /timezone-days} : Create a new timezoneDay.
     *
     * @param timezoneDayDTO the timezoneDayDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new timezoneDayDTO, or with status {@code 400 (Bad Request)} if the timezoneDay has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/timezone-days")
    public ResponseEntity<TimezoneDayDTO> createTimezoneDay(@Valid @RequestBody TimezoneDayDTO timezoneDayDTO) throws URISyntaxException {
        log.debug("REST request to save TimezoneDay : {}", timezoneDayDTO);
        if (timezoneDayDTO.getId() != null) {
            throw new BadRequestAlertException("A new timezoneDay cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TimezoneDayDTO result = timezoneDayService.save(timezoneDayDTO);
        return ResponseEntity.created(new URI("/api/timezone-days/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /timezone-days} : Updates an existing timezoneDay.
     *
     * @param timezoneDayDTO the timezoneDayDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated timezoneDayDTO,
     * or with status {@code 400 (Bad Request)} if the timezoneDayDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the timezoneDayDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/timezone-days")
    public ResponseEntity<TimezoneDayDTO> updateTimezoneDay(@Valid @RequestBody TimezoneDayDTO timezoneDayDTO) throws URISyntaxException {
        log.debug("REST request to update TimezoneDay : {}", timezoneDayDTO);
        if (timezoneDayDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TimezoneDayDTO result = timezoneDayService.save(timezoneDayDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, timezoneDayDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /timezone-days} : get all the timezoneDays.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of timezoneDays in body.
     */
    @GetMapping("/timezone-days")
    public ResponseEntity<List<TimezoneDayDTO>> getAllTimezoneDays(Pageable pageable) {
        log.debug("REST request to get a page of TimezoneDays");
        Page<TimezoneDayDTO> page = timezoneDayService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /timezone-days/:id} : get the "id" timezoneDay.
     *
     * @param id the id of the timezoneDayDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the timezoneDayDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/timezone-days/{id}")
    public ResponseEntity<TimezoneDayDTO> getTimezoneDay(@PathVariable Long id) {
        log.debug("REST request to get TimezoneDay : {}", id);
        Optional<TimezoneDayDTO> timezoneDayDTO = timezoneDayService.findOne(id);
        return ResponseUtil.wrapOrNotFound(timezoneDayDTO);
    }

    /**
     * {@code DELETE  /timezone-days/:id} : delete the "id" timezoneDay.
     *
     * @param id the id of the timezoneDayDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/timezone-days/{id}")
    public ResponseEntity<Void> deleteTimezoneDay(@PathVariable Long id) {
        log.debug("REST request to delete TimezoneDay : {}", id);
        timezoneDayService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
