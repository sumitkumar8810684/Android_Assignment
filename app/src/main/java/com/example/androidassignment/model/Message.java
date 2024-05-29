package com.example.androidassignment.model;

import com.google.gson.annotations.SerializedName;

public class Message{

	@SerializedName("role")
	private String role;

	@SerializedName("content")
	private String content;

	public void setRole(String role){
		this.role = role;
	}

	public String getRole(){
		return role;
	}

	public void setContent(String content){
		this.content = content;
	}

	public String getContent(){
		return content;
	}
}