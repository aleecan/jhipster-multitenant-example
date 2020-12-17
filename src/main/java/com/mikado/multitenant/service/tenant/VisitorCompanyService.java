package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.VisitorCompany;
import com.mikado.multitenant.repository.tenant.VisitorCompanyRepository;
import com.mikado.multitenant.service.dto.tenant.VisitorCompanyDTO;
import com.mikado.multitenant.service.mapper.tenant.VisitorCompanyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link VisitorCompany}.
 */
@Service
@Transactional
public class VisitorCompanyService {

    private final Logger log = LoggerFactory.getLogger(VisitorCompanyService.class);

    private final VisitorCompanyRepository visitorCompanyRepository;

    private final VisitorCompanyMapper visitorCompanyMapper;

    public VisitorCompanyService(VisitorCompanyRepository visitorCompanyRepository, VisitorCompanyMapper visitorCompanyMapper) {
        this.visitorCompanyRepository = visitorCompanyRepository;
        this.visitorCompanyMapper = visitorCompanyMapper;
    }

    /**
     * Save a visitorCompany.
     *
     * @param visitorCompanyDTO the entity to save.
     * @return the persisted entity.
     */
    public VisitorCompanyDTO save(VisitorCompanyDTO visitorCompanyDTO) {
        log.debug("Request to save VisitorCompany : {}", visitorCompanyDTO);
        VisitorCompany visitorCompany = visitorCompanyMapper.toEntity(visitorCompanyDTO);
        visitorCompany = visitorCompanyRepository.save(visitorCompany);
        return visitorCompanyMapper.toDto(visitorCompany);
    }

    /**
     * Get all the visitorCompanies.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<VisitorCompanyDTO> findAll(Pageable pageable) {
        log.debug("Request to get all VisitorCompanies");
        return visitorCompanyRepository.findAll(pageable)
            .map(visitorCompanyMapper::toDto);
    }


    /**
     * Get one visitorCompany by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<VisitorCompanyDTO> findOne(Long id) {
        log.debug("Request to get VisitorCompany : {}", id);
        return visitorCompanyRepository.findById(id)
            .map(visitorCompanyMapper::toDto);
    }

    /**
     * Delete the visitorCompany by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete VisitorCompany : {}", id);
        visitorCompanyRepository.deleteById(id);
    }
}
