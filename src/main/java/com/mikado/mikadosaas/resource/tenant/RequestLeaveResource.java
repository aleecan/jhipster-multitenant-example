package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.RequestLeaveService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.RequestLeaveDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.RequestLeave}.
 */
@RestController
@RequestMapping("/api")
public class RequestLeaveResource {

    private final Logger log = LoggerFactory.getLogger(RequestLeaveResource.class);

    private static final String ENTITY_NAME = "requestLeave";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final RequestLeaveService requestLeaveService;

    public RequestLeaveResource(RequestLeaveService requestLeaveService) {
        this.requestLeaveService = requestLeaveService;
    }

    /**
     * {@code POST  /request-leaves} : Create a new requestLeave.
     *
     * @param requestLeaveDTO the requestLeaveDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new requestLeaveDTO, or with status {@code 400 (Bad Request)} if the requestLeave has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/request-leaves")
    public ResponseEntity<RequestLeaveDTO> createRequestLeave(@Valid @RequestBody RequestLeaveDTO requestLeaveDTO) throws URISyntaxException {
        log.debug("REST request to save RequestLeave : {}", requestLeaveDTO);
        if (requestLeaveDTO.getId() != null) {
            throw new BadRequestAlertException("A new requestLeave cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RequestLeaveDTO result = requestLeaveService.save(requestLeaveDTO);
        return ResponseEntity.created(new URI("/api/request-leaves/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /request-leaves} : Updates an existing requestLeave.
     *
     * @param requestLeaveDTO the requestLeaveDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated requestLeaveDTO,
     * or with status {@code 400 (Bad Request)} if the requestLeaveDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the requestLeaveDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/request-leaves")
    public ResponseEntity<RequestLeaveDTO> updateRequestLeave(@Valid @RequestBody RequestLeaveDTO requestLeaveDTO) throws URISyntaxException {
        log.debug("REST request to update RequestLeave : {}", requestLeaveDTO);
        if (requestLeaveDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        RequestLeaveDTO result = requestLeaveService.save(requestLeaveDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, requestLeaveDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /request-leaves} : get all the requestLeaves.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of requestLeaves in body.
     */
    @GetMapping("/request-leaves")
    public ResponseEntity<List<RequestLeaveDTO>> getAllRequestLeaves(Pageable pageable) {
        log.debug("REST request to get a page of RequestLeaves");
        Page<RequestLeaveDTO> page = requestLeaveService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /request-leaves/:id} : get the "id" requestLeave.
     *
     * @param id the id of the requestLeaveDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the requestLeaveDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/request-leaves/{id}")
    public ResponseEntity<RequestLeaveDTO> getRequestLeave(@PathVariable Long id) {
        log.debug("REST request to get RequestLeave : {}", id);
        Optional<RequestLeaveDTO> requestLeaveDTO = requestLeaveService.findOne(id);
        return ResponseUtil.wrapOrNotFound(requestLeaveDTO);
    }

    /**
     * {@code DELETE  /request-leaves/:id} : delete the "id" requestLeave.
     *
     * @param id the id of the requestLeaveDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/request-leaves/{id}")
    public ResponseEntity<Void> deleteRequestLeave(@PathVariable Long id) {
        log.debug("REST request to delete RequestLeave : {}", id);
        requestLeaveService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
