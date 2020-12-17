package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.AdditionalGroupService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.AdditionalGroupDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.AdditionalGroup}.
 */
@RestController
@RequestMapping("/api")
public class AdditionalGroupResource {

    private final Logger log = LoggerFactory.getLogger(AdditionalGroupResource.class);

    private static final String ENTITY_NAME = "additionalGroup";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AdditionalGroupService additionalGroupService;

    public AdditionalGroupResource(AdditionalGroupService additionalGroupService) {
        this.additionalGroupService = additionalGroupService;
    }

    /**
     * {@code POST  /additional-groups} : Create a new additionalGroup.
     *
     * @param additionalGroupDTO the additionalGroupDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new additionalGroupDTO, or with status {@code 400 (Bad Request)} if the additionalGroup has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/additional-groups")
    public ResponseEntity<AdditionalGroupDTO> createAdditionalGroup(@Valid @RequestBody AdditionalGroupDTO additionalGroupDTO) throws URISyntaxException {
        log.debug("REST request to save AdditionalGroup : {}", additionalGroupDTO);
        if (additionalGroupDTO.getId() != null) {
            throw new BadRequestAlertException("A new additionalGroup cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AdditionalGroupDTO result = additionalGroupService.save(additionalGroupDTO);
        return ResponseEntity.created(new URI("/api/additional-groups/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /additional-groups} : Updates an existing additionalGroup.
     *
     * @param additionalGroupDTO the additionalGroupDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated additionalGroupDTO,
     * or with status {@code 400 (Bad Request)} if the additionalGroupDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the additionalGroupDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/additional-groups")
    public ResponseEntity<AdditionalGroupDTO> updateAdditionalGroup(@Valid @RequestBody AdditionalGroupDTO additionalGroupDTO) throws URISyntaxException {
        log.debug("REST request to update AdditionalGroup : {}", additionalGroupDTO);
        if (additionalGroupDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AdditionalGroupDTO result = additionalGroupService.save(additionalGroupDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, additionalGroupDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /additional-groups} : get all the additionalGroups.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of additionalGroups in body.
     */
    @GetMapping("/additional-groups")
    public ResponseEntity<List<AdditionalGroupDTO>> getAllAdditionalGroups(Pageable pageable) {
        log.debug("REST request to get a page of AdditionalGroups");
        Page<AdditionalGroupDTO> page = additionalGroupService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /additional-groups/:id} : get the "id" additionalGroup.
     *
     * @param id the id of the additionalGroupDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the additionalGroupDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/additional-groups/{id}")
    public ResponseEntity<AdditionalGroupDTO> getAdditionalGroup(@PathVariable Long id) {
        log.debug("REST request to get AdditionalGroup : {}", id);
        Optional<AdditionalGroupDTO> additionalGroupDTO = additionalGroupService.findOne(id);
        return ResponseUtil.wrapOrNotFound(additionalGroupDTO);
    }

    /**
     * {@code DELETE  /additional-groups/:id} : delete the "id" additionalGroup.
     *
     * @param id the id of the additionalGroupDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/additional-groups/{id}")
    public ResponseEntity<Void> deleteAdditionalGroup(@PathVariable Long id) {
        log.debug("REST request to delete AdditionalGroup : {}", id);
        additionalGroupService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
