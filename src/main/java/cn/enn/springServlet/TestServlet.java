package cn.enn.springServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.nutz.lang.Lang;
import org.nutz.resource.Scans;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import cn.enn.config.AppConfigure;

public class TestServlet extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("注册过滤器   开始------");
		
		regCustomFilter(servletContext);
		
		System.out.println("注册过滤器  结束------");
		
		System.out.println("调用父类的onstartup方法------");
		super.onStartup(servletContext);
		
		System.out.println("初始化nutz------");
		Scans.me().init(servletContext);
		
		servletContext.setAttribute("app",AppConfigure.getProfile());
		
		//添加监控
		Dynamic addServlet = servletContext.addServlet("DruidStatView", "com.alibaba.druid.support.http.StatViewServlet");
		addServlet.addMapping("/druid/*");
		
		System.out.println("onstartup方法执行完毕");
		
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
		System.out.println("加载AppConfig");
		return new Class<?>[]{AppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("加载MvcConfig");
		return new Class<?>[]{MvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("加载servletMappings");
		return new String[]{"/"};
	}
	
	@Override
	  protected ApplicationContextInitializer<?>[] getServletApplicationContextInitializers() {
		System.out.println("加载applicationContextInitializer的实现类");
	    return Lang.array(new InitWeb());
	  }
}