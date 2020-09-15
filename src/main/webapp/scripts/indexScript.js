
function getTableHeader() {
    return "<thead><tr><th scope=\"col\">Name</th><th scope=\"col\">Student ID</th><th scope=\"col\">Favorit TV-series</th></tr></thead><tbody>";
}

function getTableRow(grpMember) {
    return `<tr><td scope="row">${grpMember.name}</td><td>${grpMember.studentID}</td><td>${grpMember.favoriteTVSeries}</td></tr>`;
}


function fetchAllMembers() {
    let url = "https://svendbentsballonshow.dk/ca1/api/groupmembers/all";
    fetch(url)
            .then(res => res.json()) //in flow1, just do it
            .then(data => {
                let memberTable = document.getElementById("memberTable");
                let result = "";
                data.forEach((x) => {
                    result += getTableRow(x)
                });
                memberTable.innerHTML = `<table class="table">${getTableHeader()}${result}</tbody></table>`;
            });
}

fetchAllMembers();
document.getElementById("reloadBtn").addEventListener("click", fetchAllMembers);


