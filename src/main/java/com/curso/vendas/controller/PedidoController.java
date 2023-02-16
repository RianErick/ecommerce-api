package com.curso.vendas.controller;

import com.curso.vendas.dto.PedidoDTO;
import com.curso.vendas.model.Pedido;
import com.curso.vendas.service.impl.PedidoService;
import com.curso.vendas.service.impl.PedidoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/salvar")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer salvarPedido(@RequestBody PedidoDTO dto) {
        Pedido pedido = pedidoService.salvar(dto);
        return pedido.getId();
    }

}
