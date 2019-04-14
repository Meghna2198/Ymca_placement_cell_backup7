package com.ymca.student;


import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.net.MalformedURLException;

import java.net.URL;



public class HttpConnectionHandler
{
  static URL mUrl = null;
  private static boolean mIsFailed = false;
  
  public HttpConnectionHandler() {}
  
  public static void GetTextFileFromServer(String aUrl, final IHttpTextReaderCallback aCallback)
  {
      
    mIsFailed = false;
    try {
      mUrl = new URL(aUrl);
    }

    catch (MalformedURLException e2) {
      e2.printStackTrace();
      if ((aCallback != null) && (!mIsFailed)) {
    	
        aCallback.failedToReceiveData();
      }
    }
    
    
    Thread t = new Thread(new Runnable()
    {

      public void run()
      {

        try
        {

          BufferedReader in = new BufferedReader(
            new InputStreamReader(HttpConnectionHandler.mUrl.openStream()));
          String response = "";
          
          String str;
          while ((str = in.readLine()) != null) { 
            response = response + str;
          }

          int ind1 = 0;
          String datawithout_space = "";
          while (ind1 < response.length()) {
            try
            {
              if ((response.charAt(ind1 - 1) != ' ') && 
                (response.charAt(ind1) == ' ') && 
                (response.charAt(ind1 + 2) != ' ')) {
                datawithout_space = datawithout_space + response.charAt(ind1);
                ind1++;
              } else if (response.charAt(ind1) == ' ') {
                ind1++;
              }
              else {
                datawithout_space = datawithout_space + response.charAt(ind1);
                ind1++;
              }
            } catch (Exception e) {
              ind1++;
            }
          }
          

          in.close();
          if (aCallback != null) {
            HttpConnectionHandler.mIsFailed = true;
            aCallback.dataReceived(datawithout_space);
          }
        }
        catch (Exception e)
        {
     
          
          if ((aCallback != null) && (!HttpConnectionHandler.mIsFailed)) {
        	  aCallback.failedToReceiveData();
          }
        }
      }
    });
    t.start();
  }
  

  public static void GetTextFileFromServer1(String aUrl, final IHttpTextReaderCallback aCallback)
  {
    mIsFailed = false;
    try {
      mUrl = new URL(aUrl);
    }
    catch (MalformedURLException e2) {
      e2.printStackTrace();
      if ((aCallback != null) && (!mIsFailed))
        aCallback.failedToReceiveData();
      return;
    }
    
    Thread t = new Thread(new Runnable()
    {

      public void run()
      {

        try
        {

          BufferedReader in = new BufferedReader(
            new InputStreamReader(HttpConnectionHandler.mUrl.openStream()));
          String response = "";
          
          String str;
					while ((str = in.readLine()) != null) {
						
            response = response + str;
          }
          
          int ind1 = 0;
          String datawithout_space = "";
          while (ind1 < response.length()) {
            try
            {
              if ((response.charAt(ind1 - 1) != ' ') && 
                (response.charAt(ind1) == ' ') && 
                (response.charAt(ind1 + 2) != ' ')) {
                datawithout_space = datawithout_space + response.charAt(ind1);
                ind1++;
              } else if (response.charAt(ind1) == ' ') {
                ind1++;
              }
              else {
                datawithout_space = datawithout_space + response.charAt(ind1);
                ind1++;
              }
            } catch (Exception e) {
              ind1++;
            }
          }
          

          in.close();
          if (aCallback != null) {
            HttpConnectionHandler.mIsFailed = true;
            aCallback.dataReceived(datawithout_space);
          }
        }
        catch (Exception e)
        {
          if ((aCallback != null) && (!HttpConnectionHandler.mIsFailed)) {
        	  aCallback.failedToReceiveData();
          }
        }
      }
    });
    t.start();
  }
  
  public static void GetTextFileFromServerSimpleURL(String aUrl, final IHttpTextReaderCallback aCallback)
  {
    try
    {
      mUrl = new URL(aUrl);
    }
    catch (MalformedURLException e2) {
      e2.printStackTrace();
    }
    
    Thread t = new Thread(new Runnable()
    {

      public void run()
      {

        try
        {

          BufferedReader in = new BufferedReader(
            new InputStreamReader(HttpConnectionHandler.mUrl.openStream()));
          String response = "";
          
          String str;
          while ((str = in.readLine()) != null) { 
            response = response + str;
          }
          
          response = response.replace(" ", "");
          
          in.close();
          if (aCallback != null) {
        	  aCallback.dataReceived(response);
          }
        }
        catch (Exception e) {
          if (aCallback != null) {
        	  aCallback.failedToReceiveData();
          }
        }
      }
    });
    t.start();
  }
}
