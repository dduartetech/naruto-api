package com.diegoduarte.naruto_api.controller;

import com.diegoduarte.naruto_api.business.NinjaService;
import com.diegoduarte.naruto_api.business.dtos.request.NinjaRequestDTO;
import com.diegoduarte.naruto_api.business.dtos.response.NinjaResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
@RequiredArgsConstructor
@Tag(name = "Ninja", description = "Gerenciamento de ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    @PostMapping
    public ResponseEntity<NinjaResponseDTO> createNinja (@RequestBody @Valid NinjaRequestDTO dto) {
        return ResponseEntity.ok(ninjaService.createNinja(dto));
    }

    @GetMapping
    public ResponseEntity<List<NinjaResponseDTO>> listarNinjas () {
        return ResponseEntity.ok(ninjaService.listarNinjas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NinjaResponseDTO> findById (@PathVariable("id") Long id) {
        return ResponseEntity.ok(ninjaService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NinjaResponseDTO> updateById (@RequestBody @Valid NinjaRequestDTO dto,
                                        @PathVariable("id") Long id) {
        return ResponseEntity.ok(ninjaService.updateById(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable("id") Long id) {
        ninjaService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
