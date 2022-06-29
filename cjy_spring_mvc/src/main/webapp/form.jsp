<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/6/29
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--对应测试方法的kuick14--%>
    <form action="${pageContext.request.contextPath}/user/quick14" method="post">
        <%--表明是第一个User对象的username age--%>
<%--        封两个user对象，而每个user对象中都包含name和age，所以要区分第几个对象的name和age--%>
            <%--userList找vo属性，vo属性是userList集合，userList[0]表示集合的第一个元素--%>
            <input value="输入名字" type="text" name="userList[0].username"
                   onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                   onBlur="if(!value){value=defaultValue;this.style.color='#999'}" ><br/>
            <input value="输入年龄" type="text" name="userList[0].age"
                   onFocus="if(value==defaultValue){value='';this.style.color='#000'}"
                   onBlur="if(!value){value=defaultValue;this.style.color='#999'}" ><br/>
            <input type="text" name="userList[1].username"><br/>
            <input type="text" name="userList[1].age"><br/>
            <input type="submit" value="提交">
    </form>
</body>
</html>
