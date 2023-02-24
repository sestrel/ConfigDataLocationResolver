package com.example.demo;


import java.util.Objects;

import org.springframework.boot.context.config.ConfigDataResource;

public class DemoDataResource extends ConfigDataResource
{

	private final String value;

	public DemoDataResource(String value)
	{
		this.value = value;
	}

	public String getValue()
	{
		return value;
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(value);
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DemoDataResource other = (DemoDataResource) obj;
		return Objects.equals(value, other.value);
	}

}
