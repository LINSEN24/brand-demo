package com.linsen.web.Brand;

import com.linsen.pojo.Brand;
import com.linsen.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/addBrandServlet")
public class addBrandServlet extends HttpServlet {
    private BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        String brandName = request.getParameter("brandName");
//        brandName=new String(brandName.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        String companyName = request.getParameter("companyName");
//        companyName=new String(companyName.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
//        description=new String(description.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        String status = request.getParameter("status");

        Brand brand=new Brand(brandName,companyName,Integer.parseInt(ordered),description,Integer.parseInt(status));

//        brandService.add(brand);

        response.sendRedirect("/brand-dome/selectAllBrandServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
