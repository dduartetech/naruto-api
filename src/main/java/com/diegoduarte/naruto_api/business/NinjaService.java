package com.diegoduarte.naruto_api.business;

import com.diegoduarte.naruto_api.business.converter.NinjaConverter;
import com.diegoduarte.naruto_api.business.dtos.request.NinjaRequestDTO;
import com.diegoduarte.naruto_api.business.dtos.response.NinjaResponseDTO;
import com.diegoduarte.naruto_api.infrastructure.entities.AldeiaEntity;
import com.diegoduarte.naruto_api.infrastructure.entities.ClaEntity;
import com.diegoduarte.naruto_api.infrastructure.entities.NinjaEntity;
import com.diegoduarte.naruto_api.infrastructure.exceptions.ResourceNotFoundException;
import com.diegoduarte.naruto_api.infrastructure.repositories.AldeiaRepository;
import com.diegoduarte.naruto_api.infrastructure.repositories.ClaRepository;
import com.diegoduarte.naruto_api.infrastructure.repositories.NinjaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NinjaService {

    private final NinjaConverter converter;
    private final NinjaRepository repository;
    private final AldeiaRepository aldeiaRepository;
    private final ClaRepository claRepository;

    public NinjaResponseDTO createNinja (NinjaRequestDTO dto) {
        AldeiaEntity aldeia = aldeiaRepository.findById(dto.getAldeiaId()).orElseThrow(() ->
                new ResourceNotFoundException("Aldeia não encontrada."));

        ClaEntity cla = dto.getClaId() != null
                ? claRepository.findById(dto.getClaId())
                .orElseThrow(() -> new ResourceNotFoundException("Clã não encontrado."))
                : null;

        NinjaEntity ninja = converter.toEntity(dto, aldeia, cla);

        return converter.toDTO(repository.save(ninja));
    }

    public List<NinjaResponseDTO> listarNinjas () {
        return repository.findAll()
                .stream()
                .map(converter::toDTO)
                .toList();
    }

    public NinjaResponseDTO findById (Long id) {
        NinjaEntity ninja = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Ninja não encontrada."));

        return converter.toDTO(ninja);
    }

    public NinjaResponseDTO updateById (NinjaRequestDTO dto, Long id) {
        AldeiaEntity aldeia = aldeiaRepository.findById(dto.getAldeiaId()).orElseThrow(() ->
                new ResourceNotFoundException("Aldeia não encontrada."));

        ClaEntity cla = dto.getClaId() != null
                ? claRepository.findById(dto.getClaId())
                .orElseThrow(() -> new ResourceNotFoundException("Clã não encontrado."))
                : null;

        NinjaEntity entity = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Ninja não econtrado."));

        entity.setNome(dto.getNome());
        entity.setRank(dto.getRank());
        entity.setChakra(dto.getChakra());
        entity.setAtivo(dto.getAtivo());
        entity.setAldeia(aldeia);
        entity.setCla(cla);

        return converter.toDTO(repository.save(entity));
    }

    public void deleteById (Long id) {
        NinjaEntity entity = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Ninja não encontrado"));

        entity.setAtivo(false);
        repository.save(entity);
    }
}
