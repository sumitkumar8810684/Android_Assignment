package com.example.androidassignment.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataModel{

	@SerializedName("created")
	private int created;

	@SerializedName("usage")
	private Usage usage;

	@SerializedName("model")
	private String model;

	@SerializedName("id")
	private String id;

	@SerializedName("choices")
	private List<ChoicesItem> choices;

	@SerializedName("system_fingerprint")
	private Object systemFingerprint;

	@SerializedName("object")
	private String object;

	public void setCreated(int created){
		this.created = created;
	}

	public int getCreated(){
		return created;
	}

	public void setUsage(Usage usage){
		this.usage = usage;
	}

	public Usage getUsage(){
		return usage;
	}

	public void setModel(String model){
		this.model = model;
	}

	public String getModel(){
		return model;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setChoices(List<ChoicesItem> choices){
		this.choices = choices;
	}

	public List<ChoicesItem> getChoices(){
		return choices;
	}

	public void setSystemFingerprint(Object systemFingerprint){
		this.systemFingerprint = systemFingerprint;
	}

	public Object getSystemFingerprint(){
		return systemFingerprint;
	}

	public void setObject(String object){
		this.object = object;
	}

	public String getObject(){
		return object;
	}
}