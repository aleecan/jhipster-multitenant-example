package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.EmployeeHistoryService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.EmployeeHistoryDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.EmployeeHistory}.
 */
@RestController
@RequestMapping("/api")
public class EmployeeHistoryResource {

    private final Logger log = LoggerFactory.getLogger(EmployeeHistoryResource.class);

    private static final String ENTITY_NAME = "employeeHistory";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EmployeeHistoryService employeeHistoryService;

    public EmployeeHistoryResource(EmployeeHistoryService employeeHistoryService) {
        this.employeeHistoryService = employeeHistoryService;
    }

    /**
     * {@code POST  /employee-histories} : Create a new employeeHistory.
     *
     * @param employeeHistoryDTO the employeeHistoryDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new employeeHistoryDTO, or with status {@code 400 (Bad Request)} if the employeeHistory has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/employee-histories")
    public ResponseEntity<EmployeeHistoryDTO> createEmployeeHistory(@Valid @RequestBody EmployeeHistoryDTO employeeHistoryDTO) throws URISyntaxException {
        log.debug("REST request to save EmployeeHistory : {}", employeeHistoryDTO);
        if (employeeHistoryDTO.getId() != null) {
            throw new BadRequestAlertException("A new employeeHistory cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmployeeHistoryDTO result = employeeHistoryService.save(employeeHistoryDTO);
        return ResponseEntity.created(new URI("/api/employee-histories/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /employee-histories} : Updates an existing employeeHistory.
     *
     * @param employeeHistoryDTO the employeeHistoryDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated employeeHistoryDTO,
     * or with status {@code 400 (Bad Request)} if the employeeHistoryDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the employeeHistoryDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/employee-histories")
    public ResponseEntity<EmployeeHistoryDTO> updateEmployeeHistory(@Valid @RequestBody EmployeeHistoryDTO employeeHistoryDTO) throws URISyntaxException {
        log.debug("REST request to update EmployeeHistory : {}", employeeHistoryDTO);
        if (employeeHistoryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        EmployeeHistoryDTO result = employeeHistoryService.save(employeeHistoryDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, employeeHistoryDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /employee-histories} : get all the employeeHistories.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of employeeHistories in body.
     */
    @GetMapping("/employee-histories")
    public ResponseEntity<List<EmployeeHistoryDTO>> getAllEmployeeHistories(Pageable pageable) {
        log.debug("REST request to get a page of EmployeeHistories");
        Page<EmployeeHistoryDTO> page = employeeHistoryService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /employee-histories/:id} : get the "id" employeeHistory.
     *
     * @param id the id of the employeeHistoryDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the employeeHistoryDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/employee-histories/{id}")
    public ResponseEntity<EmployeeHistoryDTO> getEmployeeHistory(@PathVariable Long id) {
        log.debug("REST request to get EmployeeHistory : {}", id);
        Optional<EmployeeHistoryDTO> employeeHistoryDTO = employeeHistoryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(employeeHistoryDTO);
    }

    /**
     * {@code DELETE  /employee-histories/:id} : delete the "id" employeeHistory.
     *
     * @param id the id of the employeeHistoryDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/employee-histories/{id}")
    public ResponseEntity<Void> deleteEmployeeHistory(@PathVariable Long id) {
        log.debug("REST request to delete EmployeeHistory : {}", id);
        employeeHistoryService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
