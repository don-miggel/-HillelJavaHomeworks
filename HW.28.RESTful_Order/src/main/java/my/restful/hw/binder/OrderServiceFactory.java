package my.restful.hw.binder;

import my.restful.hw.service.OrderService;
import my.restful.hw.service.OrderServiceImpl;
import org.glassfish.hk2.api.Factory;


public class OrderServiceFactory implements Factory<OrderService> {
    @Override
    public OrderService provide() {
        return new OrderServiceImpl();
    }

    @Override
    public void dispose(OrderService orderService) {
        // close resources if available
    }
}
