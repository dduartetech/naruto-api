package com.diegoduarte.naruto_api.controller;

import com.diegoduarte.naruto_api.business.JutsuService;
import com.diegoduarte.naruto_api.business.dtos.request.JutsuRequestDTO;
import com.diegoduarte.naruto_api.business.dtos.response.JutsuResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jutsu")
@RequiredArgsConstructor
@Tag(name = "Jutsu", description = "Gerenciamento de jutsus")
public class JutsuController {

    private final JutsuService jutsuService;

    @PostMapping
    public ResponseEntity<JutsuResponseDTO> cadastrarJutsu (@RequestBody @Valid JutsuRequestDTO dto) {
        return ResponseEntity.ok(jutsuService.cadastrarJutsu(dto));
    }

    @GetMapping
    public ResponseEntity<List<JutsuResponseDTO>> listarJutsus () {
        return ResponseEntity.ok(jutsuService.listarJutsus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JutsuResponseDTO> getById (@PathVariable("id") Long id) {
        return ResponseEntity.ok(jutsuService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JutsuResponseDTO> updateById (@RequestBody @Valid JutsuRequestDTO dto,
                                                        @PathVariable("id") Long id) {
        return ResponseEntity.ok(jutsuService.updateById(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable("id") Long id) {
        jutsuService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
