package com.util;

import net.rcarz.jiraclient.BasicCredentials;
import net.rcarz.jiraclient.JiraClient;

public class JiraServiceProvider {
	public JiraClient jira;
	public String project;
	
	public JiraServiceProvider(String jiraUrl, String Username, String Password, String project) {
		BasicCredentials cred = new BasicCredentials(Username,Password);
		jira = new JiraClient(jiraUrl,cred);
		this.project = project;
		
	}
	
	public void jiraTicket() {
		
	}
}

