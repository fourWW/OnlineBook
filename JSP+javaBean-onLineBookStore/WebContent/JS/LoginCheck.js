/**
 * 
 */
function isValid(form) {
    		if (form.name.value=="")   {   
    			alert("用户名不能为空");   
    			return false;   
    		}  
    		else if(form.password.value==""){  
    			alert("用户密码不能为空！");  
    			return false;  
    		} 
    		else{
    			return true;  
    		}
    			
}  