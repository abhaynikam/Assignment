function parse(equation) {
		var str = document.getElementById(equation).value;
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
function createObject(id) {
		alert("inside create");
		q = Object.create(line);
		q.con_a = parseInt(document.form2.const_a.value);
		q.con_b = parseInt(document.form2.const_b.value);
		q.con_c = parseInt(document.form2.const_c.value);
		q.con_r = parseInt(document.form2.range.value);
		q.con_s = parseInt(document.form2.step.value);
		
		q.drawLine(id);
}

var line = {
	con_a : 0,
	con_b : 0,
	con_c : 0,
	con_r : 0,
	con_s : 0,
	drawLine : function (canvasNm) {
		var canvas = document.getElementById(canvasNm);
		if (canvas.getContext) {
			console.log("getcanvas");
			var ctx = canvas.getContext("2d");
		}
		var i;
		console.log(this.con_a);
		ctx.beginPath();
		ctx.translate(canvas.width / 2, canvas.height / 2);
		for (i=0; i<this.con_r; i+=this.con_s) {
			ctx.lineTo(linearEquation(this.con_a,this.con_b,this.con_c,i),i);
			ctx.stroke();
			ctx.moveTo(linearEquation(this.con_a,this.con_b,this.con_c,i),i);
		}
		if (i>this.con_r) {
			i=this.con_r;
			ctx.lineTo(linearEquation(this.con_a,this.con_b,this.con_c,i),i);
			ctx.stroke();
			ctx.moveTo(linearEquation(this.con_a,this.con_b,this.con_c,i),i);
		}
	}
				
}	



