package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! what are u learning today";
	}
	
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		
		StringBuffer sb= new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> My first html project </title>");
		sb.append("<head>");
		sb.append("<body>");
		sb.append(" my first html page\r\n"
				+ "");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
	
	
	//JSP 
	// "say-hello-jsp"=> sayHello.java
	// /myfirstwebapp/src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.java
	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
	
	
	
	
	
}