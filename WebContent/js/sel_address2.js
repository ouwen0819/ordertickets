//获取所需要的标签
var selProvince = document.querySelector('#selProvince');
var selCity = document.querySelector('#selCity');

//初始化html标签
function initPSelCtrl(){
	selProvince.innerHTML = '<option>天津市</option>';
	arrProvince.forEach(function(item){
		selProvince.innerHTML += `<option value="${item.ProID}">${item.name}</option>`;
	})
}
//初始化地级标签
function initCSelCtrl(){
	var selPval = selProvince.value;//获取省份级的数据选择
	var temResult =arrCity.filter(function(item){
		if(item.ProID==selPval){
			return item;
		}
	})
	selCity.innerHTML = `<option>天津市</option>`;
	temResult.forEach(function(item){
		selCity.innerHTML += `<option value="${item.name}">${item.name}</option>`;
	})
}

initPSelCtrl();
initCSelCtrl();

//省级选择改变
selProvince.onchange = function(){
	initCSelCtrl();
}