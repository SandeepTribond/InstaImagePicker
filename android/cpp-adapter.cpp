#include <jni.h>
#include "react-native-instagram-picker.h"

extern "C"
JNIEXPORT jint JNICALL
Java_com_instagrampicker_InstagramPickerModule_nativeMultiply(JNIEnv *env, jclass type, jdouble a, jdouble b) {
    return instagrampicker::multiply(a, b);
}
