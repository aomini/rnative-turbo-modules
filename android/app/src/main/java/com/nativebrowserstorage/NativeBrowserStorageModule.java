package com.nativebrowserstorage;

import android.content.Context;
import android.content.SharedPreferences;
import com.nativebrowserstorage.NativeBrowserStorageSpec;
import com.facebook.react.bridge.ReactApplicationContext;

public class NativeBrowserStorageModule extends NativeBrowserStorageSpec {
  public static final String NAME = "NativeBrowserStorage";

  public NativeBrowserStorageModule(ReactApplicationContext rctContext){
    super(rctContext);
  }

  @Override
  public String getName(){
    return NAME;
  }

  @Override
  public void setItem(String key, String value){
    SharedPreferences sharedPref = getReactApplicationContext().getSharedPreferences(NAME, Context.MODE_PRIVATE);
    SharedPreferences.Editor editor = sharedPref.edit();
    editor.putString(key, value);
    editor.apply();
  }

  @Override
  public String getItem(String key){
    SharedPreferences sharedPref = getReactApplicationContext().getSharedPreferences(NAME, Context.MODE_PRIVATE);
    return sharedPref.getString(key, null);
  }

  @Override
  public void removeItem(String key) {
    SharedPreferences sharedPref = getReactApplicationContext().getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
    sharedPref.edit().remove(key).apply();
  }

  @Override
  public void clear(){
    SharedPreferences sharedPref = getReactApplicationContext().getSharedPreferences(NAME, Context.MODE_PRIVATE);
    sharedPref.edit().clear().apply();
  }
}