
/**
 * React Natived显示Android原生MapView
 * Created by FJL on 2019/4/15
 */
import React, { Component } from 'react';
import {
  NativeModules,
  StyleSheet,
  Text,
  View,
  TouchableHighlight, DeviceEventEmitter,
} from 'react-native';

import MGMapView from "./NativeModule/components/MGSMapViewUI";

export default class App extends Component {


  _onGetInstance = (mapView) => {
    this.mapView = mapView;

  }

  //改变离线地图路径
  changeMap = async() => {
    await this.mapView.loadFromFile("Map/MapShow/WorldMKTTile.mapx")
  }

  state = {
    strMapPath:"Map/MapShow/WuHan/WuHan.mapx",
  };

  render() {
    return (
        <View style={ styles.container }>

          <Text style={styles.welcome}
                onPress = {this.changeMap}
          >点击切换地图</Text>


          <MGMapView
              ref = "mapView"
              onGetInstance={this._onGetInstance}
              strMapPath={this.state.strMapPath}
              style={{width:'100%',height:'100%'}}
          />
        </View>
    );
  }
}


const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 30,
    justifyContent: 'center',
    textAlign: 'center',
    marginTop:50,
    color: '#FF0000',
  },
  image: {
    width: 164, height: 164
  },
});
