package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.VwScheduleChangeService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.VwScheduleChangeDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.VwScheduleChange}.
 */
@RestController
@RequestMapping("/api")
public class VwScheduleChangeResource {

    private final Logger log = LoggerFactory.getLogger(VwScheduleChangeResource.class);

    private static final String ENTITY_NAME = "vwScheduleChange";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final VwScheduleChangeService vwScheduleChangeService;

    public VwScheduleChangeResource(VwScheduleChangeService vwScheduleChangeService) {
        this.vwScheduleChangeService = vwScheduleChangeService;
    }

    /**
     * {@code POST  /vw-schedule-changes} : Create a new vwScheduleChange.
     *
     * @param vwScheduleChangeDTO the vwScheduleChangeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new vwScheduleChangeDTO, or with status {@code 400 (Bad Request)} if the vwScheduleChange has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/vw-schedule-changes")
    public ResponseEntity<VwScheduleChangeDTO> createVwScheduleChange(@Valid @RequestBody VwScheduleChangeDTO vwScheduleChangeDTO) throws URISyntaxException {
        log.debug("REST request to save VwScheduleChange : {}", vwScheduleChangeDTO);
        if (vwScheduleChangeDTO.getId() != null) {
            throw new BadRequestAlertException("A new vwScheduleChange cannot already have an ID", ENTITY_NAME, "idexists");
        }
        VwScheduleChangeDTO result = vwScheduleChangeService.save(vwScheduleChangeDTO);
        return ResponseEntity.created(new URI("/api/vw-schedule-changes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /vw-schedule-changes} : Updates an existing vwScheduleChange.
     *
     * @param vwScheduleChangeDTO the vwScheduleChangeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated vwScheduleChangeDTO,
     * or with status {@code 400 (Bad Request)} if the vwScheduleChangeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the vwScheduleChangeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/vw-schedule-changes")
    public ResponseEntity<VwScheduleChangeDTO> updateVwScheduleChange(@Valid @RequestBody VwScheduleChangeDTO vwScheduleChangeDTO) throws URISyntaxException {
        log.debug("REST request to update VwScheduleChange : {}", vwScheduleChangeDTO);
        if (vwScheduleChangeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        VwScheduleChangeDTO result = vwScheduleChangeService.save(vwScheduleChangeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, vwScheduleChangeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /vw-schedule-changes} : get all the vwScheduleChanges.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of vwScheduleChanges in body.
     */
    @GetMapping("/vw-schedule-changes")
    public ResponseEntity<List<VwScheduleChangeDTO>> getAllVwScheduleChanges(Pageable pageable) {
        log.debug("REST request to get a page of VwScheduleChanges");
        Page<VwScheduleChangeDTO> page = vwScheduleChangeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /vw-schedule-changes/:id} : get the "id" vwScheduleChange.
     *
     * @param id the id of the vwScheduleChangeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the vwScheduleChangeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/vw-schedule-changes/{id}")
    public ResponseEntity<VwScheduleChangeDTO> getVwScheduleChange(@PathVariable Long id) {
        log.debug("REST request to get VwScheduleChange : {}", id);
        Optional<VwScheduleChangeDTO> vwScheduleChangeDTO = vwScheduleChangeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(vwScheduleChangeDTO);
    }

    /**
     * {@code DELETE  /vw-schedule-changes/:id} : delete the "id" vwScheduleChange.
     *
     * @param id the id of the vwScheduleChangeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/vw-schedule-changes/{id}")
    public ResponseEntity<Void> deleteVwScheduleChange(@PathVariable Long id) {
        log.debug("REST request to delete VwScheduleChange : {}", id);
        vwScheduleChangeService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
