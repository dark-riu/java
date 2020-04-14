package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        response.setContentType("text/html;charset=utf-8");
        if("admin".equals(username)){
//            request.setAttribute("msg","用户名不能为admin");
//            request.getRequestDispatcher("/index.jsp").forward(request,response);
            response.getWriter().println("对不起，用户名不可用");
        }else {
//            request.getRequestDispatcher("/main.jsp").forward(request,response);
            response.getWriter().println("用户名可用");
        }
    }
}
