<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="_view/stylesheets/stylesheet.css" media="screen" />
	</head>
	<body>
		<section class="page-header">
			<h1 class="">Event Factory</h1>
			<h2>APK Generated!</h2>
		</section>
		<section class="main-content">
		<p>${ errorMsg } </p>
			<p>APK File generated successfully!</p>
			<a href="${ apkFilePath }" download>Download</a>
		</section>
	</body>
</html>