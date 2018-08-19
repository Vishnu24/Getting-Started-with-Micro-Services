/**
 * -----------------------------------------------------------------------
 *     Copyright  2010 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package com.revisited.microservice.edge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.revisited.microservice.edge.filters.ErrorFilter;
import com.revisited.microservice.edge.filters.PostFilter;
import com.revisited.microservice.edge.filters.PreFilter;
import com.revisited.microservice.edge.filters.RouteFilter;

/**
 * @author Vishnu Garg
 * @created On Aug 18, 2018
 *
 */
@Configuration
public class ZuulConfiguration {
	@Bean
	public PreFilter preFilter() {
	    return new PreFilter();
	}
	@Bean
	public PostFilter postFilter() {
	    return new PostFilter();
	}
	@Bean
	public ErrorFilter errorFilter() {
	    return new ErrorFilter();
	}
	@Bean
	public RouteFilter routeFilter() {
	    return new RouteFilter();
	}
}

