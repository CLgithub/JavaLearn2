/**
 * 练习：编写一个js文件，在js文件中自定义一个数组工具对象，该工具对象要有一个最大值的方法，与找到元素对应的索引值的方法。
 */

var arrayTool=new ArrayTool();
function ArrayTool(){
	this.getMax=function(arr){
		var max=0;
		for(var i=0;i<arr.length;i++){
			max=arr[i]>max?arr[i]:max;
		}
		return max;
	}
	
	this.getIndex=function(arr,a){
		var index=-1;
		for(var i=0;i<arr.length;i++){
			if(arr[i]==a){
				index=i;
				break;
			}
		}
		return index;
	}
}

/*
需求：把getMax方法与getIndex方法添加到数组对象中
利用prototype原型属性，把getMax与getIndex方法添加到Array函数中,创建的对象就有了两个方法
给Array的原型添加了方法，Array的对象就用了所添加的方法
*/
Array.prototype.getMax=function(){
	var max=0;
	for(var i=0;i<this.length;i++){
		max=this[i]>max?this[i]:max;
	}
	return max;
}
Array.prototype.getIndex=function(a){
	var index=-1;
	for(var i=0;i<this.length;i++){
		if(this[i]==a){
			index=i;
			break;
		}
	}
	return index;
}
