package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.UserFilter;
import com.mikado.multitenant.repository.tenant.UserFilterRepository;
import com.mikado.multitenant.service.dto.tenant.UserFilterDTO;
import com.mikado.multitenant.service.mapper.tenant.UserFilterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link UserFilter}.
 */
@Service
@Transactional
public class UserFilterService {

    private final Logger log = LoggerFactory.getLogger(UserFilterService.class);

    private final UserFilterRepository userFilterRepository;

    private final UserFilterMapper userFilterMapper;

    public UserFilterService(UserFilterRepository userFilterRepository, UserFilterMapper userFilterMapper) {
        this.userFilterRepository = userFilterRepository;
        this.userFilterMapper = userFilterMapper;
    }

    /**
     * Save a userFilter.
     *
     * @param userFilterDTO the entity to save.
     * @return the persisted entity.
     */
    public UserFilterDTO save(UserFilterDTO userFilterDTO) {
        log.debug("Request to save UserFilter : {}", userFilterDTO);
        UserFilter userFilter = userFilterMapper.toEntity(userFilterDTO);
        userFilter = userFilterRepository.save(userFilter);
        return userFilterMapper.toDto(userFilter);
    }

    /**
     * Get all the userFilters.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<UserFilterDTO> findAll(Pageable pageable) {
        log.debug("Request to get all UserFilters");
        return userFilterRepository.findAll(pageable)
            .map(userFilterMapper::toDto);
    }


    /**
     * Get one userFilter by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<UserFilterDTO> findOne(Long id) {
        log.debug("Request to get UserFilter : {}", id);
        return userFilterRepository.findById(id)
            .map(userFilterMapper::toDto);
    }

    /**
     * Delete the userFilter by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete UserFilter : {}", id);
        userFilterRepository.deleteById(id);
    }
}
