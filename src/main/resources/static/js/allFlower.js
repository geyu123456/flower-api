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
        var title=$("#title").val();
        var color=$("#color").val();
        var content=$("#content").val();
        var name=$("#name").val();
        var type=$("#type").val()[0];
        var price=$("#price").val();
        var picUrl="asdasass";

        var festival=$("#festival").val()[0];
        var discount=$("#discount").val();
        var data={"title":title,"color":color,"content":content,"name":name,"type":type,"festival":festival,
        "discount":discount,"price":price,"picUrl":picUrl};
        var url=contentPath+"/total/addFlower";
    $.ajax({
        type:"POST",
        url:url,
        processData: false,
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data:JSON.stringify(data),
        success:function(msg){
            alert(msg);
        }
    })



}