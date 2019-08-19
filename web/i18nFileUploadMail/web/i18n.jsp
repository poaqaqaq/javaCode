<%--
  Created by IntelliJ IDEA.
  User: devil
  Date: 2019/7/3
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>formatNumber</h3>
如果type属性为percent或number，那么您就可以使用其它几个格式化数字属性。maxIntegerDigits属性和minIntegerDigits属性允许您指定整数的长度。
若实际数字超过了maxIntegerDigits所指定的最大值，则数字将会被截断。<br/>
有一些属性允许您指定小数点后的位数。minFractionalDigits属性和maxFractionalDigits属性允许您指定小数点后的位数。
若实际的数字超出了所指定的范围，则这个数字会被截断。会四舍五入<br/>
groupingUsed为是否分组，即可以用来在每三个数字中插入一个逗号，默认为true分组<br/>

<hr/>
<c:set var="balance" value="120000.2309"/>
<p>格式化数字 (1): <fmt:formatNumber value="${balance}"
                                type="currency"/></p>
<p>格式化数字 (2): <fmt:formatNumber type="number"
                                maxIntegerDigits="3" value="${balance}" /></p>
<p>格式化数字 (3): <fmt:formatNumber type="number"
                                maxFractionDigits="3" value="${balance}" /></p>
<p>格式化数字 (4): <fmt:formatNumber type="number"
                                groupingUsed="false"  value="${balance}" /></p>
<p>格式化数字 (5): <fmt:formatNumber type="percent"
                                maxIntegerDigits="3" value="${balance}" /></p>
<p>格式化数字 (6): <fmt:formatNumber type="percent"
                                minFractionDigits="10" value="${balance}" /></p>
<p>格式化数字 (7): <fmt:formatNumber type="percent"
                                maxIntegerDigits="3" value="${balance}" /></p>
<p>格式化数字 (8): <fmt:formatNumber type="number"
                                pattern="###.###E0" value="${balance}" /></p>
<p>美元 :
    <fmt:setLocale value="en_US"/>
    <fmt:formatNumber value="${balance}" type="currency"/></p>
<hr/>

<%--
d 月中的某一天。一位数的日期没有前导零。
dd 月中的某一天。一位数的日期有一个前导零。
ddd 周中某天的缩写名称，在 AbbreviatedDayNames 中定义。
dddd 周中某天的完整名称，在 DayNames 中定义。
M 月份数字。一位数的月份没有前导零。
MM 月份数字。一位数的月份有一个前导零。
MMM 月份的缩写名称，在 AbbreviatedMonthNames 中定义。
MMMM 月份的完整名称，在 MonthNames 中定义。
y 不包含纪元的年份。如果不包含纪元的年份小于 10，则显示不具有前导零的年份。
yy 不包含纪元的年份。如果不包含纪元的年份小于 10，则显示具有前导零的年份。
yyyy 包括纪元的四位数的年份。
gg 时期或纪元。如果要设置格式的日期不具有关联的时期或纪元字符串，则忽略该模式。
h 12 小时制的小时。一位数的小时数没有前导零。
hh 12 小时制的小时。一位数的小时数有前导零。
H 24 小时制的小时。一位数的小时数没有前导零。
HH 24 小时制的小时。一位数的小时数有前导零。
m 分钟。一位数的分钟数没有前导零。
mm 分钟。一位数的分钟数有一个前导零。
s 秒。一位数的秒数没有前导零。
ss 秒。一位数的秒数有一个前导零。
--%>

<h3>日期格式化:</h3>
<c:set var="now" value="<%=new java.util.Date()%>" />

<p>日期格式化 (1): <fmt:formatDate type="time"
                              value="${now}" pattern="HH:mm:ss" /></p>
<p>日期格式化 (2): <fmt:formatDate type="date"
                              value="${now}" pattern="yyyy-MM-dd" /></p>
<p>日期格式化 (3): <fmt:formatDate type="both"
                              value="${now}" pattern="EEEE, MM dd, yyyy HH:mm:ss Z"/></p>
<p>日期格式化 (4): <fmt:formatDate type="both"
                              dateStyle="short" timeStyle="short"
                              value="${now}" /></p>
<p>日期格式化 (5): <fmt:formatDate type="both"
                              dateStyle="medium" timeStyle="medium"
                              value="${now}" /></p>
<p>日期格式化 (6): <fmt:formatDate type="both"
                              dateStyle="long" timeStyle="long"
                              value="${now}" /></p>
<p>日期格式化 (7): <fmt:formatDate pattern="yyyy-MM-dd"
                              value="${now}" /></p>
<br/>var是将值保存到此变量中，此后可以直接用<br/>
<fmt:formatDate value="${now}" pattern="yyyy-MM-dd HH:mm" var="change"/>
${change}

</body>
</html>
