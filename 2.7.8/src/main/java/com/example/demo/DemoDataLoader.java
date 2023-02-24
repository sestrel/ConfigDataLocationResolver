package com.example.demo;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.boot.context.config.ConfigData;
import org.springframework.boot.context.config.ConfigDataLoader;
import org.springframework.boot.context.config.ConfigDataLoaderContext;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;

public class DemoDataLoader implements ConfigDataLoader<DemoDataResource>
{

	@Override
	public ConfigData load(ConfigDataLoaderContext context, DemoDataResource resource)
		throws IOException, ConfigDataResourceNotFoundException
	{
		List<PropertySource<?>> propertySources = new ArrayList<>();
		HashMap<String, Object> property = new HashMap<>();
		
		String propertyName = resource.getValue();
		property.put(propertyName, resource.getValue());
		propertySources.add(new MapPropertySource(propertyName, property));

		return new ConfigData(propertySources);

	}

}
