package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.MealGroup;
import com.mikado.multitenant.repository.tenant.MealGroupRepository;
import com.mikado.multitenant.service.dto.tenant.MealGroupDTO;
import com.mikado.multitenant.service.mapper.tenant.MealGroupMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link MealGroup}.
 */
@Service
@Transactional
public class MealGroupService {

    private final Logger log = LoggerFactory.getLogger(MealGroupService.class);

    private final MealGroupRepository mealGroupRepository;

    private final MealGroupMapper mealGroupMapper;

    public MealGroupService(MealGroupRepository mealGroupRepository, MealGroupMapper mealGroupMapper) {
        this.mealGroupRepository = mealGroupRepository;
        this.mealGroupMapper = mealGroupMapper;
    }

    /**
     * Save a mealGroup.
     *
     * @param mealGroupDTO the entity to save.
     * @return the persisted entity.
     */
    public MealGroupDTO save(MealGroupDTO mealGroupDTO) {
        log.debug("Request to save MealGroup : {}", mealGroupDTO);
        MealGroup mealGroup = mealGroupMapper.toEntity(mealGroupDTO);
        mealGroup = mealGroupRepository.save(mealGroup);
        return mealGroupMapper.toDto(mealGroup);
    }

    /**
     * Get all the mealGroups.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<MealGroupDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MealGroups");
        return mealGroupRepository.findAll(pageable)
            .map(mealGroupMapper::toDto);
    }


    /**
     * Get one mealGroup by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<MealGroupDTO> findOne(Long id) {
        log.debug("Request to get MealGroup : {}", id);
        return mealGroupRepository.findById(id)
            .map(mealGroupMapper::toDto);
    }

    /**
     * Delete the mealGroup by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete MealGroup : {}", id);
        mealGroupRepository.deleteById(id);
    }
}
