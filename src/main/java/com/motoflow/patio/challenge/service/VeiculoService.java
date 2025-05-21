package com.motoflow.patio.challenge.service;

import com.motoflow.patio.challenge.dto.VeiculoDTO;
import com.motoflow.patio.challenge.model.Veiculo;
import com.motoflow.patio.challenge.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    // Converter DTO para Entidade
    private Veiculo fromDTO(VeiculoDTO dto) {
        Veiculo v = new Veiculo();
        v.setId(dto.getId());
        v.setPlaca(dto.getPlaca());
        v.setMarca(dto.getMarca());
        v.setModelo(dto.getModelo());
        return v;
    }

    // Converter Entidade para DTO
    private VeiculoDTO toDTO(Veiculo v) {
        VeiculoDTO dto = new VeiculoDTO();
        dto.setId(v.getId());
        dto.setPlaca(v.getPlaca());
        dto.setMarca(v.getMarca());
        dto.setModelo(v.getModelo());
        return dto;
    }

    public VeiculoDTO salvar(VeiculoDTO dto) {
        Veiculo veiculo = fromDTO(dto);
        veiculo = veiculoRepository.save(veiculo);
        return toDTO(veiculo);
    }

    public List<VeiculoDTO> listarTodos() {
        List<Veiculo> lista = veiculoRepository.findAll();
        return lista.stream().map(this::toDTO).collect(Collectors.toList());
    }

    public VeiculoDTO buscarPorId(Long id) {
        return veiculoRepository.findById(id)
                .map(this::toDTO)
                .orElse(null);
    }

    public void deletar(Long id) {
        veiculoRepository.deleteById(id);
    }
}