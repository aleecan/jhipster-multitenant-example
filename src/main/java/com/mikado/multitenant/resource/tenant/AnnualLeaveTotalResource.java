package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.AnnualLeaveTotalService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.AnnualLeaveTotalDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.AnnualLeaveTotal}.
 */
@RestController
@RequestMapping("/api")
public class AnnualLeaveTotalResource {

    private final Logger log = LoggerFactory.getLogger(AnnualLeaveTotalResource.class);

    private static final String ENTITY_NAME = "annualLeaveTotal";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AnnualLeaveTotalService annualLeaveTotalService;

    public AnnualLeaveTotalResource(AnnualLeaveTotalService annualLeaveTotalService) {
        this.annualLeaveTotalService = annualLeaveTotalService;
    }

    /**
     * {@code POST  /annual-leave-totals} : Create a new annualLeaveTotal.
     *
     * @param annualLeaveTotalDTO the annualLeaveTotalDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new annualLeaveTotalDTO, or with status {@code 400 (Bad Request)} if the annualLeaveTotal has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/annual-leave-totals")
    public ResponseEntity<AnnualLeaveTotalDTO> createAnnualLeaveTotal(@Valid @RequestBody AnnualLeaveTotalDTO annualLeaveTotalDTO) throws URISyntaxException {
        log.debug("REST request to save AnnualLeaveTotal : {}", annualLeaveTotalDTO);
        if (annualLeaveTotalDTO.getId() != null) {
            throw new BadRequestAlertException("A new annualLeaveTotal cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AnnualLeaveTotalDTO result = annualLeaveTotalService.save(annualLeaveTotalDTO);
        return ResponseEntity.created(new URI("/api/annual-leave-totals/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /annual-leave-totals} : Updates an existing annualLeaveTotal.
     *
     * @param annualLeaveTotalDTO the annualLeaveTotalDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated annualLeaveTotalDTO,
     * or with status {@code 400 (Bad Request)} if the annualLeaveTotalDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the annualLeaveTotalDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/annual-leave-totals")
    public ResponseEntity<AnnualLeaveTotalDTO> updateAnnualLeaveTotal(@Valid @RequestBody AnnualLeaveTotalDTO annualLeaveTotalDTO) throws URISyntaxException {
        log.debug("REST request to update AnnualLeaveTotal : {}", annualLeaveTotalDTO);
        if (annualLeaveTotalDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AnnualLeaveTotalDTO result = annualLeaveTotalService.save(annualLeaveTotalDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, annualLeaveTotalDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /annual-leave-totals} : get all the annualLeaveTotals.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of annualLeaveTotals in body.
     */
    @GetMapping("/annual-leave-totals")
    public ResponseEntity<List<AnnualLeaveTotalDTO>> getAllAnnualLeaveTotals(Pageable pageable) {
        log.debug("REST request to get a page of AnnualLeaveTotals");
        Page<AnnualLeaveTotalDTO> page = annualLeaveTotalService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /annual-leave-totals/:id} : get the "id" annualLeaveTotal.
     *
     * @param id the id of the annualLeaveTotalDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the annualLeaveTotalDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/annual-leave-totals/{id}")
    public ResponseEntity<AnnualLeaveTotalDTO> getAnnualLeaveTotal(@PathVariable Long id) {
        log.debug("REST request to get AnnualLeaveTotal : {}", id);
        Optional<AnnualLeaveTotalDTO> annualLeaveTotalDTO = annualLeaveTotalService.findOne(id);
        return ResponseUtil.wrapOrNotFound(annualLeaveTotalDTO);
    }

    /**
     * {@code DELETE  /annual-leave-totals/:id} : delete the "id" annualLeaveTotal.
     *
     * @param id the id of the annualLeaveTotalDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/annual-leave-totals/{id}")
    public ResponseEntity<Void> deleteAnnualLeaveTotal(@PathVariable Long id) {
        log.debug("REST request to delete AnnualLeaveTotal : {}", id);
        annualLeaveTotalService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
