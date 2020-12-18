package com.mikado.mikadosaas.resource.tenant;

import com.mikado.mikadosaas.service.tenant.GroupCodeService;
import com.mikado.mikadosaas.resource.errors.BadRequestAlertException;
import com.mikado.mikadosaas.service.dto.tenant.GroupCodeDTO;

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
 * REST controller for managing {@link com.mikado.mikadosaas.domain.tenant.GroupCode}.
 */
@RestController
@RequestMapping("/api")
public class GroupCodeResource {

    private final Logger log = LoggerFactory.getLogger(GroupCodeResource.class);

    private static final String ENTITY_NAME = "groupCode";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final GroupCodeService groupCodeService;

    public GroupCodeResource(GroupCodeService groupCodeService) {
        this.groupCodeService = groupCodeService;
    }

    /**
     * {@code POST  /group-codes} : Create a new groupCode.
     *
     * @param groupCodeDTO the groupCodeDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new groupCodeDTO, or with status {@code 400 (Bad Request)} if the groupCode has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/group-codes")
    public ResponseEntity<GroupCodeDTO> createGroupCode(@Valid @RequestBody GroupCodeDTO groupCodeDTO) throws URISyntaxException {
        log.debug("REST request to save GroupCode : {}", groupCodeDTO);
        if (groupCodeDTO.getId() != null) {
            throw new BadRequestAlertException("A new groupCode cannot already have an ID", ENTITY_NAME, "idexists");
        }
        GroupCodeDTO result = groupCodeService.save(groupCodeDTO);
        return ResponseEntity.created(new URI("/api/group-codes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /group-codes} : Updates an existing groupCode.
     *
     * @param groupCodeDTO the groupCodeDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated groupCodeDTO,
     * or with status {@code 400 (Bad Request)} if the groupCodeDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the groupCodeDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/group-codes")
    public ResponseEntity<GroupCodeDTO> updateGroupCode(@Valid @RequestBody GroupCodeDTO groupCodeDTO) throws URISyntaxException {
        log.debug("REST request to update GroupCode : {}", groupCodeDTO);
        if (groupCodeDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        GroupCodeDTO result = groupCodeService.save(groupCodeDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, groupCodeDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /group-codes} : get all the groupCodes.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of groupCodes in body.
     */
    @GetMapping("/group-codes")
    public ResponseEntity<List<GroupCodeDTO>> getAllGroupCodes(Pageable pageable) {
        log.debug("REST request to get a page of GroupCodes");
        Page<GroupCodeDTO> page = groupCodeService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /group-codes/:id} : get the "id" groupCode.
     *
     * @param id the id of the groupCodeDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the groupCodeDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/group-codes/{id}")
    public ResponseEntity<GroupCodeDTO> getGroupCode(@PathVariable Long id) {
        log.debug("REST request to get GroupCode : {}", id);
        Optional<GroupCodeDTO> groupCodeDTO = groupCodeService.findOne(id);
        return ResponseUtil.wrapOrNotFound(groupCodeDTO);
    }

    /**
     * {@code DELETE  /group-codes/:id} : delete the "id" groupCode.
     *
     * @param id the id of the groupCodeDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/group-codes/{id}")
    public ResponseEntity<Void> deleteGroupCode(@PathVariable Long id) {
        log.debug("REST request to delete GroupCode : {}", id);
        groupCodeService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
