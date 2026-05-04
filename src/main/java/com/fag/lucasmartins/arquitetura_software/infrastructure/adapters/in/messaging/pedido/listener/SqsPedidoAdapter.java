package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.listener;

import com.fag.lucasmartins.arquitetura_software.application.ports.in.service.PedidoServicePort;
import com.fag.lucasmartins.arquitetura_software.core.domain.bo.PedidoBO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto.EntradaPedidoDTO;
import com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.mapper.PedidoBOMapper;
import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class SqsPedidoAdapter {;

    private final PedidoServicePort pedidoServicePort;
    private final PedidoBOMapper pedidoBOMapper;

    public SqsPedidoAdapter(PedidoServicePort pedidoServicePort, PedidoBOMapper pedidoBOMapper) {
        this.pedidoServicePort = pedidoServicePort;
        this.pedidoBOMapper = pedidoBOMapper;
    }

    @SqsListener("${queue.order-events}")
    public void listen(EntradaPedidoDTO dto) {
        System.out.println("Mensagem recebida, pessoa ID: " + dto.getCustomerId());

        PedidoBO pedidoBO = pedidoBOMapper.toBo(dto);

        pedidoServicePort.criarPedido(pedidoBO);

        System.out.println("Mensagem consumida com sucesso. Pedido cadastrado com sucesso!");
    };

};
    
    