package edu.miu.ea.sandesh.ordermanagementsystem.Order.specification;

import edu.miu.ea.sandesh.ordermanagementsystem.Order.Status;
import edu.miu.ea.sandesh.ordermanagementsystem.Order.entity.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class OrderSpecifications {
    public static Specification<Order> hasRestaurantId(Long restaurantId) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("restaurant").get("id"), restaurantId);
    }

    public static Specification<Order> hasStatus(Status status) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("status"), status);
    }
}
