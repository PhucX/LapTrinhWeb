#Bài tập tuần 01

## Giới thiệu
Ứng dụng web triển khai 2 cơ chế đăng nhập đơn giản: qua Cookie và qua Session.


## Cấu trúc chính
- `src/main/java/vn/iotstar/controllers/` chứa các `Servlet`
- `src/main/webapp/` chứa các trang HTML tĩnh và tài nguyên web
- `pom.xml` cấu hình Maven (biên dịch Java 17, đóng gói WAR)

## Cài đặt và build
```bash
mvn clean package
```
Kết quả: file WAR ở `target/HelloWorld-0.0.1.war`.

## Triển khai và chạy
- Triển khai WAR lên Tomcat 10.1+ (copy vào `TOMCAT_HOME/webapps/` hoặc dùng Tomcat Manager).
- Sau khi deploy, giả sử context path là `/HelloWorld`, truy cập trang chủ:
  - `http://localhost:8080/HelloWorld/`

Nếu chạy trong Spring Tool Suite/Eclipse với Tomcat tích hợp:
- Add project vào server Tomcat 10.1+ và Start server. Truy cập context path được gán bởi IDE.

## Các tính năng và tuyến (routes)

### 1) Form cơ bản (HelloWorld)
- Trang: `GET /index.html` chứa form gửi `ten`, `holot`
- Xử lý:
  - `GET /HelloWorld` (servlet `HelloWorld`)
  - In ra giá trị `First Name` và `Last Name`

### 2) Đăng nhập bằng Cookie
- Trang form: `GET /Login.html`
  - Gửi `POST /login` với `username`, `password`
- Xử lý: `LoginServlet` (`/login`)
  - Nếu đúng thông tin: đặt cookie `username` (sống 30 giây), redirect `GET /hello`
  - Nếu sai: redirect lại `/Login.html`
- Trang chào: `HelloServlet` (`/hello`, `/xin-chao`)
  - Kiểm tra cookie `username`; nếu không có → redirect `/Login.html`
  - Nếu có → hiển thị “Xin chao {username}” và link đăng xuất
- Đăng xuất Cookie: `GET /logout-cookie`
  - Xoá cookie `username`, quay về `/Login.html`

### 3) Đăng nhập bằng Session
- Trang form: `GET /SessionLogin.html`
  - Gửi `POST /session-login` với `username`, `password`
- Xử lý: `SessionLoginServlet` (`/session-login`)
  - Nếu đúng thông tin: tạo `HttpSession`, set attribute `username`, `session.setMaxInactiveInterval(60)` (60 giây), redirect `GET /hello-session`
  - Nếu sai: redirect lại `/SessionLogin.html`
- Trang chào session: `HelloSessionServlet` (`/hello-session`)
  - Lấy session hiện tại; nếu không có hoặc thiếu `username` → redirect `/SessionLogin.html`
  - Nếu hợp lệ → hiển thị “Xin chao (Session) {username}” và link đăng xuất
- Đăng xuất Session: `GET /logout-session`
  - `session.invalidate()` và quay về `/SessionLogin.html`

## Tài khoản mẫu
- Username: `trung`
- Password: `123`

