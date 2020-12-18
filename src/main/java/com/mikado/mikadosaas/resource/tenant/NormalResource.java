package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.NormalService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.NormalDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.Normal}.
 */
@RestController
@RequestMapping("/api")
public class NormalResource {

    private final Logger log = LoggerFactory.getLogger(NormalResource.class);

    private static final String ENTITY_NAME = "normal";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final NormalService normalService;

    public NormalResource(NormalService normalService) {
        this.normalService = normalService;
    }

    /**
     * {@code POST  /normals} : Create a new normal.
     *
     * @param normalDTO the normalDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new normalDTO, or with status {@code 400 (Bad Request)} if the normal has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/normals")
    public ResponseEntity<NormalDTO> createNormal(@Valid @RequestBody NormalDTO normalDTO) throws URISyntaxException {
        log.debug("REST request to save Normal : {}", normalDTO);
        if (normalDTO.getId() != null) {
            throw new BadRequestAlertException("A new normal cannot already have an ID", ENTITY_NAME, "idexists");
        }
        NormalDTO result = normalService.save(normalDTO);
        return ResponseEntity.created(new URI("/api/normals/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /normals} : Updates an existing normal.
     *
     * @param normalDTO the normalDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated normalDTO,
     * or with status {@code 400 (Bad Request)} if the normalDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the normalDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/normals")
    public ResponseEntity<NormalDTO> updateNormal(@Valid @RequestBody NormalDTO normalDTO) throws URISyntaxException {
        log.debug("REST request to update Normal : {}", normalDTO);
        if (normalDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        NormalDTO result = normalService.save(normalDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, normalDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /normals} : get all the normals.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of normals in body.
     */
    @GetMapping("/normals")
    public ResponseEntity<List<NormalDTO>> getAllNormals(Pageable pageable) {
        log.debug("REST request to get a page of Normals");
        Page<NormalDTO> page = normalService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /normals/:id} : get the "id" normal.
     *
     * @param id the id of the normalDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the normalDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/normals/{id}")
    public ResponseEntity<NormalDTO> getNormal(@PathVariable Long id) {
        log.debug("REST request to get Normal : {}", id);
        Optional<NormalDTO> normalDTO = normalService.findOne(id);
        return ResponseUtil.wrapOrNotFound(normalDTO);
    }

    /**
     * {@code DELETE  /normals/:id} : delete the "id" normal.
     *
     * @param id the id of the normalDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/normals/{id}")
    public ResponseEntity<Void> deleteNormal(@PathVariable Long id) {
        log.debug("REST request to delete Normal : {}", id);
        normalService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
