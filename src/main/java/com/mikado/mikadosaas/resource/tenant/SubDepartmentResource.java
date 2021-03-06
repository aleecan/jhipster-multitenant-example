package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.SubDepartmentService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.SubDepartmentDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.SubDepartment}.
 */
@RestController
@RequestMapping("/api")
public class SubDepartmentResource {

    private final Logger log = LoggerFactory.getLogger(SubDepartmentResource.class);

    private static final String ENTITY_NAME = "subDepartment";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SubDepartmentService subDepartmentService;

    public SubDepartmentResource(SubDepartmentService subDepartmentService) {
        this.subDepartmentService = subDepartmentService;
    }

    /**
     * {@code POST  /sub-departments} : Create a new subDepartment.
     *
     * @param subDepartmentDTO the subDepartmentDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new subDepartmentDTO, or with status {@code 400 (Bad Request)} if the subDepartment has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/sub-departments")
    public ResponseEntity<SubDepartmentDTO> createSubDepartment(@Valid @RequestBody SubDepartmentDTO subDepartmentDTO) throws URISyntaxException {
        log.debug("REST request to save SubDepartment : {}", subDepartmentDTO);
        if (subDepartmentDTO.getId() != null) {
            throw new BadRequestAlertException("A new subDepartment cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SubDepartmentDTO result = subDepartmentService.save(subDepartmentDTO);
        return ResponseEntity.created(new URI("/api/sub-departments/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /sub-departments} : Updates an existing subDepartment.
     *
     * @param subDepartmentDTO the subDepartmentDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated subDepartmentDTO,
     * or with status {@code 400 (Bad Request)} if the subDepartmentDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the subDepartmentDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/sub-departments")
    public ResponseEntity<SubDepartmentDTO> updateSubDepartment(@Valid @RequestBody SubDepartmentDTO subDepartmentDTO) throws URISyntaxException {
        log.debug("REST request to update SubDepartment : {}", subDepartmentDTO);
        if (subDepartmentDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SubDepartmentDTO result = subDepartmentService.save(subDepartmentDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, subDepartmentDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /sub-departments} : get all the subDepartments.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of subDepartments in body.
     */
    @GetMapping("/sub-departments")
    public ResponseEntity<List<SubDepartmentDTO>> getAllSubDepartments(Pageable pageable) {
        log.debug("REST request to get a page of SubDepartments");
        Page<SubDepartmentDTO> page = subDepartmentService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /sub-departments/:id} : get the "id" subDepartment.
     *
     * @param id the id of the subDepartmentDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the subDepartmentDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/sub-departments/{id}")
    public ResponseEntity<SubDepartmentDTO> getSubDepartment(@PathVariable Long id) {
        log.debug("REST request to get SubDepartment : {}", id);
        Optional<SubDepartmentDTO> subDepartmentDTO = subDepartmentService.findOne(id);
        return ResponseUtil.wrapOrNotFound(subDepartmentDTO);
    }

    /**
     * {@code DELETE  /sub-departments/:id} : delete the "id" subDepartment.
     *
     * @param id the id of the subDepartmentDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/sub-departments/{id}")
    public ResponseEntity<Void> deleteSubDepartment(@PathVariable Long id) {
        log.debug("REST request to delete SubDepartment : {}", id);
        subDepartmentService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
