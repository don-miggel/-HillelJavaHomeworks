package my.restful.hw.controller;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import my.restful.hw.model.Order;
import my.restful.hw.repo.OrderRepo;


import java.util.List;

@Path("orders")
public class OrderResource {

    @Inject
    private OrderRepo orderRepo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getAll() {
        return orderRepo.getAllOrders();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Order getOrderById(@PathParam("id") Integer id){

        if(id != null)
            return orderRepo.getOrderById(id);
        return null;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Order add(Order newOrd) {
        return orderRepo.addOrder(newOrd);
    }
}
