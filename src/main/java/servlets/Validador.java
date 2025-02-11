package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/Validador")
public class Validador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			String resultado = "<b>Datos correctos</b>";

			// Recupera todos los nombres de los parámetros
			// que llegan a traves de la petición
			Enumeration<String> nombres = request.getParameterNames();

			boolean continuar = true;
			while (nombres.hasMoreElements() && continuar) {
				if (request.getParameter(nombres.nextElement()).equals("")) {
					resultado = "<b>Error en los datos. ";
					resultado += "Debe rellenar todos los campos</b>";
					continuar = false;
				}
			}
			out.println(resultado);
		}
	}
}