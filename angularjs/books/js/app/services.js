angular.module('app')
    .factory('Book', function() {
        function Book(title, author, isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }
        return Book;
    })
    .service('bookService', function(Book) {
        this.books = [
            new Book('Krzyżacy', "Henryk Sienkiewicz", '1234'),
            new Book('Dziady', 'Adam Mickiewicz', '4532'),
            new Book('Dym', 'Maria Konopnicka', '12543')
        ];
        this.saveBook = function(book) {
            this.books.push(book);
        }
    });