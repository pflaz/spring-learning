var app = angular.module('app', []);

app.controller('HelloController', HelloController);

function HelloController() {
    this.exampleVariable = 'Przykładowy tekst';
}