package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.GateTerminalService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.GateTerminalDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.GateTerminal}.
 */
@RestController
@RequestMapping("/api")
public class GateTerminalResource {

    private final Logger log = LoggerFactory.getLogger(GateTerminalResource.class);

    private static final String ENTITY_NAME = "gateTerminal";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final GateTerminalService gateTerminalService;

    public GateTerminalResource(GateTerminalService gateTerminalService) {
        this.gateTerminalService = gateTerminalService;
    }

    /**
     * {@code POST  /gate-terminals} : Create a new gateTerminal.
     *
     * @param gateTerminalDTO the gateTerminalDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new gateTerminalDTO, or with status {@code 400 (Bad Request)} if the gateTerminal has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/gate-terminals")
    public ResponseEntity<GateTerminalDTO> createGateTerminal(@Valid @RequestBody GateTerminalDTO gateTerminalDTO) throws URISyntaxException {
        log.debug("REST request to save GateTerminal : {}", gateTerminalDTO);
        if (gateTerminalDTO.getId() != null) {
            throw new BadRequestAlertException("A new gateTerminal cannot already have an ID", ENTITY_NAME, "idexists");
        }
        GateTerminalDTO result = gateTerminalService.save(gateTerminalDTO);
        return ResponseEntity.created(new URI("/api/gate-terminals/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /gate-terminals} : Updates an existing gateTerminal.
     *
     * @param gateTerminalDTO the gateTerminalDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated gateTerminalDTO,
     * or with status {@code 400 (Bad Request)} if the gateTerminalDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the gateTerminalDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/gate-terminals")
    public ResponseEntity<GateTerminalDTO> updateGateTerminal(@Valid @RequestBody GateTerminalDTO gateTerminalDTO) throws URISyntaxException {
        log.debug("REST request to update GateTerminal : {}", gateTerminalDTO);
        if (gateTerminalDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        GateTerminalDTO result = gateTerminalService.save(gateTerminalDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, gateTerminalDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /gate-terminals} : get all the gateTerminals.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of gateTerminals in body.
     */
    @GetMapping("/gate-terminals")
    public ResponseEntity<List<GateTerminalDTO>> getAllGateTerminals(Pageable pageable) {
        log.debug("REST request to get a page of GateTerminals");
        Page<GateTerminalDTO> page = gateTerminalService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /gate-terminals/:id} : get the "id" gateTerminal.
     *
     * @param id the id of the gateTerminalDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the gateTerminalDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/gate-terminals/{id}")
    public ResponseEntity<GateTerminalDTO> getGateTerminal(@PathVariable Long id) {
        log.debug("REST request to get GateTerminal : {}", id);
        Optional<GateTerminalDTO> gateTerminalDTO = gateTerminalService.findOne(id);
        return ResponseUtil.wrapOrNotFound(gateTerminalDTO);
    }

    /**
     * {@code DELETE  /gate-terminals/:id} : delete the "id" gateTerminal.
     *
     * @param id the id of the gateTerminalDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/gate-terminals/{id}")
    public ResponseEntity<Void> deleteGateTerminal(@PathVariable Long id) {
        log.debug("REST request to delete GateTerminal : {}", id);
        gateTerminalService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
