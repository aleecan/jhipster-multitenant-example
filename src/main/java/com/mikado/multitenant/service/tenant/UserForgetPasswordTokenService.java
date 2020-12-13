package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.UserForgetPasswordToken;
import com.mikado.multitenant.repository.tenant.UserForgetPasswordTokenRepository;
import com.mikado.multitenant.service.dto.tenant.UserForgetPasswordTokenDTO;
import com.mikado.multitenant.service.mapper.tenant.UserForgetPasswordTokenMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link UserForgetPasswordToken}.
 */
@Service
@Transactional
public class UserForgetPasswordTokenService {

    private final Logger log = LoggerFactory.getLogger(UserForgetPasswordTokenService.class);

    private final UserForgetPasswordTokenRepository userForgetPasswordTokenRepository;

    private final UserForgetPasswordTokenMapper userForgetPasswordTokenMapper;

    public UserForgetPasswordTokenService(UserForgetPasswordTokenRepository userForgetPasswordTokenRepository, UserForgetPasswordTokenMapper userForgetPasswordTokenMapper) {
        this.userForgetPasswordTokenRepository = userForgetPasswordTokenRepository;
        this.userForgetPasswordTokenMapper = userForgetPasswordTokenMapper;
    }

    /**
     * Save a userForgetPasswordToken.
     *
     * @param userForgetPasswordTokenDTO the entity to save.
     * @return the persisted entity.
     */
    public UserForgetPasswordTokenDTO save(UserForgetPasswordTokenDTO userForgetPasswordTokenDTO) {
        log.debug("Request to save UserForgetPasswordToken : {}", userForgetPasswordTokenDTO);
        UserForgetPasswordToken userForgetPasswordToken = userForgetPasswordTokenMapper.toEntity(userForgetPasswordTokenDTO);
        userForgetPasswordToken = userForgetPasswordTokenRepository.save(userForgetPasswordToken);
        return userForgetPasswordTokenMapper.toDto(userForgetPasswordToken);
    }

    /**
     * Get all the userForgetPasswordTokens.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<UserForgetPasswordTokenDTO> findAll(Pageable pageable) {
        log.debug("Request to get all UserForgetPasswordTokens");
        return userForgetPasswordTokenRepository.findAll(pageable)
            .map(userForgetPasswordTokenMapper::toDto);
    }


    /**
     * Get one userForgetPasswordToken by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<UserForgetPasswordTokenDTO> findOne(Long id) {
        log.debug("Request to get UserForgetPasswordToken : {}", id);
        return userForgetPasswordTokenRepository.findById(id)
            .map(userForgetPasswordTokenMapper::toDto);
    }

    /**
     * Delete the userForgetPasswordToken by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete UserForgetPasswordToken : {}", id);
        userForgetPasswordTokenRepository.deleteById(id);
    }
}
