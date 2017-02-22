<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">
	<form method="POST">
		<font color="red">${errorMessage}</font>
		<form method="post">
			Name : <input type="text" name="name" /> Password : <input
				type="password" name="password" /> <input type="submit" />
		</form>
</div>
<%@include file="common/footer.jspf"%>