document.getElementById("showBookingPanel").addEventListener("click", function () {
    var bookingPanel = document.querySelector(".booking-panel");
    bookingPanel.style.top = "0";
    bookingPanel.style.visibility = "visible";
    overlay.style.display = "block";
});

document.getElementById("cancelBooking").addEventListener("click", function () {
    var bookingPanel = document.querySelector(".booking-panel");
    bookingPanel.style.top = "-100%";
    bookingPanel.style.visibility = "hidden";
    overlay.style.display = "none";
});