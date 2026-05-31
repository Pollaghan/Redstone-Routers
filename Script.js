document.addEventListener("DOMContentLoaded", () => {
    const preloader = document.getElementById("preloader");
    var LoadTime = Math.random()*3000;
    // Set timer for 1000ms (1 second)
    setTimeout(() => {
        preloader.classList.add("preloader-hidden");
    },  LoadTime)
    const ThemeToggle = document.getElementById("theme-toggle");
    const SwitchText = document.getElementById("SwitchText");
    ThemeToggle.addEventListener("change", () => {
        if (ThemeToggle.checked) {
            SwitchText.textContent = "New Theme (More crowded)";
        }else {
            SwitchText.textContent = "Old Theme (Less crowded)";
        }
    })
});