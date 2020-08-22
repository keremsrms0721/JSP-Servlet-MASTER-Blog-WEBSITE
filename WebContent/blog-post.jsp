<%@include file="header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="main-wrapper">
	<article class="blog-post px-3 py-5 p-md-5">
		<div class="container">
			<header class="blog-post-header">
				<h2 class="title mb-2">
					<c:out value="${blog.title}" />
				</h2>
				<!-- 				    IF YOU WANT TO ADD DATE  , YOU CAN DELETE COMMENT BELOW  -->
				<!-- 				    <div class="meta mb-3"><span class="date">Published 3 months ago</span><span class="time">5 min read</span><span class="comment"><a href="#">4 comments</a></span></div> -->
			</header>
			<div class="blog-post-body">
				<p>${blog.content}</p>
			</div>
			<nav class="blog-nav nav nav-justified my-5">
				<a href="homepage?page=1">Back</a>
			</nav>
		</div>
		
		
		<!--//container-->
	</article>
	<%@include file="footer.jsp"%>


	<!-- Page Specific JS -->
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/9.14.2/highlight.min.js"></script>

	<!-- Custom JS -->
	<script src="assets/js/blog.js"></script>



	</body>
	</html>