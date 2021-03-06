package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.UserPermissionService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.UserPermissionDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.UserPermission}.
 */
@RestController
@RequestMapping("/api")
public class UserPermissionResource {

    private final Logger log = LoggerFactory.getLogger(UserPermissionResource.class);

    private static final String ENTITY_NAME = "userPermission";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final UserPermissionService userPermissionService;

    public UserPermissionResource(UserPermissionService userPermissionService) {
        this.userPermissionService = userPermissionService;
    }

    /**
     * {@code POST  /user-permissions} : Create a new userPermission.
     *
     * @param userPermissionDTO the userPermissionDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new userPermissionDTO, or with status {@code 400 (Bad Request)} if the userPermission has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/user-permissions")
    public ResponseEntity<UserPermissionDTO> createUserPermission(@Valid @RequestBody UserPermissionDTO userPermissionDTO) throws URISyntaxException {
        log.debug("REST request to save UserPermission : {}", userPermissionDTO);
        if (userPermissionDTO.getId() != null) {
            throw new BadRequestAlertException("A new userPermission cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UserPermissionDTO result = userPermissionService.save(userPermissionDTO);
        return ResponseEntity.created(new URI("/api/user-permissions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /user-permissions} : Updates an existing userPermission.
     *
     * @param userPermissionDTO the userPermissionDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated userPermissionDTO,
     * or with status {@code 400 (Bad Request)} if the userPermissionDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the userPermissionDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/user-permissions")
    public ResponseEntity<UserPermissionDTO> updateUserPermission(@Valid @RequestBody UserPermissionDTO userPermissionDTO) throws URISyntaxException {
        log.debug("REST request to update UserPermission : {}", userPermissionDTO);
        if (userPermissionDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UserPermissionDTO result = userPermissionService.save(userPermissionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, userPermissionDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /user-permissions} : get all the userPermissions.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of userPermissions in body.
     */
    @GetMapping("/user-permissions")
    public ResponseEntity<List<UserPermissionDTO>> getAllUserPermissions(Pageable pageable) {
        log.debug("REST request to get a page of UserPermissions");
        Page<UserPermissionDTO> page = userPermissionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /user-permissions/:id} : get the "id" userPermission.
     *
     * @param id the id of the userPermissionDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the userPermissionDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/user-permissions/{id}")
    public ResponseEntity<UserPermissionDTO> getUserPermission(@PathVariable Long id) {
        log.debug("REST request to get UserPermission : {}", id);
        Optional<UserPermissionDTO> userPermissionDTO = userPermissionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(userPermissionDTO);
    }

    /**
     * {@code DELETE  /user-permissions/:id} : delete the "id" userPermission.
     *
     * @param id the id of the userPermissionDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/user-permissions/{id}")
    public ResponseEntity<Void> deleteUserPermission(@PathVariable Long id) {
        log.debug("REST request to delete UserPermission : {}", id);
        userPermissionService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
