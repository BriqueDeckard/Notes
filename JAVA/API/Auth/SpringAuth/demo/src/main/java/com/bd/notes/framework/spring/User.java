package com.bd.notes.framework.spring;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Value;

import static java.util.Objects.requireNonNull;

import java.util.ArrayList;
/**
 * To match Spring Security API, the User class implements UserDetails. 
 * This way, our custom User bean seamlessly integrates into Spring Security.
 * @author Emma
 *
 */
@Value
@Builder
public class User implements UserDetails {

	String id;
	String username;
	String password;

	@JsonCreator
	User(@JsonProperty("id") final String id, @JsonProperty("username") final String username,
			@JsonProperty("password") final String password) {
		super();
		this.id = requireNonNull(id);
		this.username = requireNonNull(username);
		this.password = requireNonNull(password);
	}

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}

	public String getId() {
		return id;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
