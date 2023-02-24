package com.example.demo;


import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.config.ConfigDataLocation;
import org.springframework.boot.context.config.ConfigDataLocationNotFoundException;
import org.springframework.boot.context.config.ConfigDataLocationResolver;
import org.springframework.boot.context.config.ConfigDataLocationResolverContext;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;

public class DemoLocationResolver implements ConfigDataLocationResolver<DemoDataResource>
{

	private static final String PREFIX = "demo://";

	@Override
	public boolean isResolvable(ConfigDataLocationResolverContext context, ConfigDataLocation location)
	{
		return location.hasPrefix(PREFIX);
	}

	@Override
	public List<DemoDataResource> resolve(ConfigDataLocationResolverContext context, ConfigDataLocation location)
		throws ConfigDataLocationNotFoundException, ConfigDataResourceNotFoundException
	{
		List<DemoDataResource> result = new ArrayList<>();

		// get value from somewhere else, in this demo case we take simply the non prefixed value
		String value = location.getNonPrefixedValue(PREFIX);
		
		DemoDataResource res = new DemoDataResource(value);
		result.add(res);
		
		if (result.isEmpty())
		{
			throw new ConfigDataLocationNotFoundException(location);
		}

		return result;
	}

}
