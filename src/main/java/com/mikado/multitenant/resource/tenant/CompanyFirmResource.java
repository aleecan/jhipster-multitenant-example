package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.CompanyFirmService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.CompanyFirmDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.CompanyFirm}.
 */
@RestController
@RequestMapping("/api")
public class CompanyFirmResource {

    private final Logger log = LoggerFactory.getLogger(CompanyFirmResource.class);

    private static final String ENTITY_NAME = "companyFirm";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CompanyFirmService companyFirmService;

    public CompanyFirmResource(CompanyFirmService companyFirmService) {
        this.companyFirmService = companyFirmService;
    }

    /**
     * {@code POST  /company-firms} : Create a new companyFirm.
     *
     * @param companyFirmDTO the companyFirmDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new companyFirmDTO, or with status {@code 400 (Bad Request)} if the companyFirm has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/company-firms")
    public ResponseEntity<CompanyFirmDTO> createCompanyFirm(@Valid @RequestBody CompanyFirmDTO companyFirmDTO) throws URISyntaxException {
        log.debug("REST request to save CompanyFirm : {}", companyFirmDTO);
        if (companyFirmDTO.getId() != null) {
            throw new BadRequestAlertException("A new companyFirm cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CompanyFirmDTO result = companyFirmService.save(companyFirmDTO);
        return ResponseEntity.created(new URI("/api/company-firms/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /company-firms} : Updates an existing companyFirm.
     *
     * @param companyFirmDTO the companyFirmDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated companyFirmDTO,
     * or with status {@code 400 (Bad Request)} if the companyFirmDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the companyFirmDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/company-firms")
    public ResponseEntity<CompanyFirmDTO> updateCompanyFirm(@Valid @RequestBody CompanyFirmDTO companyFirmDTO) throws URISyntaxException {
        log.debug("REST request to update CompanyFirm : {}", companyFirmDTO);
        if (companyFirmDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CompanyFirmDTO result = companyFirmService.save(companyFirmDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, companyFirmDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /company-firms} : get all the companyFirms.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of companyFirms in body.
     */
    @GetMapping("/company-firms")
    public ResponseEntity<List<CompanyFirmDTO>> getAllCompanyFirms(Pageable pageable) {
        log.debug("REST request to get a page of CompanyFirms");
        Page<CompanyFirmDTO> page = companyFirmService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /company-firms/:id} : get the "id" companyFirm.
     *
     * @param id the id of the companyFirmDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the companyFirmDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/company-firms/{id}")
    public ResponseEntity<CompanyFirmDTO> getCompanyFirm(@PathVariable Long id) {
        log.debug("REST request to get CompanyFirm : {}", id);
        Optional<CompanyFirmDTO> companyFirmDTO = companyFirmService.findOne(id);
        return ResponseUtil.wrapOrNotFound(companyFirmDTO);
    }

    /**
     * {@code DELETE  /company-firms/:id} : delete the "id" companyFirm.
     *
     * @param id the id of the companyFirmDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/company-firms/{id}")
    public ResponseEntity<Void> deleteCompanyFirm(@PathVariable Long id) {
        log.debug("REST request to delete CompanyFirm : {}", id);
        companyFirmService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
