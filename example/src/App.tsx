import * as React from 'react';

import { StyleSheet, View, Text, Image } from 'react-native';
import { openPicker } from 'react-native-instagram-picker';

export default function App() {
  const [result, setResult] = React.useState<any>();

  React.useEffect(() => {
    openPicker().then(setResult);
  }, []);

  React.useEffect(() => {
    console.log("Here is the image list result",result);
  }, [result]);

  return (
    <View style={styles.container}>
      {result && result.length>0 &&
      <View>

      {result.map((item:any) => (
          <Image
            source={{uri:'file://'+item.cutPath}}
            style={{width:300,height:300,backgroundColor:'yellow'}}/>
            ))}
        
        </View>
      }

    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
