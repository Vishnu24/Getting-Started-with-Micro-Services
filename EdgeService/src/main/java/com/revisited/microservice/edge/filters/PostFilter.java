/**
 * -----------------------------------------------------------------------
 *     Copyright  2010 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package com.revisited.microservice.edge.filters;

import com.netflix.zuul.ZuulFilter;

/**
 * @author Vishnu Garg
 * @created On Aug 18, 2018
 *
 */
public class PostFilter extends ZuulFilter {
	 
	  @Override
	  public String filterType() {
	    return "post";
	  }
	 
	  @Override
	  public int filterOrder() {
	    return 1;
	  }
	 
	  @Override
	  public boolean shouldFilter() {
	    return true;
	  }
	 
	  @Override
	  public Object run() {
	   System.out.println("Inside Response Filter");
	 
	    return null;
	  }
	}

