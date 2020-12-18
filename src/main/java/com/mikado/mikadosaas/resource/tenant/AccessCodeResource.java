package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.AccessCodeService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.AccessCodeDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.AccessCode}.
 */
@RestController
@RequestMapping("/api")
public class AccessCodeResource {

    private final Logger log = LoggerFactory.getLogger(AccessCodeResource.class);

    private static final String ENTITY_NAME = "accessCode";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AccessCodeService accessCodeService;

    public AccessCodeResource(AccessCodeService accessCodeService) {
        this.accessCodeService = accessCodeService;
    }

    /**
     * {@code POST  /access-codes} : Create a new accessCode.
     *
     * @param accessCodeDTO the accessCodeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new accessCodeDTO, or with status {@code 400 (Bad Request)} if the accessCode has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/access-codes")
    public ResponseEntity<AccessCodeDTO> createAccessCode(@Valid @RequestBody AccessCodeDTO accessCodeDTO) throws URISyntaxException {
        log.debug("REST request to save AccessCode : {}", accessCodeDTO);
        if (accessCodeDTO.getId() != null) {
            throw new BadRequestAlertException("A new accessCode cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AccessCodeDTO result = accessCodeService.save(accessCodeDTO);
        return ResponseEntity.created(new URI("/api/access-codes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /access-codes} : Updates an existing accessCode.
     *
     * @param accessCodeDTO the accessCodeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated accessCodeDTO,
     * or with status {@code 400 (Bad Request)} if the accessCodeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the accessCodeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/access-codes")
    public ResponseEntity<AccessCodeDTO> updateAccessCode(@Valid @RequestBody AccessCodeDTO accessCodeDTO) throws URISyntaxException {
        log.debug("REST request to update AccessCode : {}", accessCodeDTO);
        if (accessCodeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AccessCodeDTO result = accessCodeService.save(accessCodeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, accessCodeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /access-codes} : get all the accessCodes.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of accessCodes in body.
     */
    @GetMapping("/access-codes")
    public ResponseEntity<List<AccessCodeDTO>> getAllAccessCodes(Pageable pageable) {
        log.debug("REST request to get a page of AccessCodes");
        Page<AccessCodeDTO> page = accessCodeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /access-codes/:id} : get the "id" accessCode.
     *
     * @param id the id of the accessCodeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the accessCodeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/access-codes/{id}")
    public ResponseEntity<AccessCodeDTO> getAccessCode(@PathVariable Long id) {
        log.debug("REST request to get AccessCode : {}", id);
        Optional<AccessCodeDTO> accessCodeDTO = accessCodeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(accessCodeDTO);
    }

    /**
     * {@code DELETE  /access-codes/:id} : delete the "id" accessCode.
     *
     * @param id the id of the accessCodeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/access-codes/{id}")
    public ResponseEntity<Void> deleteAccessCode(@PathVariable Long id) {
        log.debug("REST request to delete AccessCode : {}", id);
        accessCodeService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
