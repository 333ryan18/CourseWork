var card = document.getElementById("cardInfo").innerHTML;

function testLength(value, length, exactLength) {
    if (exactLength == true) {
        if (value.length == length) {
            return true;
        }
        return false;
    } else {
        if (value.length >= length) {
            return true;
        } else
            return false;
    }
}

function testNumber(value) {
    if (isNaN(value)) {
        return false;
    }
    return true;
}

function updateForm(control) {
    if (control == "paypal") {
        document.getElementById("cardInfo").innerHTML = '<label for="email" style="margin-left: 59px" id="username">Email: </label><input type="text" name="username" required><br><br><label for="password" style="margin-left: 36px" id="password">Password: </label><input type="password" name="password" required><br>';
    } else {
        document.getElementById("cardInfo").innerHTML = card;
    }
}

function validateControl(control, name, length) {
    if (name == "zipcode") {
        if (testLength(control, length, true)) {
            if (testNumber(control)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    } else {
        if (testLength(control, length, true)) {
            if (testNumber(control)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

function validateCreditCard(value) {
    var str = value.replace(/\s/g, '');
    if (testNumber(str)) {
        var cardType = str.substring(0, 1);
        cardType = Number(cardType);
        switch (cardType) {
            case 3:
                if (testLength(str, 15, true)) {
                    return true;
                } else {
                    return false;
                }
                break;
            case 4:
                if (testLength(str, 16, true)) {
                    return true;
                } else {
                    return false;
                }
                break;
            case 5:
                if (testLength(str, 16, true)) {
                    return true;
                } else {
                    return false;
                }
                break;
            case 6:
                if (testLength(str, 16, true)) {
                    return true;
                } else {
                    return false;
                }
                break;
            default:
                return false;
        }
    }
    return false;
}

function validateDate(value) {
    var today = new Date();
    givenDate = new Date(value);
    if (givenDate > today) {
        return false;
    }
    return true;

}

function validateEmail(value) {
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    if (value.match(mailformat)) {
        return true;
    }
    return false;
}

function validatePassword(value, minLength) {
    passwordLength = value.length;
    console.log(value);
    console.log(passwordLength);
    if (passwordLength >= minLength) {
        if (testLength(value, minLength, false)) {
            return true
        }
        return false;
    }
    return false;
}

function validateState() {
    var state = document.forms["paymentForm"]["state"].value;
    if (state == "") {
        return false;
    }
    return true;
}


function validateForm() {
    var paymentType = document.getElementById("paymentType").checked;
    console.log("Payment Type: " + paymentType);


    if (paymentType == true) {
        var formCheck = true;
        var cardNumber = document.forms["paymentForm"]["cardNumber"].value;
        var zip = document.forms["paymentForm"]["zip"].value;
        var cvc = document.forms["paymentForm"]["CVC"].value;
        var email = document.forms["paymentForm"]["email"].value;
        var state = document.forms["paymentForm"]["state"].value;
        var date = document.forms["paymentForm"]["date"].value;
        if (validateState()) {
            console.log("Valid State Detected!");
            document.getElementById("state").classList.remove("red");
        } else {
            console.log("Invalid State Detected!");
            document.getElementById("state").classList.add("red");
            formCheck = false;
        }
        if (validateCreditCard(cardNumber)) {
            console.log("Valid Card Number Detected!");
            document.getElementById("cardNumber").classList.remove("red");
        } else {
            console.log("Invalid Card Number Detected!");
            document.getElementById("cardNumber").classList.add("red");
            formCheck = false;
        }
        if (validateControl(zip, "zipcode", 5)) {
            console.log("Vaild Zipcode Detected!");
            document.getElementById("zip").classList.remove("red");
        } else {
            console.log("Invalid Zipcode Detected!");
            document.getElementById("zip").classList.add("red");
            formCheck = false;
        }
        if (validateControl(cvc, "CVC", 3)) {
            console.log("Vaild CVC Detected!");
            document.getElementById("cvc").classList.remove("red");
        } else {
            console.log("Invalid CVC Detected!");
            document.getElementById("cvc").classList.add("red");
            formCheck = false;
        }
        if (validateEmail(email)) {
            console.log("Vaild Email Detected!");
            document.getElementById("email").classList.remove("red");
        } else {
            console.log("Invalid Email Detected!");
            document.getElementById("email").classList.add("red");
            formCheck = false;
        }
        if (validateDate(date)) {
            console.log("Vaild Date Detected!");
            document.getElementById("date").classList.remove("red");
        } else {
            console.log("Invalid Date Detected!");
            document.getElementById("date").classList.add("red");
            formCheck = false;
        }

        if (formCheck) {
            return true;
        }
        return false;

    } else {
        var formCheck = true;
        var username = document.forms["paymentForm"]["username"].value;
        var password = document.forms["paymentForm"]["password"].value;
        console.log(username)
        if (validateEmail(username)) {
            console.log("Vaild Email Detected!");
            document.getElementById("username").classList.remove("red");
        } else {
            console.log("Invalid Email Detected!");
            document.getElementById("username").classList.add("red");
            formCheck = false;
        }
        if (validatePassword(password, 8)) {
            console.log("Vaild Password Detected!");
            document.getElementById("password").classList.remove("red");
        } else {
            console.log("Invalid Password Detected!");
            document.getElementById("password").classList.add("red");
            formCheck = false;
        }
        if (formCheck) {
            return true;
        }
        return false;

    }

}
