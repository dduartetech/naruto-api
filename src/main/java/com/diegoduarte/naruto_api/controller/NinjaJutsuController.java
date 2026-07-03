package com.diegoduarte.naruto_api.controller;

import com.diegoduarte.naruto_api.business.NinjaJutsuService;
import com.diegoduarte.naruto_api.business.dtos.request.NinjaJutsuRequestDTO;
import com.diegoduarte.naruto_api.business.dtos.response.NinjaJutsuResponseDTO;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja-jutsu")
@RequiredArgsConstructor
@Tag(name = "Ninja Jutsu", description = "Gerenciamento de jutsus dos ninjas")
public class NinjaJutsuController {

    private final NinjaJutsuService ninjaJutsuService;

    @PostMapping
    public ResponseEntity<NinjaJutsuResponseDTO> createJutsu (@RequestBody @Valid NinjaJutsuRequestDTO dto) {
        return ResponseEntity.ok(ninjaJutsuService.createJutsu(dto));
    }

    @GetMapping
    public ResponseEntity<List<NinjaJutsuResponseDTO>> listarNinjasJutsus () {
        return ResponseEntity.ok(ninjaJutsuService.listarNinjasJutsus());
    }

    @GetMapping("/{id}")
    public ResponseEntity<NinjaJutsuResponseDTO> getById (@PathVariable("id") Long id) {
        return ResponseEntity.ok(ninjaJutsuService.getById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable("id") Long id) {
        ninjaJutsuService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
