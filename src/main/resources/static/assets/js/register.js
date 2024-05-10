
function redirectToPage(url) {
  event.preventDefault();
  history.pushState(null, null, url); // Thay đổi URL của trang một cách tương đối

  // Cập nhật nội dung trang tương ứng với URL mới
  fetch(url)
    .then((response) => response.text())
    .then((html) => {
      document.body.innerHTML = html; // Cập nhật nội dung trang
    })
    .catch((error) => {
      console.error("Lỗi khi tải trang: ", error);
    });
}
