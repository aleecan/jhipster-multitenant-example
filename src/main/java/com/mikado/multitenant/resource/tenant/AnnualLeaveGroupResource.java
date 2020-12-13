package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.AnnualLeaveGroupService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.AnnualLeaveGroupDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.AnnualLeaveGroup}.
 */
@RestController
@RequestMapping("/api")
public class AnnualLeaveGroupResource {

    private final Logger log = LoggerFactory.getLogger(AnnualLeaveGroupResource.class);

    private static final String ENTITY_NAME = "annualLeaveGroup";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AnnualLeaveGroupService annualLeaveGroupService;

    public AnnualLeaveGroupResource(AnnualLeaveGroupService annualLeaveGroupService) {
        this.annualLeaveGroupService = annualLeaveGroupService;
    }

    /**
     * {@code POST  /annual-leave-groups} : Create a new annualLeaveGroup.
     *
     * @param annualLeaveGroupDTO the annualLeaveGroupDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new annualLeaveGroupDTO, or with status {@code 400 (Bad Request)} if the annualLeaveGroup has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/annual-leave-groups")
    public ResponseEntity<AnnualLeaveGroupDTO> createAnnualLeaveGroup(@Valid @RequestBody AnnualLeaveGroupDTO annualLeaveGroupDTO) throws URISyntaxException {
        log.debug("REST request to save AnnualLeaveGroup : {}", annualLeaveGroupDTO);
        if (annualLeaveGroupDTO.getId() != null) {
            throw new BadRequestAlertException("A new annualLeaveGroup cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AnnualLeaveGroupDTO result = annualLeaveGroupService.save(annualLeaveGroupDTO);
        return ResponseEntity.created(new URI("/api/annual-leave-groups/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /annual-leave-groups} : Updates an existing annualLeaveGroup.
     *
     * @param annualLeaveGroupDTO the annualLeaveGroupDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated annualLeaveGroupDTO,
     * or with status {@code 400 (Bad Request)} if the annualLeaveGroupDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the annualLeaveGroupDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/annual-leave-groups")
    public ResponseEntity<AnnualLeaveGroupDTO> updateAnnualLeaveGroup(@Valid @RequestBody AnnualLeaveGroupDTO annualLeaveGroupDTO) throws URISyntaxException {
        log.debug("REST request to update AnnualLeaveGroup : {}", annualLeaveGroupDTO);
        if (annualLeaveGroupDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AnnualLeaveGroupDTO result = annualLeaveGroupService.save(annualLeaveGroupDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, annualLeaveGroupDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /annual-leave-groups} : get all the annualLeaveGroups.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of annualLeaveGroups in body.
     */
    @GetMapping("/annual-leave-groups")
    public ResponseEntity<List<AnnualLeaveGroupDTO>> getAllAnnualLeaveGroups(Pageable pageable) {
        log.debug("REST request to get a page of AnnualLeaveGroups");
        Page<AnnualLeaveGroupDTO> page = annualLeaveGroupService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /annual-leave-groups/:id} : get the "id" annualLeaveGroup.
     *
     * @param id the id of the annualLeaveGroupDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the annualLeaveGroupDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/annual-leave-groups/{id}")
    public ResponseEntity<AnnualLeaveGroupDTO> getAnnualLeaveGroup(@PathVariable Long id) {
        log.debug("REST request to get AnnualLeaveGroup : {}", id);
        Optional<AnnualLeaveGroupDTO> annualLeaveGroupDTO = annualLeaveGroupService.findOne(id);
        return ResponseUtil.wrapOrNotFound(annualLeaveGroupDTO);
    }

    /**
     * {@code DELETE  /annual-leave-groups/:id} : delete the "id" annualLeaveGroup.
     *
     * @param id the id of the annualLeaveGroupDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/annual-leave-groups/{id}")
    public ResponseEntity<Void> deleteAnnualLeaveGroup(@PathVariable Long id) {
        log.debug("REST request to delete AnnualLeaveGroup : {}", id);
        annualLeaveGroupService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
