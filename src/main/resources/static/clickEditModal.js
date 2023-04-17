let modalEdit = new bootstrap.Modal(document.querySelector("#editModal"));
let formEdit = document.forms.edit;
function clickEditModal(id) {
    fetch("/api/" + id)
        .then(response => response.json())
        .then(response => {
            modalEdit.show();
            formEdit.id.value = response.id;
            formEdit.firstName.value = response.firstName;
            formEdit.secondName.value = response.secondName;
            formEdit.age.value = response.age;
            formEdit.email.value = response.username;
            formEdit.password.value = response.password;
            selectOptionRoles(formEdit, response);
        })


    formEdit.addEventListener("submit", ev => {
        ev.preventDefault();
        editUser();
    })
}

function editUser() {
    let roles = getRolesFromPage(formEdit)
    fetch("/api/edit", {
        method: "PATCH",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: formEdit.id.value,
            firstName: formEdit.firstName.value,
            secondName: formEdit.secondName.value,
            age: formEdit.age.value,
            username: formEdit.email.value,
            password: formEdit.password.value,
            roles: roles
        })
    })
        .then(() => {
            closeEditModal();
            getTable();
        })
}
