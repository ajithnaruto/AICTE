function formValidation() 
{
var inst_name=document.College.inst_name;
var state=document.College.state;
var Zip_Code = document.College.Zip_Code;
var password=document.College.password;
var inst_id=document.College.inst_id;
if(allLetter(inst_name))  
{
if(state_validate(state))
{
if(allnumeric(Zip_Code))
{
if(password_validate(password))
{
if(id_validate(inst_id))
{
}
}
}
}
}
return false;
}
function allLetter(inst_name)  
{   
var letters = /^[A-Za-z]+$/;  
if(inst_name.value.match(letters))  
{  
return true;  
}  
else  
{  
alert('institution name cannot be empty and only letters');  
inst_name.focus();  
return false;  
}  
} 
function state_validate(state)  
{  
var stateformat = /^[A-Za-z]+$/;  
if(state.value.match(stateformat))  
{  
return true;  
}  
else  
{  
alert("please enter the state");  
state.focus();  
return false;  
}  
}
function allnumeric(Zip_Code)  
{   
var numbers = /^[0-9]+$/;  
if(Zip_Code.value.match(numbers))  
{  
return true;  
}  
else  
{  
alert('zip code must have numeric characters only');  
Zip_Code.focus();  
return false;  
}  
}
function password_validate(password)  
{  
var passlen = password.value.length;  
if(passlen>=6)  
{
return true;  
}  
else  
{  
alert('password not entered and must have atleast 6 characters');  
password.focus();  
return false;  
} 
}   
function id_validate(inst_id)  
{   
var instlen = inst_id.value.length;
var numbers = /^[0-9]+$/;  
if(inst_id.value.match(numbers) && (instlen == 4))  
{
return true;  
}  
else  
{  
alert('Institution id must have 4 numbers only');  
inst_id.focus();  
return false;  
}  
} 
