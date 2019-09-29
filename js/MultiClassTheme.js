/*
 * @Description: In User Settings Edit
 * @Author: xiaoying
 * @Date: 2019-09-03 12:00:02
 * @LastEditTime: 2019-09-09 16:05:00
 * @LastEditors: Please set LastEditors
 */
import { NativeModules } from 'react-native';
import ClassItemValue from './ClassItemValue.js';
import MultiClassThemeInfo from './MultiClassThemeInfo.js';
import ThemeInfo from './ThemeInfo.js';
import VectorTheme from './VectorTheme.js';
let MCT = NativeModules.JSMultiClassTheme;

/**
 * @class MultiClassTheme
 * @description 多表达式分段专题图
 */
export default class MultiClassTheme extends VectorTheme {
  constructor() {
    super();
    Object.defineProperty(this, '_MGMultiClassThemeId', {
      get: function() {
        return this._MGVectorThemeId;
      },
      set: function(_MGMultiClassThemeId) {
        this._MGVectorThemeId = _MGMultiClassThemeId;
      },
    });
  }

  /**
   * 构造一个新的MultiClassTheme对象
   *
   * @memberof MultiClassTheme
   * @returns {Promise<MultiClassTheme>}
   */
  async createObj() {
    try {
      var { MultiClassThemeId } = await MCT.createObj();
      var multiClassTheme = new MultiClassTheme();
      multiClassTheme._MGMultiClassThemeId = MultiClassThemeId;
      return multiClassTheme;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取缺省专题绘制信息
   *
   * @memberof MultiClassTheme
   * @returns {Promise<ThemeInfo>}
   */
  async getDefaultInfo() {
    try {
      var { ThemeInfoId } = await MCT.getDefaultInfo(this._MGMultiClassThemeId);
      var themeInfo = new ThemeInfo();
      themeInfo._MGThemeInfoId = ThemeInfoId;
      return themeInfo;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置缺省专题绘制信息
   *
   * @memberof MultiClassTheme
   * @param {Object} themeInfo 缺省专题绘制信息
   * @returns {Promise<Void>}
   */
  async setDefaultInfo(themeInfo) {
    try {
      await MCT.setDefaultInfo(
        this._MGMultiClassThemeId,
        themeInfo._MGThemeInfoId
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获得分级字段表达式的数目
   *
   * @memberof MultiClassTheme
   * @returns {int} 分级字段表达式的数目
   */
  async getExpCount() {
    try {
      let expCount = await MCT.getExpCount(this._MGMultiClassThemeId);
      return expCount;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获得项（做完笛卡尔积之后）的个数
   *
   * @memberof MultiClassTheme
   * @returns {int} 项（做完笛卡尔积之后）的个数
   */
  async getItemCount() {
    try {
      let itemCount = await MCT.getItemCount(this._MGMultiClassThemeId);
      return itemCount;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获得专题图类型
   *
   * @memberof MultiClassTheme
   * @returns {int} 专题图类型，例：AllOtherDataItemInfoSource.DefaultThemeInfo
   */
  async getAllOtherDataItemInfoSource() {
    try {
      let itemCount = await MCT.getAllOtherDataItemInfoSource(
        this._MGMultiClassThemeId
      );
      return itemCount;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置专题图类型
   *
   * @memberof MultiClassTheme
   * @param {int} allOtherDataItemInfoSource 专题图类型，例：AllOtherDataItemInfoSource.DefaultThemeInfo
   * @returns {Promise<Void>}
   *
   */
  async setAllOtherDataItemInfoSource(allOtherDataItemInfoSource) {
    try {
      await MCT.setAllOtherDataItemInfoSource(
        this._MGMultiClassThemeId,
        allOtherDataItemInfoSource
      );
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 添加分级字段表达式
   *
   * @memberof MultiClassTheme
   * @param {String} exp 字段表达式
   * @param {int} classItemType 统计分段类型
   * @returns {int} 成功返回索引
   */
  async appendExpression(exp, classItemType) {
    try {
      let index = await MCT.appendExpression(
        this._MGMultiClassThemeId,
        exp,
        classItemType
      );
      return index;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 移除分级字段表达式
   *
   * @memberof MultiClassTheme
   * @param {String} exp 字段表达式
   * @returns {boolean} true-成功 ：false-失败
   */
  async removeExpression(exp) {
    try {
      let result = await MCT.removeExpression(this._MGMultiClassThemeId, exp);
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获得分级字段表达式的索引
   *
   * @memberof MultiClassTheme
   * @param {String} exp
   * @returns {int} 成功返回字段表达式的索引
   */
  async indexOfExpression(exp) {
    try {
      let index = await MCT.indexOfExpression(this._MGMultiClassThemeId, exp);
      return index;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获得分级字段表达式
   *
   * @memberof MultiClassTheme
   * @param {int} index 字段表达式索引
   * @returns {String} 成功返回分级字段表达式
   */
  async getExpression(index) {
    try {
      let exp = await MCT.getExpression(this._MGMultiClassThemeId, index);
      return exp;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 交换两个分级字段表达式
   *
   * @memberof MultiClassTheme
   * @param {int} index1 字段表达式的索引
   * @param {int} index2 字段表达式的索引
   * @returns {boolean} true-成功 ： false-失败
   */
  async exchangeExpressions(index1, index2) {
    try {
      let result = await MCT.exchangeExpressions(
        this._MGMultiClassThemeId,
        index1,
        index2
      );
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获得分级字段表达式的类型
   *
   * @memberof MultiClassTheme
   * @param {String} exp 字段表达式
   * @returns {int} 成功返回字段表达式的统计分段类型，例：ClassItemType.UniqueType
   */
  async getExpressionClassItemType(exp) {
    try {
      let type = await MCT.getExpressionClassItemType(
        this._MGMultiClassThemeId,
        exp
      );
      return type;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 添加和字段表达式对应的分段值
   *
   * @memberof MultiClassTheme
   * @param {String} exp 字段表达式
   * @param {Object} classItemValue 和字段表达式对应的分段值
   * @returns {int} 成功返回字段表达式索引
   */
  async appendSubItem(exp, classItemValue) {
    try {
      let index = await MCT.appendSubItem(
        this._MGMultiClassThemeId,
        exp,
        classItemValue._MGClassItemValueId
      );
      return index;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 删除和字段表达式对应的分段值
   *
   * @memberof MultiClassTheme
   * @param {String} exp 字段表达式
   * @param {int} index 和字段表达式对应的分段值的索引
   * @returns {boolean} true-成功 ；false-失败
   */
  async removeSubItem(exp, index) {
    try {
      let result = await MCT.removeSubItem(
        this._MGMultiClassThemeId,
        exp,
        index
      );
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 合并和字段表达式对应的分段值（只对表达式值为RangeTheme类型的管用）
   *
   * @memberof MultiClassTheme
   * @param {String} exp 字段表达式
   * @param {int} index 待合并的分段值的索引
   * @param {int} count 待合并的分段值的数目
   * @returns {boolean} true-成功 ；false-失败
   */
  async mergeSubItem(exp, index, count) {
    try {
      let result = await MCT.mergeSubItem(
        this._MGMultiClassThemeId,
        exp,
        index,
        count
      );
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 分裂给定字段表达式对应的分段值（只对表达式值为RangeTheme类型的管用）
   *
   * @memberof MultiClassTheme
   * @param {String} exp 字段表达式
   * @param {int} index 待分裂的分段值的索引
   * @param {double} splitValue 拆分值
   * @returns {boolean} true-成功 ；false-失败
   */
  async splitSubItem(exp, index, splitValue) {
    try {
      let result = await MCT.splitSubItem(
        this._MGMultiClassThemeId,
        exp,
        index,
        splitValue
      );
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获得给定的值在分段中的索引
   *
   * @memberof MultiClassTheme
   * @param {String} exp 字段表达式
   * @param {String} itemValue  字段值
   * @returns {int} 成功返回给定的值在分段中的索引
   */
  async indexOfSubItem(exp, itemValue) {
    try {
      let index = await MCT.indexOfSubItem(
        this._MGMultiClassThemeId,
        exp,
        itemValue
      );
      return index;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 清除给定字段表达式的所有分段
   *
   * @memberof MultiClassTheme
   * @param {String} exp 字段表达式
   * @returns {boolean} true-成功 ；false-失败
   */
  async clearSubItems(exp) {
    try {
      let result = await MCT.clearSubItems(this._MGMultiClassThemeId, exp);
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获得给定字段表达式的分段数目
   *
   * @memberof MultiClassTheme
   * @param {String} exp 字段表达式
   * @returns {int} 成功返回给定字段表达式的分段数目
   */
  async getSubItemCount(exp) {
    try {
      let count = await MCT.getSubItemCount(this._MGMultiClassThemeId, exp);
      return count;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 修改给定字段表达式中指定索引处的值
   *
   * @memberof MultiClassTheme
   * @param {String} exp 字段表达式
   * @param {int} index 分段索引
   * @param {Object} classItemValue 分段值
   * @returns {boolean} true-成功 ；false-失败
   */
  async setSubItemValue(exp, index, classItemValue) {
    try {
      let result = await MCT.setSubItemValue(
        this._MGMultiClassThemeId,
        exp,
        index,
        classItemValue._MGClassItemValueId
      );
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 获取给定字段表达式中指定索引处的值
   *
   * @memberof MultiClassTheme
   * @param {String} exp 字段表达式
   * @param {int} index 分段索引
   * @returns {Promise<ClassItemValue>} 成功返回给定字段表达式中指定索引处的值
   */
  async getSubItemValue(exp, index) {
    try {
      var { ClassItemValueId } = await MCT.getSubItemValue(
        this._MGMultiClassThemeId,
        exp,
        index
      );
      var classItemValue = new ClassItemValue();
      classItemValue._MGClassItemValueId = ClassItemValueId;
      return classItemValue;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 生成所有的分段信息（该函数在调整了expression或者expression内部的分段信息后都需要调用）
   *
   * @memberof MultiClassTheme
   * @param {boolean} maintainExistentStyle 指示之前存在的分段的样式是否保持不变
   * @returns {boolean} true-成功 ；false-失败
   */
  async make(maintainExistentStyle) {
    try {
      let result = await MCT.make(
        this._MGMultiClassThemeId,
        maintainExistentStyle
      );
      return result;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 返回指定项（做完笛卡尔积之后）的信息
   *
   * @memberof MultiClassTheme
   * @param {int} index 项索引
   * @returns {Promise<MultiClassThemeInfo>} 成功返回指定项的信息
   */
  async getItem(index) {
    try {
      var { MultiClassThemeInfoId } = await MCT.getItem(
        this._MGMultiClassThemeId,
        index
      );
      var multiClassThemeInfo = new MultiClassThemeInfo();
      multiClassThemeInfo._MGMultiClassThemeInfoId = MultiClassThemeInfoId;
      return multiClassThemeInfo;
    } catch (e) {
      console.error(e);
    }
  }

  /**
   * 设置每个项（做完笛卡尔积之后）的信息
   *
   * @memberof MultiClassTheme
   * @param {int} index 项索引
   * @param {Object} multiClassThemeInfo 项信息
   * @returns {boolean} true-成功 ；false-失败
   */
  async setItem(index, multiClassThemeInfo) {
    try {
      let result = await MCT.setItem(
        this._MGMultiClassThemeId,
        index,
        multiClassThemeInfo._MGMultiClassThemeInfoId
      );
      return result;
    } catch (e) {
      console.error(e);
    }
  }
}
