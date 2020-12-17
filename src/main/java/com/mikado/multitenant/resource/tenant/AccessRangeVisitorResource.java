package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.AccessRangeVisitorService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.AccessRangeVisitorDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.AccessRangeVisitor}.
 */
@RestController
@RequestMapping("/api")
public class AccessRangeVisitorResource {

    private final Logger log = LoggerFactory.getLogger(AccessRangeVisitorResource.class);

    private static final String ENTITY_NAME = "accessRangeVisitor";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AccessRangeVisitorService accessRangeVisitorService;

    public AccessRangeVisitorResource(AccessRangeVisitorService accessRangeVisitorService) {
        this.accessRangeVisitorService = accessRangeVisitorService;
    }

    /**
     * {@code POST  /access-range-visitors} : Create a new accessRangeVisitor.
     *
     * @param accessRangeVisitorDTO the accessRangeVisitorDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new accessRangeVisitorDTO, or with status {@code 400 (Bad Request)} if the accessRangeVisitor has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/access-range-visitors")
    public ResponseEntity<AccessRangeVisitorDTO> createAccessRangeVisitor(@Valid @RequestBody AccessRangeVisitorDTO accessRangeVisitorDTO) throws URISyntaxException {
        log.debug("REST request to save AccessRangeVisitor : {}", accessRangeVisitorDTO);
        if (accessRangeVisitorDTO.getId() != null) {
            throw new BadRequestAlertException("A new accessRangeVisitor cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AccessRangeVisitorDTO result = accessRangeVisitorService.save(accessRangeVisitorDTO);
        return ResponseEntity.created(new URI("/api/access-range-visitors/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /access-range-visitors} : Updates an existing accessRangeVisitor.
     *
     * @param accessRangeVisitorDTO the accessRangeVisitorDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated accessRangeVisitorDTO,
     * or with status {@code 400 (Bad Request)} if the accessRangeVisitorDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the accessRangeVisitorDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/access-range-visitors")
    public ResponseEntity<AccessRangeVisitorDTO> updateAccessRangeVisitor(@Valid @RequestBody AccessRangeVisitorDTO accessRangeVisitorDTO) throws URISyntaxException {
        log.debug("REST request to update AccessRangeVisitor : {}", accessRangeVisitorDTO);
        if (accessRangeVisitorDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AccessRangeVisitorDTO result = accessRangeVisitorService.save(accessRangeVisitorDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, accessRangeVisitorDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /access-range-visitors} : get all the accessRangeVisitors.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of accessRangeVisitors in body.
     */
    @GetMapping("/access-range-visitors")
    public ResponseEntity<List<AccessRangeVisitorDTO>> getAllAccessRangeVisitors(Pageable pageable) {
        log.debug("REST request to get a page of AccessRangeVisitors");
        Page<AccessRangeVisitorDTO> page = accessRangeVisitorService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /access-range-visitors/:id} : get the "id" accessRangeVisitor.
     *
     * @param id the id of the accessRangeVisitorDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the accessRangeVisitorDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/access-range-visitors/{id}")
    public ResponseEntity<AccessRangeVisitorDTO> getAccessRangeVisitor(@PathVariable Long id) {
        log.debug("REST request to get AccessRangeVisitor : {}", id);
        Optional<AccessRangeVisitorDTO> accessRangeVisitorDTO = accessRangeVisitorService.findOne(id);
        return ResponseUtil.wrapOrNotFound(accessRangeVisitorDTO);
    }

    /**
     * {@code DELETE  /access-range-visitors/:id} : delete the "id" accessRangeVisitor.
     *
     * @param id the id of the accessRangeVisitorDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/access-range-visitors/{id}")
    public ResponseEntity<Void> deleteAccessRangeVisitor(@PathVariable Long id) {
        log.debug("REST request to delete AccessRangeVisitor : {}", id);
        accessRangeVisitorService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
