package com.hyegym.admin;

import org.apache.tomcat.jakartaee.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.tomcat.jakartaee.commons.lang3.builder.ToStringStyle;

import com.hyegym.notice.PaginationDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdminDTO {
	
	private int idx;
	private String id;
	private String name;
	private String password;
	private String birth;
	private String gender;
	private String email;
	private PaginationDTO paginationDTO;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public PaginationDTO getPaginationDTO() {
		return paginationDTO;
	}
	public void setPaginationDTO(PaginationDTO paginationDTO) {
		this.paginationDTO = paginationDTO;
	}
	@Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }


}
