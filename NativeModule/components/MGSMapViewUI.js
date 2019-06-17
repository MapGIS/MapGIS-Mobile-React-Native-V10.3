/**
 * @content 地图视图UI组件
 * @author fjl 2019-6-14 下午2:52:36
 */
import PropTypes from 'prop-types'
import React, {Component} from 'react';

import {
    View,requireNativeComponent, NativeModules, StyleSheet,
     } from 'react-native'

import MapView from '../MapView.js';
 class MGSMapView extends Component {

    constructor(){
        super();
        this._onChange = this._onChange.bind(this);
    }

    static propTypes = {
        ...View.propTypes,
        onGetInstance: PropTypes.func,
        returnId:PropTypes.bool
    };

    _onChange(event){
        console.log("has onGetInstance:"+event.nativeEvent.mapViewId);
        this.mapView = new MapView();
        this.mapView._MGMapViewId = event.nativeEvent.mapViewId;
        this.props.onGetInstance(this.mapView);

 }

    render() {
        var props = {...this.props};
        return(
            <View style={styles.views}>
                <RnMapView
                    returnId = {true}
                    {...this.props}
                    onChange={this._onChange}
                />
            </View>
        )
    }

}

var RnMapView = requireNativeComponent('MapviewGetInstance', MGSMapView,{nativeOnly:{
        returnId:true,
        onChange:true,
    }});

var styles = StyleSheet.create({
    views: {
        flex: 1,
        alignSelf: 'stretch',
        backgroundColor: '#ffbcbc',
        alignItems: 'center',
        justifyContent: 'center',
        overflow:'hidden',
    },
    map:{
        flex:1,
        alignSelf:'stretch',
    },
    pic:{
        position:'absolute',
        top:-100,
        left:-100,
    }
});

export default MGSMapView;


