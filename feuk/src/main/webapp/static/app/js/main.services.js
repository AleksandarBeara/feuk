var feuk = angular.module('feuk.services', ['ui.bootstrap']);

feuk.service('prenesiService', function() {

	this.namirnicaId;
	this.namirnicaName;
	// this.namirnicaKalorije;
	// this.namirnicaUgljeniHidrati;
	// this.namirnicaMasti;
	// this.namirnicaProteini;
	// this.namirnicaSecer;
});

feuk.service('namirnicaService', function($http) {
	
	this.url = 'api/namirnice';
	
	this.getOne = function(id) {
		return $http.get(this.url + '/' + id);
	};
	
	this.remove = function(id) {
		return $http.delete(this.url + '/' + id);
	};
	
	this.getAll = function(name, page, number) {
		return $http.get(this.url, {params: {'name': name, 'page': page, 'number': number}});
	};

	this.addAll = function(page, number) {
		return $http.get(this.url, {params: {'page': page, 'number': number}})
	};

	this.save = function(namirnica) {
		if (namirnica.id) {
			return $http.put(this.url + '/' + namirnica.id, namirnica);
		} else {
			return $http.post(this.url, namirnica);
		}
	};
});

feuk.service('calcService', function($http) {
	
	this.url = 'api/calc';
	
	this.getOneCalc = function(idcalc) {
		return $http.get(this.url + '/' + idcalc);
	};
	
	this.removeCalc = function(idcalc) {
		return $http.delete(this.url + '/' + idcalc);
	};
	
	this.getAllCalc = function(pagecalc, numbercalc) {
		return $http.get(this.url, {params: {'pagecalc': pagecalc, 'numbercalc': numbercalc}});
	};

	this.addAllCalc = function(pagecalc, numbercalc) {
		return $http.get(this.url, {params: {'pagecalc': pagecalc, 'numbercalc': numbercalc}})
	};

	this.saveCalc = function(calc) {
		if (calc.idcalc) {
			return $http.put(this.url + '/' + calc.idcalc, calc);
		} else {
			return $http.post(this.url, calc);
		}
	};

});