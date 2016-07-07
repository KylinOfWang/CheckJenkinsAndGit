package com.benmu.checkjenkinsandgit;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class checkjenkinsandgit {

	static int time = 30;
	
	public static void main(String[] args) throws InterruptedException {
		//System.out.println("-------" + args[0]);
		int responseCode = test(args[0]);
		if(responseCode!=200){
			System.out.println("Failed");
		}else{
			System.out.println("200");
		}
		
	}
	
	public static int test(String url) throws InterruptedException {
		// TODO Auto-generated method stub
		String url_path = url;
		int responseCode = 0000;
		try {
			URL realUrl = new URL(url_path);
			HttpURLConnection connection = (HttpURLConnection) realUrl
					.openConnection();
			connection.setRequestProperty("accept", "*/*");
			connection.setRequestProperty("connection", "Keep-Alive");
			connection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

			for (int i = time; i > 0;) {

				connection.connect();
				i = i - 5;
				responseCode = connection.getResponseCode();
				if (responseCode != 200) {
					Thread.sleep(5000);
				} else {
					break;
				}
				// 遍历所有的响应头字段

			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			Thread.sleep(5000);
			time = time-5;
			test(url_path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Thread.sleep(5000);
			time = time-5;
			test(url_path);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Thread.sleep(5000);
			time = time-5;
			test(url_path);
		}
		return responseCode;
	}

}
