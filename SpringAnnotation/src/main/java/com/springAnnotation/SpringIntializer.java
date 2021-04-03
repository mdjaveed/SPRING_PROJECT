package com.springAnnotation;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringIntializer implements WebApplicationInitializer{

	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext cfg = new AnnotationConfigWebApplicationContext();
		cfg.register(CustomViewResolver.class);
		cfg.setServletContext(servletContext);
		ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("dispatcher",
				new DispatcherServlet(cfg));
		servletRegistration.setLoadOnStartup(1);
		servletRegistration.addMapping("/");
	}

}
