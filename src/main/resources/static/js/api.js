"use strict";

function login() {

  let form = document.forms["login-form"];
  let fd = new FormData(form);
  let data = {};
  for (let [key, prop] of fd) {
    data[key] = prop;
  }
  const VALUE = JSON.stringify(data, null, 2);
  console.log(VALUE);

  const myHeaders = new Headers();
  myHeaders.append('Content-Type', 'application/json');

  fetch('/authenticate/login', {
    method: 'POST',
    headers: myHeaders,
    mode: 'cors',
    cache: 'default',
    body: VALUE
  })
      .then(data => data.json())
      .then(data => {
        console.log(data)
        window.jwtToken = data.accessToken;
        window.userData = data.userData;
        if (data.userData.roles.includes("ADMIN")) {
          window.location.replace("/html/admin.html");
        } else if (data.userData.roles.includes("FACULTY")) {
          window.location.replace("/html/faculty.html");
        } else {
          window.location.replace("/html/student.html");
        }
      })
      .catch((err) => {
        console.error(err);
        window.jwtToken = null;
        window.userData = null;
        alert(err);
      })
}