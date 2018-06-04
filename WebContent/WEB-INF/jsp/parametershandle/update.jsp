<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set  value="${pageContext.request.contextPath}" scope="page" var="ctx"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

	
<!--   <link rel="stylesheet" href="${ctx}/css/roomset/roomset.css" type="text/css"></link> -->
  <link rel="stylesheet" href="${ctx}/bootstrap/css/bootstrap.css" type="text/css"></link>
  <link href="${ctx}/bootstrap/css/bootstrap-responsive.css" rel="stylesheet">  <!-- start 响应式布局要添加的 -->
  <script src="${ctx}/bootstrap/js/jquery-3.1.1.min.js"></script>
  <script src="${ctx}/bootstrap/js/bootstrap.js"></script>
  <script type="text/javascript" src="${ctx}/My97DatePicker/WdatePicker.js"></script>

   <style>
   
   .container{
     margin-top: 10px;
   }
   
   .theadone{
     background-color: #CCFF99;
    }
   
   
   .labelroomnumber{
      position: relative;
      font-size: 17px;
      float: left;
      margin-top: 15px;
    }
    
    .marginrightone{
      margin-right: 33px;
    }
    
    .marginrighttwo{
      margin-right: 16.5px;
    }
    
    .marginrightthree{
      margin-right: 43px;
    }
    
   .textone{
    margin-top:12px;
    }
    
    .inputone{
    width:54.2%;
    }
    
    .inputtwo{
      width:46.8%;
    }
    
    .inputthree{
      width:46.8%;
    }
    
    .cboone{
      margin-top:10px;
      height: 27px;
    }
    
    .margin-top-one{
      margin-top: -10px;
    }
    
    .margin-top-two{
      margin-top: -20px;
    }
  
    .textwidth{
      width: 138px;
    }
    
    .radiusone{
     margin-left: -4px;
    }
    
     @media(min-width:731px) and (max-width:767px){
      .inputthree{
      width: 50.5%;
    }
    }
    
    @media(min-width:550px) and (max-width:730px){
      .inputtwo{
      width: 46.2%;
    }
        .inputthree{
      width: 49.2%;
    }
    }
    
    
     @media(min-width:431px) and (max-width:550px){
      .inputtwo{
      width: 43.2%;
    }
      .inputthree{
      width: 47.5%;
    }
    }
    
    @media(min-width:366px) and (max-width:430px){
      .inputtwo{
      width: 40.2%;
    }
      .inputthree{
      width: 46%;
    }
    }
    
     @media(min-width:285px) and (max-width:366px){
      .inputtwo{
      width: 37.2%;
    }
      .inputthree{
      width: 44%;
    }
    }
    
     @media(min-width:237px) and (max-width:285px){
      .inputtwo{
      width: 30%;
    }
      .inputthree{
      width: 40%;
    }
    }
    .span12{
      width:95%;
    }
    
    .yansered{
      color:red;
    }
  
  </style>
  
  </head>
  
 
  <body > 
  <div class="container" style="height:630px;overflow-x:auto;">
  
    <div class="span11" style=" border: solid; border-color: #DDDDDD;">
    <div class="span9 margin-top-one">
      <div class="row-fluid">
        <h3 style="text-align: center;">参数修改</h3>
        
      </div>
    </div>
    
    <form action="${ctx}/ParametersHandle/update.do" method="post" onsubmit="return verify()" enctype="multipart/form-data">
    <!--  ———————————————————————————————————————————————————————————————————————————————————————— -->
	    <input type="hidden" name="id" value="${list.id}" >
		<div class="span12">
			<div class="row-fluid">
				<div class="span3">
					<label>合同编号：</label>
					<input id="agreementID" name="agreementID"  type="text" style="width:97%;height:27px;float:left;"  value="${list.agreementID}" readonly="readonly">
					<div id="divOne" style="float:right;">
						<label class="yansered" style="margin-top:7px;">*</label>
					</div>
				</div>
				<div class="span3">
					<label>商户名称：</label>
					<input id="merName" name="merName" type="text" style="width:97%;height:27px;float:left;" value="${list.merName}">
					<div  id="divThree" style="float:right;">
						<label class="yansered" style="margin-top:7px;">*</label>
					</div>
				</div>
				<div class="span3">
					<label>测量师：</label>
					<input id="surveyor" name="surveyor" type="text" style="width:97%;height:27px;float:left;" value="${list.surveyor}">
					<div id="divTwo" style="float:right;">
						<label class="yansered" style="margin-top:7px;">*</label>
					</div>
				</div>
				<div class="span3">
					<label>测量日期：</label>
					<input style="width:97%;height:27px;float:left;" type="text" id="surveyorDateStr" name="surveyorDateStr" class="input-text Wdate"
						   onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d'})"
						   value="<fmt:formatDate value="${list.surveyorDate}" pattern="yyyy-MM-dd HH:mm:ss"/> ">
				</div>
			</div>
			<div class="row-fluid">
				<div class="span3">
					<label>洞口尺寸：</label>
					<input id="holeSize" name="holeSize" type="text" style="width:97%;height:27px;float:left;" value="${list.holeSize}">
				</div>
				<div class="span3">
					<label>门尺寸：</label>
					<input id="doorSize" name="doorSize" type="text" style="width:97%;height:27px;float:left;" value="${list.doorSize}">
				</div>
				<div class="span3">
					<label>开口方向：</label>
					<input id="direction" name="direction" type="text" style="width:97%;height:27px;float:left;" value="${list.direction}">
				</div>
				<div class="span3">
					<label>室内情况：</label>
					<input id="indoorInfo" name="indoorInfo" type="text" style="width:97%;height:27px;float:left;" value="${list.indoorInfo}">
				</div>
			</div>
			<div class="row-fluid">
				<div class="span12">
					<label>测量备注：</label>
					<input id="surveyorSmark" name="surveyorSmark" type="text" style="width:99.5%;height:27px;float:left;" value="${list.surveyorSmark}">
				</div>
			</div>
			<div class="row-fluid">
				<div class="span3">
					<label>安装师：</label>
					<input id="installPerson" name="installPerson" type="text" style="width:97%;height:27px;float:left;" value="${list.installPerson}">
				</div>
				<div class="span3">
					<label>安装日期：</label>
					<input style="width:97%;height:27px;float:left;" type="text" id="installDateStr" name="installDateStr" class="input-text Wdate"
						   onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd HH:mm:ss',maxDate:'%y-%M-%d'})"
						   value="<fmt:formatDate value="${list.installDate}" pattern="yyyy-MM-dd HH:mm:ss"/> ">
				</div>
				<div class="span3">
					<label>木套尺寸：</label>
					<input id="woodcase" name="woodcase" type="text" style="width:97%;height:27px;float:left;" value="${list.woodcase}">
				</div>
				<div class="span3">
					<label>压条尺寸：</label>
					<input id="moundlayer" name="moundlayer" type="text" style="width:97%;height:27px;float:left;" value="${list.moundlayer}">
				</div>
			</div>
			<div class="row-fluid">
				<div class="span12">
					<label>安装备注：</label>
					<input id="installPerSmark" name="installPerSmark" type="text" style="width:98.5%;height:27px;float:left;" value="${list.installPerSmark}">
				</div>
			</div>
			<div class="row-fluid">
				<div class="span12">
					<label>其它备注：</label>
					<input id="otherSmark" name="otherSmark" type="text" style="width:98.5%;height:27px;float:left;" value="${list.otherSmark}">
				</div>

			</div>
            <div class="row-fluid">
                <div class="span3">
                    <label>测量图片描述：</label>
                    <input type="text" name="surveyorPhotoDes" style="width:97%;height:27px;float:left;" value="${list.surveyorPhotoDes}">
                </div>
                <div class="span3">
                    <label>请选择文件：</label>
                    <input type="file" name="surveyorFile" style="width:97%;height:27px;float:left;" value="${list.surveyorPhotoPath}">
                </div>
				<div class="span3">
					<label>安装图片描述：</label>
					<input type="text" name="istallPhotoDes" style="width:97%;height:27px;float:left;" value="${list.istallPhotoDes}">
				</div>
				<div class="span3">
					<label>请选择文件：</label>
					<input type="file" name="istallFile" style="width:97%;height:27px;float:left;" value="${list.istallPhotoPath}">
				</div>
            </div>
			<div class="span6" style="text-align:center;">
				<div class="row-fluid">
					<div class="span12" style="margin-top: 10px;margin-bottom: 8px;">
						<button class="btn btn-primary" type="submit">
							<li class="icon-check icon-white"></li>修改</button>
					</div>

				</div>
			</div>
			<div class="span4" style="text-align:center;">
				<div class="row-fluid">
					<div class="span4"  style="margin-top: 10px;margin-bottom: 8px;">
						<button class="btn btn-warning" type="button" onclick="deletefunction()">
							<li class="icon-remove icon-white"></li>取消</button>
					</div>
				</div>
			</div>
		</div>
      </form>
      
      

       
    </div>
  </div>
 
 
 
 
 <script type="text/javascript">
 var Name=document.getElementById("papersNumberId").value;
 
    function verify(){
        if(document.getElementById("agreementID").value==""){
            alert("合同编号  是必填项，不能为空哦！");
            document.getElementById("agreementID").focus();
            return false;
        }else if(document.getElementById("agreementID").valuelength>64){
            alert("合同编号长度不能超过64位！");
            document.getElementById("agreementID").focus();
            return false;
        }else if(document.getElementById("holeSize").value.length>16){
            alert("洞口尺寸不能超过16位！");
            document.getElementById("holeSize").focus();
            return false;
        }else if(document.getElementById("doorSize").value.length>16){
            alert("门尺寸不能超过16位");
            document.getElementById("doorSize").focus();
            return false;
        }else if(document.getElementById("direction").value.length>4){
            alert("开口方向长度不能超过4位！");
            document.getElementById("direction").focus();
            return false;
        }else if(document.getElementById("indoorInfo").value.length>64){
            alert("室内情况长度不能超过64位！");
            document.getElementById("indoorInfo").focus();
            return false;
        }else if(document.getElementById("surveyor").value.length>16){
            alert("测量师长度不能超过16位！");
            document.getElementById("surveyor").focus();
            return false;
        }else if(document.getElementById("surveyorSmark").value.length>64){
            alert("测量师备注长度不能超过64位！");
            document.getElementById("surveyorSmark").focus();
            return false;
        }else if(document.getElementById("woodcase").value.length>16){
            alert("木套长度不能超过16位！");
            document.getElementById("woodcase").focus();
            return false;
        }else if(document.getElementById("moundlayer").value.length>16){
            alert("压条长度不能超过16位！");
            document.getElementById("moundlayer").focus();
            return false;
        }else if(document.getElementById("installPerson").value.length>16){
            alert("安装师长度不能超过16位！");
            document.getElementById("installPerson").focus();
            return false;
        }else if(document.getElementById("installPerSmark").value.length>64){
            alert("安装师备注长度不能超过64位！");
            document.getElementById("installPerSmark").focus();
            return false;
        }else if(document.getElementById("otherSmark").value.length>64){
            alert("其它备注长度不能超过64位！");
            document.getElementById("otherSmark").focus();
            return false;
        }else if(document.getElementById("merName").value.length>16){
            alert("商户名长度不能超过16位！");
            document.getElementById("merName").focus();
            return false;
        }else{
            return true;
        }
   }
   
    function deletefunction(){
     parent.document.getElementById('Mainid').src='${ctx}/ParametersHandle/tolist.do';
   }
	 
   
 </script>
   
  </body>
</html>
