package com.pack4.request_listner;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class RequestListner implements ServletRequestListener, ServletRequestAttributeListener
{
	@Override
	public void requestInitialized(ServletRequestEvent sre) 
	{
		System.out.println("Request Object Created");
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) 
	{
		System.out.println("Request Object Destroyed");
	}
	
	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) 
	{
		System.out.println("Attribute Added "+srae.getName());
		
	}
	
	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) 
	{
		System.out.println("Attribute removed");
		
	}
}
