package com.ymca.student;

public abstract interface IHttpTextReaderCallback
{
  public abstract void dataReceived(String paramString);
  
  public abstract void failedToReceiveData();
}
