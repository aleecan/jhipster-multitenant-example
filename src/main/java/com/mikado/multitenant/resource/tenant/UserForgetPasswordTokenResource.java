package com.mikado.multitenant.resource.tenant;

import com.mikado.multitenant.service.tenant.UserForgetPasswordTokenService;
import com.mikado.multitenant.resource.errors.BadRequestAlertException;
import com.mikado.multitenant.service.dto.tenant.UserForgetPasswordTokenDTO;

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
 * REST controller for managing {@link com.mikado.multitenant.domain.tenant.UserForgetPasswordToken}.
 */
@RestController
@RequestMapping("/api")
public class UserForgetPasswordTokenResource {

    private final Logger log = LoggerFactory.getLogger(UserForgetPasswordTokenResource.class);

    private static final String ENTITY_NAME = "userForgetPasswordToken";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final UserForgetPasswordTokenService userForgetPasswordTokenService;

    public UserForgetPasswordTokenResource(UserForgetPasswordTokenService userForgetPasswordTokenService) {
        this.userForgetPasswordTokenService = userForgetPasswordTokenService;
    }

    /**
     * {@code POST  /user-forget-password-tokens} : Create a new userForgetPasswordToken.
     *
     * @param userForgetPasswordTokenDTO the userForgetPasswordTokenDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new userForgetPasswordTokenDTO, or with status {@code 400 (Bad Request)} if the userForgetPasswordToken has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/user-forget-password-tokens")
    public ResponseEntity<UserForgetPasswordTokenDTO> createUserForgetPasswordToken(@Valid @RequestBody UserForgetPasswordTokenDTO userForgetPasswordTokenDTO) throws URISyntaxException {
        log.debug("REST request to save UserForgetPasswordToken : {}", userForgetPasswordTokenDTO);
        if (userForgetPasswordTokenDTO.getId() != null) {
            throw new BadRequestAlertException("A new userForgetPasswordToken cannot already have an ID", ENTITY_NAME, "idexists");
        }
        UserForgetPasswordTokenDTO result = userForgetPasswordTokenService.save(userForgetPasswordTokenDTO);
        return ResponseEntity.created(new URI("/api/user-forget-password-tokens/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /user-forget-password-tokens} : Updates an existing userForgetPasswordToken.
     *
     * @param userForgetPasswordTokenDTO the userForgetPasswordTokenDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated userForgetPasswordTokenDTO,
     * or with status {@code 400 (Bad Request)} if the userForgetPasswordTokenDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the userForgetPasswordTokenDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/user-forget-password-tokens")
    public ResponseEntity<UserForgetPasswordTokenDTO> updateUserForgetPasswordToken(@Valid @RequestBody UserForgetPasswordTokenDTO userForgetPasswordTokenDTO) throws URISyntaxException {
        log.debug("REST request to update UserForgetPasswordToken : {}", userForgetPasswordTokenDTO);
        if (userForgetPasswordTokenDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        UserForgetPasswordTokenDTO result = userForgetPasswordTokenService.save(userForgetPasswordTokenDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, userForgetPasswordTokenDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /user-forget-password-tokens} : get all the userForgetPasswordTokens.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of userForgetPasswordTokens in body.
     */
    @GetMapping("/user-forget-password-tokens")
    public ResponseEntity<List<UserForgetPasswordTokenDTO>> getAllUserForgetPasswordTokens(Pageable pageable) {
        log.debug("REST request to get a page of UserForgetPasswordTokens");
        Page<UserForgetPasswordTokenDTO> page = userForgetPasswordTokenService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /user-forget-password-tokens/:id} : get the "id" userForgetPasswordToken.
     *
     * @param id the id of the userForgetPasswordTokenDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the userForgetPasswordTokenDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/user-forget-password-tokens/{id}")
    public ResponseEntity<UserForgetPasswordTokenDTO> getUserForgetPasswordToken(@PathVariable Long id) {
        log.debug("REST request to get UserForgetPasswordToken : {}", id);
        Optional<UserForgetPasswordTokenDTO> userForgetPasswordTokenDTO = userForgetPasswordTokenService.findOne(id);
        return ResponseUtil.wrapOrNotFound(userForgetPasswordTokenDTO);
    }

    /**
     * {@code DELETE  /user-forget-password-tokens/:id} : delete the "id" userForgetPasswordToken.
     *
     * @param id the id of the userForgetPasswordTokenDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/user-forget-password-tokens/{id}")
    public ResponseEntity<Void> deleteUserForgetPasswordToken(@PathVariable Long id) {
        log.debug("REST request to delete UserForgetPasswordToken : {}", id);
        userForgetPasswordTokenService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
