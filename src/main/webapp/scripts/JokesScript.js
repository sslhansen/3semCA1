function getTableHeader() {
    return "<thead><tr><th scope=\"col\">Name</th><th scope=\"col\">Student ID</th><th scope=\"col\">Favorit TV-series</th></tr></thead><tbody>";
}

function getTableRow(joke) {
    return `<tr><td scope="row">${joke.id}</td><td>${joke.jokeLine}</td><td>${joke.type}</td></tr>`;
}

function fetchAllJokes() {
    let url = "https://svendbentsballonshow.dk/ca1/api/joke/all";
    fetch(url)
            .then(res => res.json()) //in flow1, just do it
            .then(data => {
                let jokeTable = document.getElementById("jokeAllTable");
                let result = "";
                data.forEach((x) => {
                    result += getTableRow(x)
                });
                jokeTable.innerHTML = `<table class="table">${getTableHeader()}${result}</tbody></table>`;
            });
}


function fetchJokeById() {
    id = document.getElementById("idJokeText").value;
    let url = `https://svendbentsballonshow.dk/ca1/api/joke/id/${id}`;
    fetch(url)
            .then(res => res.json()) //in flow1, just do it
            .then(data => {
                let jokeIdTable = document.getElementById("jokeIdTable");
                let result = "";
                result = getTableRow(data);
                jokeIdTable.innerHTML = `<table class="table">${getTableHeader()}${result}</tbody></table>`;
            });
}


function fetchRandomJoke() {
    let url = "https://svendbentsballonshow.dk/ca1/api/joke/random";
    fetch(url)
            .then(res => res.json()) //in flow1, just do it
            .then(data => {
                let jokeRandomTable = document.getElementById("jokeRandomTable");
                let result = "";
                result = getTableRow(data);
                jokeRandomTable.innerHTML = `<table class="table">${getTableHeader()}${result}</tbody></table>`;
            });

}

fetchAllJokes();

document.getElementById("idJokesBtn").addEventListener("click", fetchJokeById);

document.getElementById("randomJokeBtn").addEventListener("click", fetchRandomJoke);