/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.servlets;

import com.hdm.beans.AttributionAdresseIP;
import com.hdm.beans.Reseau;
import com.hdm.dao.AdresseIPDao;
import com.hdm.dao.AttributionAdresseIPDao;
import com.hdm.dao.DaoFactory;
import com.hdm.dao.ReseauDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MED
 */
public class AfficherAdressesIP extends HttpServlet {
    private AdresseIPDao adresseIPDao;
    private ReseauDao reseauDao;
    private AttributionAdresseIPDao attributionAdresseIPDao;
    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.adresseIPDao=daoFactory.getAdresseIPDao();
        this.reseauDao = daoFactory.getReseauDao();
        this.attributionAdresseIPDao = daoFactory.getAttributionAdresseIPDao();
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
            out.println("<title>Servlet AfficherAdressesIP</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AfficherAdressesIP at " + request.getContextPath() + "</h1>");
            String pathInfo = request.getRequestURI();
            String[] pathParts = pathInfo.split("/");
            String part = pathParts[3];
            out.println(part);
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
        String pathInfo = request.getRequestURI();
        String[] pathParts = pathInfo.split("/");
        String part1 = pathParts[3];
        int id = Integer.parseInt(part1.trim());
        request.setAttribute("adressesIP", adresseIPDao.listerFusionLocalBd(
                reseauDao.RechercherUnParId(id),
                attributionAdresseIPDao.listerParReseau(reseauDao.RechercherUnParId(id))));
        request.setAttribute("id_rsx", id);
        this.getServletContext().getRequestDispatcher("/WEB-INF/gererAdressesIP.jsp").forward(request, response);
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
        String pathInfo = request.getRequestURI();
        String[] pathParts = pathInfo.split("/");
        String part1 = pathParts[3];
        System.out.println(part1);
        int id = Integer.parseInt(part1.trim());
        AttributionAdresseIP attributionAdresseIP = new AttributionAdresseIP(
                request.getParameter("adresse_debut"), 
                request.getParameter("adresse_fin"), 
                request.getParameter("type"), 
                reseauDao.RechercherUnParId(id));
        boolean isAdded = false;
        isAdded = attributionAdresseIPDao.ajouter(attributionAdresseIP);
        request.setAttribute("isAdded", isAdded);
                request.setAttribute("adressesIP", adresseIPDao.listerFusionLocalBd(
                reseauDao.RechercherUnParId(id),
                attributionAdresseIPDao.listerParReseau(reseauDao.RechercherUnParId(id))));
        this.getServletContext().getRequestDispatcher("/WEB-INF/gererAdressesIP.jsp").forward(request, response);
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
