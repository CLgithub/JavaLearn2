function getXMLHttpRequest(){
	var xmlhttpRequest=null;
	if (window.XMLHttpRequest){// 新的浏览器，包括ie7及以上
		xmlhttpRequest=new XMLHttpRequest();
	} else if (window.ActiveXObject){// code for IE5 and IE6
		xmlhttpRequest=new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlhttpRequest;
}