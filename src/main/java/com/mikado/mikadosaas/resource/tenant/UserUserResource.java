package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.UserUserService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.UserUserDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.UserUser}.
 */
@RestController
@RequestMapping("/api")
public class UserUserResource {

    private final Logger log = LoggerFactory.getLogger(UserUserResource.class);

    private static final String ENTITY_NAME = "userUser";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final UserUserService userUserService;

    public UserUserResource(UserUserService userUserService) {
        this.userUserService = userUserService;
    }

    /**
     * {@code POST  /user-users} : Create a new userUser.
     *
     * @param userUserDTO the userUserDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new userUserDTO, or with status {@code 400 (Bad Request)} if the userUser has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/user-users")
    public ResponseEntity<UserUserDTO> createUserUser(@Valid @RequestBody UserUserDTO userUserDTO) throws URISyntaxException {
        log.debug("REST request to save UserUser : {}", userUserDTO);
        if (userUserDTO.getId() != null) {
            throw new BadRequestAlertException("A new userUser cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UserUserDTO result = userUserService.save(userUserDTO);
        return ResponseEntity.created(new URI("/api/user-users/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /user-users} : Updates an existing userUser.
     *
     * @param userUserDTO the userUserDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated userUserDTO,
     * or with status {@code 400 (Bad Request)} if the userUserDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the userUserDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/user-users")
    public ResponseEntity<UserUserDTO> updateUserUser(@Valid @RequestBody UserUserDTO userUserDTO) throws URISyntaxException {
        log.debug("REST request to update UserUser : {}", userUserDTO);
        if (userUserDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UserUserDTO result = userUserService.save(userUserDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, userUserDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /user-users} : get all the userUsers.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of userUsers in body.
     */
    @GetMapping("/user-users")
    public ResponseEntity<List<UserUserDTO>> getAllUserUsers(Pageable pageable) {
        log.debug("REST request to get a page of UserUsers");
        Page<UserUserDTO> page = userUserService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /user-users/:id} : get the "id" userUser.
     *
     * @param id the id of the userUserDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the userUserDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/user-users/{id}")
    public ResponseEntity<UserUserDTO> getUserUser(@PathVariable Long id) {
        log.debug("REST request to get UserUser : {}", id);
        Optional<UserUserDTO> userUserDTO = userUserService.findOne(id);
        return ResponseUtil.wrapOrNotFound(userUserDTO);
    }

    /**
     * {@code DELETE  /user-users/:id} : delete the "id" userUser.
     *
     * @param id the id of the userUserDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/user-users/{id}")
    public ResponseEntity<Void> deleteUserUser(@PathVariable Long id) {
        log.debug("REST request to delete UserUser : {}", id);
        userUserService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
