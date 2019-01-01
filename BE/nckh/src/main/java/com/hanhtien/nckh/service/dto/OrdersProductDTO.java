package com.hanhtien.nckh.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the OrdersProduct entity.
 */
public class OrdersProductDTO implements Serializable {

    private Long id;

    private Integer quantity;

    private Long productId;

    private Long orderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long ordersId) {
        this.orderId = ordersId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        OrdersProductDTO ordersProductDTO = (OrdersProductDTO) o;
        if (ordersProductDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), ordersProductDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "OrdersProductDTO{" +
            "id=" + getId() +
            ", quantity=" + getQuantity() +
            ", product=" + getProductId() +
            ", order=" + getOrderId() +
            "}";
    }
}
