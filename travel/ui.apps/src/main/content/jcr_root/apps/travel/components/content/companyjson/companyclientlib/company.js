function addNewManufacturer() {
	var CompanyName = $("#name").val();
	var CompanyTagline = $("#tag").val();
	var Employees = $("#emp").val();

	$("getJsonData").click(function() {
		alert("Data called")
		$.ajax({
			type : "GET",
			url : "/bin/getjson",
			contentType : "application/json",
			dataType : "json",
			success : function(msg) {
				if (msg) {
					alert("CompanyName" + CompanyName);
				} else {
					alert("Cannot add to list !");
				}
			},
		});
	})
}