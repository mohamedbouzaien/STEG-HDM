/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hdm.servlets;

import com.hdm.beans.Departement;
import com.hdm.beans.Site;
import com.hdm.dao.DaoFactory;
import com.hdm.dao.DepartementDao;
import com.hdm.dao.SiteDao;
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
public class GererSitesDepartements extends HttpServlet {

    private SiteDao siteDao;
    private DepartementDao departementDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.siteDao = daoFactory.getSiteDao();
        this.departementDao = daoFactory.getDepartementDao();

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
            out.println("<title>Servlet GererSitesDepartements</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GererSitesDepartements at " + request.getContextPath() + "</h1>");
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
        request.setAttribute("sites", siteDao.lister());
        request.setAttribute("departements", departementDao.lister());
        this.getServletContext().getRequestDispatcher("/WEB-INF/gererSitesDepartements.jsp").forward(request, response);
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
        if (request.getParameter("nomdept") != null) {
            Departement departement = new Departement(request.getParameter("nomdept"),
                    new Site(Integer.parseInt(request.getParameter("site"))));
            boolean isAdded = false;
            isAdded = departementDao.ajouter(departement);
            request.setAttribute("isAddeddept", isAdded);
            request.setAttribute("isAdded", isAdded);
        } else if (request.getParameter("nomsite") != null) {
            Site site = new Site(request.getParameter("nomsite"));
            boolean isAdded = false;
            isAdded = siteDao.ajouter(site);
            request.setAttribute("isAddedsite", isAdded);
        }
        
        request.setAttribute("sites", siteDao.lister());
        request.setAttribute("departements", departementDao.lister());
        this.getServletContext().getRequestDispatcher("/WEB-INF/gererSitesDepartements.jsp").forward(request, response);
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
