$(function(){
	loadData();
//	loadTableFirst();
	loadTableSecond();
	function loadData(){
		$.ajax({
			url:"/count/workCount",
			type:"post",
			dataType:"JSON",
			success:function(json){
				var data = json.data;
				$("#allNum").html(data.NOEXAMRISK+data.HASEXAMRISK);
				$("#noExamRisk").html(data.NOEXAMRISK);
				$("#hasExamRisk").html(data.HASEXAMRISK); 
				$("#prec").html(countPrec(data.HASEXAMRISK,data.NOEXAMRISK+data.HASEXAMRISK));
			}
		})
	};
	function loadTableFirst(){
		$("#userTablefirst").html("");
		var formValue = $("#qryFormFirst").serializeObject();
		$.ajax({
			url:"/count/peopleWorkCount",
			type:"post",
			data:formValue,
			dataType:"json",
			success:function(json){
				
				if(json.status=="success"){
					var data=json.data;
					for(var i=0;i<data.length;i++){
						var tr="";
						tr+="<tr role='row' class='odd'>";
						tr+="<td class='center'>"+(i+1)+"</td>";
						tr+="<td class='center'>"+data[i].examPeople+"</td>";
						tr+="<td class='center'>"+data[i].beforeRiskExamNum+"/"+data[i].beforeRiskNum+"</td>";
						tr+="<td class='center'>"+data[i].afterRiskExamNum+"/"+data[i].afterRiskNum+"</td>"
						tr+="<tr>";
						$("#userTablefirst").append(tr);
					}
				}
			}
	})
	};
	function loadTableSecond(){
		var formValue=$("#qryFormSecond").serializeObject();
		$.ajax({
			url:"/count/resultCount",
			type:"post",
			data:formValue,
			dataType:"json",
			success:function(json){
				if(json.status=="success"){
					var data=json.data;
					var beforeRisk=data.BEFORENORISK+data.BEFOREHASRISK+data.BEFORENEEDEXAMRISK;
					var afterRisk=data.AFTERNORISK+data.AFTERHASRISK+data.AFTERNEEDEXAMRISK;
					$("#beforeNoRisk").html(data.BEFORENORISK+"次");
					$("#beforeHasRisk").html(data.BEFOREHASRISK+"次");
					$("#beforeNeedExamRisk").html(data.BEFORENEEDEXAMRISK+"次");
					$("#afterNoRisk").html(data.AFTERNORISK+"次");
					$("#afterHasRisk").html(data.AFTERHASRISK+"次");
					$("#afterNeedExamRisk").html(data.AFTERNEEDEXAMRISK+"次");
					$("#beforeNoRiskPrec").html(countPrec(data.BEFORENORISK,beforeRisk));
					$("#beforeHasRiskPrec").html(countPrec(data.BEFOREHASRISK,beforeRisk));
					$("#beforeNeedExamRiskPrec").html(countPrec(data.BEFORENEEDEXAMRISK,beforeRisk));
					$("#afterNoRiskPrec").html(countPrec(data.AFTERNORISK,afterRisk));
					$("#afterHasRiskPrec").html(countPrec(data.AFTERHASRISK,afterRisk));
					$("#afterNeedExamRiskPrec").html(countPrec(data.AFTERNEEDEXAMRISK,afterRisk));
				}
			},
			error:function(){
				alert("...");
			}
		});
	}
	$("#search").click(function(){
		loadTableFirst();
	});
	$("#searchSecond").click(function(){
		loadTableSecond();
	})
	/**
	 * 计算百分比
	 */
	function countPrec(data1,data2){
		if(data2==0){
			return "0%";
		}
		return Math.round( data1 / (data2) * 10000) / 100.00 + "%"
	}
})