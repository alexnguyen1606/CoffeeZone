package com.CoffeeZone.sendmail;

import com.CoffeeZone.entity.OrderEntity;
import com.CoffeeZone.model.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

@Component
public class SendMail {
    @Autowired
    private JavaMailSender javaMailSender;
    public void ConfirmOrder(String toEmail, int TotalPrice, OrderEntity order, HashMap<Integer,Cart> cartItems){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setTo(toEmail);
            helper.setSubject("[Confirm Order]");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<h2>Code Order:");
            stringBuffer.append(String.valueOf(order.getId())+"</h2><br>");
            stringBuffer.append("<h1>Date:"+order.getCreatedDate().toString()+"</h1><br>");
            for (Map.Entry<Integer, Cart> item : cartItems.entrySet()) {
               stringBuffer.append("<h2>Product:"+String.valueOf(item.getValue().getProduct().getName()));
               stringBuffer.append("    Price:"+String.valueOf(item.getValue().getProduct().getPrice())+" VNĐ");
               stringBuffer.append("    Quantity:"+String.valueOf(item.getValue().getQuantity())+" sp</h2><br>");
            }
            stringBuffer.append("<h1>Total Price:"+String.valueOf(TotalPrice)+"</h1><br>");
            stringBuffer.append("<h1>Status: Đang được xử lý</h1><br>");
            helper.setText(stringBuffer.toString(),true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
    public void cancelOrder(OrderEntity order){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setTo(order.getCustomer().getEmail());
            helper.setSubject("[Cancel Order]");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<h2>Code Order:");
            stringBuffer.append(String.valueOf(order.getId())+"</h2><br>");
            stringBuffer.append("<h1>Date:"+order.getCreatedDate().toString()+"</h1><br>");
            stringBuffer.append("<h1>Status: Order của bạn đã bị hủy</h1><br>");
            stringBuffer.append("<h1>Description: Không đủ số lượng</h1><br>");
            stringBuffer.append("<h1>Cảm ơn anh.chị "+order.getCustomer().getName()+" đã xử dụng dịch vụ của chúng tôi</h1><br>");
            helper.setText(stringBuffer.toString(),true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    public void acceptOrder(OrderEntity order){
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setTo(order.getCustomer().getEmail());
            helper.setSubject("[Accept Order]");
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<h2>Code Order:");
            stringBuffer.append(String.valueOf(order.getId())+"</h2><br>");
            stringBuffer.append("<h1>Date:"+order.getCreatedDate().toString()+"</h1><br>");
            stringBuffer.append("<h1>Status: Order của bạn đã được xủ lý</h1><br>");
            stringBuffer.append("<h1>Description: Đang trên đường vận chuyển</h1><br>");
            stringBuffer.append("<h1>Cảm ơn anh.chị "+order.getCustomer().getName()+" đã xử dụng dịch vụ của chúng tôi</h1><br>");
            helper.setText(stringBuffer.toString(),true);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
