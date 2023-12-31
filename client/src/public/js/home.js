async function getUserInfo() {
    let params = {};
    let regex = /([^&=]+)=([^&]*)/g, m;
    while (m = regex.exec(location.href)){
        params[decodeURIComponent(m[1])] = decodeURIComponent(m[2]);
    }

    if (Object.keys(params).length > 0){
        localStorage.setItem('authInfo', JSON.stringify(params));
    }

    window.history.pushState({}, document.title, "/home", "home");
    let authInfo = JSON.parse(localStorage.getItem('authInfo'));
    let userEmail, userName;

    await fetch("https://www.googleapis.com/oauth2/v3/userinfo", {
        headers: {
            "Authorization": `Bearer ${authInfo['access_token']}`
        }
    })
        .then(data => data.json())
        .then((info) => {
            userEmail = info['email'];
            userName = info['name'];
            
        }).then(() => {
            
            
        })
        let data = JSON.stringify({
            "email": userEmail,
            "name": userName,
        });
        createUSer = await (apiPost('/user', data));
}

document.getElementById('calculator').addEventListener('click', function(event) {
    event.preventDefault();
    location.href = "/calculator";
});

document.getElementById('trivia').addEventListener('click', function(event) {
    event.preventDefault();
    location.href = "/trivia";
});

document.getElementById('quiz_history').addEventListener('click',function(event) {
    event.preventDefault();
    location.href = "/quiz_history";
})

getUserInfo();