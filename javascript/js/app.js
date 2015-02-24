


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
$(document).ready(function () {
	$("#draw").click(function () {
		createObject("mycanvas");
	});
});

$(document).ready(function () {
	$("#parse").click(function () {
		parse("equ");
	});
});