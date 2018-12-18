var theLink;

$(document).ready(function(){

    var xhr = new XMLHttpRequest();
    var firstUrl = "adminController?recType=User";
        xhr.open("get", firstUrl);

                xhr.onreadystatechange = function () {

                    if (xhr.readyState == 4 && xhr.status == 200) {

                        var result = xhr.responseText;
                        var holder = $("#adminData");
                        holder.append(result);
                        var table = $("#allRecords")



                    }
                }
        xhr.send(null);
    });

function totalUsers(){
    theLink = "";
    theLink = document.getElementById("addThis");
    
    theLink.setAttribute("href", "/Madeline/addUpdateDirector?itemType=User&actionType=add");

    //aPara.innerHTML = "";
    //aPara.innerHTML = "<span>Add New<span><a href=\"/Madeline/addUpdateDirector?itemType=User&actionType=add'><img src='images/add.jpg"/></a>";
    var xhr = new XMLHttpRequest();
    var firstUrl = "adminController?recType=User";
    xhr.open("get", firstUrl);

    xhr.onreadystatechange = function () {

        if (xhr.readyState == 4 && xhr.status == 200) {

            var result = xhr.responseText;
            var holder = $("#adminData");
            $("#allRecords").remove();
            holder.append(result);


        }
    }
    xhr.send(null);
};


function totalLocations() {
    theLink = "";
    theLink = document.getElementById("addThis");

    theLink.setAttribute("href", "/Madeline/addUpdateDirector?itemType=Location&actionType=add");

    var xhr = new XMLHttpRequest();
    var firstUrl = "adminController?recType=Location";
    xhr.open("get", firstUrl);

    xhr.onreadystatechange = function () {

        if (xhr.readyState == 4 && xhr.status == 200) {

            var result = xhr.responseText;
            var holder = $("#adminData");
            $("#allRecords").remove();
            holder.append(result);


        }
    }
    xhr.send(null);

};

function totalTrips() {
    theLink = "";
    theLink = document.getElementById("addThis");

    theLink.setAttribute("href", "/Madeline/addUpdateDirector?itemType=Trip&actionType=add");
    //para.innerHTML = "";
    //para.innerHTML = '<span>Add New<span><a href="/Madeline/addUpdateDirector?itemType=Trip&actionType=add"><img src="images/add.jpg"/></a>';

    var xhr = new XMLHttpRequest();
    var firstUrl = "adminController?recType=Trip";
    xhr.open("get", firstUrl);

    xhr.onreadystatechange = function () {

        if (xhr.readyState == 4 && xhr.status == 200) {

            var result = xhr.responseText;
            var holder = $("#adminData");
            $("#allRecords").remove();
            holder.append(result);


        }
    }
    xhr.send(null);

};