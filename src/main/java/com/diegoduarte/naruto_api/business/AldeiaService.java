package com.diegoduarte.naruto_api.business;

import com.diegoduarte.naruto_api.business.converter.AldeiaConverter;
import com.diegoduarte.naruto_api.business.dtos.request.AldeiaRequestDTO;
import com.diegoduarte.naruto_api.business.dtos.response.AldeiaResponseDTO;
import com.diegoduarte.naruto_api.infrastructure.entities.AldeiaEntity;
import com.diegoduarte.naruto_api.infrastructure.exceptions.ResourceNotFoundException;
import com.diegoduarte.naruto_api.infrastructure.repositories.AldeiaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AldeiaService {

    private final AldeiaConverter converter;
    private final AldeiaRepository repository;

    public AldeiaResponseDTO cadastraAldeia (AldeiaRequestDTO dto) {
        AldeiaEntity entity = converter.toEntity(dto);
        entity = repository.save(entity);

        return converter.toDTO(entity);

    }

    public List<AldeiaResponseDTO> listarAldeias () {
        return repository.findAll()
                .stream()
                .map(converter::toDTO)
                .toList();
    }

    public AldeiaResponseDTO buscaPorId (Long id) {
        AldeiaEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aldeia não localizada"));

        return converter.toDTO((entity));
    }

    public AldeiaResponseDTO atualizaPorId (Long id, AldeiaRequestDTO dto) {
        AldeiaEntity entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aldeia não localizada"));

        entity.setNome(dto.getNome());
        entity.setPais(dto.getPais());

        return converter.toDTO(repository.save(entity));
    }

    public void deletaPorId (Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Aldeia não localizada");
        }

        repository.deleteById(id);

    }
}
