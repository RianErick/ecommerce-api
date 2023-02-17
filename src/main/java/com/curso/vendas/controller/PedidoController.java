package com.curso.vendas.controller;

import com.curso.vendas.dto.InformacoesItemPedidoDTO;
import com.curso.vendas.dto.InformacoesPedidoDTO;
import com.curso.vendas.dto.PedidoDTO;
import com.curso.vendas.exception.regras.RegraNegocioExeption;
import com.curso.vendas.model.ItemPedido;
import com.curso.vendas.model.Pedido;
import com.curso.vendas.service.impl.PedidoService;
import com.curso.vendas.service.impl.PedidoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
    @GetMapping("/{id}")
    public InformacoesPedidoDTO getByid(@PathVariable Integer id){
        return pedidoService.obterPedidoCompleto(id)
                .map(p -> converter(p))
                .orElseThrow (  () -> new RegraNegocioExeption( HttpStatus.NOT_FOUND,"Pedido Inexistente"));
    }

    private InformacoesPedidoDTO converter(Pedido pedido){
          return InformacoesPedidoDTO.builder()
                   .codigo(pedido.getId())
                   .dataPedido(pedido.getDataPedido().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))
                   .cpf(pedido.getCliente().getCpf())
                   .nomeCliente(pedido.getCliente().getNome())
                   .total(pedido.getTotal())
                   .itens(converter(pedido.getItens())).build();

    }
    public List<InformacoesItemPedidoDTO> converter (List<ItemPedido> itens){
        if(CollectionUtils.isEmpty(itens)){
         return Collections.emptyList();
        }
        return itens.stream().map(
                item -> InformacoesItemPedidoDTO
                        .builder()
                        .descricaoProduto(item.getProduto().getDescricao())
                        .precoUnitario(item.getProduto().getPreco())
                        .quantidade(item.getQuantidade())
                        .build()
        ).collect(Collectors.toList());

    }


}
