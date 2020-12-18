package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.MonthlySumService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.MonthlySumDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.MonthlySum}.
 */
@RestController
@RequestMapping("/api")
public class MonthlySumResource {

    private final Logger log = LoggerFactory.getLogger(MonthlySumResource.class);

    private static final String ENTITY_NAME = "monthlySum";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MonthlySumService monthlySumService;

    public MonthlySumResource(MonthlySumService monthlySumService) {
        this.monthlySumService = monthlySumService;
    }

    /**
     * {@code POST  /monthly-sums} : Create a new monthlySum.
     *
     * @param monthlySumDTO the monthlySumDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new monthlySumDTO, or with status {@code 400 (Bad Request)} if the monthlySum has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/monthly-sums")
    public ResponseEntity<MonthlySumDTO> createMonthlySum(@Valid @RequestBody MonthlySumDTO monthlySumDTO) throws URISyntaxException {
        log.debug("REST request to save MonthlySum : {}", monthlySumDTO);
        if (monthlySumDTO.getId() != null) {
            throw new BadRequestAlertException("A new monthlySum cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MonthlySumDTO result = monthlySumService.save(monthlySumDTO);
        return ResponseEntity.created(new URI("/api/monthly-sums/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /monthly-sums} : Updates an existing monthlySum.
     *
     * @param monthlySumDTO the monthlySumDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated monthlySumDTO,
     * or with status {@code 400 (Bad Request)} if the monthlySumDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the monthlySumDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/monthly-sums")
    public ResponseEntity<MonthlySumDTO> updateMonthlySum(@Valid @RequestBody MonthlySumDTO monthlySumDTO) throws URISyntaxException {
        log.debug("REST request to update MonthlySum : {}", monthlySumDTO);
        if (monthlySumDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MonthlySumDTO result = monthlySumService.save(monthlySumDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, monthlySumDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /monthly-sums} : get all the monthlySums.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of monthlySums in body.
     */
    @GetMapping("/monthly-sums")
    public ResponseEntity<List<MonthlySumDTO>> getAllMonthlySums(Pageable pageable) {
        log.debug("REST request to get a page of MonthlySums");
        Page<MonthlySumDTO> page = monthlySumService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /monthly-sums/:id} : get the "id" monthlySum.
     *
     * @param id the id of the monthlySumDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the monthlySumDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/monthly-sums/{id}")
    public ResponseEntity<MonthlySumDTO> getMonthlySum(@PathVariable Long id) {
        log.debug("REST request to get MonthlySum : {}", id);
        Optional<MonthlySumDTO> monthlySumDTO = monthlySumService.findOne(id);
        return ResponseUtil.wrapOrNotFound(monthlySumDTO);
    }

    /**
     * {@code DELETE  /monthly-sums/:id} : delete the "id" monthlySum.
     *
     * @param id the id of the monthlySumDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/monthly-sums/{id}")
    public ResponseEntity<Void> deleteMonthlySum(@PathVariable Long id) {
        log.debug("REST request to delete MonthlySum : {}", id);
        monthlySumService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
