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
		q.p = parseInt(document.form2.const_a.value);
		q.q = parseInt(document.form2.const_b.value);
		q.r = parseInt(document.form2.const_c.value);
		q.s = parseInt(document.form2.range.value);
		q.t = parseInt(document.form2.step.value);
		
		q.drawLine(id);
	}

var line = {
	p : 0,
	q : 0,
	r : 0,
	s : 0,
	t : 0,
	drawLine : function (canvasNm) {
		var canvas = document.getElementById(canvasNm);
		if (canvas.getContext) {
			console.log("getcanvas");
			var ctx = canvas.getContext("2d");
		}
		var i;
		console.log(this.p);
		ctx.beginPath();
		ctx.translate(canvas.width / 2, canvas.height / 2);
		for (i=0; i<this.s; i+=this.t) {
			ctx.lineTo(linearEquation(this.p,this.q,this.r,i),i);
			ctx.stroke();
			ctx.moveTo(linearEquation(this.p,this.q,this.r,i),i);
		}
		if (i>this.s) {
			i=this.s;
			ctx.lineTo(linearEquation(this.p,this.q,this.r,i),i);
			ctx.stroke();
			ctx.moveTo(linearEquation(this.p,this.q,this.r,i),i);
		}
	}
				
}	



