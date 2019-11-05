package com.john.demo.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpClient {

	public static String doGet(String httpURL) {
		HttpURLConnection connection = null;
		InputStream is = null;
		BufferedReader br = null;
		String result = null;
		try {
			URL url = new URL(httpURL);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(15000);
			connection.setReadTimeout(60000);
			connection.connect();
			if (connection.getResponseCode() == 200) {
				is = connection.getInputStream();
				br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				StringBuffer sbf = new StringBuffer();
				String temp = null;
				while ((temp = br.readLine()) != null) {
					sbf.append(temp);
					sbf.append("\r\n");
				}
				result = sbf.toString();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			connection.disconnect();
		}
		return result;
	}

	public static String doPost(String httpUrl, String param) {
		HttpURLConnection connection = null;
		InputStream is = null;
		OutputStream os = null;
		BufferedReader br = null;
		String result = null;
		try {
			URL url = new URL(httpUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setConnectTimeout(15000);
			connection.setReadTimeout(60000);

			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setRequestProperty("Content-Type","application/json;charset-UTF-8");
			os = connection.getOutputStream();
			os.write(param.getBytes());
			if (connection.getResponseCode() == 200) {

				is = connection.getInputStream();
				br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

				StringBuffer sbf = new StringBuffer();
				String temp = null;
				while ((temp = br.readLine()) != null) {
					sbf.append(temp);
					sbf.append("\r\n");
				}
				result = sbf.toString();
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != os) {
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			connection.disconnect();
		}
		return result;
	}
}
