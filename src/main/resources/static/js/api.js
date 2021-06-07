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
      })
      .catch((err) => {
        console.error(err);
      })
}