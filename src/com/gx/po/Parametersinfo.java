package com.gx.po;


import java.io.Serializable;
import java.util.Date;

/**
*@author MrZhang
*@Description parametersInfo实体类
*/

public class Parametersinfo implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String holeSize;//洞口尺寸

	private String doorSize;//门尺寸

	private String direction;//开口方向

	private String indoorInfo;//室内情况

	private String surveyor;//测量师

	private String surveyorSmark;//测量师备注

	private Date surveyorDate;//测量日期

	private String woodcase;//木套尺寸

	private String moundlayer;//压条尺寸

	private String installPerson;//安装人员

	private String installPerSmark;//安装备注

	private Date installDate;//安装日期

	private String surveyorPhotoPath;//测量照片

	private String surveyorPhotoName;//测量照片文件名

	private String surveyorPhotoDes;//测量照片描述

	private String istallPhotoPath;//安装照片

	private String istallPhotoName;//测量照片文件名

	private String istallPhotoDes;//安装照片描述

	private String otherSmark;//其它备注

	private String agreementID; //合同id

	private Date beginDate;                    //开始时间

	private Date endDate;                    //结束时间

	private String surveyorDateStr;                //测量日期

	private String installDateStr;           //安装日期

	private String operatorID;           //操作员ID

	private String storeID;            //店

	private String roleID;                //角色id

	private  String merName; //商户名

	private Date createDate; //创建日期

	private Date updateDate;//更新日期


	public String getSurveyorPhotoDes() {
		return surveyorPhotoDes;
	}

	public void setSurveyorPhotoDes(String surveyorPhotoDes) {
		this.surveyorPhotoDes = surveyorPhotoDes;
	}

	public String getIstallPhotoDes() {
		return istallPhotoDes;
	}

	public void setIstallPhotoDes(String istallPhotoDes) {
		this.istallPhotoDes = istallPhotoDes;
	}

	public String getSurveyorDateStr() {
		return surveyorDateStr;
	}

	public void setSurveyorDateStr(String surveyorDateStr) {
		this.surveyorDateStr = surveyorDateStr;
	}

	public String getInstallDateStr() {
		return installDateStr;
	}

	public void setInstallDateStr(String installDateStr) {
		this.installDateStr = installDateStr;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getOperatorID() {
		return operatorID;
	}

	public void setOperatorID(String operatorID) {
		this.operatorID = operatorID;
	}

	public String getStoreID() {
		return storeID;
	}

	public void setStoreID(String storeID) {
		this.storeID = storeID;
	}

	public String getRoleID() {
		return roleID;
	}

	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHoleSize() {
		return holeSize;
	}

	public void setHoleSize(String holeSize) {
		this.holeSize = holeSize;
	}

	public String getDoorSize() {
		return doorSize;
	}

	public void setDoorSize(String doorSize) {
		this.doorSize = doorSize;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getIndoorInfo() {
		return indoorInfo;
	}

	public void setIndoorInfo(String indoorInfo) {
		this.indoorInfo = indoorInfo;
	}

	public String getSurveyor() {
		return surveyor;
	}

	public void setSurveyor(String surveyor) {
		this.surveyor = surveyor;
	}

	public String getSurveyorSmark() {
		return surveyorSmark;
	}

	public void setSurveyorSmark(String surveyorSmark) {
		this.surveyorSmark = surveyorSmark;
	}

	public Date getSurveyorDate() {
		return surveyorDate;
	}

	public void setSurveyorDate(Date surveyorDate) {
		this.surveyorDate = surveyorDate;
	}

	public String getWoodcase() {
		return woodcase;
	}

	public void setWoodcase(String woodcase) {
		this.woodcase = woodcase;
	}

	public String getMoundlayer() {
		return moundlayer;
	}

	public void setMoundlayer(String moundlayer) {
		this.moundlayer = moundlayer;
	}

	public String getInstallPerson() {
		return installPerson;
	}

	public void setInstallPerson(String installPerson) {
		this.installPerson = installPerson;
	}

	public String getInstallPerSmark() {
		return installPerSmark;
	}

	public void setInstallPerSmark(String installPerSmark) {
		this.installPerSmark = installPerSmark;
	}

	public Date getInstallDate() {
		return installDate;
	}

	public void setInstallDate(Date installDate) {
		this.installDate = installDate;
	}

	public String getSurveyorPhotoPath() {
		return surveyorPhotoPath;
	}

	public void setSurveyorPhotoPath(String surveyorPhotoPath) {
		this.surveyorPhotoPath = surveyorPhotoPath;
	}

	public String getIstallPhotoPath() {
		return istallPhotoPath;
	}

	public void setIstallPhotoPath(String istallPhotoPath) {
		this.istallPhotoPath = istallPhotoPath;
	}

	public String getOtherSmark() {
		return otherSmark;
	}

	public void setOtherSmark(String otherSmark) {
		this.otherSmark = otherSmark;
	}

	public String getAgreementID() {
		return agreementID;
	}

	public void setAgreementID(String agreementID) {
		this.agreementID = agreementID;
	}

	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getMerName() {
		return merName;
	}

	public void setMerName(String merName) {
		this.merName = merName;
	}

	@Override
	public String toString() {
		return "Parametersinfo{" +
				"id=" + id +
				", holeSize='" + holeSize + '\'' +
				", doorSize='" + doorSize + '\'' +
				", direction='" + direction + '\'' +
				", indoorInfo='" + indoorInfo + '\'' +
				", surveyor='" + surveyor + '\'' +
				", surveyorSmark='" + surveyorSmark + '\'' +
				", surveyorDate=" + surveyorDate +
				", woodcase='" + woodcase + '\'' +
				", moundlayer='" + moundlayer + '\'' +
				", installPerson='" + installPerson + '\'' +
				", installPerSmark='" + installPerSmark + '\'' +
				", installDate=" + installDate +
				", surveyorPhotoPath='" + surveyorPhotoPath + '\'' +
				", surveyorPhotoName='" + surveyorPhotoName + '\'' +
				", surveyorPhotoDes='" + surveyorPhotoDes + '\'' +
				", istallPhotoPath='" + istallPhotoPath + '\'' +
				", istallPhotoName='" + istallPhotoName + '\'' +
				", istallPhotoDes='" + istallPhotoDes + '\'' +
				", otherSmark='" + otherSmark + '\'' +
				", agreementID='" + agreementID + '\'' +
				", beginDate=" + beginDate +
				", endDate=" + endDate +
				", surveyorDateStr='" + surveyorDateStr + '\'' +
				", installDateStr='" + installDateStr + '\'' +
				", operatorID='" + operatorID + '\'' +
				", storeID='" + storeID + '\'' +
				", roleID='" + roleID + '\'' +
				", merName='" + merName + '\'' +
				", createDate=" + createDate +
				", updateDate=" + updateDate +
				'}';
	}

	public String getSurveyorPhotoName() {
		return surveyorPhotoName;
	}

	public void setSurveyorPhotoName(String surveyorPhotoName) {
		this.surveyorPhotoName = surveyorPhotoName;
	}

	public String getIstallPhotoName() {
		return istallPhotoName;
	}

	public void setIstallPhotoName(String istallPhotoName) {
		this.istallPhotoName = istallPhotoName;
	}
}

