"use strict"

getCurrentUser();

function getCurrentUser() {
    fetch("/api/current")
        .then(response => response.json())
        .then(currentUser => {
            $("#emailCurrentUser").append(`<span><b>${currentUser.username}</b></span>`)
            $("#rolesCurrentUser").append(`<span>${getStringRolesNames(currentUser)}</span>`)
            let rowCurrentUser = document.createElement("tr");
            rowCurrentUser.innerHTML = `
                            <td>${currentUser.id}</td>
                            <td>${currentUser.firstName}</td>
                            <td>${currentUser.secondName}</td>
                            <td>${currentUser.age}</td>
                            <td>${currentUser.username}</td>
                            <td>${getStringRolesNames(currentUser)}</td>
                             `;
            $(".table-content-currentUser").append(rowCurrentUser);
        })
}
