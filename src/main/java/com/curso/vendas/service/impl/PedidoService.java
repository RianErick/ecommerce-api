package com.curso.vendas.service.impl;

import com.curso.vendas.dto.PedidoDTO;
import com.curso.vendas.model.Pedido;

import java.util.Optional;

public interface PedidoService {

    Pedido salvar (PedidoDTO dto);

Optional<Pedido> obterPedidoCompleto(Integer id);

}
