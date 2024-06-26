<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript">

	var ws;
	function connectWs() {
		ws = new WebSocket('ws://' + location.host + '/chat');
		console.log(ws);
		ws.onmessage = function(data) {
			console.log(data.data);
			$("<p>"+data.data+"</p>").prependTo('#chat');
		}

		$('#startBtn').hide();
	}



	function send() {
		console.log(ws);
		ws.send($("#chatting").val());
		$('#chatting').val("");
	}
</script>

<body>

	<h1>채팅 방 입니다</h1>
	<button onclick="connectWs()" id="startBtn"> 채팅 시작하기</button>
	<input id="chatting"></input><button onclick="send()"> 보내기 </button>
	<div>
		<p id="chat"></p>
	</div>
</body>
</html>


<!-- 출처 : https://eunii.github.io/2019/06/22/tec/spring/socket1/ -->