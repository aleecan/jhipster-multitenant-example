package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.Title;
import com.mikado.multitenant.repository.tenant.TitleRepository;
import com.mikado.multitenant.service.dto.tenant.TitleDTO;
import com.mikado.multitenant.service.mapper.tenant.TitleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Title}.
 */
@Service
@Transactional
public class TitleService {

    private final Logger log = LoggerFactory.getLogger(TitleService.class);

    private final TitleRepository titleRepository;

    private final TitleMapper titleMapper;

    public TitleService(TitleRepository titleRepository, TitleMapper titleMapper) {
        this.titleRepository = titleRepository;
        this.titleMapper = titleMapper;
    }

    /**
     * Save a title.
     *
     * @param titleDTO the entity to save.
     * @return the persisted entity.
     */
    public TitleDTO save(TitleDTO titleDTO) {
        log.debug("Request to save Title : {}", titleDTO);
        Title title = titleMapper.toEntity(titleDTO);
        title = titleRepository.save(title);
        return titleMapper.toDto(title);
    }

    /**
     * Get all the titles.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<TitleDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Titles");
        return titleRepository.findAll(pageable)
            .map(titleMapper::toDto);
    }


    /**
     * Get one title by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<TitleDTO> findOne(Long id) {
        log.debug("Request to get Title : {}", id);
        return titleRepository.findById(id)
            .map(titleMapper::toDto);
    }

    /**
     * Delete the title by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Title : {}", id);
        titleRepository.deleteById(id);
    }
}
