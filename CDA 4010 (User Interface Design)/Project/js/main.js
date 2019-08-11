// Referneces Table
$(document).ready(function() {
    var i = 4;
    $("#add_row_ref").click(function() {
        $('#addr_ref' + i).html("<td>" + (i + 1) + "</td><td><div class='col-xs-6 mb-2'><input type='text' class='form-control' id='firstName" + i + "' placeholder='First Name' name='refFirst" + i + "' required><div class='invalid-feedback'>Valid first name is required.</div></div><div class='col-xs-6 mb-2'><input type='text' class='form-control' id='lastName" + i + "' placeholder='Last Name' name='refLast0' required><div class='invalid-feedback'>Valid last name is required.</div></div></td><td><input type='text' name='title" + i + "' placeholder='Title' class='form-control' required/><div class='invalid-feedback'>Please provide a valid title.</div></td><td><input type='text' name='company" + i + "' placeholder='Company' class='form-control' required/><div class='invalid-feedback'>Please provide a valid company.</div></td><td><input type='text' name='address0' placeholder='Address' class='form-control' required/><div class='invalid-feedback'>Please provide an address.</div></td><td><input type='number' name='refPhone" + i + "' class='form-control' id='phone' placeholder='9041234567' required><div class='invalid-feedback'>Phone number required.</div></td><td><div class='mb-2'><input type='email' class='form-control' placeholder='person@example.com' name='refEmail" + i + "' required><div class='invalid-feedback'>Please enter a valid email address.</div></div></td>");

        $('#tab_logic_ref').append('<tr id="addr_ref' + (i + 1) + '"></tr>');
        i++;
    });
    $("#delete_row_ref").click(function() {
        if (i > 4) {
            $("#addr_ref" + (i - 1)).html('');
            i--;
        }
    });

});

// Criminal Background Table
$(document).ready(function() {
    var x = 1;
    $("#add_row_criminal").click(function() {
        $('#criminal' + x).html("<td>" + (x + 1) + "</td><td><input name='date" + x + "' type='date' placeholder='Date' class='form-control' required/><div class='invalid-feedback'>Please provide a valid date.</div> </td><td><select class='custom-select d-block w-100' name='type" + x + "' required><option value=''>Choose...</option><option value='Misdemeanor'>Misdemeanor</option><option value='Felony'>Felony</option></select><div class='invalid-feedback'>Please select a type of crime.</div></td><td><input type='text' name='description" + x + "' placeholder='Description' class='form-control' required/><div class='invalid-feedback'>Please provide a description of the crime.</div></td><td><select class='custom-select d-block w-100' name='punishment" + x + "'required><option value=''>Choose...</option><option value='Confinement'>Confinement</option><option value='Probation'>Probation</option><option value='Probation'>Community Service</option><option value='Felony'>Felony</option></select><div class='invalid-feedback'>Please provide a form of punishment.</div></td><td><input type='number' class='form-control mb-2' id='Years' min='0' placeholder='Year(s)' name='punishmentyrs" + x + "' required><div class='invalid-feedback'>Please provide time in year(s).</div><input type='number' min='0' class='form-control' id='Months' placeholder='Month(s)' name='punishmentmth" + x + "' required><div class='invalid-feedback'>Please provide time in month(s)</td>");

        $('#tab_logic_criminal').append('<tr id="criminal' + (x + 1) + '"></tr>');
        x++;
    });
    $("#delete_row_criminal").click(function() {
        if (x > 1) {
            $("#criminal" + (x - 1)).html('');
            x--;
        }
    });

});

