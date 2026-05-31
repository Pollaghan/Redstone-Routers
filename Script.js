document.addEventListener("DOMContentLoaded", () => {
    const preloader = document.getElementById("preloader");
    var LoadTime = Math.random()*3000;
    // Set timer for 1000ms (1 second)
    setTimeout(() => {
        preloader.classList.add("preloader-hidden");
    },  LoadTime)
});