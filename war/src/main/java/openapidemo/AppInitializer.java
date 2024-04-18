package openapidemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import rest.OpenApiConfig;

@EnableWebMvc
public class AppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		WebApplicationContext context = getContext();
		servletContext.addListener(new ContextLoaderListener(context));
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("RestServlet",
				new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/*");
	}

	private AnnotationConfigWebApplicationContext getContext() {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.scan("rest");
		context.register(OpenApiConfig.class, org.springdoc.ui.SwaggerConfig.class,
				org.springdoc.core.SwaggerUiConfigProperties.class, org.springdoc.core.SwaggerUiOAuthProperties.class,
				org.springdoc.core.SpringDocWebMvcConfiguration.class,
				org.springdoc.core.MultipleOpenApiSupportConfiguration.class,
				org.springdoc.core.SpringDocConfiguration.class, org.springdoc.core.SpringDocConfigProperties.class,
				org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration.class);
		return context;
	}
}
