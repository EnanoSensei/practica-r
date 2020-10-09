package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Helpers.Condb;
import Helpers.Hashing;

/**
 * Servlet implementation class Registro
 */
@MultipartConfig()
@WebServlet("/Registro")
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		String user = request.getParameter("usuario");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String contrasena = request.getParameter("pw");
		String ci = request.getParameter("ci");
		String telefono = request.getParameter("telf");
		String email = request.getParameter("correo");
		String h = Hashing.hashPW(contrasena);
		try {

			Connection conexion = Condb.crearCon();
			PreparedStatement ps1 = conexion.prepareStatement("INSERT INTO public.usuario VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
			ps1.setString(1, user);
			ps1.setString(2, nombre);
			ps1.setString(3, apellido);
			ps1.setString(4, telefono);
			ps1.setString(5, ci);
			ps1.setString(6, email);
			ps1.setBoolean(7, false);
			ps1.setString(8, h);
			ps1.execute();
			out.println("{\"message\":\"Usuario creado satisfactoriamente\", \"status\": 200}");
			ps1.close();
		 } catch (SQLException e) {
			out.println("{\"message\":\"error\"}");	
		 }
	}

}
