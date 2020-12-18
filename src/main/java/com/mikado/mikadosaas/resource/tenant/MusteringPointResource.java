package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.MusteringPointService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.MusteringPointDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.MusteringPoint}.
 */
@RestController
@RequestMapping("/api")
public class MusteringPointResource {

    private final Logger log = LoggerFactory.getLogger(MusteringPointResource.class);

    private static final String ENTITY_NAME = "musteringPoint";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MusteringPointService musteringPointService;

    public MusteringPointResource(MusteringPointService musteringPointService) {
        this.musteringPointService = musteringPointService;
    }

    /**
     * {@code POST  /mustering-points} : Create a new musteringPoint.
     *
     * @param musteringPointDTO the musteringPointDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new musteringPointDTO, or with status {@code 400 (Bad Request)} if the musteringPoint has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/mustering-points")
    public ResponseEntity<MusteringPointDTO> createMusteringPoint(@Valid @RequestBody MusteringPointDTO musteringPointDTO) throws URISyntaxException {
        log.debug("REST request to save MusteringPoint : {}", musteringPointDTO);
        if (musteringPointDTO.getId() != null) {
            throw new BadRequestAlertException("A new musteringPoint cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MusteringPointDTO result = musteringPointService.save(musteringPointDTO);
        return ResponseEntity.created(new URI("/api/mustering-points/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /mustering-points} : Updates an existing musteringPoint.
     *
     * @param musteringPointDTO the musteringPointDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated musteringPointDTO,
     * or with status {@code 400 (Bad Request)} if the musteringPointDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the musteringPointDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/mustering-points")
    public ResponseEntity<MusteringPointDTO> updateMusteringPoint(@Valid @RequestBody MusteringPointDTO musteringPointDTO) throws URISyntaxException {
        log.debug("REST request to update MusteringPoint : {}", musteringPointDTO);
        if (musteringPointDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MusteringPointDTO result = musteringPointService.save(musteringPointDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, musteringPointDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /mustering-points} : get all the musteringPoints.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of musteringPoints in body.
     */
    @GetMapping("/mustering-points")
    public ResponseEntity<List<MusteringPointDTO>> getAllMusteringPoints(Pageable pageable) {
        log.debug("REST request to get a page of MusteringPoints");
        Page<MusteringPointDTO> page = musteringPointService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /mustering-points/:id} : get the "id" musteringPoint.
     *
     * @param id the id of the musteringPointDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the musteringPointDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/mustering-points/{id}")
    public ResponseEntity<MusteringPointDTO> getMusteringPoint(@PathVariable Long id) {
        log.debug("REST request to get MusteringPoint : {}", id);
        Optional<MusteringPointDTO> musteringPointDTO = musteringPointService.findOne(id);
        return ResponseUtil.wrapOrNotFound(musteringPointDTO);
    }

    /**
     * {@code DELETE  /mustering-points/:id} : delete the "id" musteringPoint.
     *
     * @param id the id of the musteringPointDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/mustering-points/{id}")
    public ResponseEntity<Void> deleteMusteringPoint(@PathVariable Long id) {
        log.debug("REST request to delete MusteringPoint : {}", id);
        musteringPointService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
