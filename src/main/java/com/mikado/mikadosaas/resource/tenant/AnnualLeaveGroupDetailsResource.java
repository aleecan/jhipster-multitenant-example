package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.AnnualLeaveGroupDetailsService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.AnnualLeaveGroupDetailsDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.AnnualLeaveGroupDetails}.
 */
@RestController
@RequestMapping("/api")
public class AnnualLeaveGroupDetailsResource {

    private final Logger log = LoggerFactory.getLogger(AnnualLeaveGroupDetailsResource.class);

    private static final String ENTITY_NAME = "annualLeaveGroupDetails";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AnnualLeaveGroupDetailsService annualLeaveGroupDetailsService;

    public AnnualLeaveGroupDetailsResource(AnnualLeaveGroupDetailsService annualLeaveGroupDetailsService) {
        this.annualLeaveGroupDetailsService = annualLeaveGroupDetailsService;
    }

    /**
     * {@code POST  /annual-leave-group-details} : Create a new annualLeaveGroupDetails.
     *
     * @param annualLeaveGroupDetailsDTO the annualLeaveGroupDetailsDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new annualLeaveGroupDetailsDTO, or with status {@code 400 (Bad Request)} if the annualLeaveGroupDetails has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/annual-leave-group-details")
    public ResponseEntity<AnnualLeaveGroupDetailsDTO> createAnnualLeaveGroupDetails(@Valid @RequestBody AnnualLeaveGroupDetailsDTO annualLeaveGroupDetailsDTO) throws URISyntaxException {
        log.debug("REST request to save AnnualLeaveGroupDetails : {}", annualLeaveGroupDetailsDTO);
        if (annualLeaveGroupDetailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new annualLeaveGroupDetails cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AnnualLeaveGroupDetailsDTO result = annualLeaveGroupDetailsService.save(annualLeaveGroupDetailsDTO);
        return ResponseEntity.created(new URI("/api/annual-leave-group-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /annual-leave-group-details} : Updates an existing annualLeaveGroupDetails.
     *
     * @param annualLeaveGroupDetailsDTO the annualLeaveGroupDetailsDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated annualLeaveGroupDetailsDTO,
     * or with status {@code 400 (Bad Request)} if the annualLeaveGroupDetailsDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the annualLeaveGroupDetailsDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/annual-leave-group-details")
    public ResponseEntity<AnnualLeaveGroupDetailsDTO> updateAnnualLeaveGroupDetails(@Valid @RequestBody AnnualLeaveGroupDetailsDTO annualLeaveGroupDetailsDTO) throws URISyntaxException {
        log.debug("REST request to update AnnualLeaveGroupDetails : {}", annualLeaveGroupDetailsDTO);
        if (annualLeaveGroupDetailsDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AnnualLeaveGroupDetailsDTO result = annualLeaveGroupDetailsService.save(annualLeaveGroupDetailsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, annualLeaveGroupDetailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /annual-leave-group-details} : get all the annualLeaveGroupDetails.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of annualLeaveGroupDetails in body.
     */
    @GetMapping("/annual-leave-group-details")
    public ResponseEntity<List<AnnualLeaveGroupDetailsDTO>> getAllAnnualLeaveGroupDetails(Pageable pageable) {
        log.debug("REST request to get a page of AnnualLeaveGroupDetails");
        Page<AnnualLeaveGroupDetailsDTO> page = annualLeaveGroupDetailsService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /annual-leave-group-details/:id} : get the "id" annualLeaveGroupDetails.
     *
     * @param id the id of the annualLeaveGroupDetailsDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the annualLeaveGroupDetailsDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/annual-leave-group-details/{id}")
    public ResponseEntity<AnnualLeaveGroupDetailsDTO> getAnnualLeaveGroupDetails(@PathVariable Long id) {
        log.debug("REST request to get AnnualLeaveGroupDetails : {}", id);
        Optional<AnnualLeaveGroupDetailsDTO> annualLeaveGroupDetailsDTO = annualLeaveGroupDetailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(annualLeaveGroupDetailsDTO);
    }

    /**
     * {@code DELETE  /annual-leave-group-details/:id} : delete the "id" annualLeaveGroupDetails.
     *
     * @param id the id of the annualLeaveGroupDetailsDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/annual-leave-group-details/{id}")
    public ResponseEntity<Void> deleteAnnualLeaveGroupDetails(@PathVariable Long id) {
        log.debug("REST request to delete AnnualLeaveGroupDetails : {}", id);
        annualLeaveGroupDetailsService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
