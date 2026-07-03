package com.diegoduarte.naruto_api.business;

import com.diegoduarte.naruto_api.business.converter.JutsuConverter;
import com.diegoduarte.naruto_api.business.dtos.request.JutsuRequestDTO;
import com.diegoduarte.naruto_api.business.dtos.response.JutsuResponseDTO;
import com.diegoduarte.naruto_api.infrastructure.entities.JutsuEntity;
import com.diegoduarte.naruto_api.infrastructure.exceptions.ResourceNotFoundException;
import com.diegoduarte.naruto_api.infrastructure.repositories.JutsuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JutsuService {

    private final JutsuConverter converter;
    private final JutsuRepository repository;

    public JutsuResponseDTO cadastrarJutsu (JutsuRequestDTO dto) {
        JutsuEntity entity = converter.toEntity(dto);

        return converter.toDTO(repository.save(entity));
    }

    public List<JutsuResponseDTO> listarJutsus () {
        return repository.findAll()
                .stream()
                .map(converter::toDTO)
                .toList();
    }

    public JutsuResponseDTO getById (Long id) {
        JutsuEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jutsu não encontrado"));

        return converter.toDTO(entity);
    }

    public JutsuResponseDTO updateById (Long id, JutsuRequestDTO dto) {
        JutsuEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jutsu não encontrado"));

        entity.setNome(dto.getNome());
        entity.setRank(dto.getRank());
        entity.setTipo(dto.getTipo());

        return converter.toDTO(repository.save(entity));
    }

    public void deleteById (Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Jutsu não encontrado");
        }

        repository.deleteById(id);
    }
}
