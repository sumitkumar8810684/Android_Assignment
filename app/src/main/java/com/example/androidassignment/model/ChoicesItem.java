package com.example.androidassignment.model;

import com.google.gson.annotations.SerializedName;

public class ChoicesItem{

	@SerializedName("finish_reason")
	private String finishReason;

	@SerializedName("index")
	private int index;

	@SerializedName("message")
	private Message message;

	@SerializedName("logprobs")
	private Object logprobs;

	public void setFinishReason(String finishReason){
		this.finishReason = finishReason;
	}

	public String getFinishReason(){
		return finishReason;
	}

	public void setIndex(int index){
		this.index = index;
	}

	public int getIndex(){
		return index;
	}

	public void setMessage(Message message){
		this.message = message;
	}

	public Message getMessage(){
		return message;
	}

	public void setLogprobs(Object logprobs){
		this.logprobs = logprobs;
	}

	public Object getLogprobs(){
		return logprobs;
	}
}