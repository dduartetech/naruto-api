package com.diegoduarte.naruto_api.business;

import com.diegoduarte.naruto_api.business.converter.ClaConverter;
import com.diegoduarte.naruto_api.business.dtos.request.ClaRequestDTO;
import com.diegoduarte.naruto_api.business.dtos.response.ClaResponseDTO;
import com.diegoduarte.naruto_api.infrastructure.entities.AldeiaEntity;
import com.diegoduarte.naruto_api.infrastructure.entities.ClaEntity;
import com.diegoduarte.naruto_api.infrastructure.exceptions.ResourceNotFoundException;
import com.diegoduarte.naruto_api.infrastructure.repositories.AldeiaRepository;
import com.diegoduarte.naruto_api.infrastructure.repositories.ClaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClaService {

    private final ClaConverter converter;
    private final ClaRepository repository;
    private final AldeiaRepository aldeiaRepository;

    public ClaResponseDTO createCla (ClaRequestDTO dto) {
        AldeiaEntity aldeia = aldeiaRepository.findById(dto.getAldeiaId())
                .orElseThrow(() -> new ResourceNotFoundException("Aldeia não localizada"));

        ClaEntity entity = converter.toEntity(dto, aldeia);

        return converter.toDTO(repository.save(entity));
    }

    public List<ClaResponseDTO> listarClas () {
        return repository.findAll()
                .stream()
                .map(converter::toDTO)
                .toList();
    }

    public ClaResponseDTO getById (Long id) {
        ClaEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clã não encontrado"));

        return converter.toDTO(entity);
    }

    public ClaResponseDTO updateById (Long id, ClaRequestDTO dto) {
        AldeiaEntity aldeia = aldeiaRepository.findById(dto.getAldeiaId())
                .orElseThrow(() -> new ResourceNotFoundException("Aldeia não localizada"));

        ClaEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Clã não encontrado"));

        entity.setNome(dto.getNome());
        entity.setKekkeiGenkai(dto.getKekkeiGenkai());
        entity.setAldeia(aldeia);

        return converter.toDTO(repository.save(entity));
    }

    public void deleteById (Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Clã não encontrado");
        }

        repository.deleteById(id);
    }
}