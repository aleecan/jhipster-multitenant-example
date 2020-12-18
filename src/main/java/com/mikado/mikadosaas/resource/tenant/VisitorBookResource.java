package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.VisitorBookService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.VisitorBookDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.VisitorBook}.
 */
@RestController
@RequestMapping("/api")
public class VisitorBookResource {

    private final Logger log = LoggerFactory.getLogger(VisitorBookResource.class);

    private static final String ENTITY_NAME = "visitorBook";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final VisitorBookService visitorBookService;

    public VisitorBookResource(VisitorBookService visitorBookService) {
        this.visitorBookService = visitorBookService;
    }

    /**
     * {@code POST  /visitor-books} : Create a new visitorBook.
     *
     * @param visitorBookDTO the visitorBookDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new visitorBookDTO, or with status {@code 400 (Bad Request)} if the visitorBook has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/visitor-books")
    public ResponseEntity<VisitorBookDTO> createVisitorBook(@Valid @RequestBody VisitorBookDTO visitorBookDTO) throws URISyntaxException {
        log.debug("REST request to save VisitorBook : {}", visitorBookDTO);
        if (visitorBookDTO.getId() != null) {
            throw new BadRequestAlertException("A new visitorBook cannot already have an ID", ENTITY_NAME, "idexists");
        }
        VisitorBookDTO result = visitorBookService.save(visitorBookDTO);
        return ResponseEntity.created(new URI("/api/visitor-books/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /visitor-books} : Updates an existing visitorBook.
     *
     * @param visitorBookDTO the visitorBookDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated visitorBookDTO,
     * or with status {@code 400 (Bad Request)} if the visitorBookDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the visitorBookDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/visitor-books")
    public ResponseEntity<VisitorBookDTO> updateVisitorBook(@Valid @RequestBody VisitorBookDTO visitorBookDTO) throws URISyntaxException {
        log.debug("REST request to update VisitorBook : {}", visitorBookDTO);
        if (visitorBookDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        VisitorBookDTO result = visitorBookService.save(visitorBookDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, visitorBookDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /visitor-books} : get all the visitorBooks.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of visitorBooks in body.
     */
    @GetMapping("/visitor-books")
    public ResponseEntity<List<VisitorBookDTO>> getAllVisitorBooks(Pageable pageable) {
        log.debug("REST request to get a page of VisitorBooks");
        Page<VisitorBookDTO> page = visitorBookService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /visitor-books/:id} : get the "id" visitorBook.
     *
     * @param id the id of the visitorBookDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the visitorBookDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/visitor-books/{id}")
    public ResponseEntity<VisitorBookDTO> getVisitorBook(@PathVariable Long id) {
        log.debug("REST request to get VisitorBook : {}", id);
        Optional<VisitorBookDTO> visitorBookDTO = visitorBookService.findOne(id);
        return ResponseUtil.wrapOrNotFound(visitorBookDTO);
    }

    /**
     * {@code DELETE  /visitor-books/:id} : delete the "id" visitorBook.
     *
     * @param id the id of the visitorBookDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/visitor-books/{id}")
    public ResponseEntity<Void> deleteVisitorBook(@PathVariable Long id) {
        log.debug("REST request to delete VisitorBook : {}", id);
        visitorBookService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
