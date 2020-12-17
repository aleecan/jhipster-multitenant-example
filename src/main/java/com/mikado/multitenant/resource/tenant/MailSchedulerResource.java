package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.MailSchedulerService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.MailSchedulerDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.MailScheduler}.
 */
@RestController
@RequestMapping("/api")
public class MailSchedulerResource {

    private final Logger log = LoggerFactory.getLogger(MailSchedulerResource.class);

    private static final String ENTITY_NAME = "mailScheduler";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MailSchedulerService mailSchedulerService;

    public MailSchedulerResource(MailSchedulerService mailSchedulerService) {
        this.mailSchedulerService = mailSchedulerService;
    }

    /**
     * {@code POST  /mail-schedulers} : Create a new mailScheduler.
     *
     * @param mailSchedulerDTO the mailSchedulerDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new mailSchedulerDTO, or with status {@code 400 (Bad Request)} if the mailScheduler has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/mail-schedulers")
    public ResponseEntity<MailSchedulerDTO> createMailScheduler(@Valid @RequestBody MailSchedulerDTO mailSchedulerDTO) throws URISyntaxException {
        log.debug("REST request to save MailScheduler : {}", mailSchedulerDTO);
        if (mailSchedulerDTO.getId() != null) {
            throw new BadRequestAlertException("A new mailScheduler cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MailSchedulerDTO result = mailSchedulerService.save(mailSchedulerDTO);
        return ResponseEntity.created(new URI("/api/mail-schedulers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /mail-schedulers} : Updates an existing mailScheduler.
     *
     * @param mailSchedulerDTO the mailSchedulerDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mailSchedulerDTO,
     * or with status {@code 400 (Bad Request)} if the mailSchedulerDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the mailSchedulerDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/mail-schedulers")
    public ResponseEntity<MailSchedulerDTO> updateMailScheduler(@Valid @RequestBody MailSchedulerDTO mailSchedulerDTO) throws URISyntaxException {
        log.debug("REST request to update MailScheduler : {}", mailSchedulerDTO);
        if (mailSchedulerDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MailSchedulerDTO result = mailSchedulerService.save(mailSchedulerDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, mailSchedulerDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /mail-schedulers} : get all the mailSchedulers.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of mailSchedulers in body.
     */
    @GetMapping("/mail-schedulers")
    public ResponseEntity<List<MailSchedulerDTO>> getAllMailSchedulers(Pageable pageable) {
        log.debug("REST request to get a page of MailSchedulers");
        Page<MailSchedulerDTO> page = mailSchedulerService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /mail-schedulers/:id} : get the "id" mailScheduler.
     *
     * @param id the id of the mailSchedulerDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the mailSchedulerDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/mail-schedulers/{id}")
    public ResponseEntity<MailSchedulerDTO> getMailScheduler(@PathVariable Long id) {
        log.debug("REST request to get MailScheduler : {}", id);
        Optional<MailSchedulerDTO> mailSchedulerDTO = mailSchedulerService.findOne(id);
        return ResponseUtil.wrapOrNotFound(mailSchedulerDTO);
    }

    /**
     * {@code DELETE  /mail-schedulers/:id} : delete the "id" mailScheduler.
     *
     * @param id the id of the mailSchedulerDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/mail-schedulers/{id}")
    public ResponseEntity<Void> deleteMailScheduler(@PathVariable Long id) {
        log.debug("REST request to delete MailScheduler : {}", id);
        mailSchedulerService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
