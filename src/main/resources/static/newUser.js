const form = document.forms.newUser;

addUser()

function addUser() {
    form.addEventListener("submit", event => {
        event.preventDefault();
        let roles = getRolesFromPage(form);
        fetch("/api/add", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify( {
                firstName: form.firstName.value,
                secondName: form.lastName.value,
                age: form.age.value,
                username: form.email.value,
                password: form.password.value,
                roles: roles
            })
        })
            .then(() => {
            form.reset();
            $("#nav-home-tab").click();
            getTable();
        })
    })
}