package com.epam.hackathon.ep

import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.web.SpringBootServletInitializer

class ServletInitializer  extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		application.sources(Application)
	}

}
