function formValidation() {
var sname=document.student.sname;
var instid = document.student.instid;

var uidai = document.student.uidai;
var gender=document.student.gender;
var level= document.student.level;
var reg_no=document.student.reg_no;
var dob = document.student.dob;
var mail = document.student.mail;
var contact_no = document.student.contact_no;
var year_passed_out=document.student.year_passed_out;
var enrolled=document.student.enrolled;
if(allLetter(sname))  
{
if(allnumerical(instid))
{

if(allnumeric(uidai))
{
	if(gender_select(gender))
	{
if(level_select(level))
{
if(allnumerical1(reg_no))
{
if(dob_validation(dob,7,12))
{
if(validate_email(mail))
{
if(allnumerics(contact_no))
{
if(pass_validation(year_passed_out,5))
{
if(enroll_select(enrolled))
{
}
}
}
}
}
}
}
}
}
}
}
return false;
}
function allLetter(sname)  
{   
var letters = /^[A-Za-z]+$/;  
if(sname.value.match(letters))  
{  
return true;  
}  
else  
{  
alert('student name must have alphabet characters only');  
sname.focus();  
return false;  
}  
} 
function allnumerical(instid)  
{   
var numbers = /^[0-9]+$/;  
if(instid.value.match(numbers))  
{  
return true;  
}  
else  
{  
alert('institution id must have numeric characters only');  
instid.focus();  
return false;  
}  
} 
function allnumeric(uidai)  
{   
var numbers = /^[0-9]+$/;  
if(uidai.value.match(numbers))  
{  
return true;  
}  
else  
{  
alert('UIDAI must have numeric characters only');  
uidai.focus();  
return false;  
}  
} 
function gender_select(gender)  
{  
if(gender.value == "default")  
{  
alert('Select your gender');  
gender.focus();  
return false;  
}  
else  
{  
return true;  
}  
}

function level_select(level)  
{  
if(level.value == "default")  
{  
alert('Select your level');  
level.focus();  
return false;  
}  
else  
{  
return true;  
}  
}
function allnumerical1(reg_no)  
{   
var numbers = /^[0-9]+$/;  
if(reg_no.value.match(numbers))  
{  
return true;  
}  
else  
{  
alert('reg no must have numeric characters only');  
reg_no.focus();  
return false;  
}  
}

function dob_validation(dob,mx,my)  
{  
var dob_len = dob.value.length;  
if (dob_len == 0 || dob_len >= my || dob_len < mx)  
{  
alert("date of birth should not be empty");  
dob.focus();  
return false;  
}  
return true;  
}


function validate_email(mail)  
{  
var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
if(mail.value.match(mailformat))  
{  
return true;  
}  
else  
{  
alert("You have entered an invalid email address!");  
mail.focus();  
return false;  
}  
}
function allnumerics(contact_no)  
{   
var conlen = contact_no.value.length;
var numbers = /^[0-9]+$/;  
if(contact_no.value.match(numbers) && (conlen == 8 || conlen == 10))  
{
return true;  
}  
else  
{  
alert('phone number must have 10 numbers only');  
contact_no.focus();  
return false;  
}  
} 
function pass_validation(year_passed_out,mx)  
{  
var yearpassedout_len = year_passed_out.value.length;  
if (yearpassedout_len == 0 || yearpassedout_len >= my)  
{  
alert("enter the year of passing out");  
year_passed_out.focus();  
return false;  
}  
return true;  
} 
function enroll_select(enrolled)  
{  
if(enrolled.value == "default")  
{  
alert('Select any one');  
enrolled.focus();  
return false;  
}  
else  
{  
return true;  
}  
}
