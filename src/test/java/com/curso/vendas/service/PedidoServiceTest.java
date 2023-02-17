//package com.curso.vendas.service;
//
//import com.curso.vendas.ApplicationConfigTest;
//import com.curso.vendas.dto.PedidoDTO;
//import com.curso.vendas.model.Cliente;
//import com.curso.vendas.model.ItemPedido;
//import com.curso.vendas.model.Pedido;
//import com.curso.vendas.repository.ClienteRepository;
//import com.curso.vendas.repository.ItemPedidoRepository;
//import com.curso.vendas.repository.PedidoRepository;
//import com.curso.vendas.repository.ProdutoRepository;
//import com.curso.vendas.service.impl.PedidoServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.Collections;
//import java.util.Optional;
//
//public class PedidoServiceTest extends ApplicationConfigTest {
//
//    @MockBean
//    private PedidoRepository pedidoRepository;
//
//    @MockBean
//    private ClienteRepository clienteRepository;
//
//    @MockBean
//    private ProdutoRepository produtoRepository;
//
//    @MockBean
//    private ItemPedidoRepository itemPedidoRepository;
//
//    @Autowired
//    PedidoServiceImpl pedidoService;
//
//    PedidoDTO pedidoDTO;
//
//    Pedido pedido;
//
//    Cliente cliente;
//
//    ItemPedido itemPedido;

//    itensPedidoDTO itensPedidoDTO;
//    @BeforeEach
//    void setup(){
//        itensPedidoDTO = Mockito.mock(itensPedidoDTO.class);
//        itemPedido =  Mockito.mock(ItemPedido.class);
//
//        pedidoDTO = Mockito.mock(PedidoDTO.class);
//        pedidoDTO.setCliente(1);
//
//        cliente = Mockito.mock(Cliente.class);
//
//        pedido = Mockito.mock(Pedido.class);
//        pedido.setCliente(cliente);
//        pedido.setDataPedido(LocalDate.now());
//        pedido.setTotal(BigDecimal.ONE);
//        pedido.setItens(Collections.singletonList(itemPedido));
//
//    }
//
//    @Test
//    void deveSalvarOPedido_ComSucesso(){
//        // preparação
//        Mockito.when(clienteRepository.findById(ArgumentMatchers.anyInt())).thenReturn(Optional.of(cliente));
//        PedidoDTO pedidoDTOTeste = new PedidoDTO();
//        pedidoDTOTeste.setCliente(1);
//        pedidoDTOTeste.setTotal(BigDecimal.ONE);
//        pedidoDTOTeste.setItens(Collections.singletonList(itensPedidoDTO));
//        // ação
//        //Pedido resposta = pedidoService.salvar();
//
//        // assertions
//
//
//    }
//
//
//}
