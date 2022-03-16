# MapGIS-Mobile-React-Native-V10.3

MapGIS Mobile for React Native，是MapGIS推出的一款基于React Native的跨平台移动开发框架，用户可以基于它使用JavaScript开发出在Android和iOS平台下运行的原生移动GIS应用。

## 安装

在React Native项目中安装 `@mapgis/mobile-react-native` 包。

```bash
yarn add @mapgis/mobile-react-native@1.1.4
# or with npm
# npm install @mapgis/mobile-react-native@1.1.4
```

### 链接原生库

- **React Native 0.60 and higher**

  [linking is automatic](https://github.com/react-native-community/cli/blob/master/docs/autolinking.md)，不需要执行任何操作。

- **React Native 0.59 and lower**

  如果您使用的是旧版本的React Native，则需要手动链接：

  ```sh
  react-native link @mapgis/mobile-react-native
  ```

## 用法


```js
// In App.js
import React, { Component } from "react";
import { Platform, StyleSheet, View, PermissionsAndroid } from "react-native";
import { Environment, MGMapView } from "@mapgis/mobile-react-native";

export default class App extends Component {
  onGetInstance = mapView => {
    this.mapView = mapView;
    this.openMap();
  };

  openMap = async () => {
    //请求权限
    await requestMultiplePermission();

    //初始化环境目录
    var environmnetModule = new Environment();
    var environmnet = await environmnetModule.createObj();
    await environmnet.initialize("MapGISSample");

    //请求授权
    await environmnet.requestAuthorization();

    //加载文档
    await this.mapView.loadFromFile(
      "MapGISSample/Map/MapShow/WuHan/WuHan.mapx"
    );
  };

  render() {
    return (
      <View style={styles.container}>
        <MGMapView
          ref="mapView"
          onGetInstance={this.onGetInstance}
          style={styles.mapView}
        />
      </View>
    );
  }
}

function checkGranted(granteds) {
  const values = Object.values(granteds);
  let isGranted = true;
  for (let i = 0; i < values.length - 1; i++) {
    if (values[i] != values[i + 1]) {
      isGranted = false;
      break;
    }
  }
  if (isGranted && values[0] === PermissionsAndroid.RESULTS.GRANTED) {
    return true;
  }
  return false;
}

async function requestMultiplePermission() {
  if (Platform.OS === "ios") return;

  try {
    const permissions = [
      PermissionsAndroid.PERMISSIONS.WRITE_EXTERNAL_STORAGE,
      PermissionsAndroid.PERMISSIONS.READ_PHONE_STATE
    ];
    //返回得是对象类型
    const granteds = await PermissionsAndroid.requestMultiple(permissions);
    if (!checkGranted(granteds)) {
      throw new Error("授权拒绝，无法正常使用本应用");
    }
  } catch (err) {
    throw new Error("授权失败，无法正常使用本应用");
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1
  },
  mapView: {
    flex: 1,
    alignSelf: "stretch"
  }
});
```
