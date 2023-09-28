allaboard_url = "http://localhost:8080";

async function apiGet(endpoint) {
    return await fetch(allaboard_url+ endpoint, {
    method: "GET",
    headers: {
        'Content-type': 'application/json; charset=UTF-8'
    }
});
}

async function apiPost(endpoint, body) {
    return await fetch(allaboard_url+ endpoint, {
    method: "POST",
    body: body,
    headers: {
        'Content-type': 'application/json; charset=UTF-8'
    }
});
}