package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.AccessControlService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.AccessControlDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.AccessControl}.
 */
@RestController
@RequestMapping("/api")
public class AccessControlResource {

    private final Logger log = LoggerFactory.getLogger(AccessControlResource.class);

    private static final String ENTITY_NAME = "accessControl";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AccessControlService accessControlService;

    public AccessControlResource(AccessControlService accessControlService) {
        this.accessControlService = accessControlService;
    }

    /**
     * {@code POST  /access-controls} : Create a new accessControl.
     *
     * @param accessControlDTO the accessControlDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new accessControlDTO, or with status {@code 400 (Bad Request)} if the accessControl has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/access-controls")
    public ResponseEntity<AccessControlDTO> createAccessControl(@Valid @RequestBody AccessControlDTO accessControlDTO) throws URISyntaxException {
        log.debug("REST request to save AccessControl : {}", accessControlDTO);
        if (accessControlDTO.getId() != null) {
            throw new BadRequestAlertException("A new accessControl cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AccessControlDTO result = accessControlService.save(accessControlDTO);
        return ResponseEntity.created(new URI("/api/access-controls/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /access-controls} : Updates an existing accessControl.
     *
     * @param accessControlDTO the accessControlDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated accessControlDTO,
     * or with status {@code 400 (Bad Request)} if the accessControlDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the accessControlDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/access-controls")
    public ResponseEntity<AccessControlDTO> updateAccessControl(@Valid @RequestBody AccessControlDTO accessControlDTO) throws URISyntaxException {
        log.debug("REST request to update AccessControl : {}", accessControlDTO);
        if (accessControlDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AccessControlDTO result = accessControlService.save(accessControlDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, accessControlDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /access-controls} : get all the accessControls.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of accessControls in body.
     */
    @GetMapping("/access-controls")
    public ResponseEntity<List<AccessControlDTO>> getAllAccessControls(Pageable pageable) {
        log.debug("REST request to get a page of AccessControls");
        Page<AccessControlDTO> page = accessControlService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /access-controls/:id} : get the "id" accessControl.
     *
     * @param id the id of the accessControlDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the accessControlDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/access-controls/{id}")
    public ResponseEntity<AccessControlDTO> getAccessControl(@PathVariable Long id) {
        log.debug("REST request to get AccessControl : {}", id);
        Optional<AccessControlDTO> accessControlDTO = accessControlService.findOne(id);
        return ResponseUtil.wrapOrNotFound(accessControlDTO);
    }

    /**
     * {@code DELETE  /access-controls/:id} : delete the "id" accessControl.
     *
     * @param id the id of the accessControlDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/access-controls/{id}")
    public ResponseEntity<Void> deleteAccessControl(@PathVariable Long id) {
        log.debug("REST request to delete AccessControl : {}", id);
        accessControlService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
