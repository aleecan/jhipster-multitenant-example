package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.CostCenterService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.CostCenterDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.CostCenter}.
 */
@RestController
@RequestMapping("/api")
public class CostCenterResource {

    private final Logger log = LoggerFactory.getLogger(CostCenterResource.class);

    private static final String ENTITY_NAME = "costCenter";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final CostCenterService costCenterService;

    public CostCenterResource(CostCenterService costCenterService) {
        this.costCenterService = costCenterService;
    }

    /**
     * {@code POST  /cost-centers} : Create a new costCenter.
     *
     * @param costCenterDTO the costCenterDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new costCenterDTO, or with status {@code 400 (Bad Request)} if the costCenter has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/cost-centers")
    public ResponseEntity<CostCenterDTO> createCostCenter(@Valid @RequestBody CostCenterDTO costCenterDTO) throws URISyntaxException {
        log.debug("REST request to save CostCenter : {}", costCenterDTO);
        if (costCenterDTO.getId() != null) {
            throw new BadRequestAlertException("A new costCenter cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CostCenterDTO result = costCenterService.save(costCenterDTO);
        return ResponseEntity.created(new URI("/api/cost-centers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /cost-centers} : Updates an existing costCenter.
     *
     * @param costCenterDTO the costCenterDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated costCenterDTO,
     * or with status {@code 400 (Bad Request)} if the costCenterDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the costCenterDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/cost-centers")
    public ResponseEntity<CostCenterDTO> updateCostCenter(@Valid @RequestBody CostCenterDTO costCenterDTO) throws URISyntaxException {
        log.debug("REST request to update CostCenter : {}", costCenterDTO);
        if (costCenterDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        CostCenterDTO result = costCenterService.save(costCenterDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, costCenterDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /cost-centers} : get all the costCenters.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of costCenters in body.
     */
    @GetMapping("/cost-centers")
    public ResponseEntity<List<CostCenterDTO>> getAllCostCenters(Pageable pageable) {
        log.debug("REST request to get a page of CostCenters");
        Page<CostCenterDTO> page = costCenterService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /cost-centers/:id} : get the "id" costCenter.
     *
     * @param id the id of the costCenterDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the costCenterDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/cost-centers/{id}")
    public ResponseEntity<CostCenterDTO> getCostCenter(@PathVariable Long id) {
        log.debug("REST request to get CostCenter : {}", id);
        Optional<CostCenterDTO> costCenterDTO = costCenterService.findOne(id);
        return ResponseUtil.wrapOrNotFound(costCenterDTO);
    }

    /**
     * {@code DELETE  /cost-centers/:id} : delete the "id" costCenter.
     *
     * @param id the id of the costCenterDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/cost-centers/{id}")
    public ResponseEntity<Void> deleteCostCenter(@PathVariable Long id) {
        log.debug("REST request to delete CostCenter : {}", id);
        costCenterService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
