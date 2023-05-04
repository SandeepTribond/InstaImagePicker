package com.instagrampicker;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.Promise;

abstract class InstagramPickerSpec extends ReactContextBaseJavaModule {
  InstagramPickerSpec(ReactApplicationContext context) {
    super(context);
  }

  public abstract void openPicker(Promise promise);
}
