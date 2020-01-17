package com.zondy.mapgis.mobile.react;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.zondy.mapgis.core.srs.SRefData;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author xiaoying 2019-08-22 下午16:30:30
 * @content 空间参照系对象Native组件
 */
public class JSSRefData extends ReactContextBaseJavaModule {
    private static final String REACT_CLASS = "JSSRefData";
    private static Map<String, SRefData> mSrefDataList = new HashMap<>();

    public JSSRefData(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    public static SRefData getObjFromList(String id){return mSrefDataList.get(id);}

    public static String registerId(SRefData obj){
        for(Map.Entry entry : mSrefDataList.entrySet()){
            if(obj.equals(entry.getValue())){
                String id = (String) entry.getKey();
                return id;
            }
        }
        String id = UUID.randomUUID().toString().substring(24);
        mSrefDataList.put(id,obj);
        return id;
    }

    @ReactMethod
    public void createObj(Promise promise){
        try {
            SRefData sRefData = new SRefData();
            String sRefDataId = registerId(sRefData);

            WritableMap map = Arguments.createMap();
            map.putString("SRefDataId",sRefDataId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSRSID(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            int srsId = sRefData.getSRSID();

            promise.resolve(srsId);
        }catch (Exception e){
         promise.reject(e);
        }
    }

    @ReactMethod
    public void setSRSID(String sRefDataId, int srsId,Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            sRefData.setSRSID(srsId);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getSRSName(String sRefdataId, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefdataId);
            String srsName = sRefData.getSRSName();
            promise.resolve(srsName);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSRSName(String sRefDataId, String srsName, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            sRefData.setSRSName(srsName);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAlias(String sRefDataId, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            String alias = sRefData.getAlias();
            promise.resolve(alias);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setAlias(String sRefDataId, String alias, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            sRefData.setAlias(alias);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAbbreviation(String sRefDataId, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            String abbreviation = sRefData.getAbbreviation();
            promise.resolve(abbreviation);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAbbreviation(String sRefDataId, String abbreviation, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            sRefData.setAbbreviation(abbreviation);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getRemark(String sRefDataId, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            String remark = sRefData.getRemark();
            promise.resolve(remark);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setRemark(String sRefDataId, String remark, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            sRefData.setRemark(remark);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getType(String sRefDataId, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            int type = sRefData.getType();
            promise.resolve(type);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setType(String sRefDataId, int type, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            sRefData.setType((short) type);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGCSName(String sRefDataId, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            String gcsName = sRefData.getGCSName();
            promise.resolve(gcsName);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setGCSName(String sRefDataId, String gcsName, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            sRefData.setGCSName(gcsName);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }


    @ReactMethod
    public void getSpheroid(String sRefDataId, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            int spheroid = sRefData.getSpheroid();
            promise.resolve(spheroid);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setSpheroid(String sRefDataId, int spheroid, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            sRefData.setSpheroid((short) spheroid);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getA(String sRefDataId, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            double a = sRefData.getA();
            promise.resolve(a);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setA(String sRefDataId, double a, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            sRefData.setA(a);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getB(String sRefDataId, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            double b = sRefData.getB();
            promise.resolve(b);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setB(String sRefDataId, double b, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            sRefData.setB(b);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAf(String sRefDataId, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            double af = sRefData.getAf();
            promise.resolve(af);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setAf(String sRefDataId, double af, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            sRefData.setAf(af);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPMName(String sRefDataId, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            String pmName = sRefData.getPMName();
            promise.resolve(pmName);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPMName(String sRefDataId, String pmName, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            sRefData.setPMName(pmName);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPMOffset(String sRefDataId, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            double pmOffset = sRefData.getPMOffset();
            promise.resolve(pmOffset);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPMOffset(String sRefDataId, double pmOffset, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            sRefData.setPMOffset(pmOffset);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getGeoCode(String sRefDataId, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            String geoCode = sRefData.getGeoCode();
            promise.resolve(geoCode);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setGeoCode(String sRefDataId, String geoCode, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            sRefData.setGeoCode(geoCode);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPCSName(String sRefDataId, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            String pcsName = sRefData.getPCSName();
            promise.resolve(pcsName);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setPCSName(String sRefDataId, String pcsName, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            sRefData.setPCSName(pcsName);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getProjName(String sRefDataId, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            String projName = sRefData.getProjName();
            promise.resolve(projName);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setProjName(String sRefDataId, String projName, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            sRefData.setProjName(projName);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getProjTypeID(String sRefDataId, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            int projTypeId = sRefData.getProjTypeID();
            promise.resolve(projTypeId);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void setProjTypeID(String sRefDataId, int projTypeID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            sRefData.setProjTypeID((short)projTypeID);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getZoneType(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            int zoneType = sRefData.getZoneType();
            promise.resolve(zoneType);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setZoneType(String sRefDataID, int zoneType, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setZoneType((short)zoneType);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getZone(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            int zone = sRefData.getZone();
            promise.resolve(zone);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setZone(String sRefDataID, int zone, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setZone((short)zone);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLon(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double lon = sRefData.getLon();
            promise.resolve(lon);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setLon(String sRefDataID, double lon, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setLon(lon);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLon1(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double lon1 = sRefData.getLon1();
            promise.resolve(lon1);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setLon1(String sRefDataID, double lon1, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setLon1(lon1);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLon2(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double lon2 = sRefData.getLon2();
            promise.resolve(lon2);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setLon2(String sRefDataID, double lon2, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setLon2(lon2);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLat(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double lat = sRefData.getLat();
            promise.resolve(lat);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setLat(String sRefDataID, double lat, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setLat(lat);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLat1(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double lat1 = sRefData.getLat1();
            promise.resolve(lat1);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setLat1(String sRefDataID, double lat1, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setLat1(lat1);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLat2(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double lat2 = sRefData.getLat2();
            promise.resolve(lat2);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setLat2(String sRefDataID, double lat2, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setLat2(lat2);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFalseE(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double falseE = sRefData.getFalseE();
            promise.resolve(falseE);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setFalseE(String sRefDataID, double falseE, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setFalseE(falseE);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getFalseN(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double falseN = sRefData.getFalseN();
            promise.resolve(falseN);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setFalseN(String sRefDataID, double falseN, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setFalseN(falseN);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getX(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double x = sRefData.getX();
            promise.resolve(x);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setX(String sRefDataID, double x, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setX(x);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getY(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double y = sRefData.getY();
            promise.resolve(y);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setY(String sRefDataID, double y, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setY(y);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getDimension(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            int dimension = sRefData.getDimension();
            promise.resolve(dimension);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setDimension(String sRefDataID, int dimension, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setDimension((short)dimension);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAxisName0(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            String axisName0 = sRefData.getAxisName0();
            promise.resolve(axisName0);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setAxisName0(String sRefDataID, String axisName0, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setAxisName0(axisName0);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAxisUnit0(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            int axisUnit0 = sRefData.getAxisUnit0();
            promise.resolve(axisUnit0);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setAxisUnit0(String sRefDataID, int axisUnit0, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setAxisUnit0((short)axisUnit0);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }


    @ReactMethod
    public void getAxisMin0(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double axisMin0 = sRefData.getAxisMin0();
            promise.resolve(axisMin0);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setAxisMin0(String sRefDataID,double axisMin0 , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setAxisMin0(axisMin0);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAxisMax0(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double axisMax0 = sRefData.getAxisMax0();
            promise.resolve(axisMax0);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setAxisMax0(String sRefDataID,double axisMax0 , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setAxisMax0(axisMax0);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPrecision0(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double precision0 = sRefData.getPrecision0();
            promise.resolve(precision0);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setPrecision0(String sRefDataID,double precision0 , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setPrecision0(precision0);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAxisName1(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            String axisName1 = sRefData.getAxisName1();
            promise.resolve(axisName1);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setAxisName1(String sRefDataID, String axisName1 , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setAxisName1(axisName1);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAxisUnit1(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            int axisUnit1 = sRefData.getAxisUnit1();
            promise.resolve(axisUnit1);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setAxisUnit1(String sRefDataID, int axisUnit1 , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setAxisUnit1((short)axisUnit1);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAxisMin1(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double axisMin1 = sRefData.getAxisMin1();
            promise.resolve(axisMin1);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setAxisMin1(String sRefDataID, double axisMin1 , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setAxisMin1(axisMin1);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAxisMax1(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double axisMax1 = sRefData.getAxisMax1();
            promise.resolve(axisMax1);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setAxisMax1(String sRefDataID, double axisMax1 , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setAxisMax1(axisMax1);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPrecision1(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double precision1 = sRefData.getPrecision1();
            promise.resolve(precision1);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setPrecision1(String sRefDataID, double precision1 , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setPrecision1(precision1);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAxisName2(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            String axisName2 = sRefData.getAxisName2();
            promise.resolve(axisName2);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setAxisName2(String sRefDataID, String axisName2 , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setAxisName2(axisName2);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAxisUnit2(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            int axisUnit2 = sRefData.getAxisUnit2();
            promise.resolve(axisUnit2);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setAxisUnit2(String sRefDataID, int axisUnit2 , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setAxisUnit2((short)axisUnit2);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAxisMin2(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double axisMin2 = sRefData.getAxisMin2();
            promise.resolve(axisMin2);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setAxisMin2(String sRefDataID, double axisMin2 , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setAxisMin2(axisMin2);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAxisMax2(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double axisMax2 = sRefData.getAxisMax2();
            promise.resolve(axisMax2);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setAxisMax2(String sRefDataID, double axisMax2 , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setAxisMax2(axisMax2);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPrecision2(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double precision2 = sRefData.getPrecision2();
            promise.resolve(precision2);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setPrecision2(String sRefDataID, double precision2 , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setPrecision2(precision2);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAxisName3(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            String axisName3 = sRefData.getAxisName3();
            promise.resolve(axisName3);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setAxisName3(String sRefDataID, String axisName3 , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setAxisName3(axisName3);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAxisUnit3(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            int axisUnit3 = sRefData.getAxisUnit3();
            promise.resolve(axisUnit3);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setAxisUnit3(String sRefDataID, int axisUnit3 , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setAxisUnit3((short)axisUnit3);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAxisMin3(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double axisMin3 = sRefData.getAxisMin3();
            promise.resolve(axisMin3);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setAxisMin3(String sRefDataID, double axisMin3 , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setAxisMin3(axisMin3);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAxisMax3(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double axisMax3 = sRefData.getAxisMax3();
            promise.resolve(axisMax3);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setAxisMax3(String sRefDataID, double axisMax3 , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setAxisMax3(axisMax3);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getPrecision3(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double precision3 = sRefData.getPrecision3();
            promise.resolve(precision3);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setPrecision3(String sRefDataID, double precision3 , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setPrecision3(precision3);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getUnit(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            int unit = sRefData.getUnit();
            promise.resolve(unit);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setUnit(String sRefDataID, int unit , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setUnit((short)unit);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getUnitFactor(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double unitFactor = sRefData.getUnitFactor();
            promise.resolve(unitFactor);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setUnitFactor(String sRefDataID, double unitFactor , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setUnitFactor(unitFactor);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAngUnit(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            int angUnit = sRefData.getAngUnit();
            promise.resolve(angUnit);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setAngUnit(String sRefDataID, int angUnit , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setAngUnit((short)angUnit);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getAngUnitFactor(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double angUnitFactor = sRefData.getAngUnitFactor();
            promise.resolve(angUnitFactor);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setAngUnitFactor(String sRefDataID, double angUnitFactor , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setAngUnitFactor(angUnitFactor);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getRate(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double rate = sRefData.getRate();
            promise.resolve(rate);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setRate(String sRefDataID, double rate , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setRate(rate);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLevelType(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            int levelType = sRefData.getLevelType();
            promise.resolve(levelType);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setLevelType(String sRefDataID, int levelType , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setLevelType((short)levelType);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLevelName(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            String levelName = sRefData.getLevelName();
            promise.resolve(levelName);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setLevelName(String sRefDataID, String levelName , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setLevelName(levelName);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getLevelOffset(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double levelOffset = sRefData.getLevelOffset();
            promise.resolve(levelOffset);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setLevelOffset(String sRefDataID, double levelOffset , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setLevelOffset(levelOffset);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getN(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double n = sRefData.getN();
            promise.resolve(n);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setN(String sRefDataID, double n , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setN(n);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getH(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double h = sRefData.getH();
            promise.resolve(h);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setH(String sRefDataID, double h , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setH(h);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getVRate(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            double vRate = sRefData.getVRate();
            promise.resolve(vRate);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setVRate(String sRefDataID, double vRate , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setVRate(vRate);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getVUnit(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            int vUnit = sRefData.getVUnit();
            promise.resolve(vUnit);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setVUnit(String sRefDataID, int vUnit , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setVUnit((short)vUnit);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void getVerticalDatumType(String sRefDataID, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            int verticalDatumType = sRefData.getVerticalDatumType();
            promise.resolve(verticalDatumType);
        }catch (Exception e){
            promise.reject(e);
        }
    }
    @ReactMethod
    public void setVerticalDatumType(String sRefDataID, int verticalDatumType , Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataID);
            sRefData.setVerticalDatumType((short)verticalDatumType);
            promise.resolve(true);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void clone(String sRefDataId, Promise promise){
        try {
            SRefData srcRefData = getObjFromList(sRefDataId);
            SRefData clonesRefData = srcRefData.clone();

            String desSrefDataId = JSSRefData.registerId(clonesRefData);
            WritableMap map = Arguments.createMap();
            map.putString("SRefDataId",desSrefDataId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void load(String sRefDataId, ReadableArray readableArray, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            byte[] array = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++){
                byte byteI = (byte) readableArray.getInt(i);
                array[i] = byteI;
            }
            boolean loadResult = sRefData.load(array);
            promise.resolve(loadResult);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public void save(String sRefDataId, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            byte[] saveArray = sRefData.save();
            WritableArray writableArray = Arguments.createArray();
            for (int i = 0; i < saveArray.length; i++){
                writableArray.pushInt(saveArray[i]);
            }
            promise.resolve(writableArray);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void getWebMercator(String sRefDataId, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            SRefData desRefData = sRefData.getWebMercator();

            String desSrefDataId = JSSRefData.registerId(desRefData);
            WritableMap map = Arguments.createMap();
            map.putString("SRefDataId",desSrefDataId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

    @ReactMethod
    public static void getWGS84(String sRefDataId, Promise promise){
        try {
            SRefData sRefData = getObjFromList(sRefDataId);
            SRefData desRefData = sRefData.getWGS84();

            String desSrefDataId = JSSRefData.registerId(desRefData);
            WritableMap map = Arguments.createMap();
            map.putString("SRefDataId",desSrefDataId);
            promise.resolve(map);
        }catch (Exception e){
            promise.reject(e);
        }
    }

}
