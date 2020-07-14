function Captcha() {
    var alpha = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'];
    var i;
    for (i = 0; i < 6; i++) {
        var a = alpha[Math.floor(Math.random() * alpha.length)];
        var b = alpha[Math.floor(Math.random() * alpha.length)];
        var c = alpha[Math.floor(Math.random() * alpha.length)];
        var d = alpha[Math.floor(Math.random() * alpha.length)];
        /*var e = alpha[Math.floor(Math.random() * alpha.length)];
        var f = alpha[Math.floor(Math.random() * alpha.length)];*/
    }
    var code = a + ' ' + b + ' ' + ' ' + c + ' ' + d + ' ' /*+ e + ' ' + f + ' '*/;
    document.getElementById("mainCaptcha").innerHTML = code;
    document.getElementById("mainCaptcha").value = code
}

function ValidCaptcha(e) {

}

function removeSpaces(string) {
    return string.split(' ').join('');
}