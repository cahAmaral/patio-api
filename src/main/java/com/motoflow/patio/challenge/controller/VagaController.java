package com.motoflow.patio.challenge.controller;

import com.motoflow.patio.challenge.dto.VagaDTO;
import com.motoflow.patio.challenge.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vaga")
public class VagaController {

    @Autowired
    private VagaService vagaService;

    @GetMapping
    public List<VagaDTO> listarTodos() {
        return vagaService.listarTodos();
    }

    @GetMapping("/{id}")
    public VagaDTO buscarPorId(@PathVariable Long id) {
        return vagaService.buscarPorId(id);
    }

    @PostMapping
    public VagaDTO salvar(@RequestBody VagaDTO dto) {
        return vagaService.salvar(dto);
    }

    @PutMapping("/{id}")
    public VagaDTO atualizar(@PathVariable Long id, @RequestBody VagaDTO dto) {
        dto.setId(id);
        return vagaService.salvar(dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        vagaService.deletar(id);
    }
}
