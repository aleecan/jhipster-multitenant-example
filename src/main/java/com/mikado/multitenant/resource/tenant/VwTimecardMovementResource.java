package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.VwTimecardMovementService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.VwTimecardMovementDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.VwTimecardMovement}.
 */
@RestController
@RequestMapping("/api")
public class VwTimecardMovementResource {

    private final Logger log = LoggerFactory.getLogger(VwTimecardMovementResource.class);

    private static final String ENTITY_NAME = "vwTimecardMovement";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final VwTimecardMovementService vwTimecardMovementService;

    public VwTimecardMovementResource(VwTimecardMovementService vwTimecardMovementService) {
        this.vwTimecardMovementService = vwTimecardMovementService;
    }

    /**
     * {@code POST  /vw-timecard-movements} : Create a new vwTimecardMovement.
     *
     * @param vwTimecardMovementDTO the vwTimecardMovementDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new vwTimecardMovementDTO, or with status {@code 400 (Bad Request)} if the vwTimecardMovement has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/vw-timecard-movements")
    public ResponseEntity<VwTimecardMovementDTO> createVwTimecardMovement(@Valid @RequestBody VwTimecardMovementDTO vwTimecardMovementDTO) throws URISyntaxException {
        log.debug("REST request to save VwTimecardMovement : {}", vwTimecardMovementDTO);
        if (vwTimecardMovementDTO.getId() != null) {
            throw new BadRequestAlertException("A new vwTimecardMovement cannot already have an ID", ENTITY_NAME, "idexists");
        }
        VwTimecardMovementDTO result = vwTimecardMovementService.save(vwTimecardMovementDTO);
        return ResponseEntity.created(new URI("/api/vw-timecard-movements/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /vw-timecard-movements} : Updates an existing vwTimecardMovement.
     *
     * @param vwTimecardMovementDTO the vwTimecardMovementDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated vwTimecardMovementDTO,
     * or with status {@code 400 (Bad Request)} if the vwTimecardMovementDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the vwTimecardMovementDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/vw-timecard-movements")
    public ResponseEntity<VwTimecardMovementDTO> updateVwTimecardMovement(@Valid @RequestBody VwTimecardMovementDTO vwTimecardMovementDTO) throws URISyntaxException {
        log.debug("REST request to update VwTimecardMovement : {}", vwTimecardMovementDTO);
        if (vwTimecardMovementDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        VwTimecardMovementDTO result = vwTimecardMovementService.save(vwTimecardMovementDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, vwTimecardMovementDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /vw-timecard-movements} : get all the vwTimecardMovements.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of vwTimecardMovements in body.
     */
    @GetMapping("/vw-timecard-movements")
    public ResponseEntity<List<VwTimecardMovementDTO>> getAllVwTimecardMovements(Pageable pageable) {
        log.debug("REST request to get a page of VwTimecardMovements");
        Page<VwTimecardMovementDTO> page = vwTimecardMovementService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /vw-timecard-movements/:id} : get the "id" vwTimecardMovement.
     *
     * @param id the id of the vwTimecardMovementDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the vwTimecardMovementDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/vw-timecard-movements/{id}")
    public ResponseEntity<VwTimecardMovementDTO> getVwTimecardMovement(@PathVariable Long id) {
        log.debug("REST request to get VwTimecardMovement : {}", id);
        Optional<VwTimecardMovementDTO> vwTimecardMovementDTO = vwTimecardMovementService.findOne(id);
        return ResponseUtil.wrapOrNotFound(vwTimecardMovementDTO);
    }

    /**
     * {@code DELETE  /vw-timecard-movements/:id} : delete the "id" vwTimecardMovement.
     *
     * @param id the id of the vwTimecardMovementDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/vw-timecard-movements/{id}")
    public ResponseEntity<Void> deleteVwTimecardMovement(@PathVariable Long id) {
        log.debug("REST request to delete VwTimecardMovement : {}", id);
        vwTimecardMovementService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
