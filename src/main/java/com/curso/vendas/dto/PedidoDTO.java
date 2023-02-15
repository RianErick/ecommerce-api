package com.curso.vendas.dto;

import com.curso.vendas.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
public class PedidoDTO {

    private Integer cliente;
    private BigDecimal total;
    private List<itensPedidoDTO> itens;

}
