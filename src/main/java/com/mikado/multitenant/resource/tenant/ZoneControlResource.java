package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.ZoneControlService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.ZoneControlDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.ZoneControl}.
 */
@RestController
@RequestMapping("/api")
public class ZoneControlResource {

    private final Logger log = LoggerFactory.getLogger(ZoneControlResource.class);

    private static final String ENTITY_NAME = "zoneControl";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ZoneControlService zoneControlService;

    public ZoneControlResource(ZoneControlService zoneControlService) {
        this.zoneControlService = zoneControlService;
    }

    /**
     * {@code POST  /zone-controls} : Create a new zoneControl.
     *
     * @param zoneControlDTO the zoneControlDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new zoneControlDTO, or with status {@code 400 (Bad Request)} if the zoneControl has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/zone-controls")
    public ResponseEntity<ZoneControlDTO> createZoneControl(@Valid @RequestBody ZoneControlDTO zoneControlDTO) throws URISyntaxException {
        log.debug("REST request to save ZoneControl : {}", zoneControlDTO);
        if (zoneControlDTO.getId() != null) {
            throw new BadRequestAlertException("A new zoneControl cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ZoneControlDTO result = zoneControlService.save(zoneControlDTO);
        return ResponseEntity.created(new URI("/api/zone-controls/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /zone-controls} : Updates an existing zoneControl.
     *
     * @param zoneControlDTO the zoneControlDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated zoneControlDTO,
     * or with status {@code 400 (Bad Request)} if the zoneControlDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the zoneControlDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/zone-controls")
    public ResponseEntity<ZoneControlDTO> updateZoneControl(@Valid @RequestBody ZoneControlDTO zoneControlDTO) throws URISyntaxException {
        log.debug("REST request to update ZoneControl : {}", zoneControlDTO);
        if (zoneControlDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ZoneControlDTO result = zoneControlService.save(zoneControlDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, zoneControlDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /zone-controls} : get all the zoneControls.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of zoneControls in body.
     */
    @GetMapping("/zone-controls")
    public ResponseEntity<List<ZoneControlDTO>> getAllZoneControls(Pageable pageable) {
        log.debug("REST request to get a page of ZoneControls");
        Page<ZoneControlDTO> page = zoneControlService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /zone-controls/:id} : get the "id" zoneControl.
     *
     * @param id the id of the zoneControlDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the zoneControlDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/zone-controls/{id}")
    public ResponseEntity<ZoneControlDTO> getZoneControl(@PathVariable Long id) {
        log.debug("REST request to get ZoneControl : {}", id);
        Optional<ZoneControlDTO> zoneControlDTO = zoneControlService.findOne(id);
        return ResponseUtil.wrapOrNotFound(zoneControlDTO);
    }

    /**
     * {@code DELETE  /zone-controls/:id} : delete the "id" zoneControl.
     *
     * @param id the id of the zoneControlDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/zone-controls/{id}")
    public ResponseEntity<Void> deleteZoneControl(@PathVariable Long id) {
        log.debug("REST request to delete ZoneControl : {}", id);
        zoneControlService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
