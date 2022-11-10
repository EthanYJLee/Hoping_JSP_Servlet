<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800'); 
@import url('https://fonts.googleapis.com/css2?family=Ubuntu&display=swap');

body{
	font-family: 'Nanum Gothic';
	
}

.mybtn {
	transition: background-color .5s;
	border-radius: 15px;
}

.mybtn:hover {
	border: 0 solid black;
	background-color: #E94560;
}

.myscontainer {
	margin-bottom: 25px;
}

.mysearch {
	border-radius: 15px;
	border: 0.5px solid #808080;
	box-shadow: 1px 1px 3px 2px #E6E6E6;
	height: 33px;
	width: 500px;
}


.mytitle{
	font-family: 'Ubuntu', sans-serif;
	color: #E94560;
	font-size: 20px;	
	font-weight: bold;
}

.mysvg{
	margin-right: 5px;
	color: #E94560;
}

.mycard{
	border: 0px solid black;
	margin-bottom: 20px;
}


.mycbody{
	padding: 20px 0 0 0;
}

.myimage {
	border-radius: 15px;
	width: 250px;
	height: 250px;
}

.myctitle{
	font-size: 15px;
	font-weight: 600;
}

.myctext{
	font-weight:100;
	color: gray;
	
}

.mymcontainer{
	margin-bottom: 50px;
}
</style>
</head>
<body>
	<!-- 2022-11-8 Hosik - Hoping svg 클릭시 메인화면으로 링크 달았음 --> 
	<%-- nav --%>
	<div class="container">
	   <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
	     <a href="main.do" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
	       <svg class="mysvg" xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="currentColor" class="bi bi-house-heart" viewBox="0 0 16 16">
		  <path d="M8 6.982C9.664 5.309 13.825 8.236 8 12 2.175 8.236 6.336 5.309 8 6.982Z"/>
		  <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.707L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.646a.5.5 0 0 0 .708-.707L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5ZM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5 5 5Z"/>
		</svg>
	       <span class="mytitle"><b>Hoping</b></span>
	     </a>
	     
	     <ul class="nav nav-pills">
	     	<li class="nav-item" style="font-size: 14px;">
	     		<a href="#" class="link-dark nav-link">호스트 모드</a>
	     	</li>
	     	
	     	<li class="nav-item">
				<svg class="dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" xmlns="http://www.w3.org/2000/svg" width="28" height="28" fill="currentColor" class="bi bi-person-lines-fill" viewBox="0 0 16 16">
					<path d="M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5zm.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1h-4zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2z"/>
				</a>
				<ul class="dropdown-menu">
			     <li><a class="dropdown-item" href="#">내 정보 관리</a></li>
			    <li><a class="dropdown-item" href="#">예약 정보 관리</a></li>
			    <li><a class="dropdown-item" href="#">위시 리스트</a></li>
			    <li><a class="dropdown-item" href="#">로그아웃</a></li>
			  </ul>
			</li>
	     </ul>
	   </header>
 	</div>
<!-- 2022-11-8 Hosik Form tag 이동 및 검색 자체는 가능하게끔 수정, 검색에서 option 값이 잘 안들어가는거 같아서 수정예정임  -->
		<%--search --%>
	<div class="container myscontainer">
      <div class="d-flex align-items-center justify-content-center justify-content-lg-center">

        <form action="searchCamp.do"class="col-12 col-lg-auto mb-4 mb-lg-0 me-lg-4" role="search">
		검색 선택:
		<select name="query">
			<option value="regName">이름</option>
			<option value="regDetailaddress" selected="selected">주소</option>
		</select>&nbsp;&nbsp;&nbsp;
          <input class="mysearch" type="search" class="form-control" aria-label="Search" name="content">
			<label for="btnSubmit">
				<svg class="mysvg" xmlns="http://www.w3.org/2000/svg" width="25" height="25" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
					  <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
				</svg>
			</label>
		<input type="submit" id="btnSubmit" style="display:none;" />
        </form>

        </div>   <!-- <div class="text-conter"> End -->
        
      </div>    <!-- <div class="d-flex align-items-center justify-content-center justify-content-lg-center"> End -->

	
	
</body>
</html>