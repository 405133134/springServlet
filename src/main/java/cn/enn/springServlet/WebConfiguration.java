package cn.enn.springServlet;

import java.lang.reflect.Modifier;
import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;

@HandlesTypes(WebParameter.class)
public class WebConfiguration implements ServletContainerInitializer {

	@Override
	public void onStartup(Set<Class<?>> webParams, ServletContext servletContext) throws ServletException {

		if(webParams !=null){
			for (Class<?> class1 : webParams) {
				if(!class1.isInterface() && !Modifier.isAbstract(class1.getModifiers())
						&& WebParameter.class.isAssignableFrom(class1)){
					try {
						((WebParameter)class1.newInstance()).loadInfo(servletContext);
					} catch (Throwable ex) {
						throw new ServletException("Failed to instantiate WebParam class", ex);
					}
				}
			}
		}
	}

}
