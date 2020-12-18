package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.MailSchedulerDayService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.MailSchedulerDayDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.MailSchedulerDay}.
 */
@RestController
@RequestMapping("/api")
public class MailSchedulerDayResource {

    private final Logger log = LoggerFactory.getLogger(MailSchedulerDayResource.class);

    private static final String ENTITY_NAME = "mailSchedulerDay";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MailSchedulerDayService mailSchedulerDayService;

    public MailSchedulerDayResource(MailSchedulerDayService mailSchedulerDayService) {
        this.mailSchedulerDayService = mailSchedulerDayService;
    }

    /**
     * {@code POST  /mail-scheduler-days} : Create a new mailSchedulerDay.
     *
     * @param mailSchedulerDayDTO the mailSchedulerDayDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new mailSchedulerDayDTO, or with status {@code 400 (Bad Request)} if the mailSchedulerDay has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/mail-scheduler-days")
    public ResponseEntity<MailSchedulerDayDTO> createMailSchedulerDay(@Valid @RequestBody MailSchedulerDayDTO mailSchedulerDayDTO) throws URISyntaxException {
        log.debug("REST request to save MailSchedulerDay : {}", mailSchedulerDayDTO);
        if (mailSchedulerDayDTO.getId() != null) {
            throw new BadRequestAlertException("A new mailSchedulerDay cannot already have an ID", ENTITY_NAME, "idexists");
        }
        MailSchedulerDayDTO result = mailSchedulerDayService.save(mailSchedulerDayDTO);
        return ResponseEntity.created(new URI("/api/mail-scheduler-days/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /mail-scheduler-days} : Updates an existing mailSchedulerDay.
     *
     * @param mailSchedulerDayDTO the mailSchedulerDayDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated mailSchedulerDayDTO,
     * or with status {@code 400 (Bad Request)} if the mailSchedulerDayDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the mailSchedulerDayDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/mail-scheduler-days")
    public ResponseEntity<MailSchedulerDayDTO> updateMailSchedulerDay(@Valid @RequestBody MailSchedulerDayDTO mailSchedulerDayDTO) throws URISyntaxException {
        log.debug("REST request to update MailSchedulerDay : {}", mailSchedulerDayDTO);
        if (mailSchedulerDayDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        MailSchedulerDayDTO result = mailSchedulerDayService.save(mailSchedulerDayDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, mailSchedulerDayDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /mail-scheduler-days} : get all the mailSchedulerDays.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of mailSchedulerDays in body.
     */
    @GetMapping("/mail-scheduler-days")
    public ResponseEntity<List<MailSchedulerDayDTO>> getAllMailSchedulerDays(Pageable pageable) {
        log.debug("REST request to get a page of MailSchedulerDays");
        Page<MailSchedulerDayDTO> page = mailSchedulerDayService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /mail-scheduler-days/:id} : get the "id" mailSchedulerDay.
     *
     * @param id the id of the mailSchedulerDayDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the mailSchedulerDayDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/mail-scheduler-days/{id}")
    public ResponseEntity<MailSchedulerDayDTO> getMailSchedulerDay(@PathVariable Long id) {
        log.debug("REST request to get MailSchedulerDay : {}", id);
        Optional<MailSchedulerDayDTO> mailSchedulerDayDTO = mailSchedulerDayService.findOne(id);
        return ResponseUtil.wrapOrNotFound(mailSchedulerDayDTO);
    }

    /**
     * {@code DELETE  /mail-scheduler-days/:id} : delete the "id" mailSchedulerDay.
     *
     * @param id the id of the mailSchedulerDayDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/mail-scheduler-days/{id}")
    public ResponseEntity<Void> deleteMailSchedulerDay(@PathVariable Long id) {
        log.debug("REST request to delete MailSchedulerDay : {}", id);
        mailSchedulerDayService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
