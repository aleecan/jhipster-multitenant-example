package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.OvertimeReasonService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.OvertimeReasonDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.OvertimeReason}.
 */
@RestController
@RequestMapping("/api")
public class OvertimeReasonResource {

    private final Logger log = LoggerFactory.getLogger(OvertimeReasonResource.class);

    private static final String ENTITY_NAME = "overtimeReason";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final OvertimeReasonService overtimeReasonService;

    public OvertimeReasonResource(OvertimeReasonService overtimeReasonService) {
        this.overtimeReasonService = overtimeReasonService;
    }

    /**
     * {@code POST  /overtime-reasons} : Create a new overtimeReason.
     *
     * @param overtimeReasonDTO the overtimeReasonDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new overtimeReasonDTO, or with status {@code 400 (Bad Request)} if the overtimeReason has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/overtime-reasons")
    public ResponseEntity<OvertimeReasonDTO> createOvertimeReason(@Valid @RequestBody OvertimeReasonDTO overtimeReasonDTO) throws URISyntaxException {
        log.debug("REST request to save OvertimeReason : {}", overtimeReasonDTO);
        if (overtimeReasonDTO.getId() != null) {
            throw new BadRequestAlertException("A new overtimeReason cannot already have an ID", ENTITY_NAME, "idexists");
        }
        OvertimeReasonDTO result = overtimeReasonService.save(overtimeReasonDTO);
        return ResponseEntity.created(new URI("/api/overtime-reasons/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /overtime-reasons} : Updates an existing overtimeReason.
     *
     * @param overtimeReasonDTO the overtimeReasonDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated overtimeReasonDTO,
     * or with status {@code 400 (Bad Request)} if the overtimeReasonDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the overtimeReasonDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/overtime-reasons")
    public ResponseEntity<OvertimeReasonDTO> updateOvertimeReason(@Valid @RequestBody OvertimeReasonDTO overtimeReasonDTO) throws URISyntaxException {
        log.debug("REST request to update OvertimeReason : {}", overtimeReasonDTO);
        if (overtimeReasonDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        OvertimeReasonDTO result = overtimeReasonService.save(overtimeReasonDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, overtimeReasonDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /overtime-reasons} : get all the overtimeReasons.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of overtimeReasons in body.
     */
    @GetMapping("/overtime-reasons")
    public ResponseEntity<List<OvertimeReasonDTO>> getAllOvertimeReasons(Pageable pageable) {
        log.debug("REST request to get a page of OvertimeReasons");
        Page<OvertimeReasonDTO> page = overtimeReasonService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /overtime-reasons/:id} : get the "id" overtimeReason.
     *
     * @param id the id of the overtimeReasonDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the overtimeReasonDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/overtime-reasons/{id}")
    public ResponseEntity<OvertimeReasonDTO> getOvertimeReason(@PathVariable Long id) {
        log.debug("REST request to get OvertimeReason : {}", id);
        Optional<OvertimeReasonDTO> overtimeReasonDTO = overtimeReasonService.findOne(id);
        return ResponseUtil.wrapOrNotFound(overtimeReasonDTO);
    }

    /**
     * {@code DELETE  /overtime-reasons/:id} : delete the "id" overtimeReason.
     *
     * @param id the id of the overtimeReasonDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/overtime-reasons/{id}")
    public ResponseEntity<Void> deleteOvertimeReason(@PathVariable Long id) {
        log.debug("REST request to delete OvertimeReason : {}", id);
        overtimeReasonService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
