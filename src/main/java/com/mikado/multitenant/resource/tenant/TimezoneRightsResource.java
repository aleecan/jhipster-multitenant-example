package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.TimezoneRightsService;
import com.mikado.multitenant.service.dto.tenant.TimezoneRightsDTO;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.TimezoneRights}.
 */
@RestController
@RequestMapping("/api")
public class TimezoneRightsResource {

    private final Logger log = LoggerFactory.getLogger(TimezoneRightsResource.class);

    private static final String ENTITY_NAME = "timezoneRights";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TimezoneRightsService timezoneRightsService;

    public TimezoneRightsResource(TimezoneRightsService timezoneRightsService) {
        this.timezoneRightsService = timezoneRightsService;
    }

    /**
     * {@code POST  /timezone-rights} : Create a new timezoneRights.
     *
     * @param timezoneRightsDTO the timezoneRightsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new timezoneRightsDTO, or with status {@code 400 (Bad Request)} if the timezoneRights has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/timezone-rights")
    public ResponseEntity<TimezoneRightsDTO> createTimezoneRights(@Valid @RequestBody TimezoneRightsDTO timezoneRightsDTO) throws URISyntaxException {
        log.debug("REST request to save TimezoneRights : {}", timezoneRightsDTO);
        if (timezoneRightsDTO.getId() != null) {
            throw new BadRequestAlertException("A new timezoneRights cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TimezoneRightsDTO result = timezoneRightsService.save(timezoneRightsDTO);
        return ResponseEntity.created(new URI("/api/timezone-rights/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /timezone-rights} : Updates an existing timezoneRights.
     *
     * @param timezoneRightsDTO the timezoneRightsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated timezoneRightsDTO,
     * or with status {@code 400 (Bad Request)} if the timezoneRightsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the timezoneRightsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/timezone-rights")
    public ResponseEntity<TimezoneRightsDTO> updateTimezoneRights(@Valid @RequestBody TimezoneRightsDTO timezoneRightsDTO) throws URISyntaxException {
        log.debug("REST request to update TimezoneRights : {}", timezoneRightsDTO);
        if (timezoneRightsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TimezoneRightsDTO result = timezoneRightsService.save(timezoneRightsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, timezoneRightsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /timezone-rights} : get all the timezoneRights.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of timezoneRights in body.
     */
    @GetMapping("/timezone-rights")
    public ResponseEntity<List<TimezoneRightsDTO>> getAllTimezoneRights(Pageable pageable) {
        log.debug("REST request to get a page of TimezoneRights");
        Page<TimezoneRightsDTO> page = timezoneRightsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /timezone-rights/:id} : get the "id" timezoneRights.
     *
     * @param id the id of the timezoneRightsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the timezoneRightsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/timezone-rights/{id}")
    public ResponseEntity<TimezoneRightsDTO> getTimezoneRights(@PathVariable Long id) {
        log.debug("REST request to get TimezoneRights : {}", id);
        Optional<TimezoneRightsDTO> timezoneRightsDTO = timezoneRightsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(timezoneRightsDTO);
    }

    /**
     * {@code DELETE  /timezone-rights/:id} : delete the "id" timezoneRights.
     *
     * @param id the id of the timezoneRightsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/timezone-rights/{id}")
    public ResponseEntity<Void> deleteTimezoneRights(@PathVariable Long id) {
        log.debug("REST request to delete TimezoneRights : {}", id);
        timezoneRightsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
