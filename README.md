# Java-Practice3

Viết chương trình sau :
- Triển khai lớp đối tường sau

1. Danh mục sản phầm -> gồm các thuộc tính sau : mã danh mục, tên danh mục

- tạo hàm tạo và các bộ getter/setter cho chương trình

- Viết hàm nhập dữ liệu và hiển thị dữ liệu cho danh mục

2. Sản phẩm -> gồm các thuộc tính : mã sản phẩm, mã danh mục, tên sp, giá, ngày nhập, ngày bán, hạn sử dụng, mô tả sản phẩm.

- tạo hàm tạo và các bộ getter/setter cho chương trình

- Viết hàm nhập dữ liệu và hiển thị dữ liệu cho danh mục

Viết menu chương trình sau

1. Nhập thông tin danh mục

2. Nhập thông tin sản phẩm 

3. In ra danh sách các sản phẩm đã bán

4. In ra danh sách sản phầm còn tồn kho

5. In ra danh sách sản phẩm đã quá hạn sử dụng (lấy giờ hiện tại của hệ thống để kiểm tra với HSD của sản phẩm)

6. In ra danh sách sản phẩm sắp hết hạn sử dụng (lấy giờ hiện tại của hệ thống và kiểm tra vs HSD, nếu giờ hiện tại <= HSD và giờ hiện tại >= HSD - 7 ngày thì in  kết quả ra)

7. Tìm kiếm >>> nhập tên sản phẩm -> in ra tất cả các sản phẩm có tên nhập vào và số sản phẩm.

Ví dụ : 

-Tìm kiếm : A

Kết quả :

Sản phẩm: A, price : 100$, ngày nhập : xx-xx-xxxx, ngày bán : xx-xx-xxxx, HSD : xx-xx-xxxx

Sản phẩm: A, price : 100$, ngày nhập : xx-xx-xxxx, ngày bán : xx-xx-xxxx, HSD : xx-xx-xxxx

Sản phẩm: A, price : 100$, ngày nhập : xx-xx-xxxx, ngày bán : xx-xx-xxxx, HSD : xx-xx-xxxx

Số lượng : 3

8. Lưu vào file (danh mục sẽ được lưu vào file category.dat, sản phẩm đã bán vào sell.dat, hết hạn sử dụng vào file : expire.dat, sản phẩm còn lại vào product.dat)

9. Đọc dữ liệu từ file và lưu ra chương trình.
