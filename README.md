# Ứng dụng minh họa kiến trúc phân tầng (layered architecture)
Đây là một trang web giả tưởng liên quan đến quản lý khách hàng và danh sách đơn hàng trong một điểm bán hàng nào đó, hỗ trợ tác vụ CRUD. Chương trình gồm 2 phần: backend dùng framework Spring Boot và cơ sở dữ liệu MongoDB; frontend dùng framework Next.js trong đó đã tích hợp sẵn React.js.

Kiến trúc phân tầng được thể hiện qua 4 thư mục đại diện cho 4 tầng: Presentation (màn hình và delegate/controller), Business (DTO và service), Persistence (DAO/repository) và Database (bao gồm các Model).

## Cách sử dụng
Sau khi tải về và giải nén tập tin hoặc clone repository
* Để chạy backend, trong package `laborder` khởi chạy tập tin `LaborderApplication.java`.
* Đối với frontend, mở terminal và nhập `npm install` để tải các package xuống, sau đó khởi chạy bằng lệnh `npm run dev`.
