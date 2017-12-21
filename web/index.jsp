<%--
  Created by IntelliJ IDEA.
  User: wj
  Date: 2017/11/1
  Time: 下午4:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<script src="js/jquery-3.2.1.js" type="text/javascript"></script>
  <head>
    <title>$Title$</title>
  </head>

<script type="text/javascript">

//  $(document).ready(function() {
//
//      var aj = $.ajax( {
//          url:'/student/queryStudent1',// 跳转到 action
////          data:{
////              selRollBack : selRollBack,
////              selOperatorsCode : selOperatorsCode,
////              PROVINCECODE : PROVINCECODE,
////              pass2 : pass2
////          },
//          type:'post',
//          dataType:'json',
//          success:function(data) {
//              console.info(data);
//
//              for (var i=0;i<data.countt;i++){
//                  var student = data.list[i];
//                  var $name = $("<td/>").text(student.name);
//                  var $age = $("<td/>").text(student.age);
//                  var $tr = $("<tr/>").append($name)
//                      .append($age);
//                  $("#studentTable").append($tr);
//              }
//          },
//          error : function() {
//              alert("异常！");
//          }
//      });
//  });

$(document).ready(function () {

    var json = {"name":"laowei"};

    var pos = $.ajax({
        contentType: 'application/json;charset=utf-8',
        url:'/student/requestByName',
        type:'post',
        data:JSON.stringify(json),
        dataType:'json',
        success:function (data) {
            var list = data.list;
            console.info("*************" + list.length);
            for (var i=0;i<list.length;i++){
                var student = data.list[i];
                var $name = $("<td/>").text(student.name);
                var $age = $("<td/>").text(student.age);
                var $tr = $("<tr/>").append($name)
                    .append($age);
                $("#studentTable").append($tr);
            }

        },
        error:function () {
            alert("error");
        }
    });
});


</script>

  <body>
  <table id="studentTable">
    <tr>
      <td>姓名</td>
      <td>年龄</td>
    </tr>

  </table>

  </body>
</html>
