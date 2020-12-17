package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.TimezoneService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.TimezoneDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.Timezone}.
 */
@RestController
@RequestMapping("/api")
public class TimezoneResource {

    private final Logger log = LoggerFactory.getLogger(TimezoneResource.class);

    private static final String ENTITY_NAME = "timezone";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TimezoneService timezoneService;

    public TimezoneResource(TimezoneService timezoneService) {
        this.timezoneService = timezoneService;
    }

    /**
     * {@code POST  /timezones} : Create a new timezone.
     *
     * @param timezoneDTO the timezoneDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new timezoneDTO, or with status {@code 400 (Bad Request)} if the timezone has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/timezones")
    public ResponseEntity<TimezoneDTO> createTimezone(@Valid @RequestBody TimezoneDTO timezoneDTO) throws URISyntaxException {
        log.debug("REST request to save Timezone : {}", timezoneDTO);
        if (timezoneDTO.getId() != null) {
            throw new BadRequestAlertException("A new timezone cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TimezoneDTO result = timezoneService.save(timezoneDTO);
        return ResponseEntity.created(new URI("/api/timezones/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /timezones} : Updates an existing timezone.
     *
     * @param timezoneDTO the timezoneDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated timezoneDTO,
     * or with status {@code 400 (Bad Request)} if the timezoneDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the timezoneDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/timezones")
    public ResponseEntity<TimezoneDTO> updateTimezone(@Valid @RequestBody TimezoneDTO timezoneDTO) throws URISyntaxException {
        log.debug("REST request to update Timezone : {}", timezoneDTO);
        if (timezoneDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TimezoneDTO result = timezoneService.save(timezoneDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, timezoneDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /timezones} : get all the timezones.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of timezones in body.
     */
    @GetMapping("/timezones")
    public ResponseEntity<List<TimezoneDTO>> getAllTimezones(Pageable pageable) {
        log.debug("REST request to get a page of Timezones");
        Page<TimezoneDTO> page = timezoneService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /timezones/:id} : get the "id" timezone.
     *
     * @param id the id of the timezoneDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the timezoneDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/timezones/{id}")
    public ResponseEntity<TimezoneDTO> getTimezone(@PathVariable Long id) {
        log.debug("REST request to get Timezone : {}", id);
        Optional<TimezoneDTO> timezoneDTO = timezoneService.findOne(id);
        return ResponseUtil.wrapOrNotFound(timezoneDTO);
    }

    /**
     * {@code DELETE  /timezones/:id} : delete the "id" timezone.
     *
     * @param id the id of the timezoneDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/timezones/{id}")
    public ResponseEntity<Void> deleteTimezone(@PathVariable Long id) {
        log.debug("REST request to delete Timezone : {}", id);
        timezoneService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
