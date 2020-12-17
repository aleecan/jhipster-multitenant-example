package com.mikado.multitenant.service.tenant;

import com.mikado.multitenant.domain.tenant.CompanyFirm;
import com.mikado.multitenant.repository.tenant.CompanyFirmRepository;
import com.mikado.multitenant.service.dto.tenant.CompanyFirmDTO;
import com.mikado.multitenant.service.mapper.tenant.CompanyFirmMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link CompanyFirm}.
 */
@Service
@Transactional
public class CompanyFirmService {

    private final Logger log = LoggerFactory.getLogger(CompanyFirmService.class);

    private final CompanyFirmRepository companyFirmRepository;

    private final CompanyFirmMapper companyFirmMapper;

    public CompanyFirmService(CompanyFirmRepository companyFirmRepository, CompanyFirmMapper companyFirmMapper) {
        this.companyFirmRepository = companyFirmRepository;
        this.companyFirmMapper = companyFirmMapper;
    }

    /**
     * Save a companyFirm.
     *
     * @param companyFirmDTO the entity to save.
     * @return the persisted entity.
     */
    public CompanyFirmDTO save(CompanyFirmDTO companyFirmDTO) {
        log.debug("Request to save CompanyFirm : {}", companyFirmDTO);
        CompanyFirm companyFirm = companyFirmMapper.toEntity(companyFirmDTO);
        companyFirm = companyFirmRepository.save(companyFirm);
        return companyFirmMapper.toDto(companyFirm);
    }

    /**
     * Get all the companyFirms.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<CompanyFirmDTO> findAll(Pageable pageable) {
        log.debug("Request to get all CompanyFirms");
        return companyFirmRepository.findAll(pageable)
            .map(companyFirmMapper::toDto);
    }


    /**
     * Get one companyFirm by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<CompanyFirmDTO> findOne(Long id) {
        log.debug("Request to get CompanyFirm : {}", id);
        return companyFirmRepository.findById(id)
            .map(companyFirmMapper::toDto);
    }

    /**
     * Delete the companyFirm by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete CompanyFirm : {}", id);
        companyFirmRepository.deleteById(id);
    }
}
