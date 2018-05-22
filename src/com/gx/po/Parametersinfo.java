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

	private String istallPhotoPath;//安装照片

	private String otherSmark;//其它备注

	private String agreementID; //合同id

	private Date beginDate;                    //开始时间

	private Date endDate;                    //结束时间

	private String playDateStr;                //下单日期

	private String payDateStr;           //交款日期

	private String operatorID;           //操作员ID

	private String storeID;            //店

	private String roleID;                //角色id

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
				", istallPhotoPath='" + istallPhotoPath + '\'' +
				", otherSmark='" + otherSmark + '\'' +
				", agreementID='" + agreementID + '\'' +
				", beginDate=" + beginDate +
				", endDate=" + endDate +
				", playDateStr='" + playDateStr + '\'' +
				", payDateStr='" + payDateStr + '\'' +
				", operatorID='" + operatorID + '\'' +
				", storeID='" + storeID + '\'' +
				", roleID='" + roleID + '\'' +
				'}';
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

	public String getPlayDateStr() {
		return playDateStr;
	}

	public void setPlayDateStr(String playDateStr) {
		this.playDateStr = playDateStr;
	}

	public String getPayDateStr() {
		return payDateStr;
	}

	public void setPayDateStr(String payDateStr) {
		this.payDateStr = payDateStr;
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

}

