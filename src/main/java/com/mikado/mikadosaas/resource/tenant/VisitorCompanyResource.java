package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.VisitorCompanyService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.VisitorCompanyDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.VisitorCompany}.
 */
@RestController
@RequestMapping("/api")
public class VisitorCompanyResource {

    private final Logger log = LoggerFactory.getLogger(VisitorCompanyResource.class);

    private static final String ENTITY_NAME = "visitorCompany";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final VisitorCompanyService visitorCompanyService;

    public VisitorCompanyResource(VisitorCompanyService visitorCompanyService) {
        this.visitorCompanyService = visitorCompanyService;
    }

    /**
     * {@code POST  /visitor-companies} : Create a new visitorCompany.
     *
     * @param visitorCompanyDTO the visitorCompanyDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new visitorCompanyDTO, or with status {@code 400 (Bad Request)} if the visitorCompany has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/visitor-companies")
    public ResponseEntity<VisitorCompanyDTO> createVisitorCompany(@Valid @RequestBody VisitorCompanyDTO visitorCompanyDTO) throws URISyntaxException {
        log.debug("REST request to save VisitorCompany : {}", visitorCompanyDTO);
        if (visitorCompanyDTO.getId() != null) {
            throw new BadRequestAlertException("A new visitorCompany cannot already have an ID", ENTITY_NAME, "idexists");
        }
        VisitorCompanyDTO result = visitorCompanyService.save(visitorCompanyDTO);
        return ResponseEntity.created(new URI("/api/visitor-companies/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /visitor-companies} : Updates an existing visitorCompany.
     *
     * @param visitorCompanyDTO the visitorCompanyDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated visitorCompanyDTO,
     * or with status {@code 400 (Bad Request)} if the visitorCompanyDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the visitorCompanyDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/visitor-companies")
    public ResponseEntity<VisitorCompanyDTO> updateVisitorCompany(@Valid @RequestBody VisitorCompanyDTO visitorCompanyDTO) throws URISyntaxException {
        log.debug("REST request to update VisitorCompany : {}", visitorCompanyDTO);
        if (visitorCompanyDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        VisitorCompanyDTO result = visitorCompanyService.save(visitorCompanyDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, visitorCompanyDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /visitor-companies} : get all the visitorCompanies.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of visitorCompanies in body.
     */
    @GetMapping("/visitor-companies")
    public ResponseEntity<List<VisitorCompanyDTO>> getAllVisitorCompanies(Pageable pageable) {
        log.debug("REST request to get a page of VisitorCompanies");
        Page<VisitorCompanyDTO> page = visitorCompanyService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /visitor-companies/:id} : get the "id" visitorCompany.
     *
     * @param id the id of the visitorCompanyDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the visitorCompanyDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/visitor-companies/{id}")
    public ResponseEntity<VisitorCompanyDTO> getVisitorCompany(@PathVariable Long id) {
        log.debug("REST request to get VisitorCompany : {}", id);
        Optional<VisitorCompanyDTO> visitorCompanyDTO = visitorCompanyService.findOne(id);
        return ResponseUtil.wrapOrNotFound(visitorCompanyDTO);
    }

    /**
     * {@code DELETE  /visitor-companies/:id} : delete the "id" visitorCompany.
     *
     * @param id the id of the visitorCompanyDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/visitor-companies/{id}")
    public ResponseEntity<Void> deleteVisitorCompany(@PathVariable Long id) {
        log.debug("REST request to delete VisitorCompany : {}", id);
        visitorCompanyService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
