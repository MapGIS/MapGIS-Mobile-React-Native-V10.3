
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
import Dot from './NativeModule/Dot'
import Image from './NativeModule/Image'
export default class App extends Component {


  _onGetInstance = (mapView) => {
    this.mapView = mapView;

  }

  componentDidMount() {
    DeviceEventEmitter.addListener("com.mapgis.RN.Mapview.single_tap_event",(res)=>{

      console.log("我是单击事件监听");
      console.log(res);
      //遍历对象所有数据
      var str='';
      for (var item in res){
        str +=item+":"+res[item]+"\n";
      }
      console.log("fjl:"+str);

    });

    DeviceEventEmitter.addListener("com.mapgis.RN.Mapview.double_tap_event",(res)=>{

      console.log("我是双击事件监听");
      console.log(res);
      //遍历对象所有数据
      var str='';
      for (var item in res){
        str +=item+":"+res[item]+"\n";
      }
      console.log("fjl:"+str);

    });
  }

  //改变离线地图路径
  changeMap = async() => {
    await this.mapView.loadFromFile("Map/MapShow/WorldMKTTile.mapx")
  }

  //设置地图的中心点测试
  pantoCernter = async() => {
    var dot = new Dot();
    var center = await dot.createObj(12751000.589636726,3568000.453292473 );
    // debugger;
    // console.log("获取点的ID:"+  center._MGDotId);
    await this.mapView.panToCenter(center);
    var c = await this.mapView.getCenter();
    console.log("获取点的ID:"+  c.x);
    await this.mapView.setTapListener();
    await this.mapView.setDoubleTapListener();

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

          <TouchableHighlight  onPress = {this.pantoCernter}>
            <Text style={styles.welcome}>PantoCenter测试</Text>
          </TouchableHighlight>
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
    fontSize: 20,
    justifyContent: 'center',
    textAlign: 'center',
    margin:10,
    color: '#FF0000',
  },
  image: {
    width: 164, height: 164
  },
});
