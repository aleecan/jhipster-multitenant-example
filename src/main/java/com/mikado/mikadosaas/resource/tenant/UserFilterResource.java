package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.UserFilterService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.UserFilterDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.UserFilter}.
 */
@RestController
@RequestMapping("/api")
public class UserFilterResource {

    private final Logger log = LoggerFactory.getLogger(UserFilterResource.class);

    private static final String ENTITY_NAME = "userFilter";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final UserFilterService userFilterService;

    public UserFilterResource(UserFilterService userFilterService) {
        this.userFilterService = userFilterService;
    }

    /**
     * {@code POST  /user-filters} : Create a new userFilter.
     *
     * @param userFilterDTO the userFilterDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new userFilterDTO, or with status {@code 400 (Bad Request)} if the userFilter has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/user-filters")
    public ResponseEntity<UserFilterDTO> createUserFilter(@Valid @RequestBody UserFilterDTO userFilterDTO) throws URISyntaxException {
        log.debug("REST request to save UserFilter : {}", userFilterDTO);
        if (userFilterDTO.getId() != null) {
            throw new BadRequestAlertException("A new userFilter cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UserFilterDTO result = userFilterService.save(userFilterDTO);
        return ResponseEntity.created(new URI("/api/user-filters/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /user-filters} : Updates an existing userFilter.
     *
     * @param userFilterDTO the userFilterDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated userFilterDTO,
     * or with status {@code 400 (Bad Request)} if the userFilterDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the userFilterDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/user-filters")
    public ResponseEntity<UserFilterDTO> updateUserFilter(@Valid @RequestBody UserFilterDTO userFilterDTO) throws URISyntaxException {
        log.debug("REST request to update UserFilter : {}", userFilterDTO);
        if (userFilterDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UserFilterDTO result = userFilterService.save(userFilterDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, userFilterDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /user-filters} : get all the userFilters.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of userFilters in body.
     */
    @GetMapping("/user-filters")
    public ResponseEntity<List<UserFilterDTO>> getAllUserFilters(Pageable pageable) {
        log.debug("REST request to get a page of UserFilters");
        Page<UserFilterDTO> page = userFilterService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /user-filters/:id} : get the "id" userFilter.
     *
     * @param id the id of the userFilterDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the userFilterDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/user-filters/{id}")
    public ResponseEntity<UserFilterDTO> getUserFilter(@PathVariable Long id) {
        log.debug("REST request to get UserFilter : {}", id);
        Optional<UserFilterDTO> userFilterDTO = userFilterService.findOne(id);
        return ResponseUtil.wrapOrNotFound(userFilterDTO);
    }

    /**
     * {@code DELETE  /user-filters/:id} : delete the "id" userFilter.
     *
     * @param id the id of the userFilterDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/user-filters/{id}")
    public ResponseEntity<Void> deleteUserFilter(@PathVariable Long id) {
        log.debug("REST request to delete UserFilter : {}", id);
        userFilterService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
