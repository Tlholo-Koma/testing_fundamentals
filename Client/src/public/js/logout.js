function logout() {
    let authInfo = JSON.parse(localStorage.getItem('authInfo'));
    fetch("https://oauth2.googleapis.com/revoke?token=" + authInfo['access_token'], {
        method: 'POST',
        headers: {
            "Content-type": 'application/x-www-form-urlencoded'
        }
    })
        .then((data) => {
            location.href = "/login";
        })
}

document.getElementById('logout-button').addEventListener('click', function(event) {
    event.preventDefault();
    logout();
});