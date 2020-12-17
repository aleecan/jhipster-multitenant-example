package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.NormalGroupService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.NormalGroupDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.NormalGroup}.
 */
@RestController
@RequestMapping("/api")
public class NormalGroupResource {

    private final Logger log = LoggerFactory.getLogger(NormalGroupResource.class);

    private static final String ENTITY_NAME = "normalGroup";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final NormalGroupService normalGroupService;

    public NormalGroupResource(NormalGroupService normalGroupService) {
        this.normalGroupService = normalGroupService;
    }

    /**
     * {@code POST  /normal-groups} : Create a new normalGroup.
     *
     * @param normalGroupDTO the normalGroupDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new normalGroupDTO, or with status {@code 400 (Bad Request)} if the normalGroup has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/normal-groups")
    public ResponseEntity<NormalGroupDTO> createNormalGroup(@Valid @RequestBody NormalGroupDTO normalGroupDTO) throws URISyntaxException {
        log.debug("REST request to save NormalGroup : {}", normalGroupDTO);
        if (normalGroupDTO.getId() != null) {
            throw new BadRequestAlertException("A new normalGroup cannot already have an ID", ENTITY_NAME, "idexists");
        }
        NormalGroupDTO result = normalGroupService.save(normalGroupDTO);
        return ResponseEntity.created(new URI("/api/normal-groups/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /normal-groups} : Updates an existing normalGroup.
     *
     * @param normalGroupDTO the normalGroupDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated normalGroupDTO,
     * or with status {@code 400 (Bad Request)} if the normalGroupDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the normalGroupDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/normal-groups")
    public ResponseEntity<NormalGroupDTO> updateNormalGroup(@Valid @RequestBody NormalGroupDTO normalGroupDTO) throws URISyntaxException {
        log.debug("REST request to update NormalGroup : {}", normalGroupDTO);
        if (normalGroupDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        NormalGroupDTO result = normalGroupService.save(normalGroupDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, normalGroupDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /normal-groups} : get all the normalGroups.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of normalGroups in body.
     */
    @GetMapping("/normal-groups")
    public ResponseEntity<List<NormalGroupDTO>> getAllNormalGroups(Pageable pageable) {
        log.debug("REST request to get a page of NormalGroups");
        Page<NormalGroupDTO> page = normalGroupService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /normal-groups/:id} : get the "id" normalGroup.
     *
     * @param id the id of the normalGroupDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the normalGroupDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/normal-groups/{id}")
    public ResponseEntity<NormalGroupDTO> getNormalGroup(@PathVariable Long id) {
        log.debug("REST request to get NormalGroup : {}", id);
        Optional<NormalGroupDTO> normalGroupDTO = normalGroupService.findOne(id);
        return ResponseUtil.wrapOrNotFound(normalGroupDTO);
    }

    /**
     * {@code DELETE  /normal-groups/:id} : delete the "id" normalGroup.
     *
     * @param id the id of the normalGroupDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/normal-groups/{id}")
    public ResponseEntity<Void> deleteNormalGroup(@PathVariable Long id) {
        log.debug("REST request to delete NormalGroup : {}", id);
        normalGroupService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
