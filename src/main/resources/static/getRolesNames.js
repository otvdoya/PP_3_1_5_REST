function getStringRolesNames(user) {
    let rolesString = [];
    user.roles.forEach(role => {
        rolesString.push(role.name.substring(role.name.indexOf("_") + 1))
    })
    return rolesString.join(" ")
}

function getListRolesNames(user) {
    let rolesString = [];
    user.roles.forEach(role => {
        rolesString.push(role.name.substring(role.name.indexOf("_") + 1))
    })
    return rolesString;
}

function getRolesFromPage(form) {
    let roles = [];
    for (let i = 0; i < form.roles.options.length; i++) {
        if (form.roles.options[i].selected) {
            roles.push({
                id: form.roles.options[i].value,
                role: "ROLE_" + form.roles.options[i].text
            });
        }
    }
    return roles;
}

function selectOptionRoles(form, user) {
    let roles = getListRolesNames(user);

    for (let i = 0; i < form.roles.options.length; i++) {
        if (roles.includes(form.roles.options[i].text)) {
            form.roles.options[i].selected = true;
        }
    }

}