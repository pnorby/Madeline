$(document).ready(function(){
    console.log("made it into js")
    var xhr = new XMLHttpRequest();
    var firstUrl = "adminController?recType=User";
        xhr.open("get", firstUrl);

                xhr.onreadystatechange = function () {

                    if (xhr.readyState == 4 && xhr.status == 200) {

                        var result = xhr.responseText;
                        var holder = $("#adminData");
                        holder.append(result);
                        $("#allRecords").DataTable();

                    }
                }
        xhr.send(null);
    }
);