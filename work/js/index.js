/*////////////////////////////////////////////////////////// для додавання*/
var $ButtonAdd = document.querySelector('.ButtonAdd');
var $ApplyAddB = document.querySelector('.ApplyAddB');
var $CanselAddB = document.querySelector('.CanselAddB');
let $BuildAddFon = document.querySelector('.BuildAddFon');
/*//////////////////////////////////////////////////////////*/
const $BuildAddAdressInput = document.querySelector('.BuildAddAdressInput');
const $BuildAddTypeList = document.querySelector('.BuildAddTypeList');
const $BInfoInput = document.querySelector('.BInfoInput');
const $OnwInfoInput = document.querySelector('.OnwInfoInput');
const $BDateInput = document.querySelector('.BDateInput');
const $RentEndDataInput = document.querySelector('.RentEndDataInput');
const $RuleInput = document.querySelector('.RuleInput');
const $CoustInput = document.querySelector('.CoustInput');

let $InfoSpace = document.querySelector('.InfoSpace');
/*////////////////////////////////////////////////////////// пароль*/
let $PasswordFon = document.querySelector('.PasswordFon');
const $PassText = document.querySelector('.PassText');
var $PassBIN = document.querySelector('.PassBIN');
var $PassBClose = document.querySelector('.PassBClose');
/*////////////////////////////////////////////////////////// для видалення*/
var $ButtonDel = document.querySelector('.ButtonDel');
var $CanselDelete = document.querySelector('.CanselDelete');
var $DeleteDelete = document.querySelector('.DeleteDelete');
let $DeleteFon = document.querySelector('.DeleteFon');
/*//////////////////////////////////////////////////// Редагування*/

/*//////////////////////////////////////////////////// виведення*/
let builds = null;
/* пошук*/
const $SearchText = document.querySelector('.SearchText');
let $ActiveWindow = 'none'

/*//////////////////////////////
///////////////////////////////*/
function qGetInfo() {
    fetch("http://localhost:8080/back?info")
        .then(function(responce) {
            return responce.json();
        })
        .then(function(data) {
            builds = data.list;
            getInfo(builds);
        });
};

function getInfo(list) {
    let temp = '';
    if (list.length) {
        for (let i = 0; i < list.length; i++) {
            temp += '<div class="BDPlate"><h6> </h6><h1 class="BDPinfolineName">Build Adress</h1><div class="BDPinfoline">' + list[i].location + '</div><h1 class="BDPinfolineName">Build type</h1 ><div class = "BDPinfoline">' + list[i].typeB + '</div><h1 class="BDPinfolineName"> Build Information </h1> <div class = "BDPinfoline">' + list[i].infoB + '</div><h1 class = "BDPinfolineName">Owner Information</h1><div class = "BDPinfoline">' + list[i].infoOwn + '</div><h1 class = "BDPinfolineName"> Rent Data </h1><div class = "BDPinfoline">' + list[i].rentDataS + '</div><h1 class = "BDPinfolineName"> Rent End Data </h1><div class = "BDPinfoline">' + list[i].rentDataF + '</div><h1 class = "BDPinfolineName"> Rule </h1><div class="BDPinfoline">' + list[i].rules + '</div><h1 class = "BDPinfolineName"> Coust </h1><div class = "BDPinfoline">' + list[i].money + ' $';
        }
    }
    $InfoSpace.innerHTML = temp;
}
qGetInfo();

/*//////////////////////////////////////////////////// */
let $SCoust = document.querySelector('.SCoust');

function summer() {
    var checkBox = document.getElementById("SummerCHB");
    var text = document.getElementById("SummerText");

    if (checkBox.checked == true) {
        $SCoust.style.opacity = "1";
        $SCoust.style.visibility = "visible";
    } else {
        $SCoust.style.opacity = "0";
        $SCoust.style.visibility = "hidden";
    }
};
/*//////////////////////////////////////////////////
//////////////////////////////////////////////////
//////////////////////////////////////////////////*/

//пошук за головним словом
$SearchText.addEventListener('input', function() {
    let query = this.value.toString().toLowerCase();
    let filterdB = builds.filter(function(el) {
        return ~el.location.toString().toLowerCase().indexOf(query);
    });
    getInfo(filterdB);
});

/*консоль админ пароля*/
function OpenPassConsole() {
    $PasswordFon.style.opacity = "1";
    $PasswordFon.style.visibility = "visible";
    $ActiveWindow = 'PassConsol'
    console.log($ActiveWindow);
};

function ClosePassConsole() {
    $PasswordFon.style.opacity = "0";
    $PasswordFon.style.visibility = "hidden";
};
/*принять пароль*/
$PassBIN.addEventListener("click", function() {
    PassAccept();
    ClosePassConsole();
    $PassText.value = ''
});
/*відмінити пароль*/
$PassBClose.addEventListener("click", function() {
    $PassText.value = ''
    ClosePassConsole();
    let $ActiveWindow = 'none'
    console.log($ActiveWindow);
});
/*перевірка пароля*/
function PassAccept() {
    let SPass = $PassText.value;
    fetch("http://localhost:8080/back?security", {
        method: 'POST',
        body: SPass,
    }).then(response =>
        response.json().then(data => ({
            data: data,
            status: response.status
        })).then(res => {
            if (JSON.stringify(res.data) == 'true') {
                alert('Accepted');
            } else { alert('Access denied'); }
        }));
}
/*Відкриття/закриття/підтвердження консолі додавання*/
function OpenAddConsole() {
    $PasswordFon.style.opacity = "1";
    $PasswordFon.style.visibility = "visible";
    let $ActiveWindow = 'AddConsole'
    console.log($ActiveWindow);
};

