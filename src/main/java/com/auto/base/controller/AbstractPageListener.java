package com.auto.base.controller;

import org.apache.log4j.Logger;

import com.auto.base.driver.web.IPage;
import com.auto.base.helper.URLHelper;
import com.auto.base.reporter.PluginsUtil;


/**
 * Provides a plug-in architecture for people who want to write rules to test
 * Headers, Java Script, Accessibility etc.
 * 
 * Any sub-class should define a public default constructor
 * 
 *  
 */
public abstract class AbstractPageListener {
	protected static final Logger logger = Logging.getLogger(AbstractPageListener.class);

	/**
	 * Notifies all the page listeners on page Load
	 * 
	 * @param page
	 */
	public static void notifyPageLoad(IPage page) {
		PluginsUtil.getInstance().invokePageListeners(ContextManager.getThreadContext().getTestMethodSignature(),
		 page, true);
		
	}

	/**
	 * Notifies all the page listeners on page Unload
	 * 
	 * @param page
	 */
	public static void notifyPageUnload(IPage page) {
		 
			 PluginsUtil.getInstance().invokePageListeners(ContextManager.getThreadContext().getTestMethodSignature(),
					 page, false);
	}

	private String title;

	private boolean testResultEffected;

	public AbstractPageListener(String title, boolean testResultEffected) {
		this.title = title;
		this.testResultEffected = testResultEffected;
	}
	
	public AbstractPageListener(){
		
	}

	public String getTitle() {
		return title;
	}

	public boolean isTestResultEffected() {
		return testResultEffected;
	}

	public abstract void onPageLoad(IPage page);

	public abstract void onPageUnload(IPage page);

	// //////////////// Static Helpers ///////////////////////

	protected String openURL(String url) throws Exception {
		return URLHelper.open(url);
	}

	public void setTestResultEffected(boolean testResultEffected) {
		this.testResultEffected = testResultEffected;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
