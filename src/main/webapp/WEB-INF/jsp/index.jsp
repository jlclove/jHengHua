<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script src="//cdn.bootcss.com/markdown.js/0.6.0-beta1/markdown.min.js"></script>
	<script type="text/javascript" src="/static/js/marked_editor.js"></script>
    <link href="http://kevinburke.bitbucket.org/markdowncss/markdown.css" rel="stylesheet"></link>
    <div id="body2">
    	
    </div>
    <script type="text/javascript" src="/static/js/zepto.min.js"></script>
    <script type="text/javascript">
    (function($) {
      $('#body2').load('/static/md/test.md',
        function(data) {
          var editor = new Editor();
          document.getElementById('body2').innerHTML = editor.constructor.markdown(data);
        }
      );
    })(Zepto);
    </script>
</body>
</html>