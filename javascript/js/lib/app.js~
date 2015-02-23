function parse() {
		var str = document.getElementById("equ").value;
		var reg_con_1 = /[a-z0-9]*x[+|-][a-z0-9]*y[+|-][a-z0-9]*=0/ig;
		var reg_con_2 = /[a-z0-9]*x[+|-][a-z0-9]*y=[a-z0-9]*/ig;
		var reg_con_3 = /[a-z0-9]*y[+|-][a-z0-9]*x[+|-][a-z0-9]*=0/ig;
		var reg_con_4 = /[a-z0-9]*y[+|-][a-z0-9]*x=[a-z0-9]*/ig;
		var split_cons = /[x|y|=]/g;	
		var i;
		var consta;
		
		var regexMatch = {
			mat:function (reg) {
				var found = str.match(reg);	
				console.log(found);
				for(i=0;i<found.length;i++){
					console.log(found[i].split(split_cons));
					consta = found[i].split(split_cons);
				}console.log(consta);
			}		
		}
		
		
		if (reg_con_2.test(str)) {
			regexMatch.mat(reg_con_2);
			var a = consta[0];
			var b = consta[1];
			var c = consta[3];
			
			identifyConstants(a,b,c);
				
		 			
		}else if (reg_con_1.test(str)){
			regexMatch.mat(reg_con_1);
			var a = consta[0];
			var b = consta[1];
			var c = consta[2];
			 
			identifyConstants(a,b,c);	
		}else if (reg_con_3.test(str)) {
			regexMatch.mat(reg_con_3);
			var b = consta[0];
			var a = consta[1];
			var c = consta[2];
			identifyConstants(a,b,c);
		}else if (reg_con_4.test(str)) {
			regexMatch.mat(reg_con_4);
			var a = consta[0];
			var b = consta[1];
			var c = consta[3];
			
			identifyConstants(a,b,c);	
		}		
	}
	
$(document).ready(function () {
	$("#draw").click(function () {
		createObject();
	});
});

$(document).ready(function () {
	$("#parse").click(function () {
		parse();
	});
});