package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.QuotaTypeService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.QuotaTypeDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.QuotaType}.
 */
@RestController
@RequestMapping("/api")
public class QuotaTypeResource {

    private final Logger log = LoggerFactory.getLogger(QuotaTypeResource.class);

    private static final String ENTITY_NAME = "quotaType";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final QuotaTypeService quotaTypeService;

    public QuotaTypeResource(QuotaTypeService quotaTypeService) {
        this.quotaTypeService = quotaTypeService;
    }

    /**
     * {@code POST  /quota-types} : Create a new quotaType.
     *
     * @param quotaTypeDTO the quotaTypeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new quotaTypeDTO, or with status {@code 400 (Bad Request)} if the quotaType has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/quota-types")
    public ResponseEntity<QuotaTypeDTO> createQuotaType(@Valid @RequestBody QuotaTypeDTO quotaTypeDTO) throws URISyntaxException {
        log.debug("REST request to save QuotaType : {}", quotaTypeDTO);
        if (quotaTypeDTO.getId() != null) {
            throw new BadRequestAlertException("A new quotaType cannot already have an ID", ENTITY_NAME, "idexists");
        }
        QuotaTypeDTO result = quotaTypeService.save(quotaTypeDTO);
        return ResponseEntity.created(new URI("/api/quota-types/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /quota-types} : Updates an existing quotaType.
     *
     * @param quotaTypeDTO the quotaTypeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated quotaTypeDTO,
     * or with status {@code 400 (Bad Request)} if the quotaTypeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the quotaTypeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/quota-types")
    public ResponseEntity<QuotaTypeDTO> updateQuotaType(@Valid @RequestBody QuotaTypeDTO quotaTypeDTO) throws URISyntaxException {
        log.debug("REST request to update QuotaType : {}", quotaTypeDTO);
        if (quotaTypeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        QuotaTypeDTO result = quotaTypeService.save(quotaTypeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, quotaTypeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /quota-types} : get all the quotaTypes.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of quotaTypes in body.
     */
    @GetMapping("/quota-types")
    public ResponseEntity<List<QuotaTypeDTO>> getAllQuotaTypes(Pageable pageable) {
        log.debug("REST request to get a page of QuotaTypes");
        Page<QuotaTypeDTO> page = quotaTypeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /quota-types/:id} : get the "id" quotaType.
     *
     * @param id the id of the quotaTypeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the quotaTypeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/quota-types/{id}")
    public ResponseEntity<QuotaTypeDTO> getQuotaType(@PathVariable Long id) {
        log.debug("REST request to get QuotaType : {}", id);
        Optional<QuotaTypeDTO> quotaTypeDTO = quotaTypeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(quotaTypeDTO);
    }

    /**
     * {@code DELETE  /quota-types/:id} : delete the "id" quotaType.
     *
     * @param id the id of the quotaTypeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/quota-types/{id}")
    public ResponseEntity<Void> deleteQuotaType(@PathVariable Long id) {
        log.debug("REST request to delete QuotaType : {}", id);
        quotaTypeService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
