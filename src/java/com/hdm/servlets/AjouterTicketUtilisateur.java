/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.servlets;

import com.hdm.beans.Agent;
import com.hdm.beans.Ticket;
import com.hdm.dao.AgentDao;
import com.hdm.dao.DaoFactory;
import com.hdm.dao.TicketDao;
import com.hdm.technical.BCrypt;
import com.hdm.technical.RandomCode;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MED
 */
public class AjouterTicketUtilisateur extends HttpServlet {
    private TicketDao ticketDao;
    private AgentDao agentDao;
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.ticketDao = daoFactory.getTicketDao();
        this.agentDao = daoFactory.getaAgentDao();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AjouterTicketUtilisateur</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AjouterTicketUtilisateur at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //request.setAttribute("code", RandomCode.calculCode());
        this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterTicketUtilisateur.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Agent agent = null;
        if (request.getParameter("nom").equals(""))
        {
            agent = new Agent(Integer.parseInt(request.getParameter("id_agent")));
        }
        else
        {
            agent = new Agent(request.getParameter("matricule"), request.getParameter("nom"),
                    RandomCode.calculCode(),request.getParameter("prenom"), request.getParameter("adresse"));
            agent = agentDao.ajouter(agent);    
        }
        Ticket ticket = new Ticket(0,0,Integer.parseInt(request.getParameter("urgence")),
                request.getParameter("peripherique"),
                request.getParameter("titre"),
                request.getParameter("description"),
                BCrypt.hashpw(request.getParameter("code"), BCrypt.gensalt()),
                LocalDate.now(), agent);
        ticketDao.ajouter(ticket);
        this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterTicketUtilisateur.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
