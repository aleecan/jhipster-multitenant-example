package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.CalendarPeriodService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.CalendarPeriodDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.CalendarPeriod}.
 */
@RestController
@RequestMapping("/api")
public class CalendarPeriodResource {

    private final Logger log = LoggerFactory.getLogger(CalendarPeriodResource.class);

    private static final String ENTITY_NAME = "calendarPeriod";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CalendarPeriodService calendarPeriodService;

    public CalendarPeriodResource(CalendarPeriodService calendarPeriodService) {
        this.calendarPeriodService = calendarPeriodService;
    }

    /**
     * {@code POST  /calendar-periods} : Create a new calendarPeriod.
     *
     * @param calendarPeriodDTO the calendarPeriodDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new calendarPeriodDTO, or with status {@code 400 (Bad Request)} if the calendarPeriod has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/calendar-periods")
    public ResponseEntity<CalendarPeriodDTO> createCalendarPeriod(@Valid @RequestBody CalendarPeriodDTO calendarPeriodDTO) throws URISyntaxException {
        log.debug("REST request to save CalendarPeriod : {}", calendarPeriodDTO);
        if (calendarPeriodDTO.getId() != null) {
            throw new BadRequestAlertException("A new calendarPeriod cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CalendarPeriodDTO result = calendarPeriodService.save(calendarPeriodDTO);
        return ResponseEntity.created(new URI("/api/calendar-periods/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /calendar-periods} : Updates an existing calendarPeriod.
     *
     * @param calendarPeriodDTO the calendarPeriodDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated calendarPeriodDTO,
     * or with status {@code 400 (Bad Request)} if the calendarPeriodDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the calendarPeriodDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/calendar-periods")
    public ResponseEntity<CalendarPeriodDTO> updateCalendarPeriod(@Valid @RequestBody CalendarPeriodDTO calendarPeriodDTO) throws URISyntaxException {
        log.debug("REST request to update CalendarPeriod : {}", calendarPeriodDTO);
        if (calendarPeriodDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CalendarPeriodDTO result = calendarPeriodService.save(calendarPeriodDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, calendarPeriodDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /calendar-periods} : get all the calendarPeriods.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of calendarPeriods in body.
     */
    @GetMapping("/calendar-periods")
    public ResponseEntity<List<CalendarPeriodDTO>> getAllCalendarPeriods(Pageable pageable) {
        log.debug("REST request to get a page of CalendarPeriods");
        Page<CalendarPeriodDTO> page = calendarPeriodService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /calendar-periods/:id} : get the "id" calendarPeriod.
     *
     * @param id the id of the calendarPeriodDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the calendarPeriodDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/calendar-periods/{id}")
    public ResponseEntity<CalendarPeriodDTO> getCalendarPeriod(@PathVariable Long id) {
        log.debug("REST request to get CalendarPeriod : {}", id);
        Optional<CalendarPeriodDTO> calendarPeriodDTO = calendarPeriodService.findOne(id);
        return ResponseUtil.wrapOrNotFound(calendarPeriodDTO);
    }

    /**
     * {@code DELETE  /calendar-periods/:id} : delete the "id" calendarPeriod.
     *
     * @param id the id of the calendarPeriodDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/calendar-periods/{id}")
    public ResponseEntity<Void> deleteCalendarPeriod(@PathVariable Long id) {
        log.debug("REST request to delete CalendarPeriod : {}", id);
        calendarPeriodService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
