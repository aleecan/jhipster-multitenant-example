package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.ZoneGateService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.ZoneGateDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.ZoneGate}.
 */
@RestController
@RequestMapping("/api")
public class ZoneGateResource {

    private final Logger log = LoggerFactory.getLogger(ZoneGateResource.class);

    private static final String ENTITY_NAME = "zoneGate";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ZoneGateService zoneGateService;

    public ZoneGateResource(ZoneGateService zoneGateService) {
        this.zoneGateService = zoneGateService;
    }

    /**
     * {@code POST  /zone-gates} : Create a new zoneGate.
     *
     * @param zoneGateDTO the zoneGateDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new zoneGateDTO, or with status {@code 400 (Bad Request)} if the zoneGate has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/zone-gates")
    public ResponseEntity<ZoneGateDTO> createZoneGate(@Valid @RequestBody ZoneGateDTO zoneGateDTO) throws URISyntaxException {
        log.debug("REST request to save ZoneGate : {}", zoneGateDTO);
        if (zoneGateDTO.getId() != null) {
            throw new BadRequestAlertException("A new zoneGate cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ZoneGateDTO result = zoneGateService.save(zoneGateDTO);
        return ResponseEntity.created(new URI("/api/zone-gates/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /zone-gates} : Updates an existing zoneGate.
     *
     * @param zoneGateDTO the zoneGateDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated zoneGateDTO,
     * or with status {@code 400 (Bad Request)} if the zoneGateDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the zoneGateDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/zone-gates")
    public ResponseEntity<ZoneGateDTO> updateZoneGate(@Valid @RequestBody ZoneGateDTO zoneGateDTO) throws URISyntaxException {
        log.debug("REST request to update ZoneGate : {}", zoneGateDTO);
        if (zoneGateDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ZoneGateDTO result = zoneGateService.save(zoneGateDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, zoneGateDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /zone-gates} : get all the zoneGates.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of zoneGates in body.
     */
    @GetMapping("/zone-gates")
    public ResponseEntity<List<ZoneGateDTO>> getAllZoneGates(Pageable pageable) {
        log.debug("REST request to get a page of ZoneGates");
        Page<ZoneGateDTO> page = zoneGateService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /zone-gates/:id} : get the "id" zoneGate.
     *
     * @param id the id of the zoneGateDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the zoneGateDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/zone-gates/{id}")
    public ResponseEntity<ZoneGateDTO> getZoneGate(@PathVariable Long id) {
        log.debug("REST request to get ZoneGate : {}", id);
        Optional<ZoneGateDTO> zoneGateDTO = zoneGateService.findOne(id);
        return ResponseUtil.wrapOrNotFound(zoneGateDTO);
    }

    /**
     * {@code DELETE  /zone-gates/:id} : delete the "id" zoneGate.
     *
     * @param id the id of the zoneGateDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/zone-gates/{id}")
    public ResponseEntity<Void> deleteZoneGate(@PathVariable Long id) {
        log.debug("REST request to delete ZoneGate : {}", id);
        zoneGateService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
