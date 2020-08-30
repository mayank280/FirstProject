package com.example.applications.controller;


import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.applications.mailing.SMTPMail;
import com.example.applications.model.MailData;
import com.example.applications.model.User_Nested;
import com.example.applications.repositary.UsersRepo;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class MyController {
	
	@Autowired
	private UsersRepo userRep;
	
	@Autowired 
	private SMTPMail smtpMailc;
	
  @RequestMapping("/")
  public String home() {
	  return "hello world";
  }
  
  @PostMapping(path="/saveData" ,consumes = {"application/json"})
  public User_Nested addData(@RequestBody User_Nested userNest) {
	  System.out.println("add works");
	  userRep.save(userNest);
	  return userNest;
  }
  
  @PostMapping(path = "/upData/{eid}",  consumes = {"application/json"})
  public User_Nested  updateData(@PathVariable String eid,@RequestBody User_Nested userNest) {
	  String u = userNest.getUsername();
	  String n = userNest.getPassword();
	  String o = userNest.getEmail();
	  String[] i = userNest.getPhonenum();
	  userRep.findUpdateById(eid,u,n,o,i);
	  System.out.println("work updated");
	  
	  return userNest;
  }
  
  @PostMapping(path = "/authServ", consumes = {"application/json"})
  public List<User_Nested> authUse(@RequestBody User_Nested uNest) {
	  System.out.println(uNest.getEmail());
	  System.out.println(uNest.getPassword());
	  
	  String ab = uNest.getEmail();
	  String bc = uNest.getPassword();
	  List<User_Nested> l1 = userRep.findByLogInCred(ab, bc);
	  System.out.println(l1);
	  if(!l1.isEmpty()) {
		  return userRep.findByLogInCred(ab, bc);  
	  }
	  return userRep.findByLogInCred(ab, bc);
  }
  
  
  
  @GetMapping(path = "/getData")
  public List<User_Nested> getData() {
	  return userRep.findAll();
	  
  
  }
  @GetMapping(path = "/getData/{id}")
  public User_Nested getData(@PathVariable String id) {
	  User_Nested una =  userRep.findById(id).orElse(new User_Nested());
	  return una;
  }
  
  @DeleteMapping(path = "/delData/{id}")
  public User_Nested delData(@PathVariable String id,User_Nested usnet) {
	  userRep.deleteById(id);
	  return usnet;
	  
  }
  
  @RequestMapping("/sendEmail")
  public MailData sendMails(@RequestBody MailData mdata) throws MessagingException{
	  System.out.println(mdata);
	  smtpMailc.sendEmailTo(mdata.getEmail(), mdata.getSubject() , mdata.getMessage());
	  
	  return mdata;
  }
}
