/**
 * 字符串数组自定义工具类
 */

/**
 * 将字符串转换成字符数组
 */
String.prototype.toCharArray=function(){
	var arr=new Array();
	for(var i=0;i<this.length;i++){
//		arr[i]=this.substring(i, i+1);
		arr[i]=this.charAt(i);
//		arr[i]=this[i];
	}
	return arr;
}

/**
 * 将字符串翻转
 */
String.prototype.reverse=function(){
	var arr=this.toCharArray();
//	for(var i=0;i<parseInt((arr.length)/2);i++){
//		var tmp=arr[i];
//		arr[i]=arr[arr.length-1-i];
//		arr[arr.length-1-i]=tmp;
//	}
	return arr.reverse().join("");
}

