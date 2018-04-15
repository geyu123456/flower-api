/**
 * Created by gyu98 on 2018/2/5.
 */
var curWwwPath=window.document.location.href;
var pathName=window.document.location.pathname;
var pos=curWwwPath.indexOf(pathName);
var  contentPath=curWwwPath.substring(0,pos);
function  toAddFlower() {

        $("#addcomments").dialog();

}



function saveFlower() {
        var form = new FormData(document.getElementById("commentForm"));
        var url=contentPath+"/total/addFlower";
    $.ajax({
        type:"POST",
        url:url,
        data:form,
        processData:false,
        contentType:false,
        success:function(obj){

            alert(obj.message);
        }
    })
}
function  deleteFlower(id) {
    alert(id)

}