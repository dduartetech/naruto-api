package com.diegoduarte.naruto_api.controller;

import com.diegoduarte.naruto_api.business.ClaService;
import com.diegoduarte.naruto_api.business.dtos.request.ClaRequestDTO;
import com.diegoduarte.naruto_api.business.dtos.response.ClaResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cla")
@RequiredArgsConstructor
@Tag(name = "Clã", description = "Gerenciamento de clãs")
public class ClaController {

    private final ClaService claService;

    @PostMapping
    public ResponseEntity<ClaResponseDTO> createCla (@RequestBody @Valid ClaRequestDTO dto) {
        return ResponseEntity.ok(claService.createCla(dto));
    }

    @GetMapping
    public ResponseEntity<List<ClaResponseDTO>> listarClas () {
        return ResponseEntity.ok(claService.listarClas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClaResponseDTO> getById (@PathVariable("id") Long id) {
        return ResponseEntity.ok(claService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClaResponseDTO> updateById (@PathVariable("id")Long id,
                                                      @RequestBody @Valid ClaRequestDTO dto) {
        return ResponseEntity.ok(claService.updateById(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable("id") Long id) {
        claService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
