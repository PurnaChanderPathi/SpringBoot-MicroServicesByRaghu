package com.app.purna;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties(prefix = "my.app")
public class MyServiceData {

	private int id;
	private String code;

	
	private List<String> data; //ArrayList
	//private Set<String> data; //LinkedHashSet
	//private String[] data;
	
	private Map<String, String> info;// LinkedHashMap
	
	private Process pob;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

	public Map<String, String> getInfo() {
		return info;
	}

	public void setInfo(Map<String, String> info) {
		this.info = info;
	}

	public Process getPob() {
		return pob;
	}

	public void setPob(Process pob) {
		this.pob = pob;
	}

	@Override
	public String toString() {
		return "MyServiceData [id=" + id + ", code=" + code + ", data=" + data + ", info=" + info + ", pob=" + pob
				+ "]";
	}
	
	
	
}
