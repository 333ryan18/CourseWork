function addMovie(movieID){
    window.location.replace("./index.php?action=add&movie_id="+movieID);
    return true;
}

function confirmCheckout(){
    var choice = confirm("Do you wish to checkout from myMovies Xpress! ?");
    if(choice == true){
        window.location.replace("./index.php?action=checkout");
        return true;
    } else {
        return false;
    }
}

function confirmRemove(title, movieID){
    var choice = confirm("Do you wish to remove the selected movie "+title+"?");

    if(choice == true){
        window.location.replace("./index.php?action=remove&movie_id="+movieID);
        return true;
    } else {
        return false;
    }
}

function confirmLogout(){
    var choice = confirm("Do you wish to logout of myMovies?");

    if(choice == true){
        window.location.replace("./logon.php?action=logoff");
        return true;
    } else {
        return false;
    }
}

function confirmRemove(title, movieID){
    var choice = confirm("Do you wish to remove the selected movie?");

    if(choice == true){
        window.location.replace("./index.php?action=remove&movie_id="+movieID);
        return true;
    } else {
        return false;
    }
}
