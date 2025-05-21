package com.motoflow.patio.challenge.repository;

import com.motoflow.patio.challenge.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
}