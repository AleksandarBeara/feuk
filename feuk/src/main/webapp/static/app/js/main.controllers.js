var feuk = angular.module('feuk.controllers', ['ui.bootstrap']);

feuk.controller('NamirnicaController', function($scope, $rootScope, $location, $routeParams, namirnicaService, calcService, prenesiService) {

	$scope.namirniceTypeahead = [];
	$scope.sigurni = false;
	$scope.sigurnicalc = false;
	$scope.sigurnisvecalc = false;
	$scope.obrisi = true;
	$scope.obrisicalc = true;
	$scope.obrisisvecalc = true;
	$scope.prenesiService=prenesiService;

	$scope.getDetail=function(ObjectData){
		prenesiService.namirnicaId=ObjectData.id;
		prenesiService.namirnicaName=ObjectData.name;
		// prenesiService.namirnicaKalorije=ObjectData.kalorije;
		// prenesiService.namirnicaUgljeniHidrati=ObjectData.ugljeniHidrati;
		// prenesiService.namirnicaMasti=ObjectData.masti;
		// prenesiService.namirnicaProteini=ObjectData.proteini;
		// prenesiService.namirnicaSecer=ObjectData.secer;
	};

	$scope.getAll = function() {
		namirnicaService.getAll($scope.search, $scope.page, $scope.number)
		.success(function(data, status, headers) {
			$scope.namirnice = data;
			$scope.hideSpinner = true;
			$scope.totalpages = headers('totalpages');
			$scope.totalnamirnice = headers('totalnamirnice');
			$scope.hidePaginationNamirnice = false;
			if (parseInt($scope.totalpages)<2) {
				$scope.hidePaginationNamirnice = true;
			}
		})
		.error(function() {
			$scope.showError = true;
			$scope.hideSpinner = true;
		});
	};

	$scope.getAllCalc = function() {
		calcService.getAllCalc($scope.pagecalc, $scope.numbercalc)
		.success(function(data, status, headers) {
			$scope.calci = data;
			$scope.totalKolicina = 0;
			$scope.totalKalorije = 0;
			$scope.totalUgljeniHidrati = 0;
			$scope.totalProteini = 0;
			$scope.totalMasti = 0;
			$scope.totalSecer = 0;
			$scope.hidePaginationCalc = false;

			for (var i = $scope.calci.length - 1; i >= 0; i--) {

				$scope.totalKolicina = $scope.totalKolicina + $scope.calci[i].kolicina;
				$scope.totalKalorije = $scope.totalKalorije + ($scope.calci[i].namirnica.kalorije/100*$scope.calci[i].kolicina);
				$scope.totalUgljeniHidrati = $scope.totalUgljeniHidrati + ($scope.calci[i].namirnica.ugljeniHidrati/100*$scope.calci[i].kolicina);
				$scope.totalProteini = $scope.totalProteini + ($scope.calci[i].namirnica.proteini/100*$scope.calci[i].kolicina);
				$scope.totalMasti = $scope.totalMasti + ($scope.calci[i].namirnica.masti/100*$scope.calci[i].kolicina);
				$scope.totalSecer = $scope.totalSecer + ($scope.calci[i].namirnica.secer/100*$scope.calci[i].kolicina);
			}
			$scope.hideSpinnerCalc = true;
			$scope.totalpagescalc = headers('totalpagescalc');
			$scope.totalcalci = headers('totalcalci');
			if (parseInt($scope.totalpagescalc)<2) {
				$scope.hidePaginationCalc = true;
			}
		})
		.error(function() {
			$scope.showErrorCalc = true;
			$scope.hideSpinnerCalc = true;
		});
	};

	$scope.addAll = function() {
		namirnicaService.addAll(page=0, number=100)
		.success(function(data) {
			$scope.namirniceFromDB = data;
			var values = $scope.namirniceFromDB;
			angular.forEach(values, function(value, key) {
				$scope.namirniceTypeahead.push(value.name); 
			})
		})
		.error(function() {
		});
	};

	$scope.remove = function(id) {
		namirnicaService.getOne(id)
		.success(function(data){
			$scope.namirnicaWarning = data;
		});

		namirnicaService.remove(id)
		.success(function() {
			$scope.getAll();
			$scope.showDeleteAlert = true;
		})
		.error(function() {
			$scope.showDeleteError = true;

		});
	};

	$scope.removeCalc = function(idcalc) {
		calcService.getOneCalc(idcalc)
		.success(function(data){
			$scope.calcWarning = data;
		});

		calcService.removeCalc(idcalc)
		.success(function() {
			$scope.getAllCalc();
			$scope.showDeleteAlertCalc = true;
		})
		.error(function() {
			$scope.showDeleteErrorCalc = true;

		});
	};

	$scope.removeAllCalc = function() {
		calcService.addAllCalc(pagecalc=0, numbercalc=100)
		.success(function(data) {
			$scope.calci = data;

		});

		for (var i = $scope.calci.length - 1; i >= 0; i--) {
			calcService.removeCalc($scope.calci[i].idcalc)
			.success(function() {
				$scope.getAllCalc();
				$scope.showDeleteAllAlertCalc = true;
			})
			.error(function() {
			$scope.showDeleteAllErrorCalc = true;

			})
		}
	};

	$scope.init = function() {
		
		$scope.namirnica = {};

		if ($routeParams.id) {
			namirnicaService.getOne($routeParams.id)
			.success(function(data) {
				$scope.namirnica = data;
			})
			.error(function() {
			});
		}

	};

	$scope.initCalc = function() {
		$scope.calc = {};

		if ($routeParams.idcalc) {
			calcService.getOneCalc($routeParams.idcalc)
			.success(function(data) {
				$scope.calc = data;
			})
			.error(function() {
			});
		}
	};

	$scope.initAddCalc = function() {
		if (prenesiService.namirnicaId) {
			namirnicaService.getOne(prenesiService.namirnicaId)
			.success(function(data) {
				$scope.namirnica = data;
			})
			.error(function() {

			});
		}
		
	};

	$scope.save = function() {
		namirnicaService.save($scope.namirnica)
		.success(function() {
			$location.path('/namirnice');
		})
		.error(function() {
		});
	};

	$scope.saveCalc = function() {
		calcService.saveCalc($scope.calc)
		.success(function() {
			$location.path('/calc');
		})
		.error(function() {
		});
	};

});

//promena naslova
feuk.run(['$rootScope', function($rootScope) {
	$rootScope.$on('$routeChangeSuccess', function (event, current, previous) {
		$rootScope.title = current.$$route.title;
	});
}]);

