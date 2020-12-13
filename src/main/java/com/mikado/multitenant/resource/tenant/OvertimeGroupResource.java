package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.OvertimeGroupService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.OvertimeGroupDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.OvertimeGroup}.
 */
@RestController
@RequestMapping("/api")
public class OvertimeGroupResource {

    private final Logger log = LoggerFactory.getLogger(OvertimeGroupResource.class);

    private static final String ENTITY_NAME = "overtimeGroup";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final OvertimeGroupService overtimeGroupService;

    public OvertimeGroupResource(OvertimeGroupService overtimeGroupService) {
        this.overtimeGroupService = overtimeGroupService;
    }

    /**
     * {@code POST  /overtime-groups} : Create a new overtimeGroup.
     *
     * @param overtimeGroupDTO the overtimeGroupDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new overtimeGroupDTO, or with status {@code 400 (Bad Request)} if the overtimeGroup has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/overtime-groups")
    public ResponseEntity<OvertimeGroupDTO> createOvertimeGroup(@Valid @RequestBody OvertimeGroupDTO overtimeGroupDTO) throws URISyntaxException {
        log.debug("REST request to save OvertimeGroup : {}", overtimeGroupDTO);
        if (overtimeGroupDTO.getId() != null) {
            throw new BadRequestAlertException("A new overtimeGroup cannot already have an ID", ENTITY_NAME, "idexists");
        }
        OvertimeGroupDTO result = overtimeGroupService.save(overtimeGroupDTO);
        return ResponseEntity.created(new URI("/api/overtime-groups/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /overtime-groups} : Updates an existing overtimeGroup.
     *
     * @param overtimeGroupDTO the overtimeGroupDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated overtimeGroupDTO,
     * or with status {@code 400 (Bad Request)} if the overtimeGroupDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the overtimeGroupDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/overtime-groups")
    public ResponseEntity<OvertimeGroupDTO> updateOvertimeGroup(@Valid @RequestBody OvertimeGroupDTO overtimeGroupDTO) throws URISyntaxException {
        log.debug("REST request to update OvertimeGroup : {}", overtimeGroupDTO);
        if (overtimeGroupDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        OvertimeGroupDTO result = overtimeGroupService.save(overtimeGroupDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, overtimeGroupDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /overtime-groups} : get all the overtimeGroups.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of overtimeGroups in body.
     */
    @GetMapping("/overtime-groups")
    public ResponseEntity<List<OvertimeGroupDTO>> getAllOvertimeGroups(Pageable pageable) {
        log.debug("REST request to get a page of OvertimeGroups");
        Page<OvertimeGroupDTO> page = overtimeGroupService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /overtime-groups/:id} : get the "id" overtimeGroup.
     *
     * @param id the id of the overtimeGroupDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the overtimeGroupDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/overtime-groups/{id}")
    public ResponseEntity<OvertimeGroupDTO> getOvertimeGroup(@PathVariable Long id) {
        log.debug("REST request to get OvertimeGroup : {}", id);
        Optional<OvertimeGroupDTO> overtimeGroupDTO = overtimeGroupService.findOne(id);
        return ResponseUtil.wrapOrNotFound(overtimeGroupDTO);
    }

    /**
     * {@code DELETE  /overtime-groups/:id} : delete the "id" overtimeGroup.
     *
     * @param id the id of the overtimeGroupDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/overtime-groups/{id}")
    public ResponseEntity<Void> deleteOvertimeGroup(@PathVariable Long id) {
        log.debug("REST request to delete OvertimeGroup : {}", id);
        overtimeGroupService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
