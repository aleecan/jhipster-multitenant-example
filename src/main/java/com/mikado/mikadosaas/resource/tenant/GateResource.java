package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.GateService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.GateDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.Gate}.
 */
@RestController
@RequestMapping("/api")
public class GateResource {

    private final Logger log = LoggerFactory.getLogger(GateResource.class);

    private static final String ENTITY_NAME = "gate";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final GateService gateService;

    public GateResource(GateService gateService) {
        this.gateService = gateService;
    }

    /**
     * {@code POST  /gates} : Create a new gate.
     *
     * @param gateDTO the gateDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new gateDTO, or with status {@code 400 (Bad Request)} if the gate has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/gates")
    public ResponseEntity<GateDTO> createGate(@Valid @RequestBody GateDTO gateDTO) throws URISyntaxException {
        log.debug("REST request to save Gate : {}", gateDTO);
        if (gateDTO.getId() != null) {
            throw new BadRequestAlertException("A new gate cannot already have an ID", ENTITY_NAME, "idexists");
        }
        GateDTO result = gateService.save(gateDTO);
        return ResponseEntity.created(new URI("/api/gates/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /gates} : Updates an existing gate.
     *
     * @param gateDTO the gateDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated gateDTO,
     * or with status {@code 400 (Bad Request)} if the gateDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the gateDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/gates")
    public ResponseEntity<GateDTO> updateGate(@Valid @RequestBody GateDTO gateDTO) throws URISyntaxException {
        log.debug("REST request to update Gate : {}", gateDTO);
        if (gateDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        GateDTO result = gateService.save(gateDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, gateDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /gates} : get all the gates.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of gates in body.
     */
    @GetMapping("/gates")
    public ResponseEntity<List<GateDTO>> getAllGates(Pageable pageable) {
        log.debug("REST request to get a page of Gates");
        Page<GateDTO> page = gateService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /gates/:id} : get the "id" gate.
     *
     * @param id the id of the gateDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the gateDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/gates/{id}")
    public ResponseEntity<GateDTO> getGate(@PathVariable Long id) {
        log.debug("REST request to get Gate : {}", id);
        Optional<GateDTO> gateDTO = gateService.findOne(id);
        return ResponseUtil.wrapOrNotFound(gateDTO);
    }

    /**
     * {@code DELETE  /gates/:id} : delete the "id" gate.
     *
     * @param id the id of the gateDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/gates/{id}")
    public ResponseEntity<Void> deleteGate(@PathVariable Long id) {
        log.debug("REST request to delete Gate : {}", id);
        gateService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
