package com.motoflow.patio.challenge.service;

import com.motoflow.patio.challenge.dto.VagaDTO;
import com.motoflow.patio.challenge.model.Vaga;
import com.motoflow.patio.challenge.repository.VagaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    private Vaga fromDTO(VagaDTO dto) {
        Vaga v = new Vaga();
        v.setId(dto.getId());
        v.setNumero(dto.getNumero());
        v.setDescricao(dto.getDescricao());
        return v;
    }

    private VagaDTO toDTO(Vaga v) {
        VagaDTO dto = new VagaDTO();
        dto.setId(v.getId());
        dto.setNumero(v.getNumero());
        dto.setDescricao(v.getDescricao());
        return dto;
    }

    public VagaDTO salvar(VagaDTO dto) {
        Vaga vaga = fromDTO(dto);
        vaga = vagaRepository.save(vaga);
        return toDTO(vaga);
    }

    public List<VagaDTO> listarTodos() {
        List<Vaga> lista = vagaRepository.findAll();
        return lista.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public VagaDTO buscarPorId(Long id) {
        return vagaRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public void deletar(Long id) {
        vagaRepository.deleteById(id);
    }
}
