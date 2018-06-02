//获取所需要的标签
var selProvince11 = document.querySelector('#selProvince1');
var selCity11 = document.querySelector('#selCity1');

//初始化html标签
function initPSelCtrl1(){
	selProvince1.innerHTML = '<option>北京市</option>';
	arrProvince.forEach(function(item){
		selProvince1.innerHTML += `<option value="${item.ProID}">${item.name}</option>`;
	})
}

//初始化地级标签
function initCSelCtrl1(){
	var selPval = selProvince1.value;//获取省份级的数据选择
	var temResult =arrCity.filter(function(item){
		if(item.ProID==selPval){
			return item;
		}
	})
	selCity1.innerHTML = `<option>北京市</option>`;
	temResult.forEach(function(item){
		selCity1.innerHTML += `<option value="${item.name}">${item.name}</option>`;
	})
}

initPSelCtrl1();
initCSelCtrl1();

//省级选择改变
selProvince11.onchange = function(){
	initCSelCtrl1();
}