function CloseAddConsole() {
    $BuildAddFon.style.opacity = "0";
    $BuildAddFon.style.visibility = "hidden";
};
/**/
$ButtonAdd.addEventListener("click", function() {
    OpenPassConsole();
});
$CanselAddB.addEventListener("click", function() {
    CloseAddConsole();
});
$ApplyAddB.addEventListener("click", function() {
    CloseAddConsole();
    addingControll();
});

function clearadd() {
    $BuildAddAdressInput.value = ''
    $BuildAddTypeList.value = ''
    $BInfoInput.value = ''
    $OnwInfoInput.value = ''
    $BDateInput.value = "2022-02-24"
    $RentEndDataInput.value = "2022-02-24"
    $RuleInput.value = ''
    $CoustInput.value = '';
}
/*Відкриття/закриття/підтвердження консолі видалення*/
function CloseDelConsole() {
    $DeleteFon.style.opacity = "0";
    $DeleteFon.style.visibility = "hidden";
}

function OpenDelConsole() {
    $DeleteFon.style.opacity = "1";
    $DeleteFon.style.visibility = "visible";
    let $ActiveWindow = 'DelConsole'
    console.log($ActiveWindow);
}
/**/
$ButtonDel.addEventListener("click", function() {
    OpenPassConsole();
});

$CanselDelete.addEventListener("click", function() {
    CloseDelConsole();
});
/*Додавання нового елементу*/
function addingControll() {
    voidLine();
    if (isCorrect) {
        adding();
    } else {
        alert('Error_B');
        clearadd();
    }
}

function adding() {
    NewBuild = {
        location: $BuildAddAdressInput.value,
        typeB: $BuildAddTypeList.value,
        infoB: $BInfoInput.value,
        infoOwn: $OnwInfoInput.value,
        rentDataS: $BDateInput.value,
        rentDataF: $RentEndDataInput.value,
        rules: $RuleInput.value,
        money: $CoustInput.value
    }
    fetch("http://localhost:8080/back?AddBuild", {
        method: 'POST',
        body: JSON.stringify(NewBuild),
    }).then(response =>
        response.json().then(data => ({
            data: data,
            status: response.status
        })).then(res => {
            if (JSON.stringify(res.data) == 'Added') {
                console.log(JSON.stringify(res.data))
            }
        }));
    alert('Successful!');
    console.log(NewBuild);
}

function voidLine() {
    isCorrect = true;
    if (($BuildAddAdressInput.value == ' ')) {
        isCorrect = false;
    }
    if (($BuildAddTypeList.value == ' ')) {
        isCorrect = false;
    }
    if (($BInfoInput.value == ' ')) {
        isCorrect = false;
    }
    if (($OnwInfoInput.value == ' ')) {
        isCorrect = false;
    }
    if (($BDateInput.value == '')) {
        isCorrect = false;
    }
    if (($RentEndDataInput.value == ' ')) {
        isCorrect = false;
    }
    if (($RuleInput.value == ' ')) {
        isCorrect = false;
    }
    if (($CoustInput.value == '')) {
        isCorrect = false;
    }
    return isCorrect;
}
/*видалення елементу за фільтром типу*/
function deletion() {
    let DeleteByType = $dSurname.value.charAt(0).toUpperCase() + $dSurname.value.substr(1);
    fetch("http://localhost:8080/back?DELBYTYP", {
        method: 'POST',
        body: DeleteByType,

    })
    alert('Successful Delete!');
}

/*Редагування*/
let EditBN;
$InfoSpace.addEventListener('dblclick', function(e) {
    console.log(i++)
    if (e.target.classList.contains('BDPlate')) {
        EditBN = e.target.getAttribute('data-index') - 1;
        $BuildAddAdressInput.value = builds[EditBN].location;
        $BuildAddTypeList.value = builds[EditBN].typeB;
        $BInfoInput.value = builds[EditBN].infoB;
        $OnwInfoInput.value = builds[EditBN].infoOwn;
        $BDateInput.value = builds[EditBN].rentDataS;
        $RentEndDataInput.value = builds[EditBN].rentDataF;
        $RuleInput.value = builds[EditBN].rules;
        $CoustInput.value = builds[EditBN].money;
    }
});
/*////////////////////////////////*/

var $CanselEB = document.querySelector('.CanselEB');
var $ApplyEB = document.querySelector('.ApplyEB');
let $BuildEditFon = document.querySelector('.BuildEditFon');

$CanselEB.addEventListener("click", function() {
    CloseEditConsole();
});
$ApplyEB.addEventListener("click", function() {
    CloseEditConsole();
});

function OpenEditConsole() {
    $BuildEditFon.style.opacity = "1";
    $BuildEditFon.style.visibility = "visible";
    let $ActiveWindow = 'EditConsole'
    console.log($ActiveWindow);
};

function CloseEditConsole() {
    $BuildEditFon.style.opacity = "0";
    $BuildEditFon.style.visibility = "hidden";
};