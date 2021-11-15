package cundi.edu.co.registro.configurationSwagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.client.LinkDiscoverer;
import org.springframework.hateoas.client.LinkDiscoverers;
import org.springframework.hateoas.mediatype.collectionjson.CollectionJsonLinkDiscoverer;
import org.springframework.plugin.core.SimplePluginRegistry;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig extends ResponseEntityExceptionHandler{

	@Bean
	public Docket apiDocket()    {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				
				.select()
				.apis(RequestHandlerSelectors.basePackage("cundi.edu.co.registro.controller"))
				.paths(PathSelectors.any())
				.build();		
	}
	
	   @Bean
	    public LinkDiscoverers discoverers() {
	        List<LinkDiscoverer> plugins = new ArrayList<>();
	        plugins.add(new CollectionJsonLinkDiscoverer());
	        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));

	    }
	
}

