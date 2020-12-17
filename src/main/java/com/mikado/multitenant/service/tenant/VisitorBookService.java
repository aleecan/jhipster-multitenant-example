package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.VisitorBook;
import com.mikado.multitenant.repository.tenant.VisitorBookRepository;
import com.mikado.multitenant.service.dto.tenant.VisitorBookDTO;
import com.mikado.multitenant.service.mapper.tenant.VisitorBookMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link VisitorBook}.
 */
@Service
@Transactional
public class VisitorBookService {

    private final Logger log = LoggerFactory.getLogger(VisitorBookService.class);

    private final VisitorBookRepository visitorBookRepository;

    private final VisitorBookMapper visitorBookMapper;

    public VisitorBookService(VisitorBookRepository visitorBookRepository, VisitorBookMapper visitorBookMapper) {
        this.visitorBookRepository = visitorBookRepository;
        this.visitorBookMapper = visitorBookMapper;
    }

    /**
     * Save a visitorBook.
     *
     * @param visitorBookDTO the entity to save.
     * @return the persisted entity.
     */
    public VisitorBookDTO save(VisitorBookDTO visitorBookDTO) {
        log.debug("Request to save VisitorBook : {}", visitorBookDTO);
        VisitorBook visitorBook = visitorBookMapper.toEntity(visitorBookDTO);
        visitorBook = visitorBookRepository.save(visitorBook);
        return visitorBookMapper.toDto(visitorBook);
    }

    /**
     * Get all the visitorBooks.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<VisitorBookDTO> findAll(Pageable pageable) {
        log.debug("Request to get all VisitorBooks");
        return visitorBookRepository.findAll(pageable)
            .map(visitorBookMapper::toDto);
    }


    /**
     * Get one visitorBook by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<VisitorBookDTO> findOne(Long id) {
        log.debug("Request to get VisitorBook : {}", id);
        return visitorBookRepository.findById(id)
            .map(visitorBookMapper::toDto);
    }

    /**
     * Delete the visitorBook by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete VisitorBook : {}", id);
        visitorBookRepository.deleteById(id);
    }
}
