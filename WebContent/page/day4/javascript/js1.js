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
