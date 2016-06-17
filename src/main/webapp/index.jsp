<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script src="resources/js/react.js"></script>
	<script src="resources/js/react-dom.js"></script>
	<script src="resources/js/browser.min.js"></script>
</head>
<body>
	<div id="example" style="background-color: red"></div>
	<div id="form"></div>
	<div id="likeButton"></div>
	
</body>

<script type="text/babel">
	var FromComponent = React.createClass({
		handleClick:function(){
			this.refs.myTextInput.focus();
		},
		render:function(){
			return (
				<div>
					 <input type="text" ref="myTextInput" placeholder={this.props.placeholder} />
        			<input type="button" value="Focus the text input" onClick={this.handleClick} />
				</div>
			)
		}
	});
	var HelloMessage = React.createClass({
		propTypes:{
			id:React.PropTypes.number.isRequired,
		},
		render:function() {
			return (
				<div>	
					<h1>hello {this.props.name}</h1>
					<h3>your idNumb is '{this.props.id}'</h3>
				</div>
			)
		}
	});

	var LikeButton = React.createClass({
		getInitialState:function(){
			return {liked:false};
		},
		handleClick:function(event){
			this.setState({liked:!this.state.liked})	
		},
		render:function(){
			var text = this.state.liked?'like':'haven\'t liked';
			var buttonText=this.state.liked?'not like':'like';
			return (
				<div>
					<p >You {text} this,Click to toggle</p>
					<input type="button" value={buttonText} onClick={this.handleClick}/>
				</div>
			);
		}
	});
	
	var id = 234;
	//hello
	ReactDOM.render(
		<HelloMessage name="DaiZhengmiao" id={id} />,
		document.getElementById('example')
	);
	//button
	ReactDOM.render(
		<FromComponent placeholder="please input your name" />,
		document.getElementById('form')
	);
	//button
	ReactDOM.render(
		<LikeButton />,
		document.getElementById('likeButton')
	);
</script>
</html>