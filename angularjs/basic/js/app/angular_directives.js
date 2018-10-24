var app = angular.module('app', []);
app.controller('HrefController', function() {
    this.movies = [
        'b-Cr0EWwaTk',
        'zg79C7XM1Xs'
    ];
    this.imgSrc = 'http://javastart.pl/theme/genesis/pix/javastart.png';
});

app.controller('ShowHideController', function() {

});

app.controller('RepeatController', function() {
    function Person(firstName, lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    this.people = [
        new Person('Jan', 'Kowalski'),
        new Person('Ania', 'Abacka'),
        new Person('Wojtek', 'Nowak')
    ];

    this.changeH1Style = function() {
        this.h1style = {'color': 'red'};
    }

    this.even='even';
    this.odd='odd';
});