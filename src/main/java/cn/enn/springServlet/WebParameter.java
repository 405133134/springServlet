package cn.enn.springServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public interface WebParameter {
	public void loadInfo(ServletContext servletContext) throws ServletException;
}
