package com.osa.base;

import org.apache.log4j.Logger;

import com.osa.files.PropertyReader;
import com.osa.utility.Utilities;

public interface AppContains {
	
	public static final Logger LOG = Utilities.getLog(Utilities.class);
	
	public static final String BASE_URI = PropertyReader.readProperty("baseURI");

}
