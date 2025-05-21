package com.motoflow.patio.challenge.service;

import com.motoflow.patio.challenge.dto.EntradaSaidaDTO;
import com.motoflow.patio.challenge.model.EntradaSaida;
import com.motoflow.patio.challenge.model.Veiculo;
import com.motoflow.patio.challenge.repository.EntradaSaidaRepository;
import com.motoflow.patio.challenge.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntradaSaidaService {

    @Autowired
    private EntradaSaidaRepository entradaSaidaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    private EntradaSaida fromDTO(EntradaSaidaDTO dto) {
        EntradaSaida e = new EntradaSaida();
        e.setId(dto.getId());
        e.setHoraEntrada(dto.getHoraEntrada());
        e.setHoraSaida(dto.getHoraSaida());

        Veiculo veiculo = veiculoRepository.findById(dto.getVeiculoId())
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado com id: " + dto.getVeiculoId()));
        e.setVeiculo(veiculo);

        return e;
    }

    private EntradaSaidaDTO toDTO(EntradaSaida e) {
        EntradaSaidaDTO dto = new EntradaSaidaDTO();
        dto.setId(e.getId());
        dto.setHoraEntrada(e.getHoraEntrada());
        dto.setHoraSaida(e.getHoraSaida());
        dto.setVeiculoId(e.getVeiculo().getId());
        return dto;
    }

    public EntradaSaidaDTO salvar(EntradaSaidaDTO dto) {
        EntradaSaida e = fromDTO(dto);
        e = entradaSaidaRepository.save(e);
        return toDTO(e);
    }

    public List<EntradaSaidaDTO> listarTodos() {
        List<EntradaSaida> lista = entradaSaidaRepository.findAll();
        return lista.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public EntradaSaidaDTO buscarPorId(Long id) {
        return entradaSaidaRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public void deletar(Long id) {
        entradaSaidaRepository.deleteById(id);
    }
}
