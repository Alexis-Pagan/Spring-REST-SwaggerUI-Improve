package com.dev.engineering.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.engineering.model.Message;
import com.dev.engineering.outbound.MailModel;
import com.dev.engineering.outbound.MailUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "/generic")
public class RestDistpacherEndpoint {
	
	/**
	 * http://localhost:8081/dev/api/v1/send/mail
	 */
	
	@Autowired 
	private MailUtils utils;
	
	@ApiOperation(value="Send Email")
	@PostMapping("api/v1/send/mail")
	public ResponseEntity<HttpStatus> mail() {
			
		MailModel model = new MailModel();
		model.setContent("Sending Message from REST"); // content of email
		model.setFrom("your-mail"); // email from with @
		model.setSubject("Web Service Mail");
		model.setTo("other-mail"); // to with @

		try {
			utils.message(model);
		} catch(MailException mailEx) {
			System.out.println(mailEx);
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@ApiOperation(value="Send message")
	@GetMapping("api/v1/message")
	public ResponseEntity<Message> simpleMessage() {
		Message msg = new Message();
		msg.setText("This is an automated documentation using swagger which exposes this endpoint or URI");
		
		return new ResponseEntity<Message>(msg, HttpStatus.OK);
	}
}