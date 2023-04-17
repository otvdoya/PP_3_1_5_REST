let modalDelete = new bootstrap.Modal(document.querySelector("#deleteModal"));
let formDelete = document.forms.delete;

function clickDeleteModal(id) {
    fetch("/api/" + id)
        .then(response => response.json())
        .then(response => {
            modalDelete.show();
            formDelete.id.value = response.id
            formDelete.firstName.value = response.firstName
            formDelete.secondName.value = response.secondName
            formDelete.age.value = response.age
            formDelete.email.value = response.username
            formDelete.password.value = response.password
            formDelete.roles.value = response.roles
        })

    formDelete.addEventListener("submit", ev => {
        ev.preventDefault();
        deleteUser();
    })
}

function deleteUser() {
    let roles = getRolesFromPage(formEdit);
    fetch("/api/delete", {
        method: "DELETE",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: formDelete.id.value,
            firstName: formDelete.firstName.value,
            secondName: formDelete.secondName.value,
            age: formDelete.age.value,
            username: formDelete.email.value,
            password: formDelete.password.value,
            roles: roles
        })
    })
        .then(() => {
            closeDeleteModal();
            getTable();
        })
}