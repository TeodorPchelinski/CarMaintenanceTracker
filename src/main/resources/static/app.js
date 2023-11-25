
let loadBooksButton:HTMLElement = document.getElementById('loadBooks')

loadBooksButton.addEventListener('click', loadBooks)

function loadBooks() {
    alert('Hello')
    fetch('http://localhost:8080/api/books')
        .then(response => response.json())
        .then(json => json.forEach(book => {
            console.log(book)
        }))
}