// Educational Background Table
$(document).ready(function() {
    var j = 1;
    $("#add_row_education").click(function() {
        $('#education' + j).html("<td>" + (j + 1) + "</td><td><select class='custom-select d-block w-100' name='type" + j + "' required><option value=''>Choose...</option><option value='highschool'>High School</option><option value='undergraduate'>Undergraduate</option><option value='graduate'>Graduate</option><option value='postGraduate'>Post-Graduate</option><option value='professional'>Professional</option></select><div class='invalid-feedback'>Please select a school type.</div></td><td><input type='text' class='form-control' placeholder='School Name' name='schoolName" + j + "' required><div class='invalid-feedback'>Please provide a school name.</div></td><td><select class='custom-select d-block w-100 mb-2' name='state" + j + "' required><option value=''>State...</option><option value='AL'>Alabama</option><option value='AK'>Alaska</option><option value='AZ'>Arizona</option><option value='AR'>Arkansas</option><option value='CA'>California</option><option value='CO'>Colorado</option><option value='CT'>Connecticut</option><option value='DE'>Delaware</option><option value='DC'>District Of Columbia</option><option value='FL'>Florida</option><option value='GA'>Georgia</option><option value='HI'>Hawaii</option><option value='ID'>Idaho</option><option value='IL'>Illinois</option><option value='IN'>Indiana</option><option value='IA'>Iowa</option><option value='KS'>Kansas</option><option value='KY'>Kentucky</option><option value='LA'>Louisiana</option><option value='ME'>Maine</option><option value='MD'>Maryland</option><option value='MA'>Massachusetts</option><option value='MI'>Michigan</option><option value='MN'>Minnesota</option><option value='MS'>Mississippi</option><option value='MO'>Missouri</option><option value='MT'>Montana</option><option value='NE'>Nebraska</option><option value='NV'>Nevada</option><option value='NH'>New Hampshire</option><option value='NJ'>New Jersey</option><option value='NM'>New Mexico</option><option value='NY'>New York</option><option value='NC'>North Carolina</option><option value='ND'>North Dakota</option><option value='OH'>Ohio</option><option value='OK'>Oklahoma</option><option value='OR'>Oregon</option><option value='PA'>Pennsylvania</option><option value='RI'>Rhode Island</option><option value='SC'>South Carolina</option><option value='SD'>South Dakota</option><option value='TN'>Tennessee</option><option value='TX'>Texas</option><option value='UT'>Utah</option><option value='VT'>Vermont</option><option value='VA'>Virginia</option><option value='WA'>Washington</option><option value='WV'>West Virginia</option><option value='WI'>Wisconsin</option><option value='WY'>Wyoming</option></select><div class='invalid-feedback'>Please select a state.</div><input type='text' name='city" + j + "' placeholder='City' class='form-control' required/><div class='invalid-feedback'>Please provide a city.</div></td><td><input type='text' class='form-control' placeholder='Accomplishment' name='accomplishment" + j + "' required><div class='invalid-feedback'>Please provide an accomplishment</div></td>");

        $('#tab_logic_edu').append('<tr id="education' + (j + 1) + '"></tr>');
        j++;
    });
    $("#delete_row_education").click(function() {
        if (j > 1) {
            $("#education" + (j - 1)).html('');
            j--;
        }
    });

});

// Work Experinece Table
$(document).ready(function() {
    var z = 1;
    $("#add_row_work").click(function() {
        console.log(z);
        $('#work' + z).html("<td>" + (z + 1) + "</td><td><div class='col-xs-6 mb-3'><input type='text' class='form-control' id='lastName0' placeholder='Job Title' name='job_title" + z + "' required><div class='invalid-feedback'>Job Title Required.</div></div></td><td><input type='text' name='emp_name0' placeholder='Employer Name' class='form-control' required /><div class='invalid-feedback'>Employer Name required.</div></td><td><input type='text' name='emp_email0' placeholder='person@example.com' class='form-control' required /><div class='invalid-feedback'>Email required.</div></td><td><input type='text' name='emp_phone0' placeholder='9041234567' class='form-control' required /><div class='invalid-feedback'>Phone number required.</div></td><td><input type='text' name='refPhone" + z + "' class='form-control' placeholder='1234 Main St' required><div class='invalid-feedback'>Address required.</div></td><td><div class='mb-3'><input type='email' class='form-control mb-2' placeholder='City' name='emp_city" + z + "' required><div class='invalid-feedback'>Please enter a city.</div><select class='custom-select d-block w-100 mb-2' required><option value=''>Select State...</option><option value='AL'>Alabama</option><option value='AK'>Alaska</option><option value='AZ'>Arizona</option><option value='AR'>Arkansas</option><option value='CA'>California</option><option value='CO'>Colorado</option><option value='CT'>Connecticut</option><option value='DE'>Delaware</option><option value='DC'>District Of Columbia</option><option value='FL'>Florida</option><option value='GA'>Georgia</option><option value='HI'>Hawaii</option><option value='ID'>Idaho</option><option value='IL'>Illinois</option><option value='IN'>Indiana</option><option value='IA'>Iowa</option><option value='KS'>Kansas</option><option value='KY'>Kentucky</option><option value='LA'>Louisiana</option><option value='ME'>Maine</option><option value='MD'>Maryland</option><option value='MA'>Massachusetts</option><option value='MI'>Michigan</option><option value='MN'>Minnesota</option><option value='MS'>Mississippi</option><option value='MO'>Missouri</option><option value='MT'>Montana</option><option value='NE'>Nebraska</option><option value='NV'>Nevada</option><option value='NH'>New Hampshire</option><option value='NJ'>New Jersey</option><option value='NM'>New Mexico</option><option value='NY'>New York</option><option value='NC'>North Carolina</option><option value='ND'>North Dakota</option><option value='OH'>Ohio</option><option value='OK'>Oklahoma</option><option value='OR'>Oregon</option><option value='PA'>Pennsylvania</option><option value='RI'>Rhode Island</option><option value='SC'>South Carolina</option><option value='SD'>South Dakota</option><option value='TN'>Tennessee</option><option value='TX'>Texas</option><option value='UT'>Utah</option><option value='VT'>Vermont</option><option value='VA'>Virginia</option><option value='WA'>Washington</option><option value='WV'>West Virginia</option><option value='WI'>Wisconsin</option><option value='WY'>Wyoming</option></select><div class='invalid-feedback'>State required.</div><input type='number' class='form-control mb-2' placeholder='Zipcode' name='emp_zipcode" + z + "' required ><div class='invalid-feedback'>Please enter valid Zip Code.</div></div></td><td><div class='mb-3'><input type='number' min='0' class='form-control mb-2' placeholder='Year(s)' name='workyrs0' required><div class='invalid-feedback'>Years Required.</div><input type='number' min='0' class='form-control' placeholder='Month(s)' name='workmth" + z + "' required><div class='invalid-feedback'>Months Required.</div></div></td>");

        $('#tab_logic_work').append('<tr id="work' + (z + 1) + '"></tr>');
        z++;
    });
    $("#delete_row_work").click(function() {
        if (z > 1) {
            $("#work" + (z - 1)).html('');
            z--;
        }
    });

});

