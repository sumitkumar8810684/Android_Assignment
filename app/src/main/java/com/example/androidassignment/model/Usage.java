package com.example.androidassignment.model;

import com.google.gson.annotations.SerializedName;

public class Usage{

	@SerializedName("completion_tokens")
	private int completionTokens;

	@SerializedName("prompt_tokens")
	private int promptTokens;

	@SerializedName("total_tokens")
	private int totalTokens;

	public void setCompletionTokens(int completionTokens){
		this.completionTokens = completionTokens;
	}

	public int getCompletionTokens(){
		return completionTokens;
	}

	public void setPromptTokens(int promptTokens){
		this.promptTokens = promptTokens;
	}

	public int getPromptTokens(){
		return promptTokens;
	}

	public void setTotalTokens(int totalTokens){
		this.totalTokens = totalTokens;
	}

	public int getTotalTokens(){
		return totalTokens;
	}
}