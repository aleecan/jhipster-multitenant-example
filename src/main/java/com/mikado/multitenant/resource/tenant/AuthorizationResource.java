package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.AuthorizationService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.AuthorizationDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.Authorization}.
 */
@RestController
@RequestMapping("/api")
public class AuthorizationResource {

    private final Logger log = LoggerFactory.getLogger(AuthorizationResource.class);

    private static final String ENTITY_NAME = "authorization";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AuthorizationService authorizationService;

    public AuthorizationResource(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    /**
     * {@code POST  /authorizations} : Create a new authorization.
     *
     * @param authorizationDTO the authorizationDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new authorizationDTO, or with status {@code 400 (Bad Request)} if the authorization has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/authorizations")
    public ResponseEntity<AuthorizationDTO> createAuthorization(@Valid @RequestBody AuthorizationDTO authorizationDTO) throws URISyntaxException {
        log.debug("REST request to save Authorization : {}", authorizationDTO);
        if (authorizationDTO.getId() != null) {
            throw new BadRequestAlertException("A new authorization cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AuthorizationDTO result = authorizationService.save(authorizationDTO);
        return ResponseEntity.created(new URI("/api/authorizations/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /authorizations} : Updates an existing authorization.
     *
     * @param authorizationDTO the authorizationDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated authorizationDTO,
     * or with status {@code 400 (Bad Request)} if the authorizationDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the authorizationDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/authorizations")
    public ResponseEntity<AuthorizationDTO> updateAuthorization(@Valid @RequestBody AuthorizationDTO authorizationDTO) throws URISyntaxException {
        log.debug("REST request to update Authorization : {}", authorizationDTO);
        if (authorizationDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AuthorizationDTO result = authorizationService.save(authorizationDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, authorizationDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /authorizations} : get all the authorizations.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of authorizations in body.
     */
    @GetMapping("/authorizations")
    public ResponseEntity<List<AuthorizationDTO>> getAllAuthorizations(Pageable pageable) {
        log.debug("REST request to get a page of Authorizations");
        Page<AuthorizationDTO> page = authorizationService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /authorizations/:id} : get the "id" authorization.
     *
     * @param id the id of the authorizationDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the authorizationDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/authorizations/{id}")
    public ResponseEntity<AuthorizationDTO> getAuthorization(@PathVariable Long id) {
        log.debug("REST request to get Authorization : {}", id);
        Optional<AuthorizationDTO> authorizationDTO = authorizationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(authorizationDTO);
    }

    /**
     * {@code DELETE  /authorizations/:id} : delete the "id" authorization.
     *
     * @param id the id of the authorizationDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/authorizations/{id}")
    public ResponseEntity<Void> deleteAuthorization(@PathVariable Long id) {
        log.debug("REST request to delete Authorization : {}", id);
        authorizationService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
