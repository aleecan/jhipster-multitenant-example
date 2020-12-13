package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.GateControlService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.GateControlDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.GateControl}.
 */
@RestController
@RequestMapping("/api")
public class GateControlResource {

    private final Logger log = LoggerFactory.getLogger(GateControlResource.class);

    private static final String ENTITY_NAME = "gateControl";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final GateControlService gateControlService;

    public GateControlResource(GateControlService gateControlService) {
        this.gateControlService = gateControlService;
    }

    /**
     * {@code POST  /gate-controls} : Create a new gateControl.
     *
     * @param gateControlDTO the gateControlDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new gateControlDTO, or with status {@code 400 (Bad Request)} if the gateControl has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/gate-controls")
    public ResponseEntity<GateControlDTO> createGateControl(@Valid @RequestBody GateControlDTO gateControlDTO) throws URISyntaxException {
        log.debug("REST request to save GateControl : {}", gateControlDTO);
        if (gateControlDTO.getId() != null) {
            throw new BadRequestAlertException("A new gateControl cannot already have an ID", ENTITY_NAME, "idexists");
        }
        GateControlDTO result = gateControlService.save(gateControlDTO);
        return ResponseEntity.created(new URI("/api/gate-controls/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /gate-controls} : Updates an existing gateControl.
     *
     * @param gateControlDTO the gateControlDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated gateControlDTO,
     * or with status {@code 400 (Bad Request)} if the gateControlDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the gateControlDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/gate-controls")
    public ResponseEntity<GateControlDTO> updateGateControl(@Valid @RequestBody GateControlDTO gateControlDTO) throws URISyntaxException {
        log.debug("REST request to update GateControl : {}", gateControlDTO);
        if (gateControlDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        GateControlDTO result = gateControlService.save(gateControlDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, gateControlDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /gate-controls} : get all the gateControls.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of gateControls in body.
     */
    @GetMapping("/gate-controls")
    public ResponseEntity<List<GateControlDTO>> getAllGateControls(Pageable pageable) {
        log.debug("REST request to get a page of GateControls");
        Page<GateControlDTO> page = gateControlService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /gate-controls/:id} : get the "id" gateControl.
     *
     * @param id the id of the gateControlDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the gateControlDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/gate-controls/{id}")
    public ResponseEntity<GateControlDTO> getGateControl(@PathVariable Long id) {
        log.debug("REST request to get GateControl : {}", id);
        Optional<GateControlDTO> gateControlDTO = gateControlService.findOne(id);
        return ResponseUtil.wrapOrNotFound(gateControlDTO);
    }

    /**
     * {@code DELETE  /gate-controls/:id} : delete the "id" gateControl.
     *
     * @param id the id of the gateControlDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/gate-controls/{id}")
    public ResponseEntity<Void> deleteGateControl(@PathVariable Long id) {
        log.debug("REST request to delete GateControl : {}", id);
        gateControlService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
