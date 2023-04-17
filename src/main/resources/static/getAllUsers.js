"use strict";

const tableBody = $(".table-content")

getTable();

function getTable() {
    tableBody.empty()
    fetch('/api')
        .then(response => response.json())
        .then(allUsers => {
            for (let key in allUsers) {
                let row = document.createElement("tr");
                row.innerHTML = `
                        <td>${allUsers[key].id}</td>
                        <td>${allUsers[key].firstName}</td>
                        <td>${allUsers[key].secondName}</td>
                        <td>${allUsers[key].age}</td>
                        <td>${allUsers[key].username}</td>
                        <td>${getStringRolesNames(allUsers[key])}</td>
                        <td>
                            <button type="button" class="btn btn-info text-white" data-bs-toggle="modal" data-bs-target="#editModal" onclick="clickEditModal(${allUsers[key].id})">
                                Edit
                            </button>
                        </td>
                        <td>
                            <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#deleteModal" onclick="clickDeleteModal(${allUsers[key].id})">
                                Delete
                            </button>
                        </td>
                        `;
                tableBody.append(row);
            }
        });
}

