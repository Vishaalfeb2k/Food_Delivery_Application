package com.fooddelivery.service;

import com.fooddelivery.dto.Items;
import com.fooddelivery.dto.Orders;
import com.fooddelivery.exception.InvalidStatementException;
import com.fooddelivery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService
{



    @Autowired
    public OrderRepository orderRepository;

    @Override
    public List<Orders> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Orders addOrder(@Validated Orders order) {
        return orderRepository.save(order);
    }

    @Override
    public ResponseEntity<List<Orders>> findByCustomerId(long customerId) {
        List<Orders> orders=orderRepository.findBycustomerId(customerId);
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Orders> updateOrderById(Orders orderDetails) {
        Orders order=orderRepository.findById(orderDetails.getOrderId()).get();
        order.setCustomerId(orderDetails.getCustomerId());
        order.setItems(orderDetails.getItems());
        order.setOrderStatus(orderDetails.getOrderStatus());
        final Orders updatedOrder=orderRepository.save(order);
         return ResponseEntity.ok(updatedOrder);

    }

    @Override
    public Map<String, Boolean> deleteOrderById(long orderId) {

        orderRepository.deleteById(orderId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Order deleted", Boolean.TRUE);
        return response;
    }

    @Override
    public ResponseEntity<Orders> updateOrderStatusById(long orderId, String orderStatus) {
        Orders order = orderRepository.findById(orderId).get();
        Map<String, String> hm = new HashMap<>();
        hm.put("PENDING", "PAYMENT_SUCCESS");
        hm.put("PAYMENT_SUCCESS", "ACCEPTED_BY_RESTAURANT");
        hm.put("ACCEPTED_BY_RESTAURANT", "FOOD_READY");
        hm.put("FOOD_READY", "DELIVERY_PERSON_ASSIGNED");
        hm.put("DELIVERY_PERSON_ASSIGNED", "DELIVERED");
        if (hm.get(order.getOrderStatus()).equals(orderStatus)) {
            order.setOrderStatus(orderStatus);
            if(orderStatus.equals("PAYMENT_SUCCESS"))
                sendMail(order);
            final Orders updatedStatus = orderRepository.save(order);
            return ResponseEntity.ok(updatedStatus);
        }
        throw new InvalidStatementException("Invalid Statement");
    }

    public void sendMail(Orders orders){
        String host="smtp.gmail.com";
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES "+properties);
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        Session session=Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("vishaalfeb2000@gmail.com","Manpower@14");
            }
        });
        session.setDebug(true);
        MimeMessage m = new MimeMessage(session);
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("vishaalfeb2000@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("vishaalfeb2000@gmail.com"));
            message.setSubject("Bill Receipt");

            BodyPart messageBodyPart = new MimeBodyPart();
            String items="";
            for(Items item:orders.getItems()) {
             items+=item.getName()+"\t"+item.getPrice()+"\n";
            }

            messageBodyPart.setText("Hi "+"\n"+"Here is your bill"+"\n"+items);
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            Transport.send(message);
            System.out.println("Email Sucessfully Sent");
        }catch (Exception e) {
            e.printStackTrace();
        }

    }


}
