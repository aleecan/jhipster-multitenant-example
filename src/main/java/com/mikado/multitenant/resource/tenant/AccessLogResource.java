package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.AccessLogService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.AccessLogDTO;

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

@RestController
@RequestMapping("/api")
public class AccessLogResource {

    private final Logger log = LoggerFactory.getLogger(AccessLogResource.class);

    private static final String ENTITY_NAME = "accessLog";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AccessLogService accessLogService;

    public AccessLogResource(AccessLogService accessLogService) {
        this.accessLogService = accessLogService;
    }

    /**
     * {@code POST  /access-logs} : Create a new accessLog.
     *
     * @param accessLogDTO the accessLogDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new accessLogDTO, or with status {@code 400 (Bad Request)} if the accessLog has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/access-logs")
    public ResponseEntity<AccessLogDTO> createAccessLog(@Valid @RequestBody AccessLogDTO accessLogDTO) throws URISyntaxException {
        log.debug("REST request to save AccessLog : {}", accessLogDTO);
        if (accessLogDTO.getId() != null) {
            throw new BadRequestAlertException("A new accessLog cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AccessLogDTO result = accessLogService.save(accessLogDTO);
        return ResponseEntity.created(new URI("/api/access-logs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /access-logs} : Updates an existing accessLog.
     *
     * @param accessLogDTO the accessLogDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated accessLogDTO,
     * or with status {@code 400 (Bad Request)} if the accessLogDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the accessLogDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/access-logs")
    public ResponseEntity<AccessLogDTO> updateAccessLog(@Valid @RequestBody AccessLogDTO accessLogDTO) throws URISyntaxException {
        log.debug("REST request to update AccessLog : {}", accessLogDTO);
        if (accessLogDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AccessLogDTO result = accessLogService.save(accessLogDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, accessLogDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /access-logs} : get all the accessLogs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of accessLogs in body.
     */
    @GetMapping("/access-logs")
    public ResponseEntity<List<AccessLogDTO>> getAllAccessLogs(Pageable pageable) {
        log.debug("REST request to get a page of AccessLogs");
        Page<AccessLogDTO> page = accessLogService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /access-logs/:id} : get the "id" accessLog.
     *
     * @param id the id of the accessLogDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the accessLogDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/access-logs/{id}")
    public ResponseEntity<AccessLogDTO> getAccessLog(@PathVariable Long id) {
        log.debug("REST request to get AccessLog : {}", id);
        Optional<AccessLogDTO> accessLogDTO = accessLogService.findOne(id);
        return ResponseUtil.wrapOrNotFound(accessLogDTO);
    }

    /**
     * {@code DELETE  /access-logs/:id} : delete the "id" accessLog.
     *
     * @param id the id of the accessLogDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/access-logs/{id}")
    public ResponseEntity<Void> deleteAccessLog(@PathVariable Long id) {
        log.debug("REST request to delete AccessLog : {}", id);
        accessLogService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
