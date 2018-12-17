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
    $("#addThis").remove();
    var newUser = $('<a id="addThis" href="/Madeline/addUpdateDirector?itemType=User&actionType=add"></a>');
    var addI = $('<img src="images/add.jpg">');
    newUser.append(addI);
    $("#addButton").append(newUser);

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
    $("#addPic").remove();
    $("#addThis").remove();
    console.log("made it into locs");
    //var newLoc = $('<a id="addThis" href="/Madeline/addUpdateDirector?itemType=Location&actionType=add"></a>');
    //var addI = $('<img id="addPic" src="images/add,jpg"/>');
    //newLoc.append(addI);
    //$("#addButton").append(newLoc);

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
    var para = document.getElementById("addButton");
    para.innerHTML = '<span>Add New<span><a href="/Madeline/addUpdateDirector?itemType=Trip&actionType=add"><img src="images/add.jpg"/></a>';
    //var newTrip = $('<a id="addThis" href="/Madeline/addUpdateDirector?itemType=Trip&actionType=add"></a>');
    //var addI = $('<img src="images/add.jpg"/>');
    //newTrip.append(addI);
    //$("#addButton").append(newTrip);
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