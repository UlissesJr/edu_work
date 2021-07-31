package top.luobogan.servlet;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.luobogan.domain.Account;

import java.io.IOException;

@javax.servlet.annotation.WebServlet(name = "AccountServlet")
public class AccountServlet extends javax.servlet.http.HttpServlet {

    @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Account account = (Account) classPathXmlApplicationContext.getBean("account");
        System.out.println(account);

    }
}
