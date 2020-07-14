	function isNullTextField(value) {
		if(value == null || value == ''  || value ==undefined ){
			return true;
		}
		return false;
	}

	function checkReg(value,pattern) {
		var patt = new RegExp(pattern);
		var res = patt.test(value);
		return res;
	}

	function checkSizeTextField(value,min,max) {
		if(value.length>max || value.length<min ){
			return true;
		}
		return false;
	}

	function addComma(Num) {
		Num += '';
		Num = Num.replace(',', ''); Num = Num.replace(',', ''); Num = Num.replace(',', '');
		Num = Num.replace(',', ''); Num = Num.replace(',', ''); Num = Num.replace(',', '');
		x = Num.split('.');
		x1 = x[0];
		x2 = x.length > 1 ? '.' + x[1] : '';
		var rgx = /(\d+)(\d{3})/;
		while (rgx.test(x1))
			x1 = x1.replace(rgx, '$1' + ',' + '$2');
		return x1 + x2;
	}



