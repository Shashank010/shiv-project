package com.cg.logger;

import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.SimpleLayout;

public class MyLogger {
	
		static Logger logger;
		
		static
		{
			logger = Logger.getLogger(MyLogger.class);
			SimpleLayout layout = new SimpleLayout();
			
			try{
			FileAppender appender = new FileAppender(layout, "basi.log");
			logger.addAppender(appender);
			logger.setLevel(Level.DEBUG);
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		
		public static Logger getLogger()
		{
			return logger;
		}

}
