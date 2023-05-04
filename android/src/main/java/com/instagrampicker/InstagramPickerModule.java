package com.instagrampicker;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.gson.Gson;
import com.instagrampicker.cache.GlideCacheEngine;
import com.instagrampicker.cache.GlideEngine;
import com.instagrampicker.lib.entity.LocalMedia;
import com.instagrampicker.lib.instagram.InsGallery;
import com.instagrampicker.lib.listener.OnResultCallbackListener;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.WritableArray;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.List;

public class InstagramPickerModule extends com.instagrampicker.InstagramPickerSpec {
  public static final String NAME = "InstagramPicker";
  private final ReactApplicationContext reactContext;

  InstagramPickerModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  static {
    System.loadLibrary("cpp");
  }

  public static native double openPicker();

  // Example method
  // See https://reactnative.dev/docs/native-modules-android
  @ReactMethod
  public void openPicker(Promise promise) {
    InsGallery.openGallery(getCurrentActivity(), GlideEngine.createGlideEngine(), GlideCacheEngine.createCacheEngine(), new OnResultCallbackListener() {
      @Override
      public void onResult(List result) {
        WritableArray arrayResult= new WritableNativeArray();
        for(Object media:result){
          LocalMedia localMedia=(LocalMedia) media;
          WritableMap video = new WritableNativeMap();
          video.putString("cutPath",localMedia.getCutPath());
          video.putString("androidQToPath",localMedia.getAndroidQToPath());
          video.putDouble("bucketId",localMedia.getBucketId());
          video.putInt("chooseModel",localMedia.getChooseModel());
          video.putBoolean("compressed",localMedia.isCompressed());
          video.putDouble("duration",localMedia.getDuration());
          video.putString("fileName",localMedia.getFileName());
          video.putInt("height",localMedia.getHeight());
          video.putDouble("id",localMedia.getId());
          video.putBoolean("isChecked",localMedia.isChecked());
          video.putBoolean("isCut",localMedia.isCut());
          video.putBoolean("isLongImage",localMedia.isLongImage);
          video.putBoolean("isMaxSelectEnabledMask",localMedia.isMaxSelectEnabledMask());
          video.putBoolean("isOriginal",localMedia.isOriginal());
          video.putInt("loadLongImageStatus",localMedia.loadLongImageStatus);
          video.putString("mimeType",localMedia.getMimeType());
          video.putInt("num",localMedia.getNum());
          video.putInt("orientation",localMedia.getOrientation());
          video.putString("parentFolderName",localMedia.getParentFolderName());
          video.putString("path",localMedia.getPath());
          video.putInt("position",localMedia.getPosition());
          video.putString("realPath",localMedia.getRealPath());
          video.putDouble("size",localMedia.getSize());
          video.putInt("width",localMedia.getWidth());

          arrayResult.pushMap(video);
        }
        promise.resolve(arrayResult);
      }

      @Override
      public void onCancel() {

      }
    });
  }
}
