package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.PrivateCodeService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.PrivateCodeDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.PrivateCode}.
 */
@RestController
@RequestMapping("/api")
public class PrivateCodeResource {

    private final Logger log = LoggerFactory.getLogger(PrivateCodeResource.class);

    private static final String ENTITY_NAME = "privateCode";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PrivateCodeService privateCodeService;

    public PrivateCodeResource(PrivateCodeService privateCodeService) {
        this.privateCodeService = privateCodeService;
    }

    /**
     * {@code POST  /private-codes} : Create a new privateCode.
     *
     * @param privateCodeDTO the privateCodeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new privateCodeDTO, or with status {@code 400 (Bad Request)} if the privateCode has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/private-codes")
    public ResponseEntity<PrivateCodeDTO> createPrivateCode(@Valid @RequestBody PrivateCodeDTO privateCodeDTO) throws URISyntaxException {
        log.debug("REST request to save PrivateCode : {}", privateCodeDTO);
        if (privateCodeDTO.getId() != null) {
            throw new BadRequestAlertException("A new privateCode cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PrivateCodeDTO result = privateCodeService.save(privateCodeDTO);
        return ResponseEntity.created(new URI("/api/private-codes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /private-codes} : Updates an existing privateCode.
     *
     * @param privateCodeDTO the privateCodeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated privateCodeDTO,
     * or with status {@code 400 (Bad Request)} if the privateCodeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the privateCodeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/private-codes")
    public ResponseEntity<PrivateCodeDTO> updatePrivateCode(@Valid @RequestBody PrivateCodeDTO privateCodeDTO) throws URISyntaxException {
        log.debug("REST request to update PrivateCode : {}", privateCodeDTO);
        if (privateCodeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PrivateCodeDTO result = privateCodeService.save(privateCodeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, privateCodeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /private-codes} : get all the privateCodes.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of privateCodes in body.
     */
    @GetMapping("/private-codes")
    public ResponseEntity<List<PrivateCodeDTO>> getAllPrivateCodes(Pageable pageable) {
        log.debug("REST request to get a page of PrivateCodes");
        Page<PrivateCodeDTO> page = privateCodeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /private-codes/:id} : get the "id" privateCode.
     *
     * @param id the id of the privateCodeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the privateCodeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/private-codes/{id}")
    public ResponseEntity<PrivateCodeDTO> getPrivateCode(@PathVariable Long id) {
        log.debug("REST request to get PrivateCode : {}", id);
        Optional<PrivateCodeDTO> privateCodeDTO = privateCodeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(privateCodeDTO);
    }

    /**
     * {@code DELETE  /private-codes/:id} : delete the "id" privateCode.
     *
     * @param id the id of the privateCodeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/private-codes/{id}")
    public ResponseEntity<Void> deletePrivateCode(@PathVariable Long id) {
        log.debug("REST request to delete PrivateCode : {}", id);
        privateCodeService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
