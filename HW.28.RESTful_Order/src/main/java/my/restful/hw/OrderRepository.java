package my.restful.hw;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import my.restful.hw.model.Order;
import my.restful.hw.service.OrderService;


import java.util.List;

@Path("orders")
public class OrderRepository {

    @Inject
    private OrderService orderService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getAll() {
        return orderService.getAllOrders();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order getOrderById(@PathParam("id") Integer id){

        if(id != null)
            return orderService.getOrderById(id);
        return null;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Order add(Order newOrd) {
        return orderService.addOrder(newOrd);
    }
}
