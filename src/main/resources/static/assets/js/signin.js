function changeEyeNorToBlind() {
  var eye = document.getElementById("login__input");
  event.preventDefault();
  var btnEyeNor = document.getElementById("btn__eye__nor");
  var btnEyeBlind = document.getElementById("btn__eye__blind");
  eye.type = "text";
  btnEyeNor.style.display = "none";
  btnEyeBlind.style.setProperty("display", "block", "important");
}
function changeEyeBlindToNor() {
  event.preventDefault();
  var eye = document.getElementById("login__input");
  var btnEyeNor = document.getElementById("btn__eye__nor");
  var btnEyeBlind = document.getElementById("btn__eye__blind");
  eye.type = "password";
  btnEyeNor.style.display = "block";
  btnEyeBlind.style.setProperty("display", "none", "important");
}

function redirectToPage(url) {
    event.preventDefault();
    history.pushState(null, null, url); // Thay đổi URL của trang một cách tương đối

    // Cập nhật nội dung trang tương ứng với URL mới
    fetch(url)
        .then(response => response.text())
        .then(html => {
            document.body.innerHTML = html; 
        })
        .catch(error => {
            console.error('Lỗi khi tải trang: ', error);
        });
}