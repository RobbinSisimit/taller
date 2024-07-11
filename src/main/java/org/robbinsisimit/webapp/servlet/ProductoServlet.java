package org.robbinsisimit.webapp.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.robbinsisimit.webapp.model.Producto;
import org.robbinsisimit.webapp.service.ProductoService;

@WebServlet("/producto-servlet")
@MultipartConfig
public class ProductoServlet extends HttpServlet{
    
    private ProductoService productoService;
    @Override
    public void init() throws ServletException{
        super.init();
        this.productoService = new ProductoService();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Producto> productos = productoService.listarProducto();
        req.setAttribute("productos", productos);
        req.getRequestDispatcher("./lista-productos/lista-productos.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> datosProducto = new ArrayList<>();
        
        String mensaje = "";
        
        String nombreProducto = req.getParameter("nombreProducto");
        String marcaProducto = req.getParameter("marcaProducto");
        String descripcionProducto = req.getParameter("descripcionProducto");
        String precioProducto = req.getParameter("precioProducto");
        
        datosProducto.add(nombreProducto);
        datosProducto.add(marcaProducto);
        datosProducto.add(descripcionProducto);
        datosProducto.add("Q." + precioProducto);
        if(nombreProducto.isEmpty()){
            System.out.println(mensaje = "NO HAY NOMBRE DE PRODUCTO!!!");
        }else if(marcaProducto.isEmpty()){
            System.out.println(mensaje = "NO HAY MARCA PRODUCTO!!!");
        }else if(descripcionProducto.isEmpty()){
            System.out.println(mensaje = "NO HAY DESCRIPCION DE PRODUCTO!!");
        }else if(precioProducto.isEmpty()){
            System.out.println(mensaje = "NO HAY PRECIO PRODUCTO!!!");
        }
        req.setAttribute("mensaje", mensaje);
        req.setAttribute("datosProducto", datosProducto);
        getServletContext().getRequestDispatcher("/formulario-producto/formulario-producto.jsp").forward(req, resp);
    }
    
    
}
