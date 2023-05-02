#ifdef __cplusplus
#import "react-native-instagram-picker.h"
#endif

#ifdef RCT_NEW_ARCH_ENABLED
#import "RNInstagramPickerSpec.h"

@interface InstagramPicker : NSObject <NativeInstagramPickerSpec>
#else
#import <React/RCTBridgeModule.h>

@interface InstagramPicker : NSObject <RCTBridgeModule>
#endif

@end
