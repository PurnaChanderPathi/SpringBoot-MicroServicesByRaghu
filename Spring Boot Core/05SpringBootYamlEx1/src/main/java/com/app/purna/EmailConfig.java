package com.app.purna;

import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Component
@ConfigurationProperties(prefix = "my.app")
@Setter
@Getter
@ToString
public class EmailConfig {
	private String host;
	private int port;
	private String username;
	private String password;
	
	private Set<String> protocals;
	
	private Map<String,String> headers;
	
	private Certificate cob;
	
}
