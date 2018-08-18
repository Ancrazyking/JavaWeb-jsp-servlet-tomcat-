function checkForm(){
	var username=document.getElementById("username");
	var password=document.getElementById("password");
	var rePassword=document.getElementById("rePassword");
	var email=document.getElementById("email");
	
	//用户名不能为空
	if(username.value==""){
		alert("用户名不能为空");
		//获取焦点
		username.focus();
		return false;		
	}
	
	//登录密码至少6位
	if(password.value.length<6){
		alert("登录密码至少6位");
		password.focus();
		return false;
	}
	
	//重复密码应该和登录密码相同
	if(rePassword.value!=password.value){
		alert("重复密码应该和登录密码相同");
		rePassword.focus();
		return false;
	}
	
	//保密邮箱不能为空，且须包含“@”和“.”字符
	var ev=email.value;
	if(ev==null || !((ev.indexOf("@")!=-1)&&(ev.indexOf(".")!=-1))){
		alert("保密邮箱不能为空，且须包含“@”和“.”字符");
		email.focus();
		return false;
	}
	
	return true;
}
