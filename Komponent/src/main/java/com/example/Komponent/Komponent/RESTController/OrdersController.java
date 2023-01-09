package com.example.Komponent.Komponent.RESTController;

import com.example.Komponent.Komponent.AddressDTO;
import com.example.Komponent.Komponent.CartDTO;
import com.example.Komponent.Komponent.OrdersDTO;
import com.example.Komponent.Komponent.PaymentDTO;
import com.example.Komponent.Komponent.model.*;
import com.example.Komponent.Komponent.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @Autowired
    private OrdersService OrdersService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

//    Optional<User> userOptional = userRepo.findById(id);
//        if (userOptional.isPresent()) {
//        ArrayList<Orders> orderList = new ArrayList<>();
//        for(Orders orders : orderList){
//            if(id == orders.getCart().getUser().getId()){
//                orderList.add(orders);
//            }
//        }
//        return orderList;

    @GetMapping
    public List<OrdersDTO> getOrders() {
        List<Orders> ordersList = OrdersService.getAllOrders();
        List<OrdersDTO> orderDTOList = new ArrayList<>();
        for(Orders orders : ordersList){
            orderDTOList.add(ordersToDTO(orders));
        }
        return orderDTOList;
    }

    @PostMapping
    public OrdersDTO createOrder(@RequestBody Orders orders) {
        Address address = orders.getAddress();
        address = addressService.saveAddress(address);

        System.out.print("address" +address);

        Payment payment = orders.getPayment();
        payment = paymentService.savePayment(payment);

        System.out.print("payment" +payment);

        User user = userService.getUserById(orders.getUser().getId());
        Cart cart = cartService.getCartById(orders.getCart().getUser().getId());
        orders.setUser(user);
        orders.setAddress(address);
        orders.setPayment(payment);
        orders.setCart(cart);
        System.out.println("orders" +orders);
        return ordersToDTO(OrdersService.saveOrder(orders));
    }
    @PutMapping
    public Orders updateOrder(@RequestBody Orders orders) {
        return OrdersService.saveOrder(orders);
    }
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable("id") int id) {
        OrdersService.deleteOrder(id);
    }

    private OrdersDTO ordersToDTO(Orders order){
        OrdersDTO ordersDTO = new OrdersDTO();
        ordersDTO.setId(order.getId());
        ordersDTO.setOrder_date(order.getOrder_date());
        ordersDTO.setOrder_total(order.getOrder_total());

        ordersDTO.setAddress(addressToDTO(order.getAddress()));
        ordersDTO.setPayment(paymentToDTO(order.getPayment()));
        ordersDTO.setCart(cartToDTO(order.getCart()));
        return ordersDTO;
    }

    private CartDTO cartToDTO(Cart cart){
        CartDTO cartDTO = new CartDTO();

        cartDTO.setCart_total(cart.getCart_total());
        cartDTO.setShipping_cost(cart.getShipping_cost());
        cartDTO.setTaxes(cart.getTaxes());
        cartDTO.setUser(cart.getUser());

        return cartDTO;
    }

    private PaymentDTO paymentToDTO(Payment payment){
        PaymentDTO paymentDTO = new PaymentDTO();

        paymentDTO.setPayment_method(payment.getPayment_method());
        paymentDTO.setCard_type(payment.getCard_type());
        paymentDTO.setCard_number(payment.getCard_number());
        paymentDTO.setCard_expiery(payment.getCard_expiery());
        paymentDTO.setCard_cvv(payment.getCard_cvv());

        return paymentDTO;
    }

    private AddressDTO addressToDTO(Address address){
        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setStreet1(address.getStreet1());
        addressDTO.setStreet2(address.getStreet2());
        addressDTO.setCity(address.getCity());
        addressDTO.setCountry(address.getCountry());
        addressDTO.setState(address.getState());
        addressDTO.setZip_code(address.getZip_code());
        addressDTO.setAddress_type(address.getAddress_type());

        return addressDTO;
    }





}
