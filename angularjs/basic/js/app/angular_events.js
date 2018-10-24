var app = angular.module('app', []);

app.controller('ClickController', function() {
    this.header = "header przed zmianami";
    this.changeHeader = function() {
        this.header = this.textInput;
    }
    this.headerClick = function() {
        this.header = this.header.toUpperCase();
    }
});

app.controller('MouseController', function() {

    this.mouseDown = function() {
        console.log('mouse down');
    }

    this.mouseUp = function() {
        console.log('mouse up');
    }

    this.mouseEnter = function() {
        console.log('mouse enter');
    }

    this.mouseLeave = function() {
        console.log("mouse leave");
    }

    this.mouseMove = function() {
        console.log("mouse move");
    }

    this.mouseOver = function() {
        console.log("mouse over");
    }
})

app.controller('KeyController', function() {
    this.up = 0;
    this.down = 0;
    this.press = 0;

    this.keyDown = function() {
        this.down++;
    }

    this.keyUp = function() {
        this.up++;
    }

    this.keyPress = function() {
        this.press++;
    }
})

app.controller('ChangeController', function() {
    this.header="unchecked";

    this.changeState = function() {
        this.header= this.checkbox ? 'checked' : "unchecked";
    }
})