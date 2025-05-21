package com.motoflow.patio.challenge.controller;

import com.motoflow.patio.challenge.dto.EntradaSaidaDTO;
import com.motoflow.patio.challenge.service.EntradaSaidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/entradasaida")
public class EntradaSaidaController {

    @Autowired
    private EntradaSaidaService entradaSaidaService;

    @GetMapping
    public List<EntradaSaidaDTO> listarTodos() {
        return entradaSaidaService.listarTodos();
    }

    @GetMapping("/{id}")
    public EntradaSaidaDTO buscarPorId(@PathVariable Long id) {
        return entradaSaidaService.buscarPorId(id);
    }

    @PostMapping
    public EntradaSaidaDTO salvar(@RequestBody EntradaSaidaDTO dto) {
        return entradaSaidaService.salvar(dto);
    }

    @PutMapping("/{id}")
    public EntradaSaidaDTO atualizar(@PathVariable Long id, @RequestBody EntradaSaidaDTO dto) {
        dto.setId(id);
        return entradaSaidaService.salvar(dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        entradaSaidaService.deletar(id);
    }
}
