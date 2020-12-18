package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.GateAccessRuleService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.GateAccessRuleDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.GateAccessRule}.
 */
@RestController
@RequestMapping("/api")
public class GateAccessRuleResource {

    private final Logger log = LoggerFactory.getLogger(GateAccessRuleResource.class);

    private static final String ENTITY_NAME = "gateAccessRule";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final GateAccessRuleService gateAccessRuleService;

    public GateAccessRuleResource(GateAccessRuleService gateAccessRuleService) {
        this.gateAccessRuleService = gateAccessRuleService;
    }

    /**
     * {@code POST  /gate-access-rules} : Create a new gateAccessRule.
     *
     * @param gateAccessRuleDTO the gateAccessRuleDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new gateAccessRuleDTO, or with status {@code 400 (Bad Request)} if the gateAccessRule has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/gate-access-rules")
    public ResponseEntity<GateAccessRuleDTO> createGateAccessRule(@Valid @RequestBody GateAccessRuleDTO gateAccessRuleDTO) throws URISyntaxException {
        log.debug("REST request to save GateAccessRule : {}", gateAccessRuleDTO);
        if (gateAccessRuleDTO.getId() != null) {
            throw new BadRequestAlertException("A new gateAccessRule cannot already have an ID", ENTITY_NAME, "idexists");
        }
        GateAccessRuleDTO result = gateAccessRuleService.save(gateAccessRuleDTO);
        return ResponseEntity.created(new URI("/api/gate-access-rules/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /gate-access-rules} : Updates an existing gateAccessRule.
     *
     * @param gateAccessRuleDTO the gateAccessRuleDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated gateAccessRuleDTO,
     * or with status {@code 400 (Bad Request)} if the gateAccessRuleDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the gateAccessRuleDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/gate-access-rules")
    public ResponseEntity<GateAccessRuleDTO> updateGateAccessRule(@Valid @RequestBody GateAccessRuleDTO gateAccessRuleDTO) throws URISyntaxException {
        log.debug("REST request to update GateAccessRule : {}", gateAccessRuleDTO);
        if (gateAccessRuleDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        GateAccessRuleDTO result = gateAccessRuleService.save(gateAccessRuleDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, gateAccessRuleDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /gate-access-rules} : get all the gateAccessRules.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of gateAccessRules in body.
     */
    @GetMapping("/gate-access-rules")
    public ResponseEntity<List<GateAccessRuleDTO>> getAllGateAccessRules(Pageable pageable) {
        log.debug("REST request to get a page of GateAccessRules");
        Page<GateAccessRuleDTO> page = gateAccessRuleService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /gate-access-rules/:id} : get the "id" gateAccessRule.
     *
     * @param id the id of the gateAccessRuleDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the gateAccessRuleDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/gate-access-rules/{id}")
    public ResponseEntity<GateAccessRuleDTO> getGateAccessRule(@PathVariable Long id) {
        log.debug("REST request to get GateAccessRule : {}", id);
        Optional<GateAccessRuleDTO> gateAccessRuleDTO = gateAccessRuleService.findOne(id);
        return ResponseUtil.wrapOrNotFound(gateAccessRuleDTO);
    }

    /**
     * {@code DELETE  /gate-access-rules/:id} : delete the "id" gateAccessRule.
     *
     * @param id the id of the gateAccessRuleDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/gate-access-rules/{id}")
    public ResponseEntity<Void> deleteGateAccessRule(@PathVariable Long id) {
        log.debug("REST request to delete GateAccessRule : {}", id);
        gateAccessRuleService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
