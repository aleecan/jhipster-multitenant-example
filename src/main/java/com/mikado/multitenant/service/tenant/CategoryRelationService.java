package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.CategoryRelation;
import com.mikado.multitenant.repository.tenant.CategoryRelationRepository;
import com.mikado.multitenant.service.dto.tenant.CategoryRelationDTO;
import com.mikado.multitenant.service.mapper.tenant.CategoryRelationMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link CategoryRelation}.
 */
@Service
@Transactional
public class CategoryRelationService {

    private final Logger log = LoggerFactory.getLogger(CategoryRelationService.class);

    private final CategoryRelationRepository categoryRelationRepository;

    private final CategoryRelationMapper categoryRelationMapper;

    public CategoryRelationService(CategoryRelationRepository categoryRelationRepository, CategoryRelationMapper categoryRelationMapper) {
        this.categoryRelationRepository = categoryRelationRepository;
        this.categoryRelationMapper = categoryRelationMapper;
    }

    /**
     * Save a categoryRelation.
     *
     * @param categoryRelationDTO the entity to save.
     * @return the persisted entity.
     */
    public CategoryRelationDTO save(CategoryRelationDTO categoryRelationDTO) {
        log.debug("Request to save CategoryRelation : {}", categoryRelationDTO);
        CategoryRelation categoryRelation = categoryRelationMapper.toEntity(categoryRelationDTO);
        categoryRelation = categoryRelationRepository.save(categoryRelation);
        return categoryRelationMapper.toDto(categoryRelation);
    }

    /**
     * Get all the categoryRelations.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CategoryRelationDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CategoryRelations");
        return categoryRelationRepository.findAll(pageable)
            .map(categoryRelationMapper::toDto);
    }


    /**
     * Get one categoryRelation by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CategoryRelationDTO> findOne(Long id) {
        log.debug("Request to get CategoryRelation : {}", id);
        return categoryRelationRepository.findById(id)
            .map(categoryRelationMapper::toDto);
    }

    /**
     * Delete the categoryRelation by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete CategoryRelation : {}", id);
        categoryRelationRepository.deleteById(id);
    }
}
