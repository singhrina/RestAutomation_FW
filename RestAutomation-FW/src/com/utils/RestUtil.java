package com.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;

import com.pojo.GitHubUsers;

import myPojo.User;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.commonshttp.CommonsHttpOAuthConsumer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

public class RestUtil {

	HttpRequest request;
	HttpResponse response;
	private GitHubUsers user;
	private myPojo.User twitteruser;

	public myPojo.User getTwitteruser() {
		return twitteruser;
	}

	public void setTwitteruser(User twitteruser) {
		this.twitteruser = twitteruser;
	}

	public GitHubUsers getUser() {
		return user;
	}

	public void setUser(GitHubUsers user) {
		this.user = user;
	}

	String URI = Configuration.URI;
	String TWITTERURI = Configuration.TWITTERURI;

	public void addAuthentication()
			throws OAuthMessageSignerException, OAuthExpectationFailedException, OAuthCommunicationException {
		OAuthConsumer consumer = new CommonsHttpOAuthConsumer(Configuration.COMSUMER_KEY,
				Configuration.CONSUMER_SECRET);
		consumer.setTokenWithSecret(Configuration.TOKEN, Configuration.TOKEN_SECRET);
		consumer.sign(request);
	}

	// twitter get request
	public void getTwitterRequest(String responseurn, String ScreenName, int count) {
		try {
			request = new HttpGet(TWITTERURI + responseurn + "screen_name=" + ScreenName + "&count=" + count);
			request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
			addAuthentication();

			this.response = HttpClientBuilder.create().build().execute((HttpUriRequest) request);
			// to access the response
			if (response != null) {
				setTwitteruser(ResourceUtil.retriveResource(response, myPojo.User.class));
			} else {
				System.out.println("something went wrong" + response);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int validateStatusCode() {
		return response.getStatusLine().getStatusCode();
	}

	public String validateLogin() {
		return getUser().getLogin();
	}

	public void postRequest(String resourceURN, String json) {
		HttpPost req = new HttpPost(URI + resourceURN);
		StringEntity entity;
		try {
			User user = new User();
			user.setId("1234");

			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writeValueAsString(user);
			entity = new StringEntity(json);
			req.setEntity(entity);
			this.response = HttpClientBuilder.create().build().execute((HttpUriRequest) request);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// get request goe github user
	public void getRequest(String responseurn) {

		request = new HttpGet(URI + responseurn);
		request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
		try {
			this.response = HttpClientBuilder.create().build().execute((HttpUriRequest) request);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// to access the response
		if (response != null) {
			setUser(ResourceUtil.retriveResource(response, GitHubUsers.class));
		} else {
			System.out.println("something went wrong" + response);
		}

	}
}
