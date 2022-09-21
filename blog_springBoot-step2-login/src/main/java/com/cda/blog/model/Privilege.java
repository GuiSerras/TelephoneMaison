package com.cda.blog.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Privilege {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrivilege;

    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> roles;

    
    
    
	public Privilege() {
		super();
	}

	public Privilege(String name) {
		super();
		this.name = name;
	}

	public Long getIdPrivilege() {
		return idPrivilege;
	}

	public void setIdPrivilege(Long idPrivilege) {
		this.idPrivilege = idPrivilege;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
    
    
}
