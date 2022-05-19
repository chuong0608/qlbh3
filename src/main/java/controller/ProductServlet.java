package controller;

import model.Product;
import service.ProductService;
import service.ProductServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
            default:
                showListPage(request,response);
        }

    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("product/edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product  = productService.findById(id);
        request.setAttribute("sanPhamSua",product);
        requestDispatcher.forward(request,response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("product/create.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showListPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher =request.getRequestDispatcher("product/list.jsp");
        List<Product> products = productService.findAll();
        request.setAttribute("danhSach",products);
        requestDispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action){
            case "create":
                createProduct(request,response);
                break;
            case "edit":
                editProduct(request,response);
                break;
        }

    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int price = Integer.parseInt(request.getParameter("price"));
        String name = request.getParameter("name");
        productService.update(id,new Product(id,name,price));
        response.sendRedirect("ProductServlet");
    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int price = Integer.parseInt(request.getParameter("price"));
        String name = request.getParameter("name");
        productService.save(new Product(id,name,price));
        response.sendRedirect("ProductServlet");
    }
}
