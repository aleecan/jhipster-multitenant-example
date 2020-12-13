package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.TimezoneCalendarService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.TimezoneCalendarDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.TimezoneCalendar}.
 */
@RestController
@RequestMapping("/api")
public class TimezoneCalendarResource {

    private final Logger log = LoggerFactory.getLogger(TimezoneCalendarResource.class);

    private static final String ENTITY_NAME = "timezoneCalendar";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TimezoneCalendarService timezoneCalendarService;

    public TimezoneCalendarResource(TimezoneCalendarService timezoneCalendarService) {
        this.timezoneCalendarService = timezoneCalendarService;
    }

    /**
     * {@code POST  /timezone-calendars} : Create a new timezoneCalendar.
     *
     * @param timezoneCalendarDTO the timezoneCalendarDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new timezoneCalendarDTO, or with status {@code 400 (Bad Request)} if the timezoneCalendar has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/timezone-calendars")
    public ResponseEntity<TimezoneCalendarDTO> createTimezoneCalendar(@Valid @RequestBody TimezoneCalendarDTO timezoneCalendarDTO) throws URISyntaxException {
        log.debug("REST request to save TimezoneCalendar : {}", timezoneCalendarDTO);
        if (timezoneCalendarDTO.getId() != null) {
            throw new BadRequestAlertException("A new timezoneCalendar cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TimezoneCalendarDTO result = timezoneCalendarService.save(timezoneCalendarDTO);
        return ResponseEntity.created(new URI("/api/timezone-calendars/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /timezone-calendars} : Updates an existing timezoneCalendar.
     *
     * @param timezoneCalendarDTO the timezoneCalendarDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated timezoneCalendarDTO,
     * or with status {@code 400 (Bad Request)} if the timezoneCalendarDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the timezoneCalendarDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/timezone-calendars")
    public ResponseEntity<TimezoneCalendarDTO> updateTimezoneCalendar(@Valid @RequestBody TimezoneCalendarDTO timezoneCalendarDTO) throws URISyntaxException {
        log.debug("REST request to update TimezoneCalendar : {}", timezoneCalendarDTO);
        if (timezoneCalendarDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TimezoneCalendarDTO result = timezoneCalendarService.save(timezoneCalendarDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, timezoneCalendarDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /timezone-calendars} : get all the timezoneCalendars.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of timezoneCalendars in body.
     */
    @GetMapping("/timezone-calendars")
    public ResponseEntity<List<TimezoneCalendarDTO>> getAllTimezoneCalendars(Pageable pageable) {
        log.debug("REST request to get a page of TimezoneCalendars");
        Page<TimezoneCalendarDTO> page = timezoneCalendarService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /timezone-calendars/:id} : get the "id" timezoneCalendar.
     *
     * @param id the id of the timezoneCalendarDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the timezoneCalendarDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/timezone-calendars/{id}")
    public ResponseEntity<TimezoneCalendarDTO> getTimezoneCalendar(@PathVariable Long id) {
        log.debug("REST request to get TimezoneCalendar : {}", id);
        Optional<TimezoneCalendarDTO> timezoneCalendarDTO = timezoneCalendarService.findOne(id);
        return ResponseUtil.wrapOrNotFound(timezoneCalendarDTO);
    }

    /**
     * {@code DELETE  /timezone-calendars/:id} : delete the "id" timezoneCalendar.
     *
     * @param id the id of the timezoneCalendarDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/timezone-calendars/{id}")
    public ResponseEntity<Void> deleteTimezoneCalendar(@PathVariable Long id) {
        log.debug("REST request to delete TimezoneCalendar : {}", id);
        timezoneCalendarService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
