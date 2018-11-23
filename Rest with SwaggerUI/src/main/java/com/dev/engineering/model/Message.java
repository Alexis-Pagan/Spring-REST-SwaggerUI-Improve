package com.dev.engineering.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="message model", description="set and get message")
public class Message {
	
	@ApiModelProperty(notes="Text variable for message")
	private String text;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
