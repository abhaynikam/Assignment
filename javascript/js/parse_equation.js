	
	function linearEquation(a,b,c,i) {
		return ((-c-(b*i))/a);			
	}	
	
	function addFormAttributes(att_name,att_type,att_label,att_value) {		
		newField = document.createElement("input");
		newField.setAttribute("name", att_name);
		newField.setAttribute("type", att_type);
		newField.setAttribute("value", att_value);
		var itemLabel = document.createElement("label");
		itemLabel.setAttribute("for",newField);
		itemLabel.innerHTML = att_label;    			
		theForm = document.getElementById("2");
		theForm.appendChild(newField);
		theForm.insertBefore(itemLabel,newField);
		
	}
	
	function removeFormElement() {
		theForm.removeChild(newField);
		theForm.removeChild(itemLabel);
	}	
	
	function identifyConstants(a,b,c) {
		if (!parseInt(a)){
				addFormAttributes("const_a","number",a,"");	
		}else{ 
			
			addFormAttributes("const_a","number","a",parseInt(a));
		}	
		if (!parseInt(b)) 
			addFormAttributes("const_b","number",b);
		else 
			addFormAttributes("const_b","number","b",parseInt(b));
			
		if (!parseInt(c)) 
			addFormAttributes("const_c","number",c);
		else 
			addFormAttributes("const_c","number","c",parseInt(c));
			
		addFormAttributes("range","number","range",102);
		var abd = parseInt(document.form2.range.value);console.log(abd);
		addFormAttributes("step","number","step",5);
	}

	function createObject() {
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
	drawLine : function () {
		var canvas = document.getElementById("mycanvas");
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



