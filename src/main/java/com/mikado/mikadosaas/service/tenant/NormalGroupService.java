package com.mikado.mikadosaas.service.tenant;
import com.mikado.mikadosaas.domain.tenant.NormalGroup;
import com.mikado.mikadosaas.repository.tenant.NormalGroupRepository;
import com.mikado.mikadosaas.service.dto.tenant.NormalGroupDTO;
import com.mikado.mikadosaas.service.mapper.tenant.NormalGroupMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class NormalGroupService {

    private final Logger log = LoggerFactory.getLogger(NormalGroupService.class);

    private final NormalGroupRepository normalGroupRepository;

    private final NormalGroupMapper normalGroupMapper;

    public NormalGroupService(NormalGroupRepository normalGroupRepository, NormalGroupMapper normalGroupMapper) {
        this.normalGroupRepository = normalGroupRepository;
        this.normalGroupMapper = normalGroupMapper;
    }

    /**
     * Save a normalGroup.
     *
     * @param normalGroupDTO the entity to save.
     * @return the persisted entity.
     */
    public NormalGroupDTO save(NormalGroupDTO normalGroupDTO) {
        log.debug("Request to save NormalGroup : {}", normalGroupDTO);
        NormalGroup normalGroup = normalGroupMapper.toEntity(normalGroupDTO);
        normalGroup = normalGroupRepository.save(normalGroup);
        return normalGroupMapper.toDto(normalGroup);
    }

    /**
     * Get all the normalGroups.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<NormalGroupDTO> findAll(Pageable pageable) {
        log.debug("Request to get all NormalGroups");
        return normalGroupRepository.findAll(pageable)
            .map(normalGroupMapper::toDto);
    }


    /**
     * Get one normalGroup by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<NormalGroupDTO> findOne(Long id) {
        log.debug("Request to get NormalGroup : {}", id);
        return normalGroupRepository.findById(id)
            .map(normalGroupMapper::toDto);
    }

    /**
     * Delete the normalGroup by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete NormalGroup : {}", id);
        normalGroupRepository.deleteById(id);
    }
}
