package com.curso.vendas.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;


@Data
public class PedidoDTO {

    private Integer cliente;
    private BigDecimal total;
    private List<itensPedidoDTO> itens;

}