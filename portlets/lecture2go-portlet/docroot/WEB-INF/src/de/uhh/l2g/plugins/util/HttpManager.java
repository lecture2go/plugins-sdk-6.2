package de.uhh.l2g.plugins.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.liferay.portal.kernel.json.JSONObject;
import com.sun.org.apache.xml.internal.security.utils.Base64;

/**
 * This utility class provides methods to send different requests to a http server
 * It uses default java packages (HttpURLConnection etc). 
 */
public class HttpManager {
	
	private HttpURLConnection connection;
	private String url;
	private String user;
	private String pass;

	
	/**
	 * Sends a GET request to the url with basic authentication
	 * @return an HttpURLConnection object
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public HttpURLConnection sendGet() throws MalformedURLException, IOException {
		// open the connection
		this.connection = (HttpURLConnection) new URL(this.url).openConnection();
		
		boolean hasBasicAuth = this.user != null && this.pass != null;
		if (hasBasicAuth) {
			String userAndPasswordEncoded = "";
			String userAndPassword = user + ":" + pass;
			userAndPasswordEncoded = Base64.encode(userAndPassword.getBytes());
			// set basic authentication
			this.connection.setRequestProperty("Authorization", "Basic " + userAndPasswordEncoded);
		}
		
	    // set the connection parameters
	    this.connection.setRequestMethod("GET");
	    this.connection.setDoInput(true);
	    this.connection.setDoOutput(false);
		
		return this.connection;
	}
	
	/**
	 * Sends a POST request to the url with a given json with basic authentication
	 * @param jo a json object to post to the url
	 * @return an HttpURLConnection object
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public HttpURLConnection sendPost(JSONObject jo) throws MalformedURLException, IOException {
		final String charset = "UTF-8";

	    // open the connection
		this.connection = (HttpURLConnection) new URL(this.url).openConnection();
		
		boolean hasBasicAuth = this.user != null && this.pass != null;
		if (hasBasicAuth) {
			String userAndPasswordEncoded = "";
			String userAndPassword = user + ":" + pass;
			userAndPasswordEncoded = Base64.encode(userAndPassword.getBytes());
			// set basic authentication
			this.connection.setRequestProperty("Authorization", "Basic " + userAndPasswordEncoded);
		}
		
	    // set the connection parameters
	    this.connection.setRequestMethod("POST");
	    this.connection.setDoOutput(true);
	    this.connection.setRequestProperty("Accept-Charset", charset);
	    this.connection.setRequestProperty("Content-type", "application/json");
	    
	    // write to the connection
	    OutputStream output = this.connection.getOutputStream();
	    output.write(jo.toString().getBytes(charset));
	    output.close();
	    
	    // finally send it
	    int responseCode = this.connection.getResponseCode();
	   
		return this.connection;
	}
	
	/**
	 * Sends a PUT request to the url with a given json with basic authentication
	 * @param jo a json object to post to the url
	 * @return an HttpURLConnection object
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public HttpURLConnection sendPut(JSONObject jo) throws MalformedURLException, IOException {
		final String charset = "UTF-8";

	    // open the connection
		this.connection = (HttpURLConnection) new URL(this.url).openConnection();
		
		boolean hasBasicAuth = this.user != null && this.pass != null;
		if (hasBasicAuth) {
			String userAndPasswordEncoded = "";
			String userAndPassword = user + ":" + pass;
			userAndPasswordEncoded = Base64.encode(userAndPassword.getBytes());
			// set basic authentication
			this.connection.setRequestProperty("Authorization", "Basic " + userAndPasswordEncoded);
		}
		
	    // set the connection parameters
	    this.connection.setRequestMethod("PUT");
	    this.connection.setDoOutput(true);
	    this.connection.setRequestProperty("Accept-Charset", charset);
	    this.connection.setRequestProperty("Content-type", "application/json");
	    
	    // write to the connection
	    OutputStream output = this.connection.getOutputStream();
	    output.write(jo.toString().getBytes(charset));
	    output.close();
	    this.connection.getResponseCode();
		return this.connection;
    }
	
	/**
	 * Sends a DELETE request to the url with Basic Authentication
	 * @return an HttpURLConnection object
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public HttpURLConnection sendDelete() throws MalformedURLException, IOException {
	    // open the connection
		this.connection = (HttpURLConnection) new URL(this.url).openConnection();
		
		boolean hasBasicAuth = this.user != null && this.pass != null;
		if (hasBasicAuth) {
			String userAndPasswordEncoded = "";
			String userAndPassword = user + ":" + pass;
			userAndPasswordEncoded = Base64.encode(userAndPassword.getBytes());
			// set basic authentication
			this.connection.setRequestProperty("Authorization", "Basic " + userAndPasswordEncoded);
		}
		
	    // set the connection parameters
		this.connection.setDoOutput(true);
	    this.connection.setRequestMethod("DELETE");
	    this.connection.getResponseCode();
		return this.connection;
	}
	
    public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
     * Closes the connection if open
     */
    public void close() {
        if (this.connection != null) {
        	this.connection.disconnect();
        }
    }
}