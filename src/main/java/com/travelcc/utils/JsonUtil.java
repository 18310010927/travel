package com.travelcc.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class JsonUtil
{
  private static Gson gs = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
  private static Gson gson = new GsonBuilder().disableHtmlEscaping().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
  
  public static String toJson(Object obj)
  {
    return toJson(obj, false);
  }
  
  public static String toJson(Object obj, boolean disableHtmlEscaping)
  {
    if (disableHtmlEscaping) {
      return gson.toJson(obj);
    }
    return gs.toJson(obj);
  }
  
  public static <T> T fromJson(String json, Class<T> classOfT)
  {
    return gs.fromJson(json, classOfT);
  }
  
  public static JsonObject toJsonObject(String json)
  {
    JsonObject jo = (JsonObject)fromJson(json, JsonObject.class);
    return jo;
  }
  
  public static void main(String[] args) {}
}
