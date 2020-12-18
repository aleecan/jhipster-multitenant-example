package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.RequestOvertimeService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.RequestOvertimeDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.RequestOvertime}.
 */
@RestController
@RequestMapping("/api")
public class RequestOvertimeResource {

    private final Logger log = LoggerFactory.getLogger(RequestOvertimeResource.class);

    private static final String ENTITY_NAME = "requestOvertime";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final RequestOvertimeService requestOvertimeService;

    public RequestOvertimeResource(RequestOvertimeService requestOvertimeService) {
        this.requestOvertimeService = requestOvertimeService;
    }

    /**
     * {@code POST  /request-overtimes} : Create a new requestOvertime.
     *
     * @param requestOvertimeDTO the requestOvertimeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new requestOvertimeDTO, or with status {@code 400 (Bad Request)} if the requestOvertime has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/request-overtimes")
    public ResponseEntity<RequestOvertimeDTO> createRequestOvertime(@Valid @RequestBody RequestOvertimeDTO requestOvertimeDTO) throws URISyntaxException {
        log.debug("REST request to save RequestOvertime : {}", requestOvertimeDTO);
        if (requestOvertimeDTO.getId() != null) {
            throw new BadRequestAlertException("A new requestOvertime cannot already have an ID", ENTITY_NAME, "idexists");
        }
        RequestOvertimeDTO result = requestOvertimeService.save(requestOvertimeDTO);
        return ResponseEntity.created(new URI("/api/request-overtimes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /request-overtimes} : Updates an existing requestOvertime.
     *
     * @param requestOvertimeDTO the requestOvertimeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated requestOvertimeDTO,
     * or with status {@code 400 (Bad Request)} if the requestOvertimeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the requestOvertimeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/request-overtimes")
    public ResponseEntity<RequestOvertimeDTO> updateRequestOvertime(@Valid @RequestBody RequestOvertimeDTO requestOvertimeDTO) throws URISyntaxException {
        log.debug("REST request to update RequestOvertime : {}", requestOvertimeDTO);
        if (requestOvertimeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        RequestOvertimeDTO result = requestOvertimeService.save(requestOvertimeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, requestOvertimeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /request-overtimes} : get all the requestOvertimes.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of requestOvertimes in body.
     */
    @GetMapping("/request-overtimes")
    public ResponseEntity<List<RequestOvertimeDTO>> getAllRequestOvertimes(Pageable pageable) {
        log.debug("REST request to get a page of RequestOvertimes");
        Page<RequestOvertimeDTO> page = requestOvertimeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /request-overtimes/:id} : get the "id" requestOvertime.
     *
     * @param id the id of the requestOvertimeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the requestOvertimeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/request-overtimes/{id}")
    public ResponseEntity<RequestOvertimeDTO> getRequestOvertime(@PathVariable Long id) {
        log.debug("REST request to get RequestOvertime : {}", id);
        Optional<RequestOvertimeDTO> requestOvertimeDTO = requestOvertimeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(requestOvertimeDTO);
    }

    /**
     * {@code DELETE  /request-overtimes/:id} : delete the "id" requestOvertime.
     *
     * @param id the id of the requestOvertimeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/request-overtimes/{id}")
    public ResponseEntity<Void> deleteRequestOvertime(@PathVariable Long id) {
        log.debug("REST request to delete RequestOvertime : {}", id);
        requestOvertimeService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
