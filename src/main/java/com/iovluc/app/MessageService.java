package com.iovluc.app;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("")
public class MessageService extends HttpServlet {
    Social social;

    @Override
    public void init() throws ServletException {
        social = new Social();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String senderParam = req.getParameter("u");
        String jsonString;

        if(senderParam != null)
            jsonString = social.getMessagesByUsername(senderParam);
        else jsonString = social.getAllMessages();

        resp.setContentType("application/json");
        PrintWriter wr = resp.getWriter();
        wr.print(jsonString);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String senderParam = req.getParameter("u");
        String receiverParam = req.getParameter("r");
        String msgParam = req.getParameter("m");
        String jsonString = "";
        PrintWriter wr = resp.getWriter();

        if(senderParam != null && receiverParam != null) {
            social.addMessage(senderParam, receiverParam, msgParam);
            jsonString = social.getMessagesByUsername(senderParam);

            resp.setContentType("application/json");
            wr.print(jsonString);
        }
        else
            wr.print("Error post");

    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String senderParam = req.getParameter("u");
        String msgIdParam = req.getParameter("id");
        String receiverParam = req.getParameter("r");
        String msgParam = req.getParameter("m");
        String jsonString = "";
        PrintWriter wr = resp.getWriter();

        if(senderParam != null && receiverParam != null && msgIdParam != null) {
            social.updateMessage(Integer.parseInt(msgIdParam), senderParam, msgParam);
            jsonString = social.getMessagesByUsername(senderParam);
            resp.setContentType("application/json");
            wr.print(jsonString);
        }
        else
            wr.print("Error update");
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String senderParam = req.getParameter("u");
        String msgIdParam = req.getParameter("id");
        String receiverParam = req.getParameter("r");
        String msgParam = req.getParameter("m");
        String jsonString = "";
        PrintWriter wr = resp.getWriter();

        if(senderParam != null) {
            if (msgIdParam != null) {
                social.deleteMessage(Integer.parseInt(msgIdParam), senderParam);
                jsonString = social.getMessagesByUsername(senderParam);
            }
        }

        resp.setContentType("application/json");
        wr.print(jsonString);
    }
}
