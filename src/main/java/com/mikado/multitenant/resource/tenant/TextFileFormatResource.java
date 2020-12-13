package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.TextFileFormatService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.TextFileFormatDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.TextFileFormat}.
 */
@RestController
@RequestMapping("/api")
public class TextFileFormatResource {

    private final Logger log = LoggerFactory.getLogger(TextFileFormatResource.class);

    private static final String ENTITY_NAME = "textFileFormat";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final TextFileFormatService textFileFormatService;

    public TextFileFormatResource(TextFileFormatService textFileFormatService) {
        this.textFileFormatService = textFileFormatService;
    }

    /**
     * {@code POST  /text-file-formats} : Create a new textFileFormat.
     *
     * @param textFileFormatDTO the textFileFormatDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new textFileFormatDTO, or with status {@code 400 (Bad Request)} if the textFileFormat has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/text-file-formats")
    public ResponseEntity<TextFileFormatDTO> createTextFileFormat(@Valid @RequestBody TextFileFormatDTO textFileFormatDTO) throws URISyntaxException {
        log.debug("REST request to save TextFileFormat : {}", textFileFormatDTO);
        if (textFileFormatDTO.getId() != null) {
            throw new BadRequestAlertException("A new textFileFormat cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TextFileFormatDTO result = textFileFormatService.save(textFileFormatDTO);
        return ResponseEntity.created(new URI("/api/text-file-formats/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /text-file-formats} : Updates an existing textFileFormat.
     *
     * @param textFileFormatDTO the textFileFormatDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated textFileFormatDTO,
     * or with status {@code 400 (Bad Request)} if the textFileFormatDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the textFileFormatDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/text-file-formats")
    public ResponseEntity<TextFileFormatDTO> updateTextFileFormat(@Valid @RequestBody TextFileFormatDTO textFileFormatDTO) throws URISyntaxException {
        log.debug("REST request to update TextFileFormat : {}", textFileFormatDTO);
        if (textFileFormatDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TextFileFormatDTO result = textFileFormatService.save(textFileFormatDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, textFileFormatDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /text-file-formats} : get all the textFileFormats.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of textFileFormats in body.
     */
    @GetMapping("/text-file-formats")
    public ResponseEntity<List<TextFileFormatDTO>> getAllTextFileFormats(Pageable pageable) {
        log.debug("REST request to get a page of TextFileFormats");
        Page<TextFileFormatDTO> page = textFileFormatService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /text-file-formats/:id} : get the "id" textFileFormat.
     *
     * @param id the id of the textFileFormatDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the textFileFormatDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/text-file-formats/{id}")
    public ResponseEntity<TextFileFormatDTO> getTextFileFormat(@PathVariable Long id) {
        log.debug("REST request to get TextFileFormat : {}", id);
        Optional<TextFileFormatDTO> textFileFormatDTO = textFileFormatService.findOne(id);
        return ResponseUtil.wrapOrNotFound(textFileFormatDTO);
    }

    /**
     * {@code DELETE  /text-file-formats/:id} : delete the "id" textFileFormat.
     *
     * @param id the id of the textFileFormatDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/text-file-formats/{id}")
    public ResponseEntity<Void> deleteTextFileFormat(@PathVariable Long id) {
        log.debug("REST request to delete TextFileFormat : {}", id);
        textFileFormatService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
