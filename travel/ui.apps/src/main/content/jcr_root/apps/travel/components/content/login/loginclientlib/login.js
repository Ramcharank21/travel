alert('login.js is called');

// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

$(document).ready(function() {
    $('#button').click(function() {
    	var name = $('#name').val();
    	var pass = $('#pass').val();
        servletCall(name,pass);
    });
});
function servletCall(uname,upass) {
    $.post(
        "/bin/enter", 
        {name : uname,pass : upass},
        function(result) {
			alert("result...."+result);
    });
};