package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.AnnualLeaveService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.AnnualLeaveDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.AnnualLeave}.
 */
@RestController
@RequestMapping("/api")
public class AnnualLeaveResource {

    private final Logger log = LoggerFactory.getLogger(AnnualLeaveResource.class);

    private static final String ENTITY_NAME = "annualLeave";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AnnualLeaveService annualLeaveService;

    public AnnualLeaveResource(AnnualLeaveService annualLeaveService) {
        this.annualLeaveService = annualLeaveService;
    }

    /**
     * {@code POST  /annual-leaves} : Create a new annualLeave.
     *
     * @param annualLeaveDTO the annualLeaveDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new annualLeaveDTO, or with status {@code 400 (Bad Request)} if the annualLeave has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/annual-leaves")
    public ResponseEntity<AnnualLeaveDTO> createAnnualLeave(@Valid @RequestBody AnnualLeaveDTO annualLeaveDTO) throws URISyntaxException {
        log.debug("REST request to save AnnualLeave : {}", annualLeaveDTO);
        if (annualLeaveDTO.getId() != null) {
            throw new BadRequestAlertException("A new annualLeave cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AnnualLeaveDTO result = annualLeaveService.save(annualLeaveDTO);
        return ResponseEntity.created(new URI("/api/annual-leaves/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /annual-leaves} : Updates an existing annualLeave.
     *
     * @param annualLeaveDTO the annualLeaveDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated annualLeaveDTO,
     * or with status {@code 400 (Bad Request)} if the annualLeaveDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the annualLeaveDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/annual-leaves")
    public ResponseEntity<AnnualLeaveDTO> updateAnnualLeave(@Valid @RequestBody AnnualLeaveDTO annualLeaveDTO) throws URISyntaxException {
        log.debug("REST request to update AnnualLeave : {}", annualLeaveDTO);
        if (annualLeaveDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AnnualLeaveDTO result = annualLeaveService.save(annualLeaveDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, annualLeaveDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /annual-leaves} : get all the annualLeaves.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of annualLeaves in body.
     */
    @GetMapping("/annual-leaves")
    public ResponseEntity<List<AnnualLeaveDTO>> getAllAnnualLeaves(Pageable pageable) {
        log.debug("REST request to get a page of AnnualLeaves");
        Page<AnnualLeaveDTO> page = annualLeaveService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /annual-leaves/:id} : get the "id" annualLeave.
     *
     * @param id the id of the annualLeaveDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the annualLeaveDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/annual-leaves/{id}")
    public ResponseEntity<AnnualLeaveDTO> getAnnualLeave(@PathVariable Long id) {
        log.debug("REST request to get AnnualLeave : {}", id);
        Optional<AnnualLeaveDTO> annualLeaveDTO = annualLeaveService.findOne(id);
        return ResponseUtil.wrapOrNotFound(annualLeaveDTO);
    }

    /**
     * {@code DELETE  /annual-leaves/:id} : delete the "id" annualLeave.
     *
     * @param id the id of the annualLeaveDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/annual-leaves/{id}")
    public ResponseEntity<Void> deleteAnnualLeave(@PathVariable Long id) {
        log.debug("REST request to delete AnnualLeave : {}", id);
        annualLeaveService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
