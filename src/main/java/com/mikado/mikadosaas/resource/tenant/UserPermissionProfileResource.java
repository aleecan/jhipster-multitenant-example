package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.UserPermissionProfileService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.UserPermissionProfileDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.UserPermissionProfile}.
 */
@RestController
@RequestMapping("/api")
public class UserPermissionProfileResource {

    private final Logger log = LoggerFactory.getLogger(UserPermissionProfileResource.class);

    private static final String ENTITY_NAME = "userPermissionProfile";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final UserPermissionProfileService userPermissionProfileService;

    public UserPermissionProfileResource(UserPermissionProfileService userPermissionProfileService) {
        this.userPermissionProfileService = userPermissionProfileService;
    }

    /**
     * {@code POST  /user-permission-profiles} : Create a new userPermissionProfile.
     *
     * @param userPermissionProfileDTO the userPermissionProfileDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new userPermissionProfileDTO, or with status {@code 400 (Bad Request)} if the userPermissionProfile has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/user-permission-profiles")
    public ResponseEntity<UserPermissionProfileDTO> createUserPermissionProfile(@Valid @RequestBody UserPermissionProfileDTO userPermissionProfileDTO) throws URISyntaxException {
        log.debug("REST request to save UserPermissionProfile : {}", userPermissionProfileDTO);
        if (userPermissionProfileDTO.getId() != null) {
            throw new BadRequestAlertException("A new userPermissionProfile cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UserPermissionProfileDTO result = userPermissionProfileService.save(userPermissionProfileDTO);
        return ResponseEntity.created(new URI("/api/user-permission-profiles/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /user-permission-profiles} : Updates an existing userPermissionProfile.
     *
     * @param userPermissionProfileDTO the userPermissionProfileDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated userPermissionProfileDTO,
     * or with status {@code 400 (Bad Request)} if the userPermissionProfileDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the userPermissionProfileDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/user-permission-profiles")
    public ResponseEntity<UserPermissionProfileDTO> updateUserPermissionProfile(@Valid @RequestBody UserPermissionProfileDTO userPermissionProfileDTO) throws URISyntaxException {
        log.debug("REST request to update UserPermissionProfile : {}", userPermissionProfileDTO);
        if (userPermissionProfileDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UserPermissionProfileDTO result = userPermissionProfileService.save(userPermissionProfileDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, userPermissionProfileDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /user-permission-profiles} : get all the userPermissionProfiles.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of userPermissionProfiles in body.
     */
    @GetMapping("/user-permission-profiles")
    public ResponseEntity<List<UserPermissionProfileDTO>> getAllUserPermissionProfiles(Pageable pageable) {
        log.debug("REST request to get a page of UserPermissionProfiles");
        Page<UserPermissionProfileDTO> page = userPermissionProfileService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /user-permission-profiles/:id} : get the "id" userPermissionProfile.
     *
     * @param id the id of the userPermissionProfileDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the userPermissionProfileDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/user-permission-profiles/{id}")
    public ResponseEntity<UserPermissionProfileDTO> getUserPermissionProfile(@PathVariable Long id) {
        log.debug("REST request to get UserPermissionProfile : {}", id);
        Optional<UserPermissionProfileDTO> userPermissionProfileDTO = userPermissionProfileService.findOne(id);
        return ResponseUtil.wrapOrNotFound(userPermissionProfileDTO);
    }

    /**
     * {@code DELETE  /user-permission-profiles/:id} : delete the "id" userPermissionProfile.
     *
     * @param id the id of the userPermissionProfileDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/user-permission-profiles/{id}")
    public ResponseEntity<Void> deleteUserPermissionProfile(@PathVariable Long id) {
        log.debug("REST request to delete UserPermissionProfile : {}", id);
        userPermissionProfileService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
