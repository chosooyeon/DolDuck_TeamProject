function closepopup(){
	window.opener.opener.location.reload();
	window.opener.close();
	window.close();
}