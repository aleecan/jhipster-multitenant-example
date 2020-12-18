package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.DailyDetailsService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.DailyDetailsDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.DailyDetails}.
 */
@RestController
@RequestMapping("/api")
public class DailyDetailsResource {

    private final Logger log = LoggerFactory.getLogger(DailyDetailsResource.class);

    private static final String ENTITY_NAME = "dailyDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DailyDetailsService dailyDetailsService;

    public DailyDetailsResource(DailyDetailsService dailyDetailsService) {
        this.dailyDetailsService = dailyDetailsService;
    }

    /**
     * {@code POST  /daily-details} : Create a new dailyDetails.
     *
     * @param dailyDetailsDTO the dailyDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dailyDetailsDTO, or with status {@code 400 (Bad Request)} if the dailyDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/daily-details")
    public ResponseEntity<DailyDetailsDTO> createDailyDetails(@Valid @RequestBody DailyDetailsDTO dailyDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save DailyDetails : {}", dailyDetailsDTO);
        if (dailyDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new dailyDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DailyDetailsDTO result = dailyDetailsService.save(dailyDetailsDTO);
        return ResponseEntity.created(new URI("/api/daily-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /daily-details} : Updates an existing dailyDetails.
     *
     * @param dailyDetailsDTO the dailyDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dailyDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the dailyDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dailyDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/daily-details")
    public ResponseEntity<DailyDetailsDTO> updateDailyDetails(@Valid @RequestBody DailyDetailsDTO dailyDetailsDTO) throws URISyntaxException {
        log.debug("REST request to update DailyDetails : {}", dailyDetailsDTO);
        if (dailyDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DailyDetailsDTO result = dailyDetailsService.save(dailyDetailsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, dailyDetailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /daily-details} : get all the dailyDetails.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dailyDetails in body.
     */
    @GetMapping("/daily-details")
    public ResponseEntity<List<DailyDetailsDTO>> getAllDailyDetails(Pageable pageable) {
        log.debug("REST request to get a page of DailyDetails");
        Page<DailyDetailsDTO> page = dailyDetailsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /daily-details/:id} : get the "id" dailyDetails.
     *
     * @param id the id of the dailyDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dailyDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/daily-details/{id}")
    public ResponseEntity<DailyDetailsDTO> getDailyDetails(@PathVariable Long id) {
        log.debug("REST request to get DailyDetails : {}", id);
        Optional<DailyDetailsDTO> dailyDetailsDTO = dailyDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dailyDetailsDTO);
    }

    /**
     * {@code DELETE  /daily-details/:id} : delete the "id" dailyDetails.
     *
     * @param id the id of the dailyDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/daily-details/{id}")
    public ResponseEntity<Void> deleteDailyDetails(@PathVariable Long id) {
        log.debug("REST request to delete DailyDetails : {}", id);
        dailyDetailsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
