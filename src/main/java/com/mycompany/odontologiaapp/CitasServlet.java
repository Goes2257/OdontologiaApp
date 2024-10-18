package com.mycompany.odontologiaapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CitasServlet")
public class CitasServlet extends HttpServlet {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/odontologia_db";
    private static final String JDBC_USER = "root";  // Cambia a tu usuario
    private static final String JDBC_PASSWORD = "";  // Cambia a tu contraseña

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/citas.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");

        try {
            Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            String sql = "INSERT INTO citas (nombre, apellido, correo, telefono) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nombre);
            statement.setString(2, apellido);
            statement.setString(3, correo);
            statement.setString(4, telefono);
            statement.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        response.sendRedirect("CitasServlet");
    }
}

