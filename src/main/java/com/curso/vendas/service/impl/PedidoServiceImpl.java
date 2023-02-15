package com.curso.vendas.service.impl;

import com.curso.vendas.dto.PedidoDTO;
import com.curso.vendas.dto.itensPedidoDTO;
import com.curso.vendas.exception.RegaNegocioExeption;
import com.curso.vendas.model.Cliente;
import com.curso.vendas.model.ItemPedido;
import com.curso.vendas.model.Pedido;
import com.curso.vendas.model.Produto;
import com.curso.vendas.repository.ClienteRepository;
import com.curso.vendas.repository.ItemPedidoRepository;
import com.curso.vendas.repository.PedidoRepository;
import com.curso.vendas.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService{

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Override
    public Pedido salvar(PedidoDTO dto) {

        Integer idCliente = dto.getCliente();
     Cliente cliente = clienteRepository
                .findById(idCliente).
                orElseThrow( () -> new RegaNegocioExeption("Codigo de Cliente Invalido"));

         Pedido pedido = new Pedido();
         pedido.setTotal(dto.getTotal());
         pedido.setDataPedido(LocalDate.now());
         pedido.setCliente(cliente);
        List <ItemPedido> itemPedidos = converterItens(pedido,dto.getItens());


         return null;
    }
    private List<ItemPedido> converterItens (Pedido pedido , List <itensPedidoDTO> itens){
        if(itens.isEmpty()){
            throw new RegaNegocioExeption("Pedido Sem Itens");
        }
        return itens.stream().map(dto -> {

            Integer idProduto = dto.getProduto();
        Produto produto = produtoRepository.findById(idProduto)
                    .orElseThrow(() -> new RegaNegocioExeption("Codigo de prduto invalido" + idProduto));

            ItemPedido itemPedido = new ItemPedido();
            itemPedido.setQuantidade(dto.getQuantidade());
            itemPedido.setPedido(pedido);
            itemPedido.setProduto(produto);

            return itemPedido;
        }).collect(Collectors.toList());
    }
}
