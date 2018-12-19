$(function(){
    $("#accordion").accordion();
});

function selectEducation(){
    console.log("made it here");
    var theTrigger;
    if(window.event) {
        theTrigger = window.event.srcElement;
    } else {
        theTrigger = this;
    }
    console.log(theTrigger.value);
    if (!document.getElementsByClassName("panel panel-danger")){

    } else {
        console.log("made it into else");
        var selectedClass = document.getElementsByClassName("panel panel-danger");

        for(i=0; i<selectedClass.length; i++){
            selectedClass[i].className = "panel panel-primary"
        }
    }


    var newSelectedClass = document.getElementById(theTrigger.value);

    newSelectedClass.className = "panel panel-danger";
    if (!!newSelectedClass && newSelectedClass.scrollIntoView) {
        newSelectedClass.scrollIntoView();
    }

}