// Text Color
$("#text_color").change(function() {
    var color = $(this).val();
    switch (color) {
        case 'Default':
            $("body, .edit, input, .custom-select").addClass("text-dark").removeClass("blue red green yellow white");
            break;
        case 'Blue':
            $("body, .edit, input, .custom-select").addClass("blue").removeClass("text-dark red green yellow white");
            break;
        case 'Green':
            $("body, .edit, input, .custom-select").addClass("green").removeClass("blue red text-dark yellow white");
            break;
        case 'Red':
            $("body, .edit, input, .custom-select").addClass("red").removeClass("blue text-dark green yellow white");
            break;
        case 'Yellow':
            $("body, .edit, input, .custom-select").addClass("yellow").removeClass("blue red green text-dark white");
            break;
        case 'White':
            $("body, .edit, input, .custom-select").addClass("white").removeClass("blue red green text-dark yellow");
            break;
        default:
            $("body, .edit, input, .custom-select").addClass("text-dark").removeClass("blue red green yellow white");
    }
});

// Background Color
$("#background_color").change(function() {
    var color = $(this).val();
    switch (color) {
        case 'Default':
            $("body, .container-fluid, .modal-content").removeClass("blue_background red_background green_background yellow_background black_background");
            $(".sidebar").removeClass("blue_background red_background green_background yellow_background black_background").addClass("bg-light");
            break;
        case 'Blue':
            $("body, .container-fluid, .sidebar, .modal-content").addClass("blue_background").removeClass("red_background green_background yellow_background black_background bg-light");
            break;
        case 'Green':
            $("body, .container-fluid, .sidebar, .modal-content").addClass("green_background").removeClass("blue_background red_background yellow_background black_backgroundbg-light");
            break;
        case 'Red':
            $("body, .container-fluid, .sidebar, .modal-content").addClass("red_background").removeClass("blue_background green_background yellow_background black_background bg-light");
            break;
        case 'Yellow':
            $("body, .container-fluid, .sidebar, .modal-content").addClass("yellow_background").removeClass("blue_background red_background green_background black_backgroundbg-light");
            break;
        case 'Black':
            $("body, .container-fluid, .sidebar, .modal-content").addClass("black_background").removeClass("blue_background red_background green_background yellow_backgroundbg-light");
            break;
        default:
            $("body, .container-fluid, .modal-content").removeClass("blue_background red_background green_background yellow_background black_background");
            $(".sidebar").removeClass("blue_background red_background green_background yellow_background black_background").addClass("bg-light");
    }
});

// Font Size
$("#font_size").change(function() {
    var size = $(this).val();
    switch (size) {
        case 'Default':
            $("*, label").removeClass("x-small small medium large x-large");
            break;
        case 'Extra Small':
            $("*, label").addClass("x-small").removeClass("small medium large x-large");
            break;
        case 'Small':
            $("*, label").addClass("small").removeClass("x-small medium large x-large");
            break;
        case 'Medium':
            $("*, label").addClass("medium").removeClass("x-small large x-large");
            break;
        case 'Large':
            $("*, label").addClass("large").removeClass("x-small small medium x-large");
            break;
        default:
            $("*, label").removeClass("x-small small medium large x-large");
    }
});



// Required Fields Check on Submit
(function() {
    'use strict';
    window.addEventListener('load', function() {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.getElementsByClassName('needs-validation');
        // Loop over them and prevent submission
        var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);
})();

// Audio Settings
$(document).ready(function() {
    $("#audioYes").on("click", function() {
        $(".audio").addClass("visible").removeClass("invisible");
        $(".audio-html-add").html("<i onmouseover='responsiveVoice.speak(\"Add Row\");' class='fas fa-volume-up ml-2 audio audio-added'></i>");
        $(".audio-html-delete").html("<i onmouseover='responsiveVoice.speak(\"Delete Row\");' class='fas fa-volume-up ml-2 audio audio-added'></i>");
        $(".audio-html-submit").html("<i onmouseover='responsiveVoice.speak(\"Submit\");' class='fas fa-volume-up ml-2 audio audio-added'></i>");
    })
    $("#audioNo").on("click", function() {
        $(".audio").addClass("invisible").removeClass("visible");
        $("i.audio-added").remove();
    })


});

// Keyboard Shortcuts
Mousetrap.bind('alt+h', function(e) {
  $('#exampleModal').modal('show');
});

// When the user clicks on the button, scroll to the top of the document
$(document).ready(function(){
    $('#back-to-top').click(function () {
        $('#back-to-top').tooltip('hide');
    });
});
