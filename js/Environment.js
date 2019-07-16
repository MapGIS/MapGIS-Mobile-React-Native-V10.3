/**
 * @content 环境初始化功能组件
 * @author fjl 2019-6-21 下午2:52:36
 */
import { NativeModules } from 'react-native';
let X = NativeModules.JSEnvironment;
/**
 * @class Environment
 */
export default class Environment {
  /**
   * 构造一个新的 Environment 对象。
   * @memberOf Environment
   * @returns {Promise.<Environment>}
   */
  async createObj() {
    try {
      var { EnvironmentId } = await X.createObj();
      var environment = new Environment();
      environment._MGEnvironmentId = EnvironmentId;
      return environment;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 环境初始化，必须在使用SDK各组件之前调用，会自动建立根目录结构
   * @param {String} strRootPath 根路径： /MapGIS/
   * @param context 上下文
   */
  async initialize(strRootPath) {
    try {
      await X.initialize(this._MGEnvironmentId,strRootPath);

    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 请求授权
   * @returns {Promise<void>}
   */
  async requestAuthorization() {
    try {
      await X.requestAuthorization(this._MGEnvironmentId);

    } catch (e) {
      console.error(e);
    }
  }


  /**
   * 设置系统库路径
   * @param strPath
   * @returns {Promise<void>}
   */
  async setSystemLibraryPath(strPath) {
    try {
      await X.setSystemLibraryPath(this._MGEnvironmentId,strPath);
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取根路径
   * @memberOf Environment
   * @returns {Promise<*>}
   */
  async getRootPath() {
    try {
      let path = await X.getRootPath(this._MGEnvironmentId);

      return path;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   *
   * 获取系统库路径
   * @memberOf Environment
   * @return 系统库路径
   */
  async getSystemLibraryPath() {
    try {
      let systemLibraryPath = await X.getSystemLibraryPath(this._MGEnvironmentId);

      return systemLibraryPath;
    } catch (e) {
      console.error(e);
    }
  }
}
