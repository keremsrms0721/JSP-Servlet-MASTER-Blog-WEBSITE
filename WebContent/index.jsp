<%@include file="header.jsp"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<div class="main-wrapper">
	<section class="cta-section theme-bg-light py-5">
		<div class="container text-center">
			<h2 class="heading">JSP + SERVLET BLOG - A Blog JSP+SERVLET FOR JAVA DEVELOPERS</h2>
			<div class="intro">Welcome to JSP+SERVLET blog.I hope you liked it.</div>
		</div>
		<!--//container-->
	</section>
	<section class="blog-list px-3 py-5 p-md-5">
		<div class="container">

		<c:forEach items="${blogList}" var="blog">
			<div class="item mb-5">
				<div class="media">
					<img class="mr-3 img-fluid post-thumb d-none d-md-flex"
						src="assets/images/blog/blog-post-thumb-5.jpg" alt="image">
					<div class="media-body">
						<h3 class="title mb-1">
							<a href="homepage?id=${blog.id}"><c:out value="${blog.title}"/></a>
						</h3>
						
<!-- 						if you want to add date , you can below. i would not remove it. -->
						<div class="meta mb-1">
							<span class="date">Published 2 months ago</span><span
								class="time">10 min read</span><span class="comment"><a
								href="#">23 comments</a></span>
						</div>

						<div class="intro">${fn:substring(blog.content,0,200)}..</div>
						<a class="more-link" href="homepage?id=${blog.id}">Read more </a>
					</div>
					<!--//media-body-->
				</div>
				<!--//media-->
			</div>
		</c:forEach>
		
			<nav class="blog-nav nav nav-justified my-5">
					<c:forEach begin="1" end="${totalPages}" step="1" var="i">
					<a
					href="homepage?page=${i}"
					>${i}</a>
					</c:forEach>
			</nav>

		</div>
	</section>

	<%@include file="footer.jsp"%>


	</body>
	</html>