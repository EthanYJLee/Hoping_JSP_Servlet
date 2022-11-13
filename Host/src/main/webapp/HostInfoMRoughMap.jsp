<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/yjstyle.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/css/bootstrap.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/2.3.2/css/bootstrap-responsive.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.js"></script>
<script src="https://https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.4.1/js/bootstrap.js"></script>

<style type="text/css">

.mybtns {
	border: 0 solid black;
	transition: background-color .5s;
	border-radius: 15px;
}

.mybtns:hover {
	background-color: #E94560;
}

.mbtn {
	background-color: #E94560;
	color: white;
}

.myinfoinput{
	
	width: 150px;
	border: 0.5px solid gray;
	border-radius: 10px;
	height: 30px;
	padding: 0px 10px 0px 10px;
	
}

</style>

</head>
<body>
<%-- nav include --%>
<%@ include file = "hnav1.jsp" %>
 
 <%-- 본문 시작 --%>
 <div class="container myscontainer">
 	<div class="row myhdrow">
 		<h5 class="col-12" style="margin: 20px 0 20px 0">캠핑장의 약도를 수정하기</h5>
 	</div>
 	
 	<%-- 기존 약도 이미지 불러오기 --%>
 	<div class="row">
 		<div class="col-6">
 			<img class="myscontainer" alt="약도" src="./images/${roughMap.regImage4 }">
 		</div>
 	</div>
 	
 	<%-- 수정할 약도 업로드 --%>
	<h5 class="row" style="margin: 25px 0 30px 0">수정할 약도 이미지를 업로드해주세요.</h5>
 	<form action = "hiddenRoughMapUpload.jsp" method = "post" enctype = "multipart/form-data">
		<input type = "file" name = "file" size = "50" />
		<br>
		<input type = "submit" value = "Upload File" size="50" />
	</form>
	<div class="d-flex flex-row-reverse">
 		<div class="p-2">
 		<a href="HostInfoMMain.jsp" type="submit" style="border-radius: 15px; width:100px;" class="btn mybtns btn-secondary">완료</a>
 		</div>
 	</div>
 	
 </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>