package com.qwm.web;

import com.qwm.utils.TokenProccessor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * form
 */
@WebServlet(name = "FormServlet")
public class FormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String token = TokenProccessor.getInstance().makeToken();
        System.out.println("生成的token:"+token);
        request.getSession().setAttribute("token",token);
        request.getRequestDispatcher("/form.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
