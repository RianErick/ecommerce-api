package com.curso.vendas.service.impl;

import com.curso.vendas.dto.PedidoDTO;
import com.curso.vendas.model.Pedido;

public interface PedidoService {

    Pedido salvar (PedidoDTO dto);
}
