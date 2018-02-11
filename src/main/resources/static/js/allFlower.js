/**
 * Created by gyu98 on 2018/2/5.
 */
function  toAddFlower() {

        $("#addcomments").dialog();

}



function saveFlower() {
        var title=$("#title").val();
        var color=$("#color").val();
        var content=$("#content").val();
        var name=$("#name").val();
        var type=$("#type").val();
        var festival=$("#festival").val();
        var discount=$("#discount").val();
        var data={"title":title,"color":color,"content":content,"name":name,"type":type,"festival":festival,
        "discount":discount}
    $.ajax({
        type:"POST",
        url:"/panorama/saveScene",
        processData: false,
        contentType: "application/json;charset=utf-8",
        dataType: "json",
        data:JSON.stringify(data),
        success:function(msg){
            alert(msg);
        }
    })



}