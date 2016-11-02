package cn.enn.springServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.nutz.lang.Lang;
import org.nutz.resource.Scans;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class TestServlet extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("注册过滤器   开始------");
		
		regCustomFilter(servletContext);
		
		System.out.println("注册过滤器  结束------");
		
		super.onStartup(servletContext);
		
		Scans.me().init(servletContext);
		
		//添加监控
		Dynamic addServlet = servletContext.addServlet("DruidStatView", "com.alibaba.druid.support.http.StatViewServlet");
		addServlet.addMapping("/druid/*");
		
	}
	
	public void regCustomFilter(ServletContext servletContext){
		CharacterEncodingFilter characterEncodingFilter=new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("utf-8");
		characterEncodingFilter.setForceEncoding(true);
		javax.servlet.FilterRegistration.Dynamic addFilter = servletContext.addFilter("encoding-filter", characterEncodingFilter);
		addFilter.addMappingForUrlPatterns(null, false, "/*");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{AppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[]{MvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}
	
	@Override
	  protected ApplicationContextInitializer<?>[] getServletApplicationContextInitializers() {
	    return Lang.array(new InitWeb());
	  }
}