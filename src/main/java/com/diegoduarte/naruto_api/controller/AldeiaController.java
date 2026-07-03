package com.diegoduarte.naruto_api.controller;

import com.diegoduarte.naruto_api.business.AldeiaService;
import com.diegoduarte.naruto_api.business.dtos.request.AldeiaRequestDTO;
import com.diegoduarte.naruto_api.business.dtos.response.AldeiaResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/aldeia")
@RequiredArgsConstructor
@Tag(name = "Aldeia", description = "Gerenciamento de aldeias")
public class AldeiaController {

    private final AldeiaService aldeiaService;

    @PostMapping
    public ResponseEntity<AldeiaResponseDTO> cadastraAldeia (@RequestBody @Valid AldeiaRequestDTO dto) {
        return ResponseEntity.ok(aldeiaService.cadastraAldeia(dto));
    }

    @GetMapping
    public ResponseEntity<List<AldeiaResponseDTO>> listarAldeias () {
        return ResponseEntity.ok(aldeiaService.listarAldeias());
    }

    @GetMapping(("/{id}"))
    public ResponseEntity<AldeiaResponseDTO> buscaPorId (@PathVariable("id") Long id) {
        return ResponseEntity.ok(aldeiaService.buscaPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AldeiaResponseDTO> atualizaPorId (@RequestBody @Valid AldeiaRequestDTO dto,
                                                            @PathVariable("id") Long id) {
        return ResponseEntity.ok(aldeiaService.atualizaPorId(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable("id") Long id) {
        aldeiaService.deletaPorId(id);
        return ResponseEntity.ok().build();
    }
}
