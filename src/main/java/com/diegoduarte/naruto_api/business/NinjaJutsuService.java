package com.diegoduarte.naruto_api.business;

import com.diegoduarte.naruto_api.business.converter.NinjaJutsuConverter;
import com.diegoduarte.naruto_api.business.dtos.request.NinjaJutsuRequestDTO;
import com.diegoduarte.naruto_api.business.dtos.response.NinjaJutsuResponseDTO;
import com.diegoduarte.naruto_api.infrastructure.entities.JutsuEntity;
import com.diegoduarte.naruto_api.infrastructure.entities.NinjaEntity;
import com.diegoduarte.naruto_api.infrastructure.entities.NinjaJutsuEntity;
import com.diegoduarte.naruto_api.infrastructure.exceptions.ResourceNotFoundException;
import com.diegoduarte.naruto_api.infrastructure.repositories.JutsuRepository;
import com.diegoduarte.naruto_api.infrastructure.repositories.NinjaJutsuRepository;
import com.diegoduarte.naruto_api.infrastructure.repositories.NinjaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NinjaJutsuService {

    private final NinjaJutsuConverter converter;
    private final NinjaJutsuRepository repository;
    private final NinjaRepository ninjaRepository;
    private final JutsuRepository jutsuRepository;

    public NinjaJutsuResponseDTO createJutsu (NinjaJutsuRequestDTO dto) {
        NinjaEntity ninja = ninjaRepository.findById(dto.getNinjaId()).orElseThrow(() ->
                new ResourceNotFoundException("Ninja não encontrado."));

        JutsuEntity jutsu = jutsuRepository.findById(dto.getJutsuId()).orElseThrow(() ->
                new ResourceNotFoundException("Jutsu não encontrado."));

        NinjaJutsuEntity entity = converter.toEntity(dto, ninja, jutsu);

        return converter.toDTO(repository.save(entity));
    }

    public List<NinjaJutsuResponseDTO> listarNinjasJutsus () {
        return repository.findAll()
                .stream()
                .map(converter::toDTO)
                .toList();
    }

    public NinjaJutsuResponseDTO getById (Long id) {
        NinjaJutsuEntity entity = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Ninja não encontrado"));

        return converter.toDTO(entity);
    }

    public void deleteById (Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Ninja não encontrado.");
        }

        repository.deleteById(id);
    }
}
