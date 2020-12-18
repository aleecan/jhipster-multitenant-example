package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.TitleService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.TitleDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.Title}.
 */
@RestController
@RequestMapping("/api")
public class TitleResource {

    private final Logger log = LoggerFactory.getLogger(TitleResource.class);

    private static final String ENTITY_NAME = "title";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TitleService titleService;

    public TitleResource(TitleService titleService) {
        this.titleService = titleService;
    }

    /**
     * {@code POST  /titles} : Create a new title.
     *
     * @param titleDTO the titleDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new titleDTO, or with status {@code 400 (Bad Request)} if the title has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/titles")
    public ResponseEntity<TitleDTO> createTitle(@Valid @RequestBody TitleDTO titleDTO) throws URISyntaxException {
        log.debug("REST request to save Title : {}", titleDTO);
        if (titleDTO.getId() != null) {
            throw new BadRequestAlertException("A new title cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TitleDTO result = titleService.save(titleDTO);
        return ResponseEntity.created(new URI("/api/titles/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /titles} : Updates an existing title.
     *
     * @param titleDTO the titleDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated titleDTO,
     * or with status {@code 400 (Bad Request)} if the titleDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the titleDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/titles")
    public ResponseEntity<TitleDTO> updateTitle(@Valid @RequestBody TitleDTO titleDTO) throws URISyntaxException {
        log.debug("REST request to update Title : {}", titleDTO);
        if (titleDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TitleDTO result = titleService.save(titleDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, titleDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /titles} : get all the titles.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of titles in body.
     */
    @GetMapping("/titles")
    public ResponseEntity<List<TitleDTO>> getAllTitles(Pageable pageable) {
        log.debug("REST request to get a page of Titles");
        Page<TitleDTO> page = titleService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /titles/:id} : get the "id" title.
     *
     * @param id the id of the titleDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the titleDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/titles/{id}")
    public ResponseEntity<TitleDTO> getTitle(@PathVariable Long id) {
        log.debug("REST request to get Title : {}", id);
        Optional<TitleDTO> titleDTO = titleService.findOne(id);
        return ResponseUtil.wrapOrNotFound(titleDTO);
    }

    /**
     * {@code DELETE  /titles/:id} : delete the "id" title.
     *
     * @param id the id of the titleDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/titles/{id}")
    public ResponseEntity<Void> deleteTitle(@PathVariable Long id) {
        log.debug("REST request to delete Title : {}", id);
        titleService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
