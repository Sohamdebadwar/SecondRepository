package com.pack1;

import java.sql.ResultSet;

public class ResultSetDemo
{
	public static void main(String[] args) 
	{
		System.out.println("------------------Types------------------");
		System.out.println("SCROLL-SENSITIVE : "+ResultSet.TYPE_SCROLL_SENSITIVE);
		System.out.println("SCROLL-INSENSITIVE : "+ResultSet.TYPE_SCROLL_INSENSITIVE);
		System.out.println("TYPE_FORWARD_ONLY : "+ResultSet.TYPE_FORWARD_ONLY);
		
		System.out.println("\n-----------------MODES-------------------");
		System.out.println("CONCUR_READ_ONLY :"+ResultSet.CONCUR_READ_ONLY);
		System.out.println("CONCUR_UPDATABLE : "+ResultSet.CONCUR_UPDATABLE);
	}
}
