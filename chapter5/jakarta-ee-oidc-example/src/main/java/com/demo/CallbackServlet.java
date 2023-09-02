package com.demo;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/callback")
public class CallbackServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(CallbackServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String referrer = (String) request.getSession().getAttribute("Referrer");
        String redirectTo = referrer != null ? referrer : request.getContextPath() + "/protected";
        LOGGER.log(Level.FINEST, "In /callback, redirect to: {0}", redirectTo);

        response.sendRedirect(redirectTo);
    }
}
