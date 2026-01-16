<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="${pageContext.request.contextPath}/globals.css" rel="stylesheet">
    <title>New Request - Kitaran</title>
</head>
<body>
    <!-- Hamburger Menu Button -->
    <button class="hamburger-btn" id="hamburgerBtn" aria-label="Toggle Menu">
        <span></span>
        <span></span>
        <span></span>
    </button>
    
    <!-- Sidebar Overlay -->
    <div class="sidebar-overlay" id="sidebarOverlay"></div>
    
    <div class="app-container">
        <aside class="sidebar" id="sidebar">
            <div class="logo">Ki<span>TARAN</span></div>
            <nav class="nav-links">
                <ul>
                    <li><a href="dashboard">Dashboard</a></li>
                    <li><a href="request.jsp" class="active">New Request</a></li>
                    <li class="spacer"></li>
                    <li>
                        <form action="logout" method="post">
                            <button type="submit" class="logout">Logout</button>
                        </form>
                    </li>
                </ul>
            </nav>
        </aside>

        <main class="main-content" style="display: flex; align-items: center; justify-content: center;">
            <div class="box" style="max-width: 600px; width: 100%;">
                <h2>Create New <span>Request</span></h2>
                <p style="color: var(--neutral-600); margin-bottom: 10px; font-size: 14px;">
                    Welcome, ${sessionScope.username != null ? sessionScope.username : 'User'}
                </p>
                <p style="color: var(--neutral-600); margin-bottom: 25px; font-size: 14px;">
                    Fill in details. The driver will weigh the items.
                </p>

                <%
                    String message = (String) request.getAttribute("message");
                    String messageType = (String) request.getAttribute("messageType");
                    if (message != null) {
                %>
                    <div class="alert alert-<%= messageType != null ? messageType : "info" %>">
                        <%= message %>
                    </div>
                <%
                    }
                %>

                <form action="submitRequest.jsp" method="POST" onsubmit="return validateForm()" style="display: flex; flex-direction: column; gap: 20px;">
                    <div style="display: flex; flex-direction: column;">
                        <label for="type" style="font-weight: 500; color: var(--neutral-700); font-size: 14px; margin-bottom: 8px;">Category</label>
                        <select name="type" id="type" required>
                            <option value="">Select Category</option>
                            <option value="Plastic" <%= "Plastic".equals(request.getParameter("type")) ? "selected" : "" %>>Plastic</option>
                            <option value="Paper" <%= "Paper".equals(request.getParameter("type")) ? "selected" : "" %>>Paper</option>
                            <option value="Metal" <%= "Metal".equals(request.getParameter("type")) ? "selected" : "" %>>Metal</option>
                            <option value="Glass" <%= "Glass".equals(request.getParameter("type")) ? "selected" : "" %>>Glass</option>
                        </select>
                    </div>

                    <div style="display: flex; flex-direction: column;">
                        <label for="item" style="font-weight: 500; color: var(--neutral-700); font-size: 14px; margin-bottom: 8px;">Item Description</label>
                        <input type="text" name="item" id="item" 
                                value="<%= request.getParameter("item") != null ? request.getParameter("item") : "" %>" 
                                placeholder="e.g. Cardboard boxes" required>
                    </div>

                    <div style="display: flex; flex-direction: column;">
                        <label for="address" style="font-weight: 500; color: var(--neutral-700); font-size: 14px; margin-bottom: 8px;">Pickup Address</label>
                        <input type="text" name="address" id="address" 
                                value="<%= request.getParameter("address") != null ? request.getParameter("address") : "" %>" 
                                placeholder="Block A, Apt 2..." required>
                    </div>

                    <input type="hidden" name="userId" value="${sessionScope.userId}">

                    <button type="submit" class="btn" style="margin-top: 10px;">Submit Request</button>
                </form>
            </div>
        </main>
    </div>

    <script>
        // Hamburger menu toggle
        const hamburgerBtn = document.getElementById('hamburgerBtn');
        const sidebar = document.getElementById('sidebar');
        const sidebarOverlay = document.getElementById('sidebarOverlay');

        function toggleSidebar() {
            hamburgerBtn.classList.toggle('active');
            sidebar.classList.toggle('active');
            sidebarOverlay.classList.toggle('active');
        }

        hamburgerBtn.addEventListener('click', toggleSidebar);
        sidebarOverlay.addEventListener('click', toggleSidebar);

        // Close sidebar when clicking a link
        const sidebarLinks = sidebar.querySelectorAll('a');
        sidebarLinks.forEach(link => {
            link.addEventListener('click', () => {
                if (window.innerWidth <= 768) {
                    toggleSidebar();
                }
            });
        });

        // Form validation
        function validateForm() {
            var type = document.getElementById('type').value;
            var item = document.getElementById('item').value;
            var address = document.getElementById('address').value;

            if (type === "" || item === "" || address === "") {
                alert("Please fill in all fields");
                return false;
            }
            return true;
        }
    </script>
</body>
</html>