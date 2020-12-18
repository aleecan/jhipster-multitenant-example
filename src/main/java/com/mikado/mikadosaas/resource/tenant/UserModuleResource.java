package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.UserModuleService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.UserModuleDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.UserModule}.
 */
@RestController
@RequestMapping("/api")
public class UserModuleResource {

    private final Logger log = LoggerFactory.getLogger(UserModuleResource.class);

    private static final String ENTITY_NAME = "userModule";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final UserModuleService userModuleService;

    public UserModuleResource(UserModuleService userModuleService) {
        this.userModuleService = userModuleService;
    }

    /**
     * {@code POST  /user-modules} : Create a new userModule.
     *
     * @param userModuleDTO the userModuleDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new userModuleDTO, or with status {@code 400 (Bad Request)} if the userModule has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/user-modules")
    public ResponseEntity<UserModuleDTO> createUserModule(@Valid @RequestBody UserModuleDTO userModuleDTO) throws URISyntaxException {
        log.debug("REST request to save UserModule : {}", userModuleDTO);
        if (userModuleDTO.getId() != null) {
            throw new BadRequestAlertException("A new userModule cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UserModuleDTO result = userModuleService.save(userModuleDTO);
        return ResponseEntity.created(new URI("/api/user-modules/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /user-modules} : Updates an existing userModule.
     *
     * @param userModuleDTO the userModuleDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated userModuleDTO,
     * or with status {@code 400 (Bad Request)} if the userModuleDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the userModuleDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/user-modules")
    public ResponseEntity<UserModuleDTO> updateUserModule(@Valid @RequestBody UserModuleDTO userModuleDTO) throws URISyntaxException {
        log.debug("REST request to update UserModule : {}", userModuleDTO);
        if (userModuleDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UserModuleDTO result = userModuleService.save(userModuleDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, userModuleDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /user-modules} : get all the userModules.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of userModules in body.
     */
    @GetMapping("/user-modules")
    public ResponseEntity<List<UserModuleDTO>> getAllUserModules(Pageable pageable) {
        log.debug("REST request to get a page of UserModules");
        Page<UserModuleDTO> page = userModuleService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /user-modules/:id} : get the "id" userModule.
     *
     * @param id the id of the userModuleDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the userModuleDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/user-modules/{id}")
    public ResponseEntity<UserModuleDTO> getUserModule(@PathVariable Long id) {
        log.debug("REST request to get UserModule : {}", id);
        Optional<UserModuleDTO> userModuleDTO = userModuleService.findOne(id);
        return ResponseUtil.wrapOrNotFound(userModuleDTO);
    }

    /**
     * {@code DELETE  /user-modules/:id} : delete the "id" userModule.
     *
     * @param id the id of the userModuleDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/user-modules/{id}")
    public ResponseEntity<Void> deleteUserModule(@PathVariable Long id) {
        log.debug("REST request to delete UserModule : {}", id);
        userModuleService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
