package com.motoflow.patio.challenge.controller;

import com.motoflow.patio.challenge.dto.VeiculoDTO;
import com.motoflow.patio.challenge.service.VeiculoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<VeiculoDTO> criarVeiculo(@Valid @RequestBody VeiculoDTO dto) {
        VeiculoDTO veiculoSalvo = veiculoService.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoSalvo);
    }

    @GetMapping
    public ResponseEntity<List<VeiculoDTO>> listarVeiculos() {
        List<VeiculoDTO> lista = veiculoService.listarTodos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDTO> buscarVeiculoPorId(@PathVariable Long id) {
        VeiculoDTO dto = veiculoService.buscarPorId(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoDTO> atualizarVeiculo(@PathVariable Long id, @Valid @RequestBody VeiculoDTO dto) {
        dto.setId(id); // garante que id do path e do dto sejam os mesmos
        VeiculoDTO veiculoAtualizado = veiculoService.salvar(dto);
        return ResponseEntity.ok(veiculoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarVeiculo(@PathVariable Long id) {
        veiculoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
