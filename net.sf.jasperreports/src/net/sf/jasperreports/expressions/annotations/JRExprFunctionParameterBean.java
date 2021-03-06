/*******************************************************************************
 * Copyright (C) 2010 - 2016. TIBCO Software Inc. 
 * All Rights Reserved. Confidential & Proprietary.
 ******************************************************************************/
package net.sf.jasperreports.expressions.annotations;


/**
 * Bean to describe a parameter of a particular function of the expressions library.
 * 
 * @author Massimo Rabbi (mrabbi@users.sourceforge.net)
 * @see JRExprFunctionParameter
 *
 */
public class JRExprFunctionParameterBean {
	
	private String name;
	private String description;
	private Class<?> parameterType;
	private boolean isOptional;
	private boolean isMulti;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Class<?> getParameterType() {
		return parameterType;
	}
	public void setParameterType(Class<?> parameterType) {
		this.parameterType = parameterType;
	}
	public boolean isOptional() {
		return isOptional;
	}
	public void setOptional(boolean isOptional) {
		this.isOptional = isOptional;
	}
	public boolean isMulti() {
		return isMulti;
	}
	public void setMulti(boolean isMulti) {
		this.isMulti = isMulti;
	}
	
}
