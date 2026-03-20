package com.pack4.request_listner;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//@WebListener
public class SessionListner implements HttpSessionAttributeListener, HttpSessionListener 
{
	@Override
	public void sessionCreated(HttpSessionEvent se)
	{
		System.out.println("Session Object Created");
	}
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) 
	{
		System.out.println("Session Object Destroyed");
	}
	
	@Override
	public void attributeAdded(HttpSessionBindingEvent hsbe) 
	{
		System.out.println("Attribute Added to the session : "+hsbe.getName());
	}
	
	@Override
	public void attributeRemoved(HttpSessionBindingEvent se) 
	{
		System.out.println("Attribute Removed to the session");
	}
}
