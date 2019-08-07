package com.controller;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import com.config.Config;
import com.operations.OperationsList;
import com.stepdefinitions.Hooks;

public class Controller extends Config
{
	static String xPath;
	public static String methodname;
	public static String stepname;
	
	static Logger logger = Logger.getLogger(Controller.class);
	
	public static void forEveryStep(String objectLogicalName, String stepName,Enum<OperationsList> operationName, String[] list)
	{
		xPath = getXPath(objectLogicalName);
		
		methodname = operationName.toString();
		
		Hooks.stepCount++;
		
		stepname = "Step "+Hooks.stepCount+" : "+stepName;
		
		logger.info(stepname);
		
		// now we might need to call appropriate method
		
		try 
		{
			Class<?> object = Class.forName("com.operations.Operations");
			
			Method[] methods = object.getDeclaredMethods();
			
			for (Method methodName : methods) 
			{
				if(methodName.getName().equalsIgnoreCase(methodname))
				{
					methodName.invoke(null, list, xPath);
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
