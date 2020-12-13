package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.VisitReasonService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.VisitReasonDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.VisitReason}.
 */
@RestController
@RequestMapping("/api")
public class VisitReasonResource {

    private final Logger log = LoggerFactory.getLogger(VisitReasonResource.class);

    private static final String ENTITY_NAME = "visitReason";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final VisitReasonService visitReasonService;

    public VisitReasonResource(VisitReasonService visitReasonService) {
        this.visitReasonService = visitReasonService;
    }

    /**
     * {@code POST  /visit-reasons} : Create a new visitReason.
     *
     * @param visitReasonDTO the visitReasonDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new visitReasonDTO, or with status {@code 400 (Bad Request)} if the visitReason has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/visit-reasons")
    public ResponseEntity<VisitReasonDTO> createVisitReason(@Valid @RequestBody VisitReasonDTO visitReasonDTO) throws URISyntaxException {
        log.debug("REST request to save VisitReason : {}", visitReasonDTO);
        if (visitReasonDTO.getId() != null) {
            throw new BadRequestAlertException("A new visitReason cannot already have an ID", ENTITY_NAME, "idexists");
        }
        VisitReasonDTO result = visitReasonService.save(visitReasonDTO);
        return ResponseEntity.created(new URI("/api/visit-reasons/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /visit-reasons} : Updates an existing visitReason.
     *
     * @param visitReasonDTO the visitReasonDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated visitReasonDTO,
     * or with status {@code 400 (Bad Request)} if the visitReasonDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the visitReasonDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/visit-reasons")
    public ResponseEntity<VisitReasonDTO> updateVisitReason(@Valid @RequestBody VisitReasonDTO visitReasonDTO) throws URISyntaxException {
        log.debug("REST request to update VisitReason : {}", visitReasonDTO);
        if (visitReasonDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        VisitReasonDTO result = visitReasonService.save(visitReasonDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, visitReasonDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /visit-reasons} : get all the visitReasons.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of visitReasons in body.
     */
    @GetMapping("/visit-reasons")
    public ResponseEntity<List<VisitReasonDTO>> getAllVisitReasons(Pageable pageable) {
        log.debug("REST request to get a page of VisitReasons");
        Page<VisitReasonDTO> page = visitReasonService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /visit-reasons/:id} : get the "id" visitReason.
     *
     * @param id the id of the visitReasonDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the visitReasonDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/visit-reasons/{id}")
    public ResponseEntity<VisitReasonDTO> getVisitReason(@PathVariable Long id) {
        log.debug("REST request to get VisitReason : {}", id);
        Optional<VisitReasonDTO> visitReasonDTO = visitReasonService.findOne(id);
        return ResponseUtil.wrapOrNotFound(visitReasonDTO);
    }

    /**
     * {@code DELETE  /visit-reasons/:id} : delete the "id" visitReason.
     *
     * @param id the id of the visitReasonDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/visit-reasons/{id}")
    public ResponseEntity<Void> deleteVisitReason(@PathVariable Long id) {
        log.debug("REST request to delete VisitReason : {}", id);
        visitReasonService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
