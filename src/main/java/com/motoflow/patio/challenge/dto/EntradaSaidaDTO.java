package com.motoflow.patio.challenge.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class EntradaSaidaDTO {

    private Long id;

    @NotNull(message = "Hora de entrada é obrigatória")
    private LocalDateTime horaEntrada;

    private LocalDateTime horaSaida;

    @NotNull(message = "ID do veículo é obrigatório")
    private Long veiculoId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public Long getVeiculoId() {
        return veiculoId;
    }

    public void setVeiculoId(Long veiculoId) {
        this.veiculoId = veiculoId;
    }
}
