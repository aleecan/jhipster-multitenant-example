package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.AnnualLeaveAddsubService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.AnnualLeaveAddsubDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.AnnualLeaveAddsub}.
 */
@RestController
@RequestMapping("/api")
public class AnnualLeaveAddsubResource {

    private final Logger log = LoggerFactory.getLogger(AnnualLeaveAddsubResource.class);

    private static final String ENTITY_NAME = "annualLeaveAddsub";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final AnnualLeaveAddsubService annualLeaveAddsubService;

    public AnnualLeaveAddsubResource(AnnualLeaveAddsubService annualLeaveAddsubService) {
        this.annualLeaveAddsubService = annualLeaveAddsubService;
    }

    /**
     * {@code POST  /annual-leave-addsubs} : Create a new annualLeaveAddsub.
     *
     * @param annualLeaveAddsubDTO the annualLeaveAddsubDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new annualLeaveAddsubDTO, or with status {@code 400 (Bad Request)} if the annualLeaveAddsub has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/annual-leave-addsubs")
    public ResponseEntity<AnnualLeaveAddsubDTO> createAnnualLeaveAddsub(@Valid @RequestBody AnnualLeaveAddsubDTO annualLeaveAddsubDTO) throws URISyntaxException {
        log.debug("REST request to save AnnualLeaveAddsub : {}", annualLeaveAddsubDTO);
        if (annualLeaveAddsubDTO.getId() != null) {
            throw new BadRequestAlertException("A new annualLeaveAddsub cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AnnualLeaveAddsubDTO result = annualLeaveAddsubService.save(annualLeaveAddsubDTO);
        return ResponseEntity.created(new URI("/api/annual-leave-addsubs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /annual-leave-addsubs} : Updates an existing annualLeaveAddsub.
     *
     * @param annualLeaveAddsubDTO the annualLeaveAddsubDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated annualLeaveAddsubDTO,
     * or with status {@code 400 (Bad Request)} if the annualLeaveAddsubDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the annualLeaveAddsubDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/annual-leave-addsubs")
    public ResponseEntity<AnnualLeaveAddsubDTO> updateAnnualLeaveAddsub(@Valid @RequestBody AnnualLeaveAddsubDTO annualLeaveAddsubDTO) throws URISyntaxException {
        log.debug("REST request to update AnnualLeaveAddsub : {}", annualLeaveAddsubDTO);
        if (annualLeaveAddsubDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AnnualLeaveAddsubDTO result = annualLeaveAddsubService.save(annualLeaveAddsubDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, annualLeaveAddsubDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /annual-leave-addsubs} : get all the annualLeaveAddsubs.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of annualLeaveAddsubs in body.
     */
    @GetMapping("/annual-leave-addsubs")
    public ResponseEntity<List<AnnualLeaveAddsubDTO>> getAllAnnualLeaveAddsubs(Pageable pageable) {
        log.debug("REST request to get a page of AnnualLeaveAddsubs");
        Page<AnnualLeaveAddsubDTO> page = annualLeaveAddsubService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /annual-leave-addsubs/:id} : get the "id" annualLeaveAddsub.
     *
     * @param id the id of the annualLeaveAddsubDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the annualLeaveAddsubDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/annual-leave-addsubs/{id}")
    public ResponseEntity<AnnualLeaveAddsubDTO> getAnnualLeaveAddsub(@PathVariable Long id) {
        log.debug("REST request to get AnnualLeaveAddsub : {}", id);
        Optional<AnnualLeaveAddsubDTO> annualLeaveAddsubDTO = annualLeaveAddsubService.findOne(id);
        return ResponseUtil.wrapOrNotFound(annualLeaveAddsubDTO);
    }

    /**
     * {@code DELETE  /annual-leave-addsubs/:id} : delete the "id" annualLeaveAddsub.
     *
     * @param id the id of the annualLeaveAddsubDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/annual-leave-addsubs/{id}")
    public ResponseEntity<Void> deleteAnnualLeaveAddsub(@PathVariable Long id) {
        log.debug("REST request to delete AnnualLeaveAddsub : {}", id);
        annualLeaveAddsubService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
