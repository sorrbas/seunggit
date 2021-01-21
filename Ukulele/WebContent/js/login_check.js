






$(function() {
	$('.login_form1').focusout(function() {
		var idcheck = $('#register_id').val().trim();
		var reg1 = /^[a-z][a-z0-9]{3,9}/;
		if (!reg1.test(idcheck)) {
			alert("ID는 소문자와 숫자조합으로 4~10글자 사이로 가능합니다"); 
			return false;
		}


		var pwcheck = $('#register_pw').val().trim();
		var pwcheck2 = $('#register_check_pw').val().trim();
		if(pwcheck.length!=0 && pwcheck2.length!=0){
			if(pwcheck != pwcheck2){
				alert("비밀번호를 확인해주세요");
				return false;
			}
		}

		if(idcheck == pwcheck) {
			alert("아이디와 비밀번호는 같을 수 없습니다");
			return false;
		}

	});
	
	$('.update_form').focusout(function() {
		var idcheck = $('#update_id').val().trim();
		var pwcheck = $('#update_pw').val().trim();
		var pwcheck2 = $('#update_pwch').val().trim();
		if(pwcheck.length!=0 && pwcheck2.length!=0){
			if(pwcheck != pwcheck2){
				alert("비밀번호가 다릅니다. 비밀번호를 확인해주세요");
				return false;
			}
		}

		if(idcheck == pwcheck) {
			alert("아이디와 비밀번호는 같을 수 없습니다");
			return false;
		}

	});
});