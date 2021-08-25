var Module = function () {
	var oneStage = function(item){
		var str = '';
		str += '<div class="stage" style="margin-bottom:150px;" id="stage' + item.FStageId + '">';
		str += '<p style="width:100%; text-align:center; font-size:56px; font-weight:bold; color:red !important" id="name">' + item.FStageName + '</p>';
		str += '<p style="width:100%; text-align:center; font-size:26px; color:red !important" id="name">' + item.FBeginDate + '至' + item.FEndDate + '</p>';		
		str += '</div>';
		return str;
	}
	var oneStageJoin = function(employeeMap, item, color) {
		var str = '';
		str += '								<li style="border-top:1px solid #999" id="join' + item.FStageJoinId + '">';
		str += '									<div class="meet-our-team">';
		str += '										<div class="team-info" style="min-height:80px;">';
		str += '											<div style="font-size:16px;">';
		str += '												<span style="font-size:42px; font-weight:bold; color:red !important">' + item.FTitle + '</span><span style="font-size:24px; color:red !important" style="display: inline-block;" id="name' + item.FStageJoinId + '"></span><span id="value' + item.FStageJoinId + '" FStageJoinId="' + item.FStageJoinId + '" style=" color:red !important;font:42px/80px Mircrosoft YaHei" class="value">0</span><span class="num pull-right" style="font-size:42px; font-weight:bold; color:red !important" id="num' + item.FStageJoinId + '"></span><br/><br/><div style="display: flex;justify-content: flex-start;flex-direction: column;width: 100%;height: 100%;flex-flow: wrap;">';
		var fenMap = item.fenMap;
		for(var index in fenMap){
			var FEmployeeId = index.substring(8);
			if(typeof(fenMap[FEmployeeId])== "function")
				continue;
			str += '												<p>' + employeeMap[item.FDb + FEmployeeId] + '&nbsp;<span class="badge badge-default employee" style="color:red !important" FFen="' + fenMap[index] + '">' + fenMap[index] + '分</span></p>';
			
		}
		str += '											</div></div>';
		str += '										</div>';
		str += '									</div>';
		str += '								</li>';
		return str;
	}
	var loadStage = function(){
		var nid = getParam(window.location.href, 'nid');
		var yid = getParam(window.location.href, 'yid');
		var queryString;
		if (nid !== undefined) queryString = 'nid=' + nid;
		else if (yid !== undefined) queryString = 'yid=' + yid;
		$.ajax({
			url:'getStageListOrderByIdDesc.do?closeParentStage=' + getParam(window.location.href, 'closeParentStage'),
			data:queryString,
			dataType:'json',
			type:'POST',
			success: function(data){
				if( data.message.result!=0 ){
					if (data.message.result == 2) {
						parent.window.location = "../login/login.html";
					} else {						
						fail(data.message.errorMsg);
					}
				} else {
					if (data.iTotalRecords == 0) {
						$("#noMessage").show();
						//$("#wait").hide();
					}else{
						$("#noMessage").hide();
						/*$("#wait").show();
						window.setTimeout(function() {
							$("#wait").hide();
							$("#content").show();
						}, 500);*/
						var stageHtml = '';
						$.each(data.aaData,function(index,item){
							stageHtml += oneStage(item);
						});
						var content = '';
						content += '<marquee style="WIDTH: 100%; HEIGHT:' + document.documentElement.clientHeight + 'px" behaviour="Alternate" scrollamount="2" scrolldelay="60" direction="up" >';
						content += stageHtml;
						content += '</marquee>';						
						$("#content").html(content);
						
						var random = 0;
						var last = 0;
						$.each(data.stageJoinList,function(index,item){
							if (last != item.FStageId) {
								random = 0;
								last = item.FStageId;							
							}
							var color = 'label-default';
							if (random % 5 == 1) {
								color = 'label-primary';
							} else if (random % 5 == 2) {
								color = 'label-success';
							} else if (random % 5 == 3) {
								color = 'label-warning';
							} else if (random % 5 == 4) {
								color = 'label-info';
							} else if (random % 5 == 0) {
								color = 'label-danger';
							}
							random = random + 1;							
							var str = oneStageJoin(data.employeeMap, item, color);
							$('#stage' + item.FStageId).append(str);

							var total = 0;
							var count = 0;
							$.each($('#join' + item.FStageJoinId).find(".employee"), function(index, item) {
								total += 1 * $(this).attr('FFen');		
								count++;
							});
							if (data.stageTypeMap['type' + item.FStageId] == 1) {
								$('#name' + item.FStageJoinId).html('总分');
								$('#value' + item.FStageJoinId).html(total);
							}  else {
								$('#name' + item.FStageJoinId).html('平均分');
								var FEmployeeIds = item.FEmployeeIds.split(',');
								$('#value' + item.FStageJoinId).html(round(total/count, 1));
							}
						});						
					};
					$.each($(".stage"), function(index, item) {
						var arr = new Array();
						$.each($(this).find(".value"), function(index, item) {
							var v = $(this).html();
							arr.push(v);
						});
						arr = arr.unique2();
						if (arr.length > 1) {
							$.each($(this).find(".value"), function(index, item) {
								var v = $(this).html();
								var num = 1;
								for(var i=0;i<arr.length;i++){
									if (v*1.0 < arr[i]*1.0) {
										num++;
									}					
								}
								var str = '第' + num + '名';
								if (num == 1) str = '冠军';
								if (num == 2) str = '亚军';
								if (num == 3) str = '季军';
								$('#num' + $(this).attr('FStageJoinId')).html('当前排名：' + str);							
							});
						}
					});					
				};
			},
			error: function(xhr, ajaxOptions, thrownError) {
				
			}
		});
	}
	Array.prototype.unique2 = function(){
	 this.sort(); //先排序
	 var res = [this[0]];
	 for(var i = 1; i < this.length; i++){
	  if(this[i] !== res[res.length - 1]){
	   res.push(this[i]);
	  }
	 }
	 return res;
	}
	//var arr = [1, 'a', 'a', 'b', 'd', 'e', 'e', 1, 0]
	//alert(arr.unique2());	
	function round(v,e){
		var t=1;
		for(;e>0;t*=10,e--);
		for(;e<0;t/=10,e++);
		return Math.round(v*t)/t;
	}	
	var time = 3600;	
	//var time = 3600 * 12;
	//if (window.location.host == 'xb.xiaov100.com') time = 60 * 60;
	var flash = function() {
		window.setTimeout(function() {
			loadStage();
			flash();
		}, 1000 * time);
	}
	flash();		

	return {
		init: function () {
			loadStage();
		}
	};
}();
