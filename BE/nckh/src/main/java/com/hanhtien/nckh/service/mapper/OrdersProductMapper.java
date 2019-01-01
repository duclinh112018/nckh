package com.hanhtien.nckh.service.mapper;

import com.hanhtien.nckh.bean.*;
import com.hanhtien.nckh.service.dto.OrdersProductDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity OrdersProduct and its DTO OrdersProductDTO.
 */
@Mapper(componentModel = "spring", uses = {ProductMapper.class, OrdersMapper.class})
public interface OrdersProductMapper extends EntityMapper<OrdersProductDTO, OrdersProduct> {

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "order.id", target = "orderId")
    OrdersProductDTO toDto(OrdersProduct ordersProduct);

    @Mapping(source = "productId", target = "product")
    @Mapping(source = "orderId", target = "order")
    OrdersProduct toEntity(OrdersProductDTO ordersProductDTO);

    default OrdersProduct fromId(Long id) {
        if (id == null) {
            return null;
        }
        OrdersProduct ordersProduct = new OrdersProduct();
        ordersProduct.setId(id);
        return ordersProduct;
    }
}
