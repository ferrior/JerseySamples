package org.glassfish.jersey.examples.helloworld.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HelloInfo {

	private String id;
	private String name;
	private String type;
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param string the id to set
	 */
	public void setId(String string) {
		this.id = string;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
