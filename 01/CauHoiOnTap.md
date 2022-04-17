1. groupID: là tên miền đảo ngược, dùng để phân biệt tổ chức, công ty sở hữu
    artifactId: là tên package chính và cũng là tên thư mục dự án
2. đảo ngược tên miền trong groupID để tránh trùng tên file như khi các file có cùng tên nhưng thuộc folder khác nhau.
3. 2 công cụ quản lý thư viện là maven và gradle
4.  file pom.xml là nơi khai báo tất cả những gì liên quan đến dự án được cấu hính qua maven
5. thể <dependency> dùng để khai báo các thư viện
6. @Controller dùng để đánh dấu class là 1 controller
7. @RequestMapping dùng để map request của web tới các phương thức của Spring       Controller. 
    ngoài value, nó còn có tham số:
    - method 
    - params
    - headers
    - consumes
    - procedures
    - custom
8. @RequestBody dùng để báo cho Spring giải mã request body thành 1 object và object sẽ được chuyền thành 1 tham số của method 
9. @PathVariable: là thành phần dẫn đường còn @RequestParam là tham số trong query string 
10. có thể hoán đổi thứ tự các thành phần đường dẫn @PathVariable 
11. @GetMapping: là xử lý lệnh HTTP GET dung để lấy dữ liệu
    @PostMapping: là xử lý lệnh HTTP POST dung để thêm dữ liệu
12. tham số produces = MediaType.XXXX  dúng để thể hiện loại định dạng được chấp nhận bởi controller
13. @RequestBody Message message: nhận vào 1 dãy JSON và giải mã nó sang kiểu dữ liệu Message và chuyền thánh tham số của method
14. có thể thay đổi băng cách thêm server.port=8081 vào file application.properties
hoặc dùng command line java -jar spring-5.jar --server.port=8083
