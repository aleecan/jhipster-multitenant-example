package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.AdditionalService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.AdditionalDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.Additional}.
 */
@RestController
@RequestMapping("/api")
public class AdditionalResource {

    private final Logger log = LoggerFactory.getLogger(AdditionalResource.class);

    private static final String ENTITY_NAME = "additional";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AdditionalService additionalService;

    public AdditionalResource(AdditionalService additionalService) {
        this.additionalService = additionalService;
    }

    /**
     * {@code POST  /additionals} : Create a new additional.
     *
     * @param additionalDTO the additionalDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new additionalDTO, or with status {@code 400 (Bad Request)} if the additional has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/additionals")
    public ResponseEntity<AdditionalDTO> createAdditional(@Valid @RequestBody AdditionalDTO additionalDTO) throws URISyntaxException {
        log.debug("REST request to save Additional : {}", additionalDTO);
        if (additionalDTO.getId() != null) {
            throw new BadRequestAlertException("A new additional cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AdditionalDTO result = additionalService.save(additionalDTO);
        return ResponseEntity.created(new URI("/api/additionals/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /additionals} : Updates an existing additional.
     *
     * @param additionalDTO the additionalDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated additionalDTO,
     * or with status {@code 400 (Bad Request)} if the additionalDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the additionalDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/additionals")
    public ResponseEntity<AdditionalDTO> updateAdditional(@Valid @RequestBody AdditionalDTO additionalDTO) throws URISyntaxException {
        log.debug("REST request to update Additional : {}", additionalDTO);
        if (additionalDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AdditionalDTO result = additionalService.save(additionalDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, additionalDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /additionals} : get all the additionals.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of additionals in body.
     */
    @GetMapping("/additionals")
    public ResponseEntity<List<AdditionalDTO>> getAllAdditionals(Pageable pageable) {
        log.debug("REST request to get a page of Additionals");
        Page<AdditionalDTO> page = additionalService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /additionals/:id} : get the "id" additional.
     *
     * @param id the id of the additionalDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the additionalDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/additionals/{id}")
    public ResponseEntity<AdditionalDTO> getAdditional(@PathVariable Long id) {
        log.debug("REST request to get Additional : {}", id);
        Optional<AdditionalDTO> additionalDTO = additionalService.findOne(id);
        return ResponseUtil.wrapOrNotFound(additionalDTO);
    }

    /**
     * {@code DELETE  /additionals/:id} : delete the "id" additional.
     *
     * @param id the id of the additionalDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/additionals/{id}")
    public ResponseEntity<Void> deleteAdditional(@PathVariable Long id) {
        log.debug("REST request to delete Additional : {}", id);
        additionalService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
