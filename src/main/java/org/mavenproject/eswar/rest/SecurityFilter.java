package org.mavenproject.eswar.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;

@Provider
public class SecurityFilter implements ContainerRequestFilter{

	private static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	private static final String AUTHORIZATION_HEADER_PREFIX = "Basic";
	private static final String SECURED_URL_PREFIX = "secured";
	 
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		if(requestContext.getUriInfo().getPath().contains(SECURED_URL_PREFIX)) {
		List<String> authHeader = requestContext.getHeaders().get(AUTHORIZATION_HEADER_KEY);
		if(authHeader!=null && authHeader.size()>0) {
			String authToken = authHeader.get(0);
			authToken = authToken.replaceFirst(AUTHORIZATION_HEADER_PREFIX, "");
			String decodedString = Base64.decodeAsString(authToken.trim()); //use trim() for encoded strings because unnecessary white spaces might be there 
			StringTokenizer tokenizer = new StringTokenizer(decodedString, ":");
			List<String> auths= new ArrayList<>();
			auths.add(tokenizer.nextToken());
			while(tokenizer.hasMoreElements()) {
				auths.add(tokenizer.nextElement().toString());
			}
			System.out.println("Size of auths : "+ auths.size());
			System.out.println("\nUsername : " +auths.get(0));
			System.out.println("\nPassword : " +auths.get(1));
			if("user".equals(auths.get(0)) && "password".equals(auths.get(1))) {
				System.out.println("\nIn :\n");
				return;
			}
		}
		Response unauthorizedStatus = Response
				.status(Response.Status.UNAUTHORIZED)
				.entity("User cannot access")
				.build();
		requestContext.abortWith(unauthorizedStatus);
	}
  }
}
