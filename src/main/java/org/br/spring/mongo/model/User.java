package org.br.spring.mongo.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	/**
	 * Id user
	 */
	@Id
	private String id;
	/**
	 * User name
	 */
	@NotEmpty
    private String name;
    /**
     * User email 
     */
    @Indexed( unique = true )
    private String email;
    /**
     * user phone
     */
    private String phone;
    /**
     * user password
     */
    @Transient
    private String password;
    /**
     * Constructor default of the value object.
     */
    public User() {
    	super();
	}
	/**
	 * Constructor using all fields.
	 * @param id {@link String}
	 * @param name {@link String}
	 * @param email {@link String}
	 * @param phone {@link String}
	 * @param password {@link String}
	 */
    public User(String id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}
	/**
	 * @return the id
	 */
	public final String getId() {
		return id;
	}
	/**
	 * @param value the id to set
	 */
	public final void setId(final String value) {
		this.id = value;
	}
	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}
	/**
	 * @param value the name to set
	 */
	public final void setName(final String value) {
		this.name = value;
	}
	/**
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}
	/**
	 * @param value the email to set
	 */
	public final void setEmail(final String value) {
		this.email = value;
	}
	/**
	 * @return the phone
	 */
	public final String getPhone() {
		return phone;
	}
	/**
	 * @param value the phone to set
	 */
	public final void setPhone(final String value) {
		this.phone = value;
	}
	/**
	 * @return the password
	 */
	public final String getPassword() {
		return password;
	}
	/**
	 * @param value the password to set
	 */
	public final void setPassword(final String value) {
		this.password = value;
	}
    
    
}
