package my.restful.hw.binder;

import my.restful.hw.repo.OrderRepo;
import my.restful.hw.repo.OrderRepoImpl;
import org.glassfish.hk2.api.Factory;


public class OrderServiceFactory implements Factory<OrderRepo> {
    @Override
    public OrderRepo provide() {
        return new OrderRepoImpl();
    }

    @Override
    public void dispose(OrderRepo orderService) {
        // close resources if available
    }
}
