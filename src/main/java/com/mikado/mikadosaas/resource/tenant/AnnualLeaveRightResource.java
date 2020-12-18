package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.AnnualLeaveRightService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.AnnualLeaveRightDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.AnnualLeaveRight}.
 */
@RestController
@RequestMapping("/api")
public class AnnualLeaveRightResource {

    private final Logger log = LoggerFactory.getLogger(AnnualLeaveRightResource.class);

    private static final String ENTITY_NAME = "annualLeaveRight";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AnnualLeaveRightService annualLeaveRightService;

    public AnnualLeaveRightResource(AnnualLeaveRightService annualLeaveRightService) {
        this.annualLeaveRightService = annualLeaveRightService;
    }

    /**
     * {@code POST  /annual-leave-rights} : Create a new annualLeaveRight.
     *
     * @param annualLeaveRightDTO the annualLeaveRightDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new annualLeaveRightDTO, or with status {@code 400 (Bad Request)} if the annualLeaveRight has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/annual-leave-rights")
    public ResponseEntity<AnnualLeaveRightDTO> createAnnualLeaveRight(@Valid @RequestBody AnnualLeaveRightDTO annualLeaveRightDTO) throws URISyntaxException {
        log.debug("REST request to save AnnualLeaveRight : {}", annualLeaveRightDTO);
        if (annualLeaveRightDTO.getId() != null) {
            throw new BadRequestAlertException("A new annualLeaveRight cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AnnualLeaveRightDTO result = annualLeaveRightService.save(annualLeaveRightDTO);
        return ResponseEntity.created(new URI("/api/annual-leave-rights/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /annual-leave-rights} : Updates an existing annualLeaveRight.
     *
     * @param annualLeaveRightDTO the annualLeaveRightDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated annualLeaveRightDTO,
     * or with status {@code 400 (Bad Request)} if the annualLeaveRightDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the annualLeaveRightDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/annual-leave-rights")
    public ResponseEntity<AnnualLeaveRightDTO> updateAnnualLeaveRight(@Valid @RequestBody AnnualLeaveRightDTO annualLeaveRightDTO) throws URISyntaxException {
        log.debug("REST request to update AnnualLeaveRight : {}", annualLeaveRightDTO);
        if (annualLeaveRightDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AnnualLeaveRightDTO result = annualLeaveRightService.save(annualLeaveRightDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, annualLeaveRightDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /annual-leave-rights} : get all the annualLeaveRights.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of annualLeaveRights in body.
     */
    @GetMapping("/annual-leave-rights")
    public ResponseEntity<List<AnnualLeaveRightDTO>> getAllAnnualLeaveRights(Pageable pageable) {
        log.debug("REST request to get a page of AnnualLeaveRights");
        Page<AnnualLeaveRightDTO> page = annualLeaveRightService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /annual-leave-rights/:id} : get the "id" annualLeaveRight.
     *
     * @param id the id of the annualLeaveRightDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the annualLeaveRightDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/annual-leave-rights/{id}")
    public ResponseEntity<AnnualLeaveRightDTO> getAnnualLeaveRight(@PathVariable Long id) {
        log.debug("REST request to get AnnualLeaveRight : {}", id);
        Optional<AnnualLeaveRightDTO> annualLeaveRightDTO = annualLeaveRightService.findOne(id);
        return ResponseUtil.wrapOrNotFound(annualLeaveRightDTO);
    }

    /**
     * {@code DELETE  /annual-leave-rights/:id} : delete the "id" annualLeaveRight.
     *
     * @param id the id of the annualLeaveRightDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/annual-leave-rights/{id}")
    public ResponseEntity<Void> deleteAnnualLeaveRight(@PathVariable Long id) {
        log.debug("REST request to delete AnnualLeaveRight : {}", id);
        annualLeaveRightService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
