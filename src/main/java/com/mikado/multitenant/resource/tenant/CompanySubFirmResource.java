package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.CompanySubFirmService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.CompanySubFirmDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.CompanySubFirm}.
 */
@RestController
@RequestMapping("/api")
public class CompanySubFirmResource {

    private final Logger log = LoggerFactory.getLogger(CompanySubFirmResource.class);

    private static final String ENTITY_NAME = "companySubFirm";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CompanySubFirmService companySubFirmService;

    public CompanySubFirmResource(CompanySubFirmService companySubFirmService) {
        this.companySubFirmService = companySubFirmService;
    }

    /**
     * {@code POST  /company-sub-firms} : Create a new companySubFirm.
     *
     * @param companySubFirmDTO the companySubFirmDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new companySubFirmDTO, or with status {@code 400 (Bad Request)} if the companySubFirm has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/company-sub-firms")
    public ResponseEntity<CompanySubFirmDTO> createCompanySubFirm(@Valid @RequestBody CompanySubFirmDTO companySubFirmDTO) throws URISyntaxException {
        log.debug("REST request to save CompanySubFirm : {}", companySubFirmDTO);
        if (companySubFirmDTO.getId() != null) {
            throw new BadRequestAlertException("A new companySubFirm cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CompanySubFirmDTO result = companySubFirmService.save(companySubFirmDTO);
        return ResponseEntity.created(new URI("/api/company-sub-firms/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /company-sub-firms} : Updates an existing companySubFirm.
     *
     * @param companySubFirmDTO the companySubFirmDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated companySubFirmDTO,
     * or with status {@code 400 (Bad Request)} if the companySubFirmDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the companySubFirmDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/company-sub-firms")
    public ResponseEntity<CompanySubFirmDTO> updateCompanySubFirm(@Valid @RequestBody CompanySubFirmDTO companySubFirmDTO) throws URISyntaxException {
        log.debug("REST request to update CompanySubFirm : {}", companySubFirmDTO);
        if (companySubFirmDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CompanySubFirmDTO result = companySubFirmService.save(companySubFirmDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, companySubFirmDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /company-sub-firms} : get all the companySubFirms.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of companySubFirms in body.
     */
    @GetMapping("/company-sub-firms")
    public ResponseEntity<List<CompanySubFirmDTO>> getAllCompanySubFirms(Pageable pageable) {
        log.debug("REST request to get a page of CompanySubFirms");
        Page<CompanySubFirmDTO> page = companySubFirmService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /company-sub-firms/:id} : get the "id" companySubFirm.
     *
     * @param id the id of the companySubFirmDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the companySubFirmDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/company-sub-firms/{id}")
    public ResponseEntity<CompanySubFirmDTO> getCompanySubFirm(@PathVariable Long id) {
        log.debug("REST request to get CompanySubFirm : {}", id);
        Optional<CompanySubFirmDTO> companySubFirmDTO = companySubFirmService.findOne(id);
        return ResponseUtil.wrapOrNotFound(companySubFirmDTO);
    }

    /**
     * {@code DELETE  /company-sub-firms/:id} : delete the "id" companySubFirm.
     *
     * @param id the id of the companySubFirmDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/company-sub-firms/{id}")
    public ResponseEntity<Void> deleteCompanySubFirm(@PathVariable Long id) {
        log.debug("REST request to delete CompanySubFirm : {}", id);
        companySubFirmService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
