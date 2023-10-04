package my.restful.hw.binder;

import jakarta.inject.Singleton;
import my.restful.hw.repo.OrderRepo;
import org.glassfish.hk2.utilities.binding.AbstractBinder;


public class MyAppBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bindFactory(new OrderServiceFactory())
                .to(OrderRepo.class)
                .in(Singleton.class);
    }

}
