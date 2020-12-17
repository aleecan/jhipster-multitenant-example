package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.ZoneAccessRuleService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.ZoneAccessRuleDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.ZoneAccessRule}.
 */
@RestController
@RequestMapping("/api")
public class ZoneAccessRuleResource {

    private final Logger log = LoggerFactory.getLogger(ZoneAccessRuleResource.class);

    private static final String ENTITY_NAME = "zoneAccessRule";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ZoneAccessRuleService zoneAccessRuleService;

    public ZoneAccessRuleResource(ZoneAccessRuleService zoneAccessRuleService) {
        this.zoneAccessRuleService = zoneAccessRuleService;
    }

    /**
     * {@code POST  /zone-access-rules} : Create a new zoneAccessRule.
     *
     * @param zoneAccessRuleDTO the zoneAccessRuleDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new zoneAccessRuleDTO, or with status {@code 400 (Bad Request)} if the zoneAccessRule has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/zone-access-rules")
    public ResponseEntity<ZoneAccessRuleDTO> createZoneAccessRule(@Valid @RequestBody ZoneAccessRuleDTO zoneAccessRuleDTO) throws URISyntaxException {
        log.debug("REST request to save ZoneAccessRule : {}", zoneAccessRuleDTO);
        if (zoneAccessRuleDTO.getId() != null) {
            throw new BadRequestAlertException("A new zoneAccessRule cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ZoneAccessRuleDTO result = zoneAccessRuleService.save(zoneAccessRuleDTO);
        return ResponseEntity.created(new URI("/api/zone-access-rules/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /zone-access-rules} : Updates an existing zoneAccessRule.
     *
     * @param zoneAccessRuleDTO the zoneAccessRuleDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated zoneAccessRuleDTO,
     * or with status {@code 400 (Bad Request)} if the zoneAccessRuleDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the zoneAccessRuleDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/zone-access-rules")
    public ResponseEntity<ZoneAccessRuleDTO> updateZoneAccessRule(@Valid @RequestBody ZoneAccessRuleDTO zoneAccessRuleDTO) throws URISyntaxException {
        log.debug("REST request to update ZoneAccessRule : {}", zoneAccessRuleDTO);
        if (zoneAccessRuleDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ZoneAccessRuleDTO result = zoneAccessRuleService.save(zoneAccessRuleDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, zoneAccessRuleDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /zone-access-rules} : get all the zoneAccessRules.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of zoneAccessRules in body.
     */
    @GetMapping("/zone-access-rules")
    public ResponseEntity<List<ZoneAccessRuleDTO>> getAllZoneAccessRules(Pageable pageable) {
        log.debug("REST request to get a page of ZoneAccessRules");
        Page<ZoneAccessRuleDTO> page = zoneAccessRuleService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /zone-access-rules/:id} : get the "id" zoneAccessRule.
     *
     * @param id the id of the zoneAccessRuleDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the zoneAccessRuleDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/zone-access-rules/{id}")
    public ResponseEntity<ZoneAccessRuleDTO> getZoneAccessRule(@PathVariable Long id) {
        log.debug("REST request to get ZoneAccessRule : {}", id);
        Optional<ZoneAccessRuleDTO> zoneAccessRuleDTO = zoneAccessRuleService.findOne(id);
        return ResponseUtil.wrapOrNotFound(zoneAccessRuleDTO);
    }

    /**
     * {@code DELETE  /zone-access-rules/:id} : delete the "id" zoneAccessRule.
     *
     * @param id the id of the zoneAccessRuleDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/zone-access-rules/{id}")
    public ResponseEntity<Void> deleteZoneAccessRule(@PathVariable Long id) {
        log.debug("REST request to delete ZoneAccessRule : {}", id);
        zoneAccessRuleService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
