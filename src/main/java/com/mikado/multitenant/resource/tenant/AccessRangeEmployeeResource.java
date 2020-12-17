package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.AccessRangeEmployeeService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.AccessRangeEmployeeDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.AccessRangeEmployee}.
 */
@RestController
@RequestMapping("/api")
public class AccessRangeEmployeeResource {

    private final Logger log = LoggerFactory.getLogger(AccessRangeEmployeeResource.class);

    private static final String ENTITY_NAME = "accessRangeEmployee";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AccessRangeEmployeeService accessRangeEmployeeService;

    public AccessRangeEmployeeResource(AccessRangeEmployeeService accessRangeEmployeeService) {
        this.accessRangeEmployeeService = accessRangeEmployeeService;
    }

    /**
     * {@code POST  /access-range-employees} : Create a new accessRangeEmployee.
     *
     * @param accessRangeEmployeeDTO the accessRangeEmployeeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new accessRangeEmployeeDTO, or with status {@code 400 (Bad Request)} if the accessRangeEmployee has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/access-range-employees")
    public ResponseEntity<AccessRangeEmployeeDTO> createAccessRangeEmployee(@Valid @RequestBody AccessRangeEmployeeDTO accessRangeEmployeeDTO) throws URISyntaxException {
        log.debug("REST request to save AccessRangeEmployee : {}", accessRangeEmployeeDTO);
        if (accessRangeEmployeeDTO.getId() != null) {
            throw new BadRequestAlertException("A new accessRangeEmployee cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AccessRangeEmployeeDTO result = accessRangeEmployeeService.save(accessRangeEmployeeDTO);
        return ResponseEntity.created(new URI("/api/access-range-employees/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /access-range-employees} : Updates an existing accessRangeEmployee.
     *
     * @param accessRangeEmployeeDTO the accessRangeEmployeeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated accessRangeEmployeeDTO,
     * or with status {@code 400 (Bad Request)} if the accessRangeEmployeeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the accessRangeEmployeeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/access-range-employees")
    public ResponseEntity<AccessRangeEmployeeDTO> updateAccessRangeEmployee(@Valid @RequestBody AccessRangeEmployeeDTO accessRangeEmployeeDTO) throws URISyntaxException {
        log.debug("REST request to update AccessRangeEmployee : {}", accessRangeEmployeeDTO);
        if (accessRangeEmployeeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AccessRangeEmployeeDTO result = accessRangeEmployeeService.save(accessRangeEmployeeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, accessRangeEmployeeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /access-range-employees} : get all the accessRangeEmployees.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of accessRangeEmployees in body.
     */
    @GetMapping("/access-range-employees")
    public ResponseEntity<List<AccessRangeEmployeeDTO>> getAllAccessRangeEmployees(Pageable pageable) {
        log.debug("REST request to get a page of AccessRangeEmployees");
        Page<AccessRangeEmployeeDTO> page = accessRangeEmployeeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /access-range-employees/:id} : get the "id" accessRangeEmployee.
     *
     * @param id the id of the accessRangeEmployeeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the accessRangeEmployeeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/access-range-employees/{id}")
    public ResponseEntity<AccessRangeEmployeeDTO> getAccessRangeEmployee(@PathVariable Long id) {
        log.debug("REST request to get AccessRangeEmployee : {}", id);
        Optional<AccessRangeEmployeeDTO> accessRangeEmployeeDTO = accessRangeEmployeeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(accessRangeEmployeeDTO);
    }

    /**
     * {@code DELETE  /access-range-employees/:id} : delete the "id" accessRangeEmployee.
     *
     * @param id the id of the accessRangeEmployeeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/access-range-employees/{id}")
    public ResponseEntity<Void> deleteAccessRangeEmployee(@PathVariable Long id) {
        log.debug("REST request to delete AccessRangeEmployee : {}", id);
        accessRangeEmployeeService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
