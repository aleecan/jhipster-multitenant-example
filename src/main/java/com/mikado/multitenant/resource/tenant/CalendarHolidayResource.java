package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.CalendarHolidayService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.CalendarHolidayDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.CalendarHoliday}.
 */
@RestController
@RequestMapping("/api")
public class CalendarHolidayResource {

    private final Logger log = LoggerFactory.getLogger(CalendarHolidayResource.class);

    private static final String ENTITY_NAME = "calendarHoliday";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CalendarHolidayService calendarHolidayService;

    public CalendarHolidayResource(CalendarHolidayService calendarHolidayService) {
        this.calendarHolidayService = calendarHolidayService;
    }

    /**
     * {@code POST  /calendar-holidays} : Create a new calendarHoliday.
     *
     * @param calendarHolidayDTO the calendarHolidayDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new calendarHolidayDTO, or with status {@code 400 (Bad Request)} if the calendarHoliday has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/calendar-holidays")
    public ResponseEntity<CalendarHolidayDTO> createCalendarHoliday(@Valid @RequestBody CalendarHolidayDTO calendarHolidayDTO) throws URISyntaxException {
        log.debug("REST request to save CalendarHoliday : {}", calendarHolidayDTO);
        if (calendarHolidayDTO.getId() != null) {
            throw new BadRequestAlertException("A new calendarHoliday cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CalendarHolidayDTO result = calendarHolidayService.save(calendarHolidayDTO);
        return ResponseEntity.created(new URI("/api/calendar-holidays/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /calendar-holidays} : Updates an existing calendarHoliday.
     *
     * @param calendarHolidayDTO the calendarHolidayDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated calendarHolidayDTO,
     * or with status {@code 400 (Bad Request)} if the calendarHolidayDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the calendarHolidayDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/calendar-holidays")
    public ResponseEntity<CalendarHolidayDTO> updateCalendarHoliday(@Valid @RequestBody CalendarHolidayDTO calendarHolidayDTO) throws URISyntaxException {
        log.debug("REST request to update CalendarHoliday : {}", calendarHolidayDTO);
        if (calendarHolidayDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CalendarHolidayDTO result = calendarHolidayService.save(calendarHolidayDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, calendarHolidayDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /calendar-holidays} : get all the calendarHolidays.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of calendarHolidays in body.
     */
    @GetMapping("/calendar-holidays")
    public ResponseEntity<List<CalendarHolidayDTO>> getAllCalendarHolidays(Pageable pageable) {
        log.debug("REST request to get a page of CalendarHolidays");
        Page<CalendarHolidayDTO> page = calendarHolidayService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /calendar-holidays/:id} : get the "id" calendarHoliday.
     *
     * @param id the id of the calendarHolidayDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the calendarHolidayDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/calendar-holidays/{id}")
    public ResponseEntity<CalendarHolidayDTO> getCalendarHoliday(@PathVariable Long id) {
        log.debug("REST request to get CalendarHoliday : {}", id);
        Optional<CalendarHolidayDTO> calendarHolidayDTO = calendarHolidayService.findOne(id);
        return ResponseUtil.wrapOrNotFound(calendarHolidayDTO);
    }

    /**
     * {@code DELETE  /calendar-holidays/:id} : delete the "id" calendarHoliday.
     *
     * @param id the id of the calendarHolidayDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/calendar-holidays/{id}")
    public ResponseEntity<Void> deleteCalendarHoliday(@PathVariable Long id) {
        log.debug("REST request to delete CalendarHoliday : {}", id);
        calendarHolidayService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
