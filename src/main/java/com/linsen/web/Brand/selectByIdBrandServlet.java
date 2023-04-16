package com.linsen.web.Brand;

import com.linsen.pojo.Brand;
import com.linsen.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectByIdBrandServlet")
public class selectByIdBrandServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        Brand brand = brandService.selectById(Integer.parseInt(id));

        request.setAttribute("brand",brand);
        request.getRequestDispatcher("/updataBrand.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
