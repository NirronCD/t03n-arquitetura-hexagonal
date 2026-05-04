package com.fag.lucasmartins.arquitetura_software.infrastructure.adapters.in.messaging.pedido.dto;

import java.time.OffsetDateTime;
import java.util.List;

public class EntradaPedidoDTO {

    private String zipCode;
    private Integer customerId;
    private List<PedidoItemDTO> orderItems;
    private String origin;
    private OffsetDateTime occurredAt;

    public EntradaPedidoDTO() {}

    public EntradaPedidoDTO(String zipCode, Integer customerId, List<PedidoItemDTO> orderItems, String origin, OffsetDateTime occurredAt) {
        this.zipCode = zipCode;
        this.customerId = customerId;
        this.orderItems = orderItems;
        this.origin = origin;
        this.occurredAt = occurredAt;
    }

    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) { this.zipCode = zipCode; }

    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    public List<PedidoItemDTO> getOrderItems() { return orderItems; }
    public void setOrderItems(List<PedidoItemDTO> orderItems) { this.orderItems = orderItems; }

    public String getOrigin() { return origin; }
    public void setOrigin(String origin) { this.origin = origin; }

    public OffsetDateTime getOccurredAt() { return occurredAt; }
    public void setOccurredAt(OffsetDateTime occurredAt) { this.occurredAt = occurredAt; }
}