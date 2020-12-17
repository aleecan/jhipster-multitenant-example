package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.AuthorizationGroupService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.AuthorizationGroupDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.AuthorizationGroup}.
 */
@RestController
@RequestMapping("/api")
public class AuthorizationGroupResource {

    private final Logger log = LoggerFactory.getLogger(AuthorizationGroupResource.class);

    private static final String ENTITY_NAME = "authorizationGroup";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AuthorizationGroupService authorizationGroupService;

    public AuthorizationGroupResource(AuthorizationGroupService authorizationGroupService) {
        this.authorizationGroupService = authorizationGroupService;
    }

    /**
     * {@code POST  /authorization-groups} : Create a new authorizationGroup.
     *
     * @param authorizationGroupDTO the authorizationGroupDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new authorizationGroupDTO, or with status {@code 400 (Bad Request)} if the authorizationGroup has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/authorization-groups")
    public ResponseEntity<AuthorizationGroupDTO> createAuthorizationGroup(@Valid @RequestBody AuthorizationGroupDTO authorizationGroupDTO) throws URISyntaxException {
        log.debug("REST request to save AuthorizationGroup : {}", authorizationGroupDTO);
        if (authorizationGroupDTO.getId() != null) {
            throw new BadRequestAlertException("A new authorizationGroup cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AuthorizationGroupDTO result = authorizationGroupService.save(authorizationGroupDTO);
        return ResponseEntity.created(new URI("/api/authorization-groups/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /authorization-groups} : Updates an existing authorizationGroup.
     *
     * @param authorizationGroupDTO the authorizationGroupDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated authorizationGroupDTO,
     * or with status {@code 400 (Bad Request)} if the authorizationGroupDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the authorizationGroupDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/authorization-groups")
    public ResponseEntity<AuthorizationGroupDTO> updateAuthorizationGroup(@Valid @RequestBody AuthorizationGroupDTO authorizationGroupDTO) throws URISyntaxException {
        log.debug("REST request to update AuthorizationGroup : {}", authorizationGroupDTO);
        if (authorizationGroupDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AuthorizationGroupDTO result = authorizationGroupService.save(authorizationGroupDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, authorizationGroupDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /authorization-groups} : get all the authorizationGroups.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of authorizationGroups in body.
     */
    @GetMapping("/authorization-groups")
    public ResponseEntity<List<AuthorizationGroupDTO>> getAllAuthorizationGroups(Pageable pageable) {
        log.debug("REST request to get a page of AuthorizationGroups");
        Page<AuthorizationGroupDTO> page = authorizationGroupService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /authorization-groups/:id} : get the "id" authorizationGroup.
     *
     * @param id the id of the authorizationGroupDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the authorizationGroupDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/authorization-groups/{id}")
    public ResponseEntity<AuthorizationGroupDTO> getAuthorizationGroup(@PathVariable Long id) {
        log.debug("REST request to get AuthorizationGroup : {}", id);
        Optional<AuthorizationGroupDTO> authorizationGroupDTO = authorizationGroupService.findOne(id);
        return ResponseUtil.wrapOrNotFound(authorizationGroupDTO);
    }

    /**
     * {@code DELETE  /authorization-groups/:id} : delete the "id" authorizationGroup.
     *
     * @param id the id of the authorizationGroupDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/authorization-groups/{id}")
    public ResponseEntity<Void> deleteAuthorizationGroup(@PathVariable Long id) {
        log.debug("REST request to delete AuthorizationGroup : {}", id);
        authorizationGroupService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
