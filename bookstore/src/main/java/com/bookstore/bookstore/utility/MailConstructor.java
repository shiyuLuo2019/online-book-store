package com.bookstore.bookstore.utility;

import java.util.Locale;

import com.bookstore.bookstore.domain.Order;
import com.bookstore.bookstore.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Component
public class MailConstructor {
    @Autowired
    private Environment env;

    @Autowired
    private TemplateEngine templateEngine;

    public SimpleMailMessage constructResetTokenEmail(
            String contextPath, Locale locale, String token, User user, String password
    ) {

        String url = contextPath + "/newAccount?token=" + token;
        String message = "\nYour current password is: " + password + ". Please click on the following link to reset your password:\n";
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject("Corner Bookstore - Reset Password");
        email.setText(message + url);
        email.setFrom(env.getProperty("support.email"));
        return email;

    }

    public MimeMessagePreparator constructOrderConfirmationEmail (User user, Order order, Locale locale) {
        Context context = new Context();
        context.setVariable("order", order);
        context.setVariable("user", user);
        context.setVariable("cartItemList", order.getCartItemList());
        String text = templateEngine.process("orderConfirmationEmailTemplate", context);

        MimeMessagePreparator messagePreparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                MimeMessageHelper email = new MimeMessageHelper(mimeMessage);
                email.setTo(user.getEmail());
                email.setSubject("Order Confirmation - "+order.getId());
                email.setText(text, true);
                email.setFrom(new InternetAddress("ray.deng83@gmail.com"));
            }
        };

        return messagePreparator;
    }
}
