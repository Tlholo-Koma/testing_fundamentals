const CLIENT_ID = '1027636847861-3210ictgim9rbksvdnrprl324kh64hpi.apps.googleusercontent.com';
const REDIRECT_URI = 'http://localhost:4040/home'; 

function loginWithGoogle() {
    const url = `https://accounts.google.com/o/oauth2/auth?client_id=${CLIENT_ID}&redirect_uri=${REDIRECT_URI}&response_type=token&scope=email%20profile https://www.googleapis.com/auth/userinfo.profile&state=pass-through-value`;
    window.location.href = url;

}

document.getElementById('loginWithGoogle').addEventListener('click', function(event) {
    event.preventDefault();
    loginWithGoogle();
});