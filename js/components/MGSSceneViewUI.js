/*
 * @Description: 
 * @Version: 1.0
 * @Autor: liaoliang
 * @Date: 2020-07-16 15:38:55
 * @LastEditors: liaoliang
 * @LastEditTime: 2020-08-19 21:52:37
 */
/**
 * @content 地图视图UI组件
 * @author fjl 2019-6-14 下午2:52:36
 */
import PropTypes from 'prop-types';
import React, { Component } from 'react';

import { View, requireNativeComponent, StyleSheet } from 'react-native';

import SceneView from '../scene/SceneView.js';
class MGSSceneView extends Component {
  constructor() {
    super();
    this._onChange = this._onChange.bind(this);
  }

  static propTypes = {
    ...View.propTypes,
    onGetInstance: PropTypes.func,
    returnId: PropTypes.bool,
  };

  _onChange(event) {
    this.sceneView = new SceneView();
    this.sceneView._MGSceneViewId = event.nativeEvent.sceneViewId;
    this.props.onGetInstance(this.sceneView);
  }

  render() {
    return (
      <View style={styles.views}>
        <RNSceneView returnId={true} {...this.props} onChange={this._onChange} />
      </View>
    );
  }
}

var RNSceneView = requireNativeComponent('SceneViewManager', MGSSceneView, {
  nativeOnly: {
    returnId: true,
    onChange: true,
  },
});

var styles = StyleSheet.create({
  views: {
    flex: 1,
    alignSelf: 'stretch',
    backgroundColor: '#ffbcbc',
    alignItems: 'center',
    justifyContent: 'center',
    overflow: 'hidden',
  },
  map: {
    flex: 1,
    alignSelf: 'stretch',
  },
  pic: {
    position: 'absolute',
    top: -100,
    left: -100,
  },
});

export default MGSSceneView;
