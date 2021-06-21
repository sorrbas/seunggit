var signIn = document.getElementById('sign_in');
var signUp = document.getElementById('sign_up');
var loginModal = document.getElementById('login_modal');
var signUpModal = document.getElementById('signUp_modal');
var closeBtn = document.getElementById('close_btn');
var closeBtnn = document.getElementById('close_btnn');
var searchidBtn = document.getElementById('search_id');
var searchidModal = document.getElementById('searchid_modal');
var closeBtnId = document.getElementById('close_btn_id');


signIn.onclick = function () {
loginModal.style.display = 'inherit';
};

closeBtn.onclick = function () {
loginModal.style.display = 'none';
};

signUp.onclick = function () {
signUpModal.style.display = 'inherit';
};

closeBtnn.onclick = function () {
signUpModal.style.display = 'none';
};

searchidBtn.onclick = function() {
searchidModal.style.display = 'inherit';
};

closeBtnId.onclick = function () {
searchidModal.style.display = 'none';
};
