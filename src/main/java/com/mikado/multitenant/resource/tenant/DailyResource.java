package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.DailyService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.DailyDTO;

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

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.Daily}.
 */
@RestController
@RequestMapping("/api")
public class DailyResource {

    private final Logger log = LoggerFactory.getLogger(DailyResource.class);

    private static final String ENTITY_NAME = "daily";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DailyService dailyService;

    public DailyResource(DailyService dailyService) {
        this.dailyService = dailyService;
    }

    /**
     * {@code POST  /dailies} : Create a new daily.
     *
     * @param dailyDTO the dailyDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dailyDTO, or with status {@code 400 (Bad Request)} if the daily has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/dailies")
    public ResponseEntity<DailyDTO> createDaily(@RequestBody DailyDTO dailyDTO) throws URISyntaxException {
        log.debug("REST request to save Daily : {}", dailyDTO);
        if (dailyDTO.getId() != null) {
            throw new BadRequestAlertException("A new daily cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DailyDTO result = dailyService.save(dailyDTO);
        return ResponseEntity.created(new URI("/api/dailies/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /dailies} : Updates an existing daily.
     *
     * @param dailyDTO the dailyDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dailyDTO,
     * or with status {@code 400 (Bad Request)} if the dailyDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dailyDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/dailies")
    public ResponseEntity<DailyDTO> updateDaily(@RequestBody DailyDTO dailyDTO) throws URISyntaxException {
        log.debug("REST request to update Daily : {}", dailyDTO);
        if (dailyDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DailyDTO result = dailyService.save(dailyDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, dailyDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /dailies} : get all the dailies.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dailies in body.
     */
    @GetMapping("/dailies")
    public ResponseEntity<List<DailyDTO>> getAllDailies(Pageable pageable) {
        log.debug("REST request to get a page of Dailies");
        Page<DailyDTO> page = dailyService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /dailies/:id} : get the "id" daily.
     *
     * @param id the id of the dailyDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dailyDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/dailies/{id}")
    public ResponseEntity<DailyDTO> getDaily(@PathVariable Long id) {
        log.debug("REST request to get Daily : {}", id);
        Optional<DailyDTO> dailyDTO = dailyService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dailyDTO);
    }

    /**
     * {@code DELETE  /dailies/:id} : delete the "id" daily.
     *
     * @param id the id of the dailyDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/dailies/{id}")
    public ResponseEntity<Void> deleteDaily(@PathVariable Long id) {
        log.debug("REST request to delete Daily : {}", id);
        dailyService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
