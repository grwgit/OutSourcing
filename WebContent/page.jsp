<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>  
  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<%  
    int PageCount = 15;  
%>  
<html>  
    <body>  
        <table>  
            <tr>  
                <td>  
                    <a href=showpage.jsp?ToPage=<%=1%>>����1ҳ</a>  
                </td>  
                <td>  
                    <a href=showpage.jsp?ToPage=<%=PageCount%>>�����һҳ</a>  
                </td>  
            </tr>  
        </table>        
    </body>  
</html>  