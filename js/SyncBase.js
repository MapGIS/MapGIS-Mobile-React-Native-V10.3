/**
 * @content 数据同步基类功能组件
 * @author  2019-09-25
 */
import {NativeModules} from 'react-native';
let SYB = NativeModules.JSSyncBase;

/**
 * @class SyncBase
 * @description 数据同步基类
 */
export default class SyncBase{

    /**
     * 设置同步结果监听
     * @memberOf SyncBase
     * @returns {Promise.<void>}
     */
   static async setFinishedListener()
	{
		try {
            await SYB.setFinishedListener();
          } catch (e) {
            console.error(e);
          }		
	}
    
    /**
     * 设置同步进度监听
     * @memberOf SyncBase
     * @returns {Promise.<void>}
     */
  static async setProgressListener()
	{
		try {
            await SYB.setProgressListener();
          } catch (e) {
            console.error(e);
          }	
	}
    
    /**
     * 移除同步进度监听
     * @memberOf SyncBase
     * @returns {Promise.<int>} >0-成功 ；<=0-失败
     */
  static async removeProgressListener()
	{
		try {
            return await SYB.removeProgressListener();
          } catch (e) {
            console.error(e);
          }	
	}
    
    /**
     * 移除同步结果监听
     * @memberOf SyncBase
     * @returns {Promise.<int>} >0-成功 ；<=0-失败
     */
    static async removeFinishedListener()
    {
        try {
            return await SYB.removeFinishedListener();
          } catch (e) {
            console.error(e);
          }	
    }
}