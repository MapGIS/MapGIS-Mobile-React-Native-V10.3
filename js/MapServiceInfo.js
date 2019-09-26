/**
 * @content 地图服务信息组件
 * @author  2019-09-25
 */
import { NativeModules } from "react-native";

let MSI = NativeModules.JSMapServiceInfo;

import MapServiceLayerInfo from "./MapServiceLayerInfo.js"

/**
 * @class MapServiceInfo
 * @description 地图服务信息
 */
export default class MapServiceInfo{

    /**
	 * 获取地图服务图层 列表
	 * @memberOf MapServiceInfo
	 * @return {Promise.List<MapServiceLayerInfo>} 地图服务图层列表
	 */
	async getLayerInfos()
	{
		try {
            var objArr = [];
            let { MapServiceLayerInfoArr } = await MSI.getLayerInfos(this._MGMapServiceInfoId);
            for (var i = 0; i < MapServiceLayerInfoArr.length; i++) {
              var mapServiceLayerInfo = new MapServiceLayerInfo();
              mapServiceLayerInfo._MGMapServiceLayerInfoId = MapServiceLayerInfoArr[i];
              objArr.push(mapServiceLayerInfo);
            }
            return objArr;
          } catch (e) {
            console.error(e);
        }
	}